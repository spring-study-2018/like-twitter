import React from 'react';
import { withStyles } from '@material-ui/core/styles';
import Header from './Header';

const style = (theme) => ({
  root: {
    display: 'flex',
    backgroundColor: theme.palette.secondary.A100
  },
  primary: {},
  icon: {},
  container: {
    flexGrow: 1,
    paddingTop: 46,
    height: '100vh',
    overflow: 'auto',
  },
  content: {
    width: 1250,
    margin: '0 auto',
    padding: theme.spacing.unit * 2
  }
});

export default withStyles(style)(({ children, classes }) => (
  <div className={classes.root}>
    <Header />
    <div className={classes.container}>
      <section className={classes.content}>
        {children}
      </section>
    </div>
  </div>
));
