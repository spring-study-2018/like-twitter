import React from 'react';
import Grid from '@material-ui/core/Grid';
import { withStyles } from '@material-ui/core/styles';

const style = (theme) => ({
});

export default withStyles(style)(({ children, classes, leftPenal, rightPenal }) => (
  <Grid container spacing={16}>
    <Grid item xs={3}>{leftPenal}</Grid>
    <Grid item xs={6}>{children}</Grid>
    <Grid item xs={3}>{rightPenal}</Grid>
  </Grid>
));
