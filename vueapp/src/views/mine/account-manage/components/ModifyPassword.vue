<template>
  <div>
    <van-nav-bar title="修改密码"
                 left-arrow
                 @click-left="onClickLeft" >
    </van-nav-bar>
    <div class="content">
      <div class="margin-top-normal">
        <p class="text-normal">请输入需要修改的密码：</p>
      </div>

      <van-cell-group>
        <van-field class="margin-topdown-normal" v-model="password" type="password" label="密码" label-width="48px" label-class="text-normal"/>
      </van-cell-group>
      <van-button plain hairline type="primary" block @click="finish">完成</van-button>
    </div>
  </div>
</template>

<script>
  export default {
    name: "ModifyPassword",
    data() {
      return {
        password: '',
      }
    },
    methods: {
      finish() {

      },
      onClickLeft() {
        this.$router.back()
      }
    }
  }
</script>

<style scoped>

</style>