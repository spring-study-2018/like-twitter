import React from 'react';
import ReactDOM from 'react-dom';
import {createBrowserHistory} from 'history';
import {Router, Route, Switch, Redirect} from 'react-router-dom';

import Layout from './component/layout';
import rootPages from './component/page';

const history = createBrowserHistory();

ReactDOM.render(
    <Router history={history}>
        <Switch>
            {/* Route root pages */}
            {rootPages.map((root, rootKey) => (
                <Route key={rootKey} path={root.path} render={(props) => (
                    <Layout headerName={root.name}>
                        <Switch>
                            {/* Route sub pages */}
                            {root.subPages.map((sub, subKey) => (
                                <Route exact
                                       key={subKey}
                                       path={props.match.url + sub.path}
                                       component={sub.component}/>
                            ))}
                            {/* 404 Not Found */}
                            <Redirect path={props.match.url} to={'/'}/>
                        </Switch>
                    </Layout>
                )}/>
            ))}
            {/* 404 NotFount => Fallback: redirect to default page */}
            <Redirect path={'/'} to={'/dashboard'}/>
        </Switch>
    </Router>,
    document.getElementById("react")
);
