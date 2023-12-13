<template>
  <div class="container mt-3">
	  <h1 class="display-1 text-center">사용자 수정</h1>
	  
		<form action="/editById" method="post">
			<input type="hidden" name="no">
		  <div class="mb-3 mt-3">
		    <label for="name" class="form-label">이름:</label>
		    <input type="text" class="form-control" id="name" placeholder="이름을 입력하세요." name="name" v-model="userInfo.name" readonly>
		  </div>
		  <div class="mb-3 mt-3">
		    <label for="email" class="form-label">이메일:</label>
		    <input type="email" class="form-control" id="email" placeholder="이메일를 입력하세요." name="email" v-model="userInfo.email">
		  </div>
		  <div class="mb-3">
		    <label for="pwd" class="form-label">비밀번호:</label>
		    <input type="password" class="form-control" id="pwd" placeholder="비밀번호를 입력하세요." name="pwd" v-model="userInfo.pwd">
		  </div>
			
			<div class="d-flex">
			  <div class="p-2 flex-fill">
			  	<div class="form-check">
					<input type="radio" class="form-check-input" id="radio1" name="gender" :value="1" v-model="userInfo.gender">
					<label class="form-check-label" for="radio1">남성</label>
				</div>
			  </div>
			  <div class="p-2 flex-fill">
			  	<div class="form-check">
					<input type="radio" class="form-check-input" id="radio2" name="gender" :value="0" checked v-model="userInfo.gender">
					<label class="form-check-label" for="radio2">여성</label>
				</div>
			  </div>
			</div>
			
			<div class="d-flex">
			  <div class="p-2 flex-fill d-grid">
			  	<div @click="save()" class="btn btn-primary">저장</div>
			  </div>
			  <div class="p-2 flex-fill d-grid">
				<a @click="cancel()" class="btn btn-primary">취소</a>  
			  </div>
			</div>	
			
		</form>
		
	</div>
</template>

<script>
  import axios from 'axios' 

  export default {
    name: 'UpdateView',
    data() {
      return {
        userInfo: {}
      }
    },
    created() {
      console.log(this.$store.state.user)
      this.userInfo = this.$store.state.user
    },
    methods: {
      save() {
        const result = confirm('사용자 정보를 수정하시겠습니까?')
        if(result) {
          axios
            .post(process.env.VUE_APP_BASEURL + '/editById', this.userInfo)
            .then((response) => {
              if(response.data.state) {
                this.$store.commit('setUser', this.userInfo)
                this.cancel()
              } else {
                alert(response.data.message)
              }
            })
        }
      },
      cancel() {
        this.$router.push({ name: 'SelectView' })
      },
    }
  }
</script>

<style scoped>

</style>