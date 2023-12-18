<template>
  <div class="container mt-3">
	  <h1 class="display-1 text-center">사용자 정보</h1>
		<form>
		  <div class="mb-3 mt-3">
		    <label for="name" class="form-label">이름:</label>
		    <input type="text" class="form-control" id="name" v-model="userInfo.name" name="name" readonly="readonly">
		  </div>
		  <div class="mb-3 mt-3">
		    <label for="email" class="form-label">이메일:</label>
		    <input type="email" class="form-control" id="email" v-model="userInfo.email" name="email" readonly="readonly">
		  </div>
		  <div class="mb-3">
		    <label for="pwd" class="form-label">비밀번호:</label>
		    <input type="password" class="form-control" id="pwd" v-model="userInfo.pwd" name="pwd" readonly="readonly">
		  </div>
			
      <div class="d-flex">

        <div class="p-2 flex-fill" v-if="userInfo.gender == 1">
			  	<div class="form-check">
            <input type="radio" class="form-check-input" id="radio1" name="gender" value="1" checked v-model="userInfo.gender">
            <label class="form-check-label" for="radio1">남성</label>
				  </div>
			  </div>
			  
			  <div class="p-2 flex-fill" v-if="userInfo.gender == 0">
			  	<div class="form-check">
            <input type="radio" class="form-check-input" id="radio2" name="gender" value="0" checked v-model="userInfo.gender">
            <label class="form-check-label" for="radio2">여성</label>
				  </div>
			  </div>

			</div>
		</form>
		<div class="d-flex">
		  <div class="p-2 flex-fill d-grid">
		  	<a @click="edit()" class="btn btn-primary">수정</a>
		  </div>
		  <div class="p-2 flex-fill d-grid">
		  	<a @click="del()" class="btn btn-primary">삭제</a>
		  </div>
		  <div class="p-2 flex-fill d-grid">
			  <a @click="cancel()" class="btn btn-primary">취소</a>  
		  </div>
		</div>
	</div>
</template>

<script>
  import axios from 'axios'

  export default {
    name: 'SelectView',
    created() {
      this.userInfo = this.$store.state.user
    },
    data() {
      return {
        userInfo: {}
      }
    },
    methods: {
      edit() {
        this.$router.push({ name: 'UpdateView' })
      },
      del() {
        const result = confirm('사용자 정보를 삭제하시겠습니까?')

        if (result) {
          const params = { params: { no: this.userInfo.no } }
          axios
            .delete(process.env.VUE_APP_BASEURL + '/delete', params)
            .then((response) => {
              if (response.data.state) {
                this.cancel()
              } else {
                alert(response.data.message)
              }
            })
            .catch((error) => console.log(error))
        }
      },
      cancel() {
        this.clearUserInfo()
        this.$router.push({ name: 'ListView' })
      },
      clearUserInfo() {
        this.$store.commit('setUser', {})
        sessionStorage.removeItem('setUser')
      }
    }
  }
</script>

<style scoped>

</style>