<template>
  <div>
    <van-sticky>
      <van-nav-bar title="创建班课"
                   left-arrow
                   @click-left="onClickLeft" >
      </van-nav-bar>
    </van-sticky>
    <div class="content">
      <teacher-class-info />
      <div class="margin-top-normal">
        <van-button plain hairline type="primary" block >创建</van-button>
      </div>
    </div>
  </div>
</template>

<script>
  import TeacherClassInfo from "components/teacher-class-info/TeacherClassInfo";
  export default {
    name: "TeacherCreateClass",
    data() {
      return {

      }
    },
    components:
    {
      TeacherClassInfo
    },
    methods: {
      onClickLeft() {
        this.$router.back()
      },
    }
  }
</script>

<style scoped>

</style>