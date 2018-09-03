import Sidebar from './Sidebar';
import {withStyles} from '@material-ui/core/styles';

const style = (theme) => ({
    sidebar: {
        position: 'relative',
        whiteSpace: 'nowrap',
        width: 240,
    },
    avatar: {
        margin: 12,
        cursor: 'pointer',
    },
    nickname: {
        paddingTop: 20,
    },
    accountMenuIcon: {
        marginTop: 7,
    },
    accountMenu: {
        marginTop: 30,
    },
    plainText: {
        textDecoration: 'none',
    },
    active: {
        '& $menuItem': {
            backgroundColor: theme.palette.primary.light,
        },
    },
    menuItem: {},
});

export default withStyles(style)(Sidebar);
