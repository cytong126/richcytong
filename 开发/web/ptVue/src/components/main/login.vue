<template>
	<div class="login">
		<div class="loginscroll">
			<div class="mylogdiv">

				<div style="position: absolute;">

					<div style="text-align: center;">
						<img src="../../assets/logo.png">
						<h2>请登录</h2>
					</div>
					<br>
					<el-form ref="form" :model="form" :rules="rules" class="form">


						<el-form-item prop="username">
							<el-input class="log-input" v-model="form.username" placeholder="用户名" prefix-icon="icon-login_user">
							</el-input>
						</el-form-item>
						<el-form-item prop="password">
							<el-input class="log-input" v-model="form.password" placeholder="密码" type="password" prefix-icon="icon-login_pwd"
							 @keydown.enter.native="login()">
							</el-input>
						</el-form-item>
						<div class="btn-group btn-group-justified" role="group" aria-label="...">
							<div class="btn-group" role="group">
								<button v-on:click="login" type="button" class="btn btn-default">登录</button>
							</div>
						</div>
					</el-form>
				</div>
			</div>

		</div>

	</div>
</template>

<script>
	//import qs from 'qs'
	export default {
		name: 'login',
		data() {
			return {
				form: {
					username: "",
					password: "",
				},
				checkCode: '',
				rules: {
					username: [{
						required: true,
						message: "请输入用户名",
						trigger: "blur"
					}],
					password: [{
						required: true,
						message: "请输入密码",
						trigger: "blur"
					}],
				},
			};
		},
		methods: {
			init: function() { 
			},
			login: function() {
				var fd = new FormData();
				fd.append("username", this.form.username);
				fd.append("password", this.form.password);
				var url = this.global.managerUrl + "/AdministratorLogin/selectByCodePass";

				if (this.form.username.trim().length == 0 || this.form.password.trim().length == 0) {
					alert("用户名和密码都不能为空！！！");
					return false;
				}

				this.$http({
					method: 'post',
					url: url,
					data: this.qs.stringify({
						code: this.form.username,
						pass: this.form.password
					})
				}).then((response) => {
					console.log(response);
					var datas = response.data;
					//	this.$parent.analysisData(datas); 
					if (datas.code == 0) {
						//alert("登录成功");
						setTimeout(() => {
							this.$router.push({ //核心语句
								path: '/' //跳转的路径 
							})
						}, 1000)
					} else {
						alert(datas.msg);
					}
				})
			},

		},
		computed: {},
		created: function() {
			this.init();

		}
	}
</script>
<style scoped>
	.mylogdiv {
		position: absolute;
		left: 50%;
		top: 10%;
		width: 500px;
		transform: translate(-50%, -50%);
		background-color: white;
		box-shadow: 2px 2px 2px #909090;
	}
</style>
