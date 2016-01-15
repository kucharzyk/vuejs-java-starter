import Vuex from 'vuex';
import Vue from 'vue';

Vue.use(Vuex);

var store = new Vuex.Store({
  state: {
    count: 0
  },
  mutations: {
    INCREMENT: function (state) {
      state.count++;
      if (state.count > 100) {
        state.count = state.count - 100;
      }
    },
    DECREMENT: function (state) {
      state.count--;
      if (state.count < 0) {
        state.count = state.count + 100;
      }
    },
    SET_PROGRESS: function (state, number) {
      state.count = number;
    }
  }
});

export default store;
