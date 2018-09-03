import Layout from './Layout';
import {withStyles} from '@material-ui/core/styles';

const style = (theme) => ({
    root: {
        display: 'flex',
    },
    primary: {},
    icon: {},
    content: {
        flexGrow: 1,
        padding: theme.spacing.unit * 3,
        paddingTop: theme.spacing.unit * 3 + 64,
        height: '100vh',
        overflow: 'auto',
    }
});

export default withStyles(style)(Layout);
