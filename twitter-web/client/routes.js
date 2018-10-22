import React from 'react';
import ReactDOM from 'react-dom';
import { createBrowserHistory } from 'history';
import { Router, Route, Switch, Redirect } from 'react-router-dom';
import { MuiThemeProvider } from '@material-ui/core/styles';
import theme from './utils/theme-provider';
import Layout from './components/layout';

const history = createBrowserHistory();

ReactDOM.render(
  <MuiThemeProvider theme={theme}>
    <Router history={history}>
      <Layout>
        <Switch>
          <Route exact path="/" render={() => <div>Hello React</div>} />
          
          {/* 404 NotFount => Fallback: redirect to default page */}
          <Redirect path={'/'} to={'/'} />
        </Switch>
      </Layout>
    </Router>
  </MuiThemeProvider>,
  document.getElementById("react")
);
