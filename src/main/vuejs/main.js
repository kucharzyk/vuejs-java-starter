import Vue from 'vue';
import VueRouter from 'vue-router';
import { configRouter } from './route-config';
require('es6-promise').polyfill();

import App from './app';

// install router
Vue.use(VueRouter);

// create router
const router = new VueRouter({
  history: true,
  saveScrollPosition: true
});

// configure router
configRouter(router);

// boostrap the app
router.start(App, 'app');

