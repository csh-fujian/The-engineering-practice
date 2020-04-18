<template>
  <div class="content-css" >
    <div v-if="isTeacher">
      <div class="margin-top-normal">
        <van-button plain hairline type="primary" block>结束班课</van-button>
      </div>
      <div class="margin-top-small">
        <van-button plain hairline type="primary" block>删除班课</van-button>
      </div>
    </div>
    <div v-else>
      <van-button plain hairline type="primary" block>退出班课</van-button>
    </div>

  </div>
</template>

<script>
  export default {
    name: "DetailBottom",
    data() {
      return {
        isTeacher: false,
      }
    },
    created() {
      this.isTeacher = this.$store.getters.getStatus === 'teacher'
    }
  }
</script>

<style scoped>
  .content-css {
    padding: 0 4%;
    margin-bottom: 50px;
  }
</style>