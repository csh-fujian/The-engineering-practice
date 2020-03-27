<template>
  <div>

    <van-nav-bar title="关于云班课"
                 left-text=""
                 left-arrow
                 @click-left="onClickLeft" >
    </van-nav-bar>

    <div class="content text-center margin-top-max">
      <van-image :src="require('assets/image/mine/yunbanke.png')" width="75" height="70" />
      <h1>云班课</h1>
      <span class="margin-top-max text-small font-gray">Ver 5.15</span>
    </div>
    <Footer />
  </div>
</template>

<script>
  import Footer from "components/Footer";
  export default {
    name: "AboutUs",
    methods: {
      onClickLeft() {
        this.$router.back()
      }
    },
    components: {
      Footer
    }
  }
</script>

<style scoped>
</style>