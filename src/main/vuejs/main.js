import Vue from 'vue';
import VueRouter from 'vue-router';
import VueResource from 'vue-resource';
import { configRouter } from './route-config';
require('es6-promise').polyfill();

import App from './app';

// install vue-resource
Vue.use(VueResource);

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

