<template xmlns="http://www.w3.org/1999/html">
  <div class="question">
    <h2>{{q.name}} ({{q.type}})</h2>

    <input v-model="q.answer" name="questionFieldName" type="text" v-if="q.type==='TEXT'">

    <select v-model="q.answer" name="questionFieldName" v-if="q.type==='COMBO'">
      <option v-for="o in q.options" :value="o.value">{{o.name}}</option>
    </select>

    <template v-if="q.type==='RADIO'">
      <template v-for="o in q.options">
        <input v-model="q.answer" type="radio" :name="questionFieldName" :value="o.value">{{o.name}}</input>
        <br>
      </template>
    </template>

  </div>
</template>
<script>
  export default{
    name: 'question',

    props: ['q'],

    data: function () {
      return {};
    },

    computed: {
      questionFieldName: function () {
        return 'q_' + this.q.id;
      }
    },

    ready: function () {
    },

    components: {}

  };
</script>
