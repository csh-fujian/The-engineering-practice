<template>
  <div>
    <van-nav-bar title="身份认证"
                 left-arrow
                 @click-left="onClickLeft" >
    </van-nav-bar>
    <div class="content">
      <div class="margin-top-normal">
        <p class="text-normal">身份认证，请输入登录密码：</p>
      </div>

      <van-cell-group>
        <van-field class="margin-topdown-normal" v-model="password" type="password" label="密码" label-width="48px" label-class="text-normal"/>
      </van-cell-group>
      <van-button plain hairline type="primary" block @click="nextClick">下一步</van-button>
    </div>
  </div>
</template>

<script>
  export default {
    name: "IdentityCheck",
    data() {
      return {
        password: ''
      }
    },
    methods: {
      nextClick() {
        this.$router.push('/mine/account-manage/identity-check/modify-password/password')
      },
      onClickLeft() {
        this.$router.back()
      }
    }
  }
</script>

<style scoped>

</style>