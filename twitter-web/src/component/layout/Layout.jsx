import React from 'react';
import PropTypes from 'prop-types';
import CssBaseline from '@material-ui/core/CssBaseline';
import Header from './Header';
import Sidebar from './Sidebar';
import Footer from './Footer';

class Layout extends React.Component {
    constructor(props) {
        super(props);
    }

    render() {
        const {
            children,
            classes,
            headerName,
        } = this.props;

        console.log(this);
        return (
            <React.Fragment>
                <CssBaseline/>
                <div className={classes.root}>
                    <Header title={headerName}/>
                    <Sidebar/>
                    <main className={classes.content}>
                        {children}
                    </main>
                    <Footer/>
                </div>
            </React.Fragment>
        );
    }
}

Layout.propTypes = {
    children: PropTypes.node.isRequired,
    classes: PropTypes.object.isRequired,
    headerName: PropTypes.string.isRequired,
};

export default Layout;
