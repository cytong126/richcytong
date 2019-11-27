<template>
	<div class="alertmsg thescroll ">
		<div class="myalert">
			
			<div class="alert alert-warning alert-dismissable" >
				<button type="button" class="close" data-dismiss="alert" aria-hidden="true">
					&times;
				</button>
				<strong>【信息】</strong><br>&nbsp;&nbsp;
				<div>{{msg}}</div> <br>
					如果{{second}}秒后，页面没有反应，请点击
					<router-link class="navRou" :to="{path:url}">这里</router-link>
					
				
			</div>
			
		</div> 
	</div>
</template>

<script>
	export default {
		name: 'alertmsg',
		 data () {
		  return {
				url: '/',
				msg: "【提示】",
				second:10,
		  }
		},
		methods: {
			init: function() {
				if (this.$route.query.url != null) {
					this.msg = this.$route.query.msg;
					this.url = this.$route.query.url;
					this.second = this.$route.query.second;
					var second1000 = parseInt(this.second) * 1000;
					setTimeout(() => { 
						console.log("login");
						this.$router.push({ //核心语句
							path: this.url //跳转的路径 
						})
					}, second1000)
				}
			},
			secondSub: function() {
				const TIME_COUNT = parseInt(this.second); 
					var subfunc = setInterval(() => {
						if (this.second > 0 && this.second <= TIME_COUNT) {
							this.second--; 
							console.log(this.second);
						} else { 
							clearInterval(subfunc);
							//this.$parent.routershow = true;
						}
					}, 1000)
			}

		},
		computed: {
		},
		created: function() {
			//this.$parent.routershow = false;
			this.init();
			this.secondSub();
			
		}
	}
</script>
<style scoped>
.myalert{
    position: absolute;
    left:50%;
    top:50%;
		width: 500px;;
    transform: translate(-50%, -50%);
}
</style>
