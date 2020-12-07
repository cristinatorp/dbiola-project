import {aggOptions, propertyOptions} from "../helpers/mongoData";

export const actions = {
    selectRevenueAgg: "SELECT_REVENUE_AGGREGATION",
    selectBudgetAgg: "SELECT_BUDGET_AGGREGATION",
    selectProperty: "SELECT_PROPERTY",
    buildQuery: "BUILD_QUERY",
    setTableData: "SET_TABLE_DATA",
    reset: "RESET"
};

export const initialState = {
    aggOptions: aggOptions,
    revenueAgg: aggOptions[0],
    budgetAgg: aggOptions[0],

    propertyOptions: propertyOptions,
    selectedProperty: propertyOptions[0],

    queryString: "",

    foundResults: false,
    tableData: [],
    tableCols: [],

    isReset: true,
};

const mongoReducer = (state, { type, payload }) => {
    console.log(type, payload);
    switch(type) {
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
        case actions.selectProperty:
            return {
                ...state,
                selectedProperty: payload
            };
        case actions.buildQuery:
            const queryObj = buildQueryString(state);
            return {
                ...state,
                queryString: queryObj
            };
        case actions.setTableData:
            let columns = Object.keys(payload[0]);
            columns[0] = state.selectedProperty;
            return {
                ...state,
                tableData: payload,
                tableCols: columns,
                foundResults: true,
            }
        case actions.reset:
            return initialState;
        default:
            throw new Error("Could not resolve action type in mongo reducer");
    }
};

const buildQueryString = ({revenueAgg, budgetAgg, selectedProperty}) => {
    let queryObj = [];

    const firstGroup = {
        "$group": {
            "_id": {
                "Movie": "$id",
                "Property": selectedProperty.value,
                "Budget": "$budget",
                "Revenue": "$revenue"
            }
        }
    };

    let secondGroup = {
        "$group": {
            "_id": "$_id.Property"
        }
    };

    let revObj = {};
    let budObj = {};

    revObj[revenueAgg.value] = "$_id.Revenue";
    budObj[budgetAgg.value] = "$_id.Budget";

    secondGroup.$group[revenueAgg.column + " revenue"] = revObj;
    secondGroup.$group[budgetAgg.column + " budget"] = budObj;

    queryObj.push(firstGroup);
    queryObj.push(secondGroup);

    return queryObj;
};

export default mongoReducer;