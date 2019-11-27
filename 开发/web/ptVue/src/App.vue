<template>
  <div id="myapp">
		<img src="./assets/logo.png">
		 <h3>{{name}}</h3>
			<h1>{{msg}}</h1> 
		 <button  class="btn  btn-info"  v-on:click="logout">登出</button>
  </div>
</template> 
<script> 

export default {
  name: 'myapp',
  data() {
  	return { 
  		msg: '欢迎进入后台管理系统',
			name: ''
  	}
  },
  methods: {
  	logout: function() {
  		var url = this.global.managerUrl + "/AdministratorLogin/logout";
  		if (confirm("确认登出系统？")) {
  			this.$http({
  				method: 'post',
  				url: url
  			}).then((response) => {
  				console.log(response);
  				var datas = response.data;
  				if (datas.code == 0) {
  					//alert("登出成功");
  					setTimeout(() => {
  						this.$router.push({ //核心语句
  							path: '/login' //跳转的路径 
  						})
  					}, 1000)
  				} else {
  					alert("登出失败”");
  				}
  			})
  		} 
  	},
  },
	created:function(){
	    this.$parent.selectByCode();     
			this.name=this.$parent.name;
	},
}
</script>

<style>
#myapp {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
