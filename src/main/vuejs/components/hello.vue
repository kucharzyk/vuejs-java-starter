<template>
  <div class="hello">
    <h1>{{ msg }}</h1>

    <p>Counter: {{count}}</p>
    <progress class="progress progress-striped progress-success progress-animated" value="{{count}}" max="100">{{count}}%</progress>
    <button class="btn btn-primary" v-on:click="inc">+1</button>
    <button class="btn btn-primary" v-on:click="dec">-1</button>
    <button class="btn btn-primary" v-on:click="setProgress(42)">42</button>
  </div>
</template>

<script>
  export default {
    data () {
      return {
        // note: changing this line won't causes changes
        // with hot-reload because the reloaded component
        // preserves its current state and we are modifying
        // its initial state.
        msg: 'Hello Vue.js!!!',
        count: 0
      };
    },
    methods: {
      inc: function () {
        this.count++;
      },
      dec: function () {
        this.count--;
      },
      setProgress: function (number) {
        this.count = number;
      }
    }
  };
</script>
