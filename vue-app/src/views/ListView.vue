<template>
  <div class="container mt-3">
	  <h1 class="display-1 text-center">사용자 목록</h1>
	  <div class="btn-group">
	    <a href="/user/save" class="btn btn-primary">사용자 추가</a>
	  </div>
	  <table class="table table-hover mt-3">
	    <thead class="table-dark">
	      <tr>
	      	<th>이름</th>
	        <th>이메일</th>
	        <th>가입날짜</th>
	      </tr>
	    </thead>
	    <tbody>
	      <tr 
          class="cursor-pointer" 
          v-for="row in result" 
          v-bind:key="row.no" 
          @click="href(row)">
	        <td>{{ row.name }}</td>
	        <td>{{ row.email }}</td>
	        <td>{{ row.regDate }}</td>
	      </tr>
	    </tbody>
	  </table>
	</div>
</template>

<script>
  import axios from 'axios'
  import store from '@/store/index.js'

  export default {
    name: 'ListView',
    data() {
      return {
        result: []
      }
    },
    created() {
      console.log(this.$store)
      this.getData()
    },
    methods: {
      getData() {
      axios
        .post('http://localhost:8080/findAll')
        .then((response) => {
          this.result = response.data.result
        })
        .catch((error) => console.log(error))
      },
      href(row) {
        console.log(row)
        // query > http:localhost:8080/user/findById?name=사용자&pwd=1
        // params > http:localhost:8080/user/findById/사용자/1
        // index.js > path: '/user/findById/:name/:pwd'

        // this.$router.push({ name: 'SelectView', query: row })
        // this.$router.push({ name: 'SelectView', params: row })
        store.commit('setUser', row)
        this.$router.push({ name: 'SelectView' })
      }
    }
  }
</script>

<style scoped>

</style>