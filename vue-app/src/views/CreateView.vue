<template>
  <div class="container mt-3">
	  <h1 class="display-1 text-center">사용자 등록</h1>
	  
		<form action="/save" method="post">
		  <div class="mb-3 mt-3">
		    <label for="name" class="form-label">이름:</label>
		    <input type="text" class="form-control" id="name" placeholder="이름을 입력하세요." name="name" v-model="userInfo.name">
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
					<input type="radio" class="form-check-input" id="radio1" name="gender" :value="1" checked v-model="userInfo.gender">
					<label class="form-check-label" for="radio1">남성</label>
				</div>
			  </div>
			  <div class="p-2 flex-fill">
			  	<div class="form-check">
					<input type="radio" class="form-check-input" id="radio2" name="gender" :value="0" v-model="userInfo.gender">
					<label class="form-check-label" for="radio2">여성</label>
				</div>
			  </div>
			</div>
			
			<div class="d-flex">
			  <div class="p-2 flex-fill d-grid">
			  	<div @click="save()" class="btn btn-primary">생성</div>
			  </div>
			  <div class="p-2 flex-fill d-grid">
				<a href="/user" class="btn btn-primary">취소</a>  
			  </div>
			</div>
			
		</form>
		
	</div>
</template>

<script>
  import axios from 'axios'

  export default {
    name: 'CreateView',
    data() {
      return {
        userInfo: {}
      }
    },
    methods: {
      save() {
        const result = confirm("입력하신 정보대로 사용자 계정을 생성하시겠습니까?")

        if(result){
          axios
            .put(process.env.VUE_APP_BASEURL + '/save', this.userInfo)
            .then((res) => {
              if(res.data.state) {
                this.$router.push( { name: 'ListView' } )
              } else {
                alert(res.data.message)
              }
            })
            .catch((error) => console.log(error))
        }
      }
    }
  }
</script>

<style scoped>

</style>