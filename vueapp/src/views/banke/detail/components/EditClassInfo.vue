<template>
  <div>
    <van-sticky>
      <van-nav-bar title="编辑班课信息"
                   left-arrow
                   @click-left="onClickLeft" >
      </van-nav-bar>
    </van-sticky>
    <div class="content">
      <teacher-class-info />
      <div class="margin-top-normal">
        <van-button plain hairline type="primary" block >保存</van-button>
      </div>
    </div>
  </div>
</template>

<script>
  import TeacherClassInfo from "components/teacher-class-info/TeacherClassInfo";
  export default {
    name: "EditClassInfo",
    activated() {
      alert('尚未开发')
    },
    components: {TeacherClassInfo},
    methods: {
      onClickLeft() {
        this.$router.back()
      }
    }
  }
</script>

<style scoped>

</style>