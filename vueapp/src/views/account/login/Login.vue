<template>
  <div>
    <div class="van-tabs" ref="test">
      <van-tabs
        v-model="activeName"
        type="line"
        :border="false">


        <van-tab  name="accountLogin">
          <div class="different-login">
            <account-login  @accountLogin="accountLoginClick"/>
            <login-bottom :buttonName="buttonName"/>
          </div>
          <span :class="{tabTitle:!titleActive}" slot="title">账号登录</span>
        </van-tab>

        <van-tab name="verifyLogin" ref="verify">
          <div class="different-login">
            <verify-login />
            <login-bottom :buttonName="buttonName"/>
          </div>
          <span :class="{tabTitle:titleActive}" slot="title">验证码登录</span>
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
  import {getLogin} from "network/account/home";


  export default {
    name: "Login",
    data() {
      return {
        activeName: 'accountLogin',
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
    created() {

    },
    activated() {
      // 第二次登录，注销账号时window.localStorage["isFirst"]=-1
      if(window.localStorage["isFirst"]==1 ) {
        const params = {
          'phone':window.localStorage['phone'],
          'password':window.localStorage['passWord']
        }
        this.loginRequest(params)
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
    methods: {
      //网络请求
      accountLoginClick(params) {
        this.loginRequest(params)
      },
      //登录请求
      loginRequest(params) {
        console.log(params);
        getLogin(params).then(res=>{
          const data = res.data
          console.log(data);

          if(data.state!="false") {
            this.$toast(data.role+'用户 登录成功');
            console.log(data.token);
            // window.localStorage["token"] = JSON.stringify(data.token);
            window.localStorage["token"] = data.token
            window.localStorage["userName"] = data.map.username

            console.log(window.localStorage["userName"]);
            if (data.role == '学生')
              window.localStorage["role"] = 'student'
            else if (data.role == '老师')
              window.localStorage["role"] = 'teacher'

            this.$store.commit('role', data.role)
            this.$store.commit('userName', params.username)

            //第二次不需要登录
            window.localStorage["isFirst"] = 1
            window.localStorage["passWord"] =  params.password
            window.localStorage['phone'] = params.phone
            this.$router.push('/banke')

          }else if (data.code == 500) {
            this.$toast(data.msg);
          }
          else {
            this.$toast(data.info);
          }
          console.log(res);
        }).catch(err=>{
          console.log(err);
        })
      }

    }
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