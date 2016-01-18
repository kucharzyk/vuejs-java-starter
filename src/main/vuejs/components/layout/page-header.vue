<template>
  <div class="page-header">
    <!-- Fixed navbar -->
    <div class="pos-f-t">
      <div class="collapse" id="navbar-header">
        <div class="container bg-inverse p-a-1">
          <h3>Collapsed content</h3>
          <p>Toggleable via the navbar brand.</p>
        </div>
      </div>
      <nav class="navbar navbar-dark bg-inverse navbar-static-top">
        <div class="container">
          <button class="navbar-toggler hidden-sm-up" type="button" data-toggle="collapse"
                  data-target="#exCollapsingNavbar2">
            &#9776;
          </button>
          <div class="collapse navbar-toggleable-xs">
            <a class="navbar-brand" v-link="{ path: '/home' }">
              <img class="pull-xs-left header-logo" src="../../assets/images/logo.png">
              <span class="pull-xs-left m-l-1">Vue.js java starter</span>
              <span class="pull-xs-none"></span>
            </a>
            <ul class="nav navbar-nav">
              <li class="nav-item v-link-active">
                <a class="nav-link" v-link="{ path: '/home' }">HOME</a>
              </li>
              <li class="nav-item v-link-active">
                <a class="nav-link" v-link="{ path: '/chat' }">CHAT</a>
              </li>
              <li class="nav-item v-link-active">
                <a class="nav-link" v-link="{ path: '/hello' }">HELLO</a>
              </li>
              <li class="nav-item v-link-active">
                <a class="nav-link" v-link="{ path: '/survey' }">SURVEY</a>
              </li>
              <li class="nav-item v-link-active">
                <a class="nav-link" v-link="{ path: '/about' }">ABOUT</a>
              </li>
              <li class="nav-item v-link-active">
                <a class="nav-link" v-link="{ path: '/404' }">NOT FOUND</a>
              </li>
              <li class="nav-item v-link-active">
                <a class="nav-link" v-link="{ path: '/forbidden' }">FORBIDDEN</a>
              </li>
              <li class="nav-item dropdown">
                <a class="nav-link" data-target="#" data-toggle="dropdown">USER</a>
                <div class="dropdown-menu">
                  <h6 class="dropdown-header">User actions</h6>
                  <a class="dropdown-item" v-link="{ path: '/user/1234/profile/what' }">user profile</a>
                  <a class="dropdown-item" v-link="{ path: '/user/1234/posts' }">user posts</a>
                  <a class="dropdown-item" v-link="{ path: '/user/1234/settings' }">user settings</a>
                </div>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </div>
  </div>
</template>
<script>
  export default {
    name: 'page-header'
  };
</script>
