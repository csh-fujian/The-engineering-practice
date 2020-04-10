<template>
  <div>
    <md-nav-bar title="加入班课" />

    <div class="content">

      <div class="content text-center margin-top-normal">
        <van-image :src="require('assets/image/mine/yunbanke.png')" width="75" height="70" />
        <h3>工程实践</h3>

        <div class="border-radius shadow margin-top-normal content text-left">
          <van-cell title="老师" value="csh" />
          <van-cell title="班课号" :value="classId"/>
          <van-cell title="学校" value="福州大学"/>
          <van-cell title="学院" value="数计学院"/>
        </div>

        <div class="margin-top-normal">
          <van-button plain hairline type="primary" block @click="participate">加入</van-button>
        </div>

      </div>

    </div>
  </div>
</template>

<script>
  import MdNavBar from "components/MdNavBar";
  export default {
    name: "AddClassDetail",
    data() {
      return {
        classId: ''
      }
    },
    created() {
      this.classId = this.$route.params.classId
    },
    components: {
      [MdNavBar.name]: MdNavBar
    },
    methods: {
      participate() {
        console.log('加入成功');
        this.$router.replace('/banke')
      }
    }
  }
</script>

<style scoped>

</style>