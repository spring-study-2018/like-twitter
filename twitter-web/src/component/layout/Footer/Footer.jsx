import React from 'react';
import PropTypes from 'prop-types';
import Typography from '@material-ui/core/Typography';

class Footer extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        const {classes} = this.props;
        return (
            <Typography className={classes.footer}>
                @2018 Spring study group
            </Typography>
        );
    }
}

Footer.propTypes = {
    classes: PropTypes.object.isRequired,
};

export default Footer;
