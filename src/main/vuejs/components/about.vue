<template>
  <div class="about">
    <h1>About:</h1>
    <blockquote class="blockquote">
      <p>{{message}}</p>
      <footer><cite>{{author}}</cite></footer>
    </blockquote>
    <div>
      <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal">change message
      </button>
      <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
           aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
              <h4 class="modal-title" id="exampleModalLabel">Change message</h4>
            </div>
            <div class="modal-body">
              <form>
                <div class="form-group">
                  <label for="author-name" class="form-control-label">Author:</label>
                  <input type="text" class="form-control" id="author-name" v-model="author">
                </div>
                <div class="form-group">
                  <label for="message-text" class="form-control-label">Message:</label>
                  <textarea rows="5" class="form-control" id="message-text" v-model="message"></textarea>
                </div>
              </form>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
  export default {
    name: 'about',
    data () {
      return {
        author: 'jon.doe@gmail.com',
        message: 'Vue.js (pronounced /vjuː/, like view) is a library for building interactive web interfaces. The goal of Vue.js is to provide the benefits of reactive data binding and composable view components with an API that is as simple as possible.'
      };
    },
    components: {},
    ready: function () {

    }
  };
</script>
