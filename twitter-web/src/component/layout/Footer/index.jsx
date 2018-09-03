import Footer from './Footer';
import {withStyles} from '@material-ui/core/styles';

const style = (theme) => ({
    footer: {
        display: 'block',
        position: 'absolute',
        zIndex: 9999999,
        bottom: 10,
        right: 10,
        fontWeight: 500,
    }
});

export default withStyles(style)(Footer);
