<template>
  <van-tabbar v-model="active" @change="onChange">
    <van-tabbar-item name="banke" icon="home-o">班课</van-tabbar-item>
    <van-tabbar-item name='search' icon="search" dot>发现</van-tabbar-item>
    <van-tabbar-item name="mine" icon="user-o" badge="5">我的</van-tabbar-item>
  </van-tabbar>
</template>

<script>
  export default {
    name: "MdTabBar",
    data() {
      return {
        active: 'banke'
      }
    },
    props: {
      activeValue: {
        type: String,
        default: ''
      }
    },
    activated() {
      this.active = this.activeValue
    },
    methods: {
      onChange(name) {
        switch(name) {
          case'banke':
            this.$router.replace('/banke')
            break
          case 'search':
            this.$router.replace('/search')
            break
          case 'mine':
            this.$router.replace('/mine')
            break
        }
      }
    }
  }
</script>

<style scoped>

</style>