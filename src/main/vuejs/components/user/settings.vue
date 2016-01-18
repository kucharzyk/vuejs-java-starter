<template>
  <div class="user-settings">
    <h2>user settings</h2>

    <div v-if="!loaded">
      <h3>loading...</h3>
    </div>
    <div v-if="loaded">
      <ul>
        <li v-for="s in settings">
          {{ s }}
        </li>
      </ul>
    </div>
  </div>
</template>
<script>
  export default {
    name: 'user-settings',
    data () {
      return {
        loaded: false,
        settings: []
      };
    },
    components: {},
    ready: function () {
      let userSettings = this.$resource('/rest/user/{userId}/settings');
      let userId = this.$route.params.userId;
      userSettings.get({userId: userId}).then(function (response) {
        this.$set('settings', response.data);
        this.$data.loaded = true;
      });
    }
  };
</script>
