<template>
  <div class="user-profile">
    <h2>user profile</h2>
    <p>{{$route.params.userId}} {{$route.params.something}}</p>
  </div>
</template>
<script>
  export default {
    name: 'user-profile'
  };
</script>
