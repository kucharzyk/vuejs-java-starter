<style>
  @import "../../../node_modules/semantic-ui-css/semantic.css";

  .view {
    transition: all .5s ease;
  }

  .test-enter, .test-leave {
    opacity: 0;
    transform: translate3d(10px, 0, 0);
  }

  .v-link-active {
    color: red;
  }

  [v-cloak] {
    display: none;
  }

  body {
    font-family: Helvetica, sans-serif;
  }
</style>

<template>
  <div id="app">
    <img class="logo" src="assets/logo.png">
    <hello></hello>
  </div>
  <div>
    <a v-link="{ path: '/' }">home</a>
    <a v-link="{ path: '/about' }">about</a>
    <a v-link="{ path: '/user/1234/profile/what' }">user profile</a>
    <a v-link="{ path: '/user/1234/posts' }">user posts</a>
    <a v-link="{ path: '/user/1234/settings' }">user settings</a>
    <a v-link="{ path: '/404' }">not found</a>
    <a v-link="{ path: '/forbidden' }">forbidden</a>

    <router-view class="view" transition="test" transition-mode="out-in" keep-alive></router-view>
  </div>
</template>

<script>
  require('semantic-ui-css/semantic.min.js');

  import Hello from './components/hello.vue';

  export default {
    data () {
      return {
        authenticating: false
      };
    },
    components: {
      'hello': Hello
    }
  };
</script>

