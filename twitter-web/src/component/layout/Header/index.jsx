import Header from './Header';
import {withStyles} from '@material-ui/core/styles';

const style = (theme) => ({
    appBar: {
        position: 'absolute',
        width: `calc(100% - 240px)`,
        marginLeft: 240,
    }
});

export default withStyles(style)(Header);
