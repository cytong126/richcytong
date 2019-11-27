<template>
  <div class="about">
    <h2>关于我们</h2>  
		<p>{{msg}}</p>
  </div>
</template>

<script>
export default {
  name: 'about',
  data () {
    return {
      msg: ' Welcome to About Page '
    }
  }
}
</script> 
<style scoped>
 .about{
	 text-align: center;
 }
</style>
