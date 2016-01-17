import Vue from 'vue';
import VueRouter from 'vue-router';
import VueResource from 'vue-resource';

require('es6-promise').polyfill();
import { configRouter } from './config/routes';

// Bootstrap 4
require('bootstrap');

// debug mode
Vue.config.debug = false;

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
router.start(require('./app'), 'app');

