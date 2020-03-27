<template>
  <div>
    <van-row type="flex" justify="center" class="text-smal margin-top-normal">
      <van-col span="6">联系客服</van-col>
      <van-col span="6">免费注册</van-col>
    </van-row>
  </div>
</template>

<script>
  export default {
    name: "LoginBottom",
    props: {
      buttonName: {
        type: String,
        default: '登录'
      },
      phone: {
        type: String,
        default: ''
      }
    },
    methods: {
    }
  }
</script>

<style scoped>
  .forgetCss {
    float: right;
    margin-top: 5px;
    margin-bottom: 10px;
  }

</style>