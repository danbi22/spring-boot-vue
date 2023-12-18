<template>
  <!-- <nav>
    <router-link to="/">Home</router-link> |
    <router-link to="/about">About</router-link> |
    <router-link to="/user">UserList</router-link> |
    <router-link to="/user/findById">UserSelect</router-link> |
    <router-link to="/user/editById">UserUpdate</router-link> |
    <router-link to="/user/save">UserCreate</router-link> 
  </nav> -->
  <router-view/>
</template>

<script>
export default {
  created() {
    const user = sessionStorage.getItem('setUser')
    if(user) {
      this.$store.commit('setUser', this.base64(user))
      console.log(this.$store)
    } 
  },
  methods: {
    base64(user) {
      return JSON.parse(decodeURIComponent(window.atob(user)))
    }
  }
}
</script>
