import React from 'react';
import PropTypes from "prop-types";
import Menu from '@material-ui/core/Menu';
import MenuList from '@material-ui/core/MenuList';
import MenuItem from '@material-ui/core/MenuItem';
import Paper from '@material-ui/core/Paper';
import ListItemIcon from '@material-ui/core/ListItemIcon';
import ListItemText from '@material-ui/core/ListItemText';
import Avatar from '@material-ui/core/Avatar';
import Divider from '@material-ui/core/Divider';
import Grid from '@material-ui/core/Grid';
import Typography from '@material-ui/core/Typography';
import IconButton from '@material-ui/core/IconButton';
import MoreVertIcon from '@material-ui/icons/MoreVert';

import {NavLink} from 'react-router-dom';
import rootPages from '../../page';

class Sidebar extends React.Component {
    constructor(props) {
        super(props);
        this.state = {accountMenuAnchor: null};
    }

    handleClick = event => {
        this.setState({accountMenuAnchor: event.currentTarget});
    };

    handleClose = () => {
        this.setState({accountMenuAnchor: null});
    };

    render() {
        const {classes} = this.props;
        const {accountMenuAnchor} = this.state;

        return (
            <Paper className={classes.sidebar}>
                <Grid container>
                    <Grid item>
                        <Avatar className={classes.avatar}>H</Avatar>
                    </Grid>
                    <Grid item xs>
                        <Typography className={classes.nickname}>kimtis</Typography>
                    </Grid>
                    <Grid item>
                        <IconButton
                            className={classes.accountMenuIcon}
                            aria-label="More"
                            aria-owns={open ? 'account-menu' : null}
                            aria-haspopup="true"
                            onClick={this.handleClick}>
                            <MoreVertIcon/>
                        </IconButton>
                        <Menu
                            id="account-menu"
                            className={classes.accountMenu}
                            anchorEl={accountMenuAnchor}
                            open={Boolean(accountMenuAnchor)}
                            onClose={this.handleClose}>
                            <MenuItem onClick={this.handleClose}>Logout</MenuItem>
                        </Menu>
                    </Grid>
                </Grid>

                <Divider/>

                <MenuList>
                    {rootPages.map((page, index) => (
                        <NavLink key={index} to={page.path} className={classes.plainText} activeClassName={classes.active}>
                            <MenuItem className={classes.menuItem}>
                                <ListItemIcon>
                                    <page.icon/>
                                </ListItemIcon>
                                <ListItemText inset primary={page.name}/>
                            </MenuItem>
                        </NavLink>
                    ))}
                </MenuList>
            </Paper>
        );
    }
}

Sidebar.propTypes = {
    classes: PropTypes.object.isRequired,
};

export default Sidebar;