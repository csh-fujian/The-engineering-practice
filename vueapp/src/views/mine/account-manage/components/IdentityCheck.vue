<template>
  <div class="content">
    <div class="margin-top-normal">
      <p class="text-normal">身份认证，请输入登录密码：</p>
    </div>

    <van-cell-group>
      <van-field class="margin-topdown-normal" v-model="password" type="password" label="密码" label-width="48px" label-class="text-normal"/>
    </van-cell-group>
    <van-button plain hairline type="primary" block>下一步</van-button>
  </div>
</template>

<script>
  export default {
    name: "IdentityCheck",
    data() {
      return {
        password: ''
      }
    }
  }
</script>

<style scoped>

</style>