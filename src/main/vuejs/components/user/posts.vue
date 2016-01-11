<template>
  <h2>user posts</h2>
  <ul>
    <li v-for="post in posts">
      {{ post.title }}
    </li>
  </ul>
</template>

<script>
  export default {
    data () {
      return {
        posts: []
      };
    },
    components: {},
    ready: function () {
      let userPosts = this.$resource('/rest/user/{userId}/posts');
      let userId = this.$route.params.userId;
      userPosts.get({userId: userId}).then(function (response) {
        this.$set('posts', response.data);
      });
    }
  };
</script>
