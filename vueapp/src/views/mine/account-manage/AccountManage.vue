<template>
  <div>
    <van-nav-bar title="账号安全"
                 left-arrow
                 @click-left="onClickLeft" >
    </van-nav-bar>


    <router-view />


    <Footer />
  </div>
</template>

<script>
  import Footer from "components/Footer";
  export default {
    name: "AccountManage",
    components: {
      Footer
    },
    methods: {
      onClickLeft() {
        this.$router.back()
      }
    }
  }
</script>

<style scoped>

</style>