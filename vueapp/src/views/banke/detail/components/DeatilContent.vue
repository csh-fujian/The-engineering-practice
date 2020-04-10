<template>
  <div class="margin-top-small">
    <van-cell title="云教材" :label="data.cloudBook" />
    <van-cell title="学校院系" :label="data.school + data.department"/>
    <van-cell title="学习要求" :label="data.studyRequire" :border="false"/>
    <van-cell title="教学进度" :label="data.teachProcss" :border="false"/>
    <van-cell title="考试安排" :label="data.exam" :border="false"/>
  </div>
</template>

<script>
  export default {
    name: "DeatilContent",
    props: {
      data: {
        type: Object
      }
    }
  }
</script>

<style scoped>

</style>