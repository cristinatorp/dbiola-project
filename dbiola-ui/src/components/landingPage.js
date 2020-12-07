import React from "react";
import { Row, Col, Button, Tabs, Tab } from "react-bootstrap";

import PostgreSQLContainer from "./tabs/psql";
import MongoDBContainer from "./tabs/mongodb";
import Neo4jContainer from "./tabs/neo4j";
import { Spacer } from "./globalComponents";
import styles from "../resources/css/main.module.css";

const LandingPage = () => {
    return <>
        <Row className={styles.headerContainer}>
            <Col className={"d-flex flex-column justify-content-center align-items-center"}>
                <h1 className={styles.title}>DBIOLA</h1>
                <h4 className={styles.subtitle}>Search through our Data Warehouse to find infomation about your favorite movies.</h4>

                <Spacer space={"3em"} />
                <Button className={styles.beginButton} href={"#content"}>Begin</Button>
            </Col>
        </Row>

        <Row id={"content"} className={styles.contentContainer}>
            <Col md={{ span: 10, offset: 1 }}>
                <Spacer space={"10vh"}/>
                <Tabs defaultActiveKey={0}>
                    { tabs.map((tab, index) => (
                        <Tab key={index} eventKey={index} title={tab.title} tabClassName={styles.tab}>
                            { tab.component }
                        </Tab>
                    ))}
                </Tabs>
                <Spacer space={"10vh"}/>
            </Col>
        </Row>
    </>
};

const tabs = [
    {
        title: "PostgreSQL",
        component: <PostgreSQLContainer/>
    },
    {
        title: "MongoDB",
        component: <MongoDBContainer/>
    },
    {
        title: "Neo4j",
        component: <Neo4jContainer/>
    }
];

export default LandingPage;