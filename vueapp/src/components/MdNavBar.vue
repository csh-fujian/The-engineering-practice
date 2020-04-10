<template>
  <div>
    <van-nav-bar :title="title"
                 left-arrow
                 @click-left="onClickLeft" >
    </van-nav-bar>
  </div>
</template>

<script>
  export default {
    name: "MdNavBar",
    props: {
      title: {
        type: String,
        default: '标题'
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