import React from "react";
import {Row, Col, Spinner, Button, Form} from "react-bootstrap";
import styles from "../resources/css/main.module.css";
import {actionTypes as fetchActions} from "../hooks/useAPI";
import { GoCheck, GoStop } from "react-icons/go";
import Select from "react-select";
import {actions} from "../reducers/psqlReducer";
import BasicTable from "./tableComponent";

export const Spacer = ({ space }) => {
    return <div style={{ marginTop: space }} />
};

export const Loading = () => {
    return (
        <Row>
            <Col className={"d-flex justify-content-center align-items-center"}>
                <Spinner animation={"border"} role={"status"}>
                    <span className={"sr-only"}>Loading...</span>
                </Spinner>
            </Col>
        </Row>
    )
};

export const FetchButton = ({ text, loadText, status, className, isDisabled, handleClick }) => {
    const { isLoading, lastAction } = status;
    const styleClass = lastAction === fetchActions.success ? styles.successButton : lastAction === fetchActions.error ? styles.errorButton : className;
    return isLoading ? (
        <Button block
                className={className}
                disabled>
            <Spinner as="span"
                     animation="border"
                     size="sm"
                     role="status"
                     aria-hidden="true" style={{ marginRight: ".5em" }}/>
            { loadText }
        </Button>
    ) : (
        <Button block
                onClick={handleClick}
                className={styleClass}
                disabled={isDisabled}>
            { lastAction === fetchActions.success
                ? <><GoCheck style={{ marginRight: "0.5em" }}/>Success</>
                : lastAction === fetchActions.error
                    ? <><GoStop style={{ marginRight: "0.5em" }}/>Error</>
                    : text
            }
        </Button>
    )
};

export const ChooseAggregation = ({ state, dispatch }) => {
    return (
        <div id={"aggregation-section"}>
            <Row className={styles.sectionHeading}>
                <Col className={"d-flex align-items-center"}>
                    <h4>1. Choose fact aggregation</h4>
                </Col>
            </Row>
            <Spacer space={"1em"} />
            <Row>
                <Col>
                    <Form.Group>
                        <Form.Label className={styles.label}>Revenue</Form.Label>
                        <Select value={state.revenueAgg} options={state.aggOptions} onChange={(e) => dispatch({ type: actions.selectRevenueAgg, payload: e })}/>
                    </Form.Group>
                </Col>
                <Col>
                    <Form.Group>
                        <Form.Label className={styles.label}>Budget</Form.Label>
                        <Select value={state.budgetAgg} options={state.aggOptions} onChange={(e) => dispatch({ type: actions.selectBudgetAgg, payload: e })}/>
                    </Form.Group>
                </Col>
            </Row>
            <Spacer space={"2em"} />
        </div>
    )
};

export const ShowResults = ({ data, columns, doReset }) => {
    return <>
        <Row className={styles.sectionHeading}>
            <Col className={"d-flex align-items-center"}>
                <h4>3. Results</h4>
            </Col>
        </Row>
        <Row>
            <Col>
                <BasicTable data={data} columns={columns} />
            </Col>
        </Row>
        <Spacer space={"1em"} />
        <Row>
            <Col md={{span: 4, offset: 4}} className={styles.flexColCenterAll}>
                <Button block
                        onClick={doReset}
                        className={styles.searchButton}>Try again</Button>
            </Col>
        </Row>
    </>
}

const groupStyles = {
    display: "flex",
    alignItems: "center",
    justifyContent: "space-between"
} ;

// eslint-disable-next-line
const groupBadgeStyles = {
    backgroundColor: '#EBECF0',
    borderRadius: '2em',
    color: '#172B4D',
    display: 'inline-block',
    fontSize: 12,
    fontWeight: 'normal',
    lineHeight: '1',
    minWidth: 1,
    padding: '0.16666666666667em 0.5em',
    textAlign: 'center',
}

export const formatGroupLabel = (data) => (
    <div style={groupStyles}>
        <span>{data.label}</span>
    </div>
);