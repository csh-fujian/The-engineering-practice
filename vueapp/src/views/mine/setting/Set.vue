<template>
  <div>
    <md-nav-bar title="设置" />

    <van-cell-group class="margin-top-normal">
      <van-cell title="缓存管理" is-link />
    </van-cell-group>

    <van-cell-group class="margin-top-normal">
      <van-cell title="检查更新" is-link />
      <van-cell title="反馈、投诉与建议" is-link />
      <van-cell title="隐私设计" is-link />
    </van-cell-group>

    <div class="content margin-top-normal">
      <van-button plain hairline type="primary" block @click="signOut">退出当前账号</van-button>
      <div class="text-small font-gray margin-top-small">如果注销账号请添加QQ服务群：11111111，我们会有专人为您处理</div>
    </div>



  </div>
</template>

<script>
  import MdNavBar from "components/MdNavBar";
  export default {
    name: "Set",
    components: {
      [MdNavBar.name]: MdNavBar
    },
    methods: {
      signOut() {
        this.$router.replace('/login')
      }
    }
  }
</script>

<style scoped>

</style>