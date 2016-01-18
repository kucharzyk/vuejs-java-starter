<template>
  <div class="chat">
    <h2>Realtime chat</h2>
    <h4>(open it in another browser window)</h4>

    <table style="width: 100%">
      <tr v-for="m in messages">
        <td class="label label-pill label-default" width="20%">{{ m.author }}</td>
        <td class="label label-success" width="80%">{{ m.message }}</td>
      </tr>
    </table>

    <form>
      <div class="form-group">
        <label for="author-name" class="form-control-label">Author:</label>
        <input type="text" class="form-control" id="author-name" v-model="author">
      </div>
      <div class="form-group">
        <label for="message-text" class="form-control-label">Message:</label>
        <input type="text" class="form-control" id="message-text" v-model="message"/>
      </div>
      <div class="form-group">
        <button class="btn btn-primary"  :disabled="!message || !author" @click.prevent="postMessage">Post</button>
      </div>
    </form>
  </div>
</template>

<script>
  export default {
    name: 'chat',
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
          self.message = 'Send next message';
        });
      }
    }
  };
</script>
