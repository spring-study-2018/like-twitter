import { createStore, applyMiddleware, compose } from 'redux';
import createSagaMiddleware  from 'redux-saga';
import reducers from '../reducers';
import rootSaga from '../sagas';

const saga = createSagaMiddleware();

export default function configureStore(initialState, { isServer, req, res, debug, storeKey }) {
  const store = createStore(reducers, initialState, compose(
    applyMiddleware(saga),
    // ## Chrome extensions
    // https://chrome.google.com/webstore/detail/redux-devtools/lmhkpmbekcpmknklioeibfkpmmfibljd
    !isServer && debug && window.devToolsExtension ? window.devToolsExtension() : f => f
  ));

  saga.run(rootSaga);
  return store;
}
