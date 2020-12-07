import React, {useState} from "react";
import {makeStyles, useTheme} from "@material-ui/core/styles";
import {
    Paper,
    TableBody,
    TableCell,
    TableContainer,
    TableFooter,
    TableHead,
    TablePagination,
    TableRow
} from "@material-ui/core";
import {Spacer} from "./globalComponents";
import Table from "@material-ui/core/Table";
import IconButton from "@material-ui/core/IconButton";
import LastPageIcon from "@material-ui/icons/LastPage";
import FirstPageIcon from "@material-ui/icons/FirstPage";
import KeyboardArrowRight from "@material-ui/icons/KeyboardArrowRight";
import KeyboardArrowLeft from "@material-ui/icons/KeyboardArrowLeft";
import TableSortLabel from "@material-ui/core/TableSortLabel";

const BasicTable = ({ data, columns }) => {
    const [page, setPage] = useState(0);
    const [rowsPerPage, setRowsPerPage] = useState(5);
    const [order, setOrder] = useState("asc");
    const [orderBy, setOrderBy] = useState(columns.length - 1);
    const emptyRows = rowsPerPage - Math.min(rowsPerPage, data.length - page * rowsPerPage);

    const nProps = columns.length - 2;
    const headerCells = [];
    for (let i = 0; i < nProps; i++) {
        headerCells.push({ id: i, numeric: columns[i].type === "Number", label: columns[i].label})
    }

    headerCells.push({ id: nProps, numeric: true, label: columns[nProps]});
    headerCells.push({ id: nProps + 1, numeric: true, label: columns[nProps + 1]});

    const handleChangePage = (event, newPage) => setPage(newPage);
    const handleChangeRowsPerPage = (event) => {
        setRowsPerPage(parseInt(event.target.value, 10));
        setPage(0);
    };

    const descendingComparator = (a, b, orderBy) => {
        const valueA = Object.entries(a)[orderBy][1];
        const valueB = Object.entries(b)[orderBy][1];
        if (valueB < valueA) return -1;
        if (valueB > valueA) return 1;
        return 0;
    }

    const getComparator = (order, orderBy) => {
        return order === "desc"
        ? (a, b) => descendingComparator(a, b, orderBy)
        : (a, b) => -descendingComparator(a, b, orderBy);
    }

    const stableSort = (array, comparator) => {
        const stabilizedThis = array.map((el, index) => [el, index]);
        stabilizedThis.sort((a, b) => {
            const order = comparator(a[0], b[0]);
            if (order !== 0) return order;
            return a[1] - b[1];
        });
        return stabilizedThis.map((el) => el[0]);
    }

    const handleRequestSort = (event, property) => {
        const isAsc = orderBy === property && order === "asc";
        setOrder(isAsc ? "desc" : "asc");
        setOrderBy(property);
    }

    return <>
        <Spacer space={"1em"}/>
        <TableContainer component={Paper}>
            <Table>
                <EnhancedTableHead headerCells={headerCells}
                                   order={order}
                                   orderBy={orderBy}
                                   onRequestSort={handleRequestSort}
                                   rowCount={data.length}/>
                <TableBody>
                    {stableSort(data, getComparator(order, orderBy))
                        .slice(page * rowsPerPage, page * rowsPerPage + rowsPerPage)
                        .map((row, index) => {
                            return (
                                <TableRow>
                                    <TableCell>{index + 1}</TableCell>
                                    {Object.entries(row).map(([key, value], j) => (
                                        <TableCell key={j} align={"right"}>{value}</TableCell>
                                    ))}
                                </TableRow>
                            );
                        }
                    )}

                    {emptyRows > 0 && (
                        <TableRow style={{ height: 53 * emptyRows }}>
                            <TableCell colSpan={6} />
                        </TableRow>
                    )}
                </TableBody>
                <TableFooter>
                    <TableRow>
                        <TablePagination rowsPerPageOptions={[5, 10, 20, 30, 40, 50]}
                                         count={data.length}
                                         rowsPerPage={rowsPerPage}
                                         page={page}
                                         SelectProps={{ inputProps: { 'aria-label': 'rows per page' }, native: true }}
                                         onChangePage={handleChangePage}
                                         onChangeRowsPerPage={handleChangeRowsPerPage}
                                         ActionsComponent={TablePaginationActions} />
                    </TableRow>
                </TableFooter>
            </Table>
        </TableContainer>
    </>;
};

const EnhancedTableHead = ({ headerCells, order, orderBy, onRequestSort }) => {
    const createSortHandler = (property) => (event) => {
        console.log("Create sort handler", property, event);
        onRequestSort(event, property);
    };

    return (
        <TableHead>
            <TableRow style={{ backgroundColor: "#c4d2ef" }}>
                <TableCell align={"left"}>#</TableCell>
                { headerCells.map((col, i) => (
                    <TableCell key={i}
                               align={"right"}
                               sortDirection={orderBy === col.id ? order : false}>
                        <TableSortLabel active={orderBy === col.id}
                                        direction={orderBy === col.id ? order : 'asc'}
                                        onClick={createSortHandler(col.id)}>
                            {col.label}
                            {orderBy === col.id ? (
                                <span style={{ display: "none" }}>
                                        { order === 'desc' ? 'sorted descending' : 'sorted ascending' }
                                </span>
                            ) : null}
                        </TableSortLabel>
                    </TableCell>
                ))}
            </TableRow>
        </TableHead>
    );
};

const TablePaginationActions = ({count, page, rowsPerPage, onChangePage}) => {
    const useStyles1 = makeStyles((theme) => ({
        root: {
            flexShrink: 0,
            marginLeft: theme.spacing(2.5),
        },
    }));

    const classes = useStyles1();
    const theme = useTheme();

    const handleFirstPageButtonClick = (event) => { onChangePage(event, 0); };
    const handleBackButtonClick = (event) => { onChangePage(event, page - 1); };
    const handleNextButtonClick = (event) => { onChangePage(event, page + 1); };
    const handleLastPageButtonClick = (event) => { onChangePage(event, Math.max(0, Math.ceil(count / rowsPerPage) - 1)); };

    return (
        <div className={classes.root}>
            <IconButton onClick={handleFirstPageButtonClick}
                        disabled={page === 0}
                        aria-label="first page">
                {theme.direction === 'rtl' ? <LastPageIcon /> : <FirstPageIcon />}
            </IconButton>
            <IconButton onClick={handleBackButtonClick}
                        disabled={page === 0}
                        aria-label="previous page">
                {theme.direction === 'rtl' ? <KeyboardArrowRight /> : <KeyboardArrowLeft />}
            </IconButton>
            <IconButton onClick={handleNextButtonClick}
                        disabled={page >= Math.ceil(count / rowsPerPage) - 1}
                        aria-label="next page">
                {theme.direction === 'rtl' ? <KeyboardArrowLeft /> : <KeyboardArrowRight />}
            </IconButton>
            <IconButton onClick={handleLastPageButtonClick}
                        disabled={page >= Math.ceil(count / rowsPerPage) - 1}
                        aria-label="last page">
                {theme.direction === 'rtl' ? <FirstPageIcon /> : <LastPageIcon />}
            </IconButton>
        </div>
    )
}

export default BasicTable;