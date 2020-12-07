import styles from "../../resources/css/main.module.css";
import React, {useCallback, useEffect, useReducer} from "react";
import {Row, Col, Form} from "react-bootstrap";
import {ChooseAggregation, FetchButton, ShowResults, Spacer} from "../globalComponents";
import Select from "react-select";
import mongoReducer, {initialState, actions} from "../../reducers/mongoReducer";
import useAPI, {actionTypes as fetchActions} from "../../hooks/useAPI";
import {apiURL, mongoEndpoints} from "../../helpers/globalVariables";

const MongoDBContainer = () => {
    const [{queryString, ...state}, dispatch] = useReducer(mongoReducer, initialState);

    return (
        <div className={styles.tabContent + " d-flex flex-column"}>
            {!state.foundResults
                ? <>
                    <ChooseAggregation state={state} dispatch={dispatch}/>
                    <ChooseProperty state={state} dispatch={dispatch}/>

                    <Spacer space={"1em"}/>
                    <SearchRow queryString={queryString}
                               dispatch={dispatch}/>
                </>
                : <ShowResults data={state.tableData}
                               columns={state.tableCols}
                               doReset={() => dispatch({type: actions.reset})}/>
            }
        </div>
    )
};

const ChooseProperty = ({ state, dispatch }) => {
    return <>
        <Row className={styles.sectionHeading}>
            <Col className={"d-flex align-items-center"}>
                <h4>2. Choose property</h4>
            </Col>
        </Row>
        <Spacer space={"1em"} />
        <Row>
            <Col>
                <Form.Group>
                    <Form.Label className={styles.label}>Property</Form.Label>
                    <Select value={state.selectedProperty} options={state.propertyOptions} onChange={(e) => dispatch({ type: actions.selectProperty, payload: e })}/>
                </Form.Group>
            </Col>
        </Row>
    </>
};

const SearchRow = ({  queryString, dispatch }) => {
    const [{ data: queryResults, ...fetchState }, doFetchQueryData] = useAPI(false);

    const stableDispatch = useCallback(args => {
        return dispatch(args);
    }, [dispatch]);

    useEffect(() => {
        if (queryString.length > 0) doFetchQueryData(apiURL.mongo + mongoEndpoints.aggregate, {
            method: "POST",
            body: JSON.stringify(queryString),
            headers: {
                "Content-Type": "application/json",
                "Accept": "application/json;charset=UTF-8",
                "Access-Control-Allow-Origin": "*"
            }
        })
    }, [queryString, doFetchQueryData]);

    useEffect(() => {
        if (fetchState.lastAction === fetchActions.success) {
            const showSuccess = setTimeout(() => {
                stableDispatch({ type: actions.setTableData, payload: queryResults });
            }, 500);
            return () => clearTimeout(showSuccess);
        }
        if (fetchState.lastAction === fetchActions.error) console.log("Fetch error");
    }, [fetchState.error, fetchState.lastAction, stableDispatch, queryResults]);

    return (
        <Row className={styles.flexCenterGrow}>
            <Col md={4}>
                <FetchButton text={"Search"}
                             loadText={"Searching..."}
                             isDisabled={false}
                             status={fetchState}
                             handleClick={() => stableDispatch({ type: actions.buildQuery })}
                             className={styles.searchButton}>Search</FetchButton>
            </Col>
        </Row>
    )
};

export default MongoDBContainer;