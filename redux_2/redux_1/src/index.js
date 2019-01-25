import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';
import colorReducer from './reducers/colorReducer'
import {createStore} from "redux"
import {Provider} from "react-redux"
const store = createStore(colorReducer)

ReactDOM.render(
    <Provider store={store}>
        <App />
    </Provider>    , document.getElementById('root'));

serviceWorker.unregister();
