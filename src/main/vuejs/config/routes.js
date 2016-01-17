export function configRouter (router) {

  // normal routes
  router.map({
    '/home': {
      component: require('./../components/home.vue')
    },
    // nested example
    '/user/:userId': {
      component: require('./../components/user/index.vue'),
      subRoutes: {
        // matches "/user/:userId/profile/:something"
        'profile/:something': {
          component: require('./../components/user/profile.vue')
        },
        // matches "/user/:userId/posts"
        'posts': {
          component: require('./../components/user/posts.vue')
        },
        // matches "/user/:userId/settings"
        'settings': {
          component: require('./../components/user/settings.vue')
        }
      }
    },
    // basic example
    '/about': {
      component: require('./../components/about.vue')
    },
    '/survey': {
      component: require('./../components/survey/survey.vue')
    },
    '/chat': {
      component: require('./../components/chat.vue')
    },
    '/hello': {
      component: require('./../components/hello.vue')
    },
    // not found handler
    '*': {
      component: require('./../components/not-found.vue')
    }
  });

  // redirect
  router.redirect({
    '/info': '/about',
    '/': '/home',
    '/hello/:userId': '/user/:userId'
  });

  // global before
  // 3 options:
  // 1. return a boolean
  // 2. return a Promise that resolves to a boolean
  // 3. call transition.next() or transition.abort()
  router.beforeEach((transition) => {
    if (transition.to.path === '/forbidden') {
      router.app.authenticating = true;
      setTimeout(() => {
        router.app.authenticating = false;
        alert('this route is forbidden by a global before hook');
        transition.abort();
      }, 3000);
    } else {
      transition.next();
    }
  });
}
