// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import VueRouter from 'vue-router'
//import VueResource from 'vue-resource'
import axios from 'axios'
import qs from 'qs'

import partCategory from './components/category/partCategory'
import About from './components/main/about'

import alertmsg from './components/main/alertmsg'
import login from './components/main/login'


import global_variable from '@/api/global_variable.js'


import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
Vue.use(ElementUI)


Vue.config.productionTip = false

Vue.use(VueRouter)
// Vue.use(VueResource) 
Vue.prototype.$http = axios

Vue.prototype.global = global_variable
Vue.prototype.qs = qs



//与后端进行数据交换的时候带上cookie
axios.defaults.withCredentials = true;

// 设置路由
const router = new VueRouter({
	mode: "history",
	base: __dirname,
	routes: [{
			path: "/",
			component: App
		},
		{
			path: "/login",
			component: login
		},
		{
			path: "/alertmsg",
			component: alertmsg
		},
		{
			path: "/about",
			component: About
		},
		{
			path: "/partCategory",
			component: partCategory
		},
	]
})





export default router

router.beforeEach((to, from, next) => {
	if (to.meta.requireAuth) { // 判断该路由是否需要登录权限
		if (sessionStorage.getItem("token") == 'true') { // 判断本地是否存在token
			next()
		} else {
			// 未登录,跳转到登陆页面
			next({
				path: '/login'
			})
		}
	} else {
		if (sessionStorage.getItem("token") == 'true') {
			next('/index/table');
		} else {
			next();
		}
	}
});

var indexvue = new Vue({
	router,
	data() {
		return {
			routershow: true,
			name: '未登录',
		}
	},


	methods: {
		init() {
			this.selectByCode();
		},
		selectByCode() {
			this.$http.get("http://localhost:8083/parttimes/Administrator/selectByCode")
				.then((response) => {
					console.log(response);
					var datas = response.data;
					this.analysisData(datas);
					this.name = datas.data.name;
				})
		},
		
		analysisData(data) {
			switch (data.code) {
				case 0:
					return true;
					break;
				case 102:
					this.$router.push({ //核心语句
						path: '/alertmsg', //跳转的路径
						query: { //路由传参时push和query搭配使用 ，作用时传递参数
							url: 'login',
							msg: '未登录系统，即将进入登录页面',
							second: 2,
						}
					})
					throw data.msg;
					break;
				default:
					throw data.msg;
			}
		}

	},
	template: `
	<div id="app">
		 <nav v-show="routershow" id="mainNav" class="navbar navbar-inverse">
	      <div class="container"> 
					<router-link to="/" class="navbar-brand" >首页</router-link> 
	        <div id="navbar" class="collapse navbar-collapse">
	          <ul class="nav navbar-nav">
					<li><router-link class="navRou" to="/partCategory">类别</router-link></li> 
					<li><router-link class="navRou" to="/x1">功能1</router-link></li>
					<li><router-link class="navRou" to="/x2">功能2</router-link></li>
					<li><router-link class="navRou" to="/x3">功能3</router-link></li>
					<li><router-link class="navRou" to="/about">关于我们</router-link></li>	
				</ul> 
				<ul class="nav navbar-nav navbar-right">
					<li><router-link class="navRou" to="/personinfo">{{name}}</router-link></li>	
					 
	          </ul>
	        </div><!--/.nav-collapse -->
	      </div>
	    </nav>
		<router-view></router-view> 
		 
	</div>
  `
}).$mount("#app")

//进入系统后，执行
indexvue.init();
