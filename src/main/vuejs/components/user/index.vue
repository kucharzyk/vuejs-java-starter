<template>
  <div class="user jumbotron jumbotron-fluid">
    <div class="container">
      <h1 class="display-3"><i class="fa fa-users"></i>User page</h1>
      <router-view class="view" transition="test" transition-mode="out-in" keep-alive></router-view>
    </div>
  </div>
</template>
<script>
  export default {
    name: 'user'
  };
</script>
