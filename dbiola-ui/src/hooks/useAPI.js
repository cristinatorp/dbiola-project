import { useReducer, useCallback } from "react";
import {apiURL} from "../helpers/globalVariables";

export const actionTypes = {
    init: "INIT",
    success: "SUCCESS",
    error: "FAILURE"
};

const fetchDataReducer = (state, action) => {
    switch (action.type) {
        case actionTypes.init:
            return {
                ...state,
                isLoading: true,
                error: null,
                lastAction: action.type
            };
        case actionTypes.success:
            return {
                ...state,
                isLoading: false,
                error: null,
                data: action.payload,
                lastAction: action.type
            };
        case actionTypes.error:
            console.log(action.payload);
            return {
                ...state,
                isLoading: false,
                error: action.payload,
                lastAction: action.type
            };
        default:
            throw new Error("Could not resolve fetch data reducer");
    }
};

const useAPI = (isFetchingAtMount= false) => {
    const [state, dispatch] = useReducer(fetchDataReducer, {
        isLoading: isFetchingAtMount,
        error: null,
        data: null,
        lastAction: ""
    });

    const fetchData = useCallback(async(url, options={}) => {
        const method = options["method"] || "GET";
        const endpoint = "\"" + url.split(apiURL.local).pop() + "\"";
        console.log("API request: " + method + " " + endpoint);

        try {
            dispatch({ type: actionTypes.init });
            const response = await fetch(url, options);
            const data = await response.json();
            dispatch({ type: data.status ? actionTypes.error : actionTypes.success, payload: data });
        } catch(error) {
            dispatch({ type: actionTypes.error, payload: error });
        }
    }, []);

    return [state, fetchData];
};

export default useAPI;