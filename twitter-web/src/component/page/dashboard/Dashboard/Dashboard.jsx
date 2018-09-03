import React from 'react';
import classes from './index.css';
import {Link} from 'react-router-dom';

class Dashboard extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div>
                <div className={classes.todo}>Implement here!!</div>
                <Link to='/dashboard/remove/me'>Link(remove me)</Link>
            </div>
        );
    }
}

export default Dashboard;
