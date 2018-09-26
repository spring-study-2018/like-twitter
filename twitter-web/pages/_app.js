import React from 'react';
import { Provider } from 'react-redux'
import App, { Container } from 'next/app';
import withRedux from 'next-redux-wrapper';
import CssBaseline from '@material-ui/core/CssBaseline';
import { MuiThemeProvider } from '@material-ui/core/styles';
import JssProvider from 'react-jss/lib/JssProvider';
import getPageContext from '../client/page-context';
import configureStore from '../client/store';

import Layout from '../components/layout';

const debug = process.env.NODE_ENV === 'development';
export default withRedux(configureStore, { debug })(class CustomApp extends App {
  constructor(props) {
    super(props);
    this.pageContext = getPageContext();
  }

  pageContext = null;

  componentDidMount() {
    // Remove the server-side injected CSS.
    const jssStyles = document.querySelector('#jss-server-side');
    if (jssStyles && jssStyles.parentNode) {
      jssStyles.parentNode.removeChild(jssStyles);
    }
  }

  static async getInitialProps({ Component, router, ctx }) {
    return {
      pageProps: {
        // Call page level getInitialProps
        ...(Component.getInitialProps
          ? await Component.getInitialProps(ctx)
          : {}),
      }
    };
  }

  render() {
    const ctx = this.pageContext;
    const { Component, pageProps, store } = this.props;
    return (
      <Container>
        {/* Makes the Redux store available to the connect() calls in the component hierarchy below. */}
        <Provider store={store}>
          {/* Wrap every page in Jss and Theme providers */}
          <JssProvider registry={ctx.sheetsRegistry} generateClassName={ctx.generateClassName}>
            {/* MuiThemeProvider makes the theme available down the React tree thanks to React context. */}
            <MuiThemeProvider theme={ctx.theme} sheetsManager={ctx.sheetsManager}>
              {/* CssBaseline kickstart an elegant, consistent, and simple baseline to build upon. */}
              <CssBaseline />

              <Layout>
                {/* Pass pageContext to the _document though the renderPage enhancer to render collected styles on server side. */}
                <Component pageContext={ctx} {...pageProps} />
              </Layout>

            </MuiThemeProvider>
          </JssProvider>
        </Provider>
      </Container>
    );
  }
});
