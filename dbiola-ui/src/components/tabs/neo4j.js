import styles from "../../resources/css/main.module.css";
import React, {useState} from "react";
import Neovis from "neovis.js";
import {Col, Row, Button} from "react-bootstrap";
import {Spacer} from "../globalComponents";
import TextField from "@material-ui/core/TextField";

const Neo4jContainer = () => {
    const [queryText, setQueryText] = useState("");
    const [queryProp, sendQueryProp] = useState("");

    return (
        <div className={styles.tabContent}>
            <Row className={styles.sectionHeading}>
                <Col className={"d-flex align-items-center"}>
                    <h4>1. Write custom query</h4>
                </Col>
            </Row>

            <Spacer space={"1em"} />
            <Row>
                <Col>
                    <TextField style={{ width: "100%" }}
                               rows={2}
                               value={queryText}
                               onChange={(e) => setQueryText(e.target.value) }
                               label={"Write a query in Cypher"}
                               placeholder={"For example \"MATCH (n:Genre) RETURN n LIMIT 25\""}
                               multiline
                               variant={"outlined"}
                    />
                </Col>
            </Row>

            <Spacer space={"2em"} />
            <Row>
                <Col md={{ span: 4, offset: 4}}>
                    <Button block onClick={() => sendQueryProp(queryText)} className={styles.searchButton}>Search</Button>
                </Col>
            </Row>

            <Spacer space={"3em"} />
            <Row className={styles.sectionHeading}>
                <Col className={"d-flex align-items-center"}>
                    <h4>2. Explore results</h4>
                </Col>
            </Row>
            <Spacer space={"1em"} />

            <NeoVizRenderer query={queryProp} />
        </div>
    )
};

class NeoVizRenderer extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            query: "MATCH (n:Genre) RETURN n LIMIT 25",
        }
    }

    componentDidMount() {
        let config = {
            container_id: "viz",
            server_url: "bolt://v-hollund.no:7687",
            server_user: "neo4j",
            server_password: "dbiola",

            labels: {
                "Genre": {
                    "caption": "genre"
                },
                "DimMovie": {
                    "caption": "title",
                    "size": "voteCount",
                    "community": "rating",
                },
                "FactRevenue": {
                    "caption": "Fact"
                }
            },
            relationships: {
                "INTERACTS": {
                    "thickness": "weight",
                    "caption": "false"
                }
            },

            initial_cypher: this.state.query
        };

        this.viz = new Neovis(config);
        this.viz.updateWithCypher(this.state.query);
    }

    componentDidUpdate(prevProps) {
        if (prevProps.query !== this.props.query) {
            console.log("NEW QUERY:", this.props.query);
            this.viz.renderWithCypher(this.props.query);
            console.log(this.viz);
        }
    }

    render() {
        const vizStyle = { width: "100%", height: "30em" };
        return <div id={"viz"} style={vizStyle}/>;
    }
}

export default Neo4jContainer;