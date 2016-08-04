<style lang="sass" src="./assets/scss/main.scss"></style>

<template>
  <div class="app">

    <page-header></page-header>

    <div class="application main container">
      <router-view class="view" transition="test" transition-mode="out-in" keep-alive></router-view>
    </div>

    <page-footer></page-footer>

  </div>
</template>

<script>

  import PageHeader from './components/layout/page-header.vue';
  import PageFooter from './components/layout/page-footer.vue';

  export default {
    name: 'app',
    data () {
      return {
        authenticating: false
      };
    },
    components: {
      PageHeader, PageFooter
    },
    ready: function () {

    }
  };
</script>
