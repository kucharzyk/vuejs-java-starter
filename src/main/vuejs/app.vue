<template>
  <div id="app">
    <img class="logo" src="assets/images/logo.png">
    <hello></hello>
  </div>

  <div>
    <div class="ui menu">
      <a class="item" v-link="{ path: '/' }">home</a>
      <a class="item" v-link="{ path: '/about' }">about</a>
      <a class="item" v-link="{ path: '/user/1234/profile/what' }">user profile</a>
      <a class="item" v-link="{ path: '/user/1234/posts' }">user posts</a>
      <a class="item" v-link="{ path: '/user/1234/settings' }">user settings</a>
      <a class="item" v-link="{ path: '/404' }">not found</a>
      <a class="item" v-link="{ path: '/forbidden' }">forbidden</a>
    </div>

    <router-view class="view" transition="test" transition-mode="out-in" keep-alive></router-view>
  </div>
</template>

<script>

  import Hello from './components/hello.vue';

  export default {
    data () {
      return {
        authenticating: false
      };
    },
    components: {
      Hello
    }
  };
</script>

