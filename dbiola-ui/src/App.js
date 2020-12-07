import React from "react";
import { BrowserRouter as Router, Route } from "react-router-dom";
import { Container } from "react-bootstrap";
import 'bootstrap/dist/css/bootstrap.min.css';
import styles from "./resources/css/main.module.css";

import LandingPage from "./components/landingPage";

function App() {
    return (
        <Container fluid className={styles.mainContainer}>
            <Router>
                <Route exact path={"/"} component={LandingPage} />
            </Router>
        </Container>
    );
}

export default App;
