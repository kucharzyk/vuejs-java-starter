<template>
  <div class="hello">
    <h1>{{ msg }}</h1>

    <p>Counter: {{count}}</p>
    <progress class="progress progress-striped progress-success progress-animated" value="{{count}}" max="100">
      {{count}}%
    </progress>
    <button class="btn btn-primary" @click="inc">+1</button>
    <button class="btn btn-primary" @click="dec">-1</button>
    <button class="btn btn-primary" @click="setProgress(42)">42</button>
  </div>
</template>

<script>
  import store from '../stores/store';
  export default {
    name: 'hello',
    data () {
      return {
        // note: changing this line won't causes changes
        // with hot-reload because the reloaded component
        // preserves its current state and we are modifying
        // its initial state.
        msg: 'Hello Vue.js!!!'
      };
    },
    computed: {
      count () {
        return store.state.count;
      }
    },
    methods: {
      inc: function () {
        store.dispatch('INCREMENT');
      },
      dec: function () {
        store.dispatch('DECREMENT');
      },
      setProgress: function (number) {
        store.dispatch('SET_PROGRESS', number);
      }
    }
  };
</script>
