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
      },
      backto: {
        type: Number,
        default: -1
      }
    },
    created() {

    },
    methods: {
      onClickLeft() {
        if (this.backto != -1)
          this.$router.go(this.backto)
        else
          this.$router.back()
      }
    }
  }
</script>

<style scoped>

</style>