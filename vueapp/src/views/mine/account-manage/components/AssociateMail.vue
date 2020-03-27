<template>
  <div>
    <van-nav-bar title="关联邮箱"
                 left-arrow
                 @click-left="onClickLeft" >
    </van-nav-bar>
  </div>
</template>

<script>
  export default {
    name: "AssociateMail",
    methods :{
      onClickLeft() {
        this.$router.back()
      }
    }
  }
</script>

<style scoped>

</style>