<template>
	<div class="partCa">
		<h3>类别</h3>

		<form class="formSty1">
			<div class="input-group" style="width: 100%;">
				<span class="input-group-addon" style="width: 100px;"> 类别码：</span>
				<input v-model="form.type" type="text" class="form-control" placeholder="类别码">
			</div>
			<br>
			<div class="input-group" style="width: 100%;">
				<span class="input-group-addon" style="width: 100px;"> 类别名称：</span>
				<input v-model="form.name" type="text" class="form-control" placeholder="类别名称">
			</div>
			<br>
			<div class="input-group" style="width: 100%;">
				<span class="input-group-addon" style="width: 100px;"> 状态：</span>
				<input v-model="form.status" type="text" class="form-control" placeholder="状态">
			</div>
			<br>
			<div class="btn-group btn-group-justified" role="group" aria-label="..." style="width: 50%;">
				<div class="btn-group" role="group">
					<button v-on:click="selectByCon" type="button" class="btn btn-success">查询</button>
				</div>
			</div>
			<br>

		</form>



		<table class="table table-bordered">
			<thead>
				<tr>
					<th>名称</th>
					<th>类别</th>
					<th>创建时间</th>
					<th>状态</th>
					<th>排序</th>
					<!--  <th></th> -->
				</tr>
			</thead>

			<tbody>
				<tr v-for="list in lists">
					<td>{{list.categoryName}}</td>
					<td>{{list.categoryType}}</td>
					<td>{{list.createTime}}</td>
					<td>{{list.status}} {{list.categoryStatusMsg}}</td>
					<td>{{list.sort}}</td>


					<!--  <td><router-link class="btn btn-default" v-bind:to="'/customer/'+customer.id">详情</router-link></td> -->
				</tr>
			</tbody>

		</table>


	</div>
</template>

<script>
	//import mymainApp from './mymainApp'


	export default {
		name: 'partCa',
		data() {
			return {
				lists: [],
				form: {
					type: "",
					status: "",
					name: "",
				},

			}
		},
		methods: {
			selectByCon() {
				var url = this.global.managerUrl + "/PartCategory/selectByConByPage";
				var fd = new FormData();
				fd.append("type", this.form.type);
				fd.append("status", this.form.status);
				fd.append("name", this.form.name);
				
				this.$http({
						method: 'post',
						url: url,
						data: fd,
						headers: {
							'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8',
							'x-requested-with': 'XMLHttpRequest'
						}
					})
					.then((response) => {
						console.log(response);
						var datas = response.data;
						this.$parent.analysisData(datas);

						this.lists = datas.data.list;
						this.msg = datas.msg;
					})
			},
			created() {

			}
		},
		//用于数据初始化
		created: function() {
			this.created();
		},

	}
</script>
<style scoped>

</style>
