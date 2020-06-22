<template>
  <div>
    <van-row type="flex" justify="center" class="text-smal margin-top-normal">
      <van-col span="6" @click="Customer_service">联系客服</van-col>
      <van-col span="4" ></van-col>
      <van-col span="6" @click="free_register">免费注册</van-col>
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
      Customer_service() {
        this.$toast("抱歉，客服服务未上线")
      },
      free_register() {
        this.$router.push('/register')
      }
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