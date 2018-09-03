import React from 'react';
import PropTypes from 'prop-types';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';

class Header extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        const {title, classes} = this.props;
        return (
            <AppBar className={classes.appBar}>
                <Toolbar>
                    <Typography variant="title" color="inherit" noWrap>
                        {title}
                    </Typography>
                </Toolbar>
            </AppBar>
        );
    }
}

Header.propTypes = {
    title: PropTypes.string.isRequired,
    classes: PropTypes.object.isRequired,
};

export default Header;