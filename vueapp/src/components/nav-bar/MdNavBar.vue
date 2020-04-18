<template>
  <div>
    <van-sticky>
      <van-nav-bar :title="title"
                   left-arrow
                   @click-left="onClickLeft" >
      </van-nav-bar>
    </van-sticky>
  </div>
</template>

<script>
  export default {
    name: "MdNavBar",
    props: {
      title: {
        type: String,
        default: '工程实训',
      }
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