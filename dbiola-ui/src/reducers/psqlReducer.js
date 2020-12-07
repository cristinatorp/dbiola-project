import {aggOptions, allFilterOptions, dimensionOptions} from "../helpers/psqlData";

export const actions = {
    createFirstItem: "CREATE_FIRST_ITEM",
    selectRevenueAgg: "SELECT_REVENUE_AGGREGATION",
    selectBudgetAgg: "SELECT_BUDGET_AGGREGATION",
    incrementFilters: "INCREMENT_FILTERS",
    addFilterComponent: "ADD_NEW_FILTER",
    editFilter: "EDIT_FILTER",
    buildQuery: "BUILD_QUERY",
    setTableData: "SET_TABLE_DATA",
    reset: "RESET",
};

const generateNewFilterItem = (key) => {
    return {
        key: key,
        item: { property: "", filter: "", input: "" },
        type: allFilterOptions[0].type,
        filterOptions: allFilterOptions[0].options
    }
};

export const initialState = {
    revenueAgg: aggOptions[0],
    budgetAgg: aggOptions[0],
    aggOptions: aggOptions,

    filters: [],
    numFilters: 1,
    availableProperties: dimensionOptions,

    validQuery: false,
    queryString: "",
    foundResults: false,
    tableData: [],
    tableCols: [],

    isReset: true,
};

const psqlReducer = (state, { type, payload }) => {
    console.log(type, payload);
    switch(type) {
        case actions.createFirstItem:
            return {
                ...state,
                filters: [generateNewFilterItem(0)],
                isReset: false,
            }
        case actions.selectRevenueAgg:
            return {
                ...state,
                revenueAgg: payload
            };
        case actions.selectBudgetAgg:
            return {
                ...state,
                budgetAgg: payload
            };
        case actions.editFilter:
            payload.filterOptions = allFilterOptions.find(item => item.type === payload.type);
            let chosenProperties = state.filters.map(filter => filter.item.property);

            return {
                ...state,
                filters: state.filters.map((filter, key) => key === payload.key ? payload : filter),
                availableProperties: dimensionOptions.filter(prop => !chosenProperties.includes(prop.value)),
                validQuery: state.filters.every(filter => (filter.item.filter.value === "*") || (filter.item.input !== ""))
            };
        case actions.incrementFilters:
            const { numFilters } = state;
            return {
                ...state,
                numFilters: numFilters + 1,
                filters: [...state.filters, generateNewFilterItem(numFilters)],
                validQuery: false
            };
        case actions.buildQuery:
            return {
                ...state,
                queryString: buildQueryString(state)
            };
        case actions.setTableData:
            const columns = state.filters.map(f => f.item.property);
            columns.push((state.revenueAgg.label === "Sum" ? "Total" : state.revenueAgg.label) + " revenue");
            columns.push((state.budgetAgg.label === "Sum" ? "Total" : state.budgetAgg.label) + " budget");

            return {
                ...state,
                foundResults: true,
                tableData: payload,
                tableCols: columns
            };
        case actions.reset:
            console.log(initialState.filters);
            return initialState;
        default:
            throw new Error("Could not resolve action type in mongo reducer");
    }
};

const buildQueryString = ({ budgetAgg, revenueAgg, filters }) => {
    let filterItems = filters.map(f => f.item);

    // SELECT ROW
    let query = "SELECT ";
    for (let f of filterItems) {
        query += f.property.value + ", ";
    }

    query += revenueAgg.value + "(F.revenue) AS " + revenueAgg.value  + "_Revenue, ";
    query += budgetAgg.value + "(F.budget) AS " + budgetAgg.value + "_Budget";

    // FROM ROW
    query += "\n";
    let tables = filters.map(f => f.item.property.table);
    tables.push("fact_revenue F");
    tables = [...new Set(tables)];
    query += "FROM ";
    for (let table of tables) {
        query += table + ", ";
    }
    query = query.slice(0, -2);

    // WHERE ROW
    query += "\n";
    query += "WHERE ";
    let mentionedKeys = [''];
    for (let f of filterItems) {
        const { pk, table } = f.property;
        if (mentionedKeys.includes(pk)) continue;
        query += "F." + pk + " = " + table.slice(-1) + "." + pk + " AND ";
        mentionedKeys.push(pk);
    }

    for (let f of filterItems) {
        if (f.filter.value === "*") continue;
        query += f.property.value + " ";

        if (f.property.type === "String") {
            switch (f.filter.value) {
                case "=":
                    query += "= '" + f.input + "' AND ";
                    break;
                case "contains":
                    query += "ILIKE '%" + f.input + "%' AND ";
                    break;
                case "notcontains":
                    query += "NOT ILIKE '%" + f.input + "%' AND ";
                    break;
                case "starts":
                    query += "ILIKE '" + f.input + "%' AND ";
                    break;
                case "ends":
                    query += "ILIKE '%" + f.input + "' AND ";
                    break;
                default:
                    break;
            }
        } else {
            query += f.filter.value + " " + f.input + " AND ";
        }
    }
    query = query.slice(0, -5);

    // GROUP BY ROW
    query += "\n";
    query += "GROUP BY ";
    for (let f of filterItems) {
        query += f.property.value + ", ";
    }
    query = query.slice(0, -2);

    // ORDER BY ROW
    query += "\n";
    query += "ORDER BY " + budgetAgg.value + "_Budget DESC, " + revenueAgg.value + "_Revenue DESC";

    return query;
};

export default psqlReducer;