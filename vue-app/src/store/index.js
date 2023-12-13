import { createStore } from 'vuex'

export default createStore({
  state() {
    return {
      user: {}
    }
  },
  getters: {
  },
  mutations: {
    setUser(state, value) {
      state.user = value
    }
  },
  actions: {
  },
  modules: {
  }
})
