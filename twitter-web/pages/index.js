import React from 'react';
import Paper from '@material-ui/core/Paper';
import Grid from '@material-ui/core/Grid';

class Index extends React.Component {
  constructor(props) {
    super(props);
  }

  static getInitialProps() {
    return {};
  }

  componentDidMount() {
    console.log(this.props);
  }

  render() {
    return (
      <Grid container spacing={16}>
        <Grid item xs={3}>
          <Paper square elevation={0} style={{height: '500px'}}>TODO</Paper>
        </Grid>
        <Grid item xs={6}>
          <Paper square elevation={0} style={{height: '500px'}}>TODO</Paper>
        </Grid>
        <Grid item xs={3}>
          <Paper square elevation={0} style={{height: '500px'}}>TODO</Paper>
        </Grid>
      </Grid>
    );
  }
}

export default Index;
