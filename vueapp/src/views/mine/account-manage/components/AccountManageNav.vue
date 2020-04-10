<template>
  <div>
    <van-nav-bar title="账号安全"
                 left-arrow
                 @click-left="onClickLeft" >
    </van-nav-bar>

    <van-cell-group class="margin-topdown-normal">
      <van-cell title="关联手机" value="15078383033" @click.native="phoneClick"/>
      <van-cell title="关联邮箱" value="未关联"  @click.native="emailClick"/>
    </van-cell-group>

    <van-cell-group class="">
      <van-cell title="修改密码" @click.native="modifyPasswordClick"/>
    </van-cell-group>

  </div>
</template>

<script>
  export default {
    name: "AccountManageNav",
    components: {
    },
    methods: {
      emailClick() {
        this.$router.push('/mine/account-manage/modify-email')
      },
      phoneClick() {
        this.$router.push('/mine/account-manage/modify-phone')
      },
      modifyPasswordClick() {
        this.$router.push('/mine/account-manage/identity-check/modify-password')
      },
      onClickLeft() {
        this.$router.back()
      }
    }
  }
</script>

<style scoped>

</style>