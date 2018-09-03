import React from 'react';
import classes from './index.css';

class RemoveMe extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        return (
            <div className={classes.todo}>Remove me!!</div>
        );
    }
}

export default RemoveMe;
