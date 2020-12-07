import React, {useCallback, useEffect, useLayoutEffect, useReducer, useState} from "react";
import Select from "react-select";
import {Button, Col, Form, Row} from "react-bootstrap";
import styles from "../../resources/css/main.module.css";

import psqlReducer, {actions, initialState} from "../../reducers/psqlReducer";
import {ChooseAggregation, FetchButton, Spacer, ShowResults} from "../globalComponents";
import useAPI, {actionTypes as fetchActions} from "../../hooks/useAPI";
import {apiURL} from "../../helpers/globalVariables";

const PostgreSQLContainer = () => {
    const [state, dispatch] = useReducer(psqlReducer, initialState);

    useLayoutEffect(() => {
        if (state.isReset) dispatch({ type: actions.createFirstItem });
    }, [state.isReset]);

    useEffect(() => {
        if (state.foundResults) console.log("Found result");
    }, [state.foundResults]);

    return state.filters.length > 0 &&
        <div className={styles.tabContent + " d-flex flex-column"}>
            { !state.foundResults
                ? <>
                    <ChooseAggregation state={state} dispatch={dispatch} />
                    <ChooseFilters state={state} dispatch={dispatch} />
                </>
                : <ShowResults data={state.tableData} columns={state.tableCols} doReset={() => dispatch({ type: actions.reset })}/>
            }
        </div>
};

const ChooseFilters = ({ state, dispatch }) => {
    const stableDispatch = useCallback(args => {
        return dispatch(args);
    }, [dispatch]);

    const [filters, addFilters] = useState(null);
    useEffect(() => {
        let children = [];
        for (let i = 0; i < state.numFilters; i++) {
            children.push(<Filter state={state} dispatch={stableDispatch} key={i} filterId={i}/>);
        }
        addFilters(children);
    }, [state, stableDispatch]);

    const buildQuery = () => stableDispatch({ type: actions.buildQuery });

    const [{ data: queryResults, ...fetchState }, doFetchQueryData] = useAPI(false);
    useEffect(() => {
        if (state.queryString !== "") doFetchQueryData(apiURL.local + "/fact/query", {
            method: "POST",
            body: state.queryString,
            headers: { "Access-Control-Allow-Origin": "*" }
        });
    }, [state.queryString, doFetchQueryData]);

    useEffect(() => {
        if (fetchState.lastAction === fetchActions.success) {
            const showSuccess = setTimeout(() => {
                stableDispatch({ type: actions.setTableData, payload: queryResults });
            }, 500);
            return () => clearTimeout(showSuccess);
        }
        if (fetchState.lastAction === fetchActions.error) console.log("Fetch error", fetchState.error);
    }, [fetchState.error, fetchState.lastAction, stableDispatch, queryResults]);

    return (
        <div id={"filter-section"} className={styles.flexColGrow}>
            <Row className={styles.sectionHeading}>
                <Col className={"d-flex align-items-center"}>
                    <h4>2. Choose custom filters</h4>
                </Col>
            </Row>

            <Spacer space={"1em"} />

            <Row>
                <Col>
                    <Form.Label className={styles.label}>Database property</Form.Label>
                </Col>
                <Col>
                    <Form.Label className={styles.label}>Filter</Form.Label>
                </Col>
                <Col>
                    <Form.Label className={styles.label}>Input</Form.Label>
                </Col>
            </Row>

            { filters }

            {state.validQuery &&
                <Row className={styles.addFilterRow}>
                    <Col>
                        <Button variant={"link"}
                                onClick={() => stableDispatch({ type: actions.incrementFilters })}
                                style={{paddingLeft: ".3em"}}>Add new filter</Button>
                    </Col>
                </Row>

            }

            <Row className={styles.flexCenterGrow}>
                <Col md={4}>
                    <Spacer space={"2em"}/>
                    <FetchButton text={"Search"}
                                 loadText={"Searching..."}
                                 status={fetchState}
                                 className={styles.searchButton}
                                 isDisabled={!state.validQuery}
                                 handleClick={buildQuery}/>
                </Col>
            </Row>

            <Spacer space={"2em"}/>
        </div>
    )
};

const Filter = ({ state, dispatch, filterId }) => {
    let filterItem = state.filters.find(item => item.key === filterId);
    const { property, filter, input } = filterItem.item;

    const editItem = (e, action) => {
        if (action) {
            filterItem.item[action.name] = e;
            if (action.name === "property") filterItem.type = e.type;
            if (action.name === "filter" && e.label === "Include all") filterItem.item["input"] = "";
        } else {
            filterItem.item["input"] = e.target.value;
        }

        dispatch({ type: actions.editFilter, payload: filterItem });
    };

    return (
        <React.Fragment>
            <Row>
                <Col>
                    <Select name={"property"}
                            placeholder={"Select property..."}
                            options={state.availableProperties}
                            onChange={editItem}/>
                </Col>
                <Col>
                    <Select name={"filter"}
                            placeholder={"Select filter..."}
                            isDisabled={property === ""}
                            options={filterItem.filterOptions.options}
                            onChange={editItem}/>
                </Col>
                <Col>
                    <Form.Control name={"input"}
                                  disabled={filter === "" || filter.value === "*"}
                                  value={input}
                                  type={filterItem.type === "String" ? "text" : "number"}
                                  onChange={editItem}/>
                </Col>
            </Row>

            <Spacer space={"1em"}/>
        </React.Fragment>
    )
};

export default PostgreSQLContainer;