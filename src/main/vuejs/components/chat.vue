<template>
  <div>
    <h2>Chat</h2>
    <ul>
      <li v-for="m in messages">
        {{ m.author }} {{ m.message }}
      </li>
    </ul>
    <form>
      <div class="form-group">
        <label for="author-name" class="form-control-label">Author:</label>
        <input type="text" class="form-control" id="author-name" v-model="author">
      </div>
      <div class="form-group">
        <label for="message-text" class="form-control-label">Message:</label>
        <textarea rows="5" class="form-control" id="message-text" v-model="message"></textarea>
      </div>
      <div class="form-group">
        <button class="btn btn-primary" v-on:click.prevent="postMessage">Post</button>
      </div>
    </form>
  </div>
</template>

<script>
  export default {

    data () {
      return {
        author: 'John',
        message: 'Vue.js works great with Java',
        messages: []
      };
    },
    components: {},
    ready: function () {
      var eventSource = new EventSource('/rest/chat/sse/updates');
      var self = this;
      eventSource.onmessage = function (e) {
        var msg = JSON.parse(e.data);
        console.log(e);
        self.messages.push(msg);
      };

    },
    methods: {
      postMessage: function () {
        var self = this;
        self.$http.post('/rest/chat/post', {
          author: self.author,
          message: self.message
        }).then(function () {
          self.message = '';
        });
      }
    }
  };
</script>
