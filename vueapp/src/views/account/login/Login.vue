<template>
  <div>
    <div class="van-tabs" ref="test">
      <van-tabs
        v-model="activeName"
        type="line"
        :border="false">
        <van-tab name="verifyLogin" ref="verify">
          <div class="different-login">
            <verify-login />
            <login-bottom :buttonName="buttonName"/>
          </div>
          <span :class="{tabTitle:titleActive}" slot="title">验证码登录</span>
        </van-tab>

        <van-tab  name="accountLogin">
          <div class="different-login">
            <account-login />
            <login-bottom :buttonName="buttonName" />
          </div>
          <span :class="{tabTitle:!titleActive}" slot="title">账号登录</span>
        </van-tab>
      </van-tabs>
    </div>
    <Footer />
  </div>
</template>

<script>
  import AccountLogin from "./components/AccountLogin";
  import VerifyLogin from "./components/VerifyLogin";
  import LoginBottom from "./components/LoginBottom";
  import Footer from "components/Footer";

  import { Button, Tab, Tabs } from 'vant';

  export default {
    name: "Login",
    data() {
      return {
        activeName: 'verifyLogin',
      };
    },
    computed: {
      titleActive() {
        return 'verifyLogin' == this.activeName
      },
      buttonName() {
        return 'verifyLogin' == this.activeName ? '验证码登录' : '登录'
      }
    },
    mounted() {
      console.log(this.$refs.tttt);
    },
    components: {
      VerifyLogin,
      AccountLogin,
      Footer,
      LoginBottom,
      [Button.name]: Button,
      [Tab.name]: Tab,
      [Tabs.name]: Tabs,
    },
  }
</script>

<style scoped>
  .van-tabs {
    width: 100%;
    position: absolute;
    top: 7%;
    left: 0;
    right: 0;
    margin-right: 45px;
    padding: 20px;
  }
  .tabTitle {
    font-size: 16px;
    font-weight:bold;
  }
  .different-login {
    width: 100%;
    padding: 20px 8%;
    margin: 0 auto;
  }

</style>