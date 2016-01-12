<style lang="less" src="semantic-ui-css/semantic.min.css"></style>
<style lang="less" src="./assets/less/main.less"></style>

<template>
  <div id="app">

    <div class="ui borderless main menu">
      <div class="ui text container">
        <div class="header item">
          <img class="logo" src="assets/images/logo.png">
          <a v-link="{ path: '/home' }" class="project-name">Vue.js java starter</a>
        </div>
        <a class="item" v-link="{ path: '/hello' }">HELLO</a>
        <a class="item" v-link="{ path: '/about' }">ABOUT</a>
        <a class="item" v-link="{ path: '/404' }">NOT FOUND</a>
        <a class="item" v-link="{ path: '/forbidden' }">FORBIDDEN</a>
        <a href="#" class="ui right floated dropdown item">
          USER <i class="dropdown icon"></i>
          <div class="menu">
            <div class="divider"></div>
            <div class="header">Actions:</div>
            <div class="item" v-link="{ path: '/user/1234/profile/what' }">user profile</div>
            <div class="item" v-link="{ path: '/user/1234/posts' }">user posts</div>
            <div class="item" v-link="{ path: '/user/1234/settings' }">user settings</div>
          </div>
        </a>
      </div>
    </div>


    <div class="ui text application main container">
        <router-view class="view" transition="test" transition-mode="out-in" keep-alive></router-view>
    </div>

    <div class="ui inverted vertical page footer segment">
      <div class="ui center aligned container">
        <div class="ui inverted section divider"></div>
        <img src="assets/images/logo.png" class="ui centered mini image">
        <div class="ui horizontal inverted small divided link list">
          <a class="item" href="#">Site Map</a>
          <a class="item" href="#">Contact Us</a>
          <a class="item" href="#">Terms and Conditions</a>
          <a class="item" href="#">Privacy Policy</a>
        </div>
      </div>
    </div>
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
    },
    ready: function () {

      // fix main menu to page on passing
      $('.main.menu').visibility({
        type: 'fixed'
      });
      $('.overlay').visibility({
        type: 'fixed',
        offset: 80
      });

      // lazy load images
      $('.image').visibility({
        type: 'image',
        transition: 'vertical flip in',
        duration: 500
      });

      // show dropdown on hover
      $('.main.menu  .ui.dropdown').dropdown({
        on: 'hover'
      });

    }
  };
</script>

