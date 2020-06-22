<template>
  <div>
    <div class="margin-top-large">
      <van-icon name="manager" class="iconCss" size="20px"/> <label class="spanLabel">账号</label><br>
      <van-field
              class="fieldCss"
              v-model="userName"
              placeholder="请输入用户名"
              size="large"
              @click="fieldItemClick('userName')"
      />
    </div>

    <div class="margin-top-small">
      <van-icon  name="lock" class="iconCss" size="20px"/> <span class="spanLabel">密码</span><br>
      <van-field
              class="fieldCss"
              v-model="passWord"
              placeholder="请输入密码"
              size="large"
              @click="fieldItemClick('passWord')"
      />
    </div>

    <label class="forgetCss" @click="forgetPw">忘记密码</label>
    <van-button type="primary" block class="margin-top-normal" @click="btnClick">登录</van-button>
  </div>
</template>

<script>
  import {getLogin} from "network/account/home";

  export default {
    name: "AccountLogin",
    data() {
      return {
        userName: '',
        passWord: '',
      }
    },
    methods: {
      forgetPw() {
        console.log('忘记密码');
        this.$router.push('/resetpassword')
      },
      fieldItemClick(tag) {
      },
      btnClick() {
        const params = {
          'username':this.userName,
          'password':this.passWord
        }

        getLogin(params).then(res=>{
          const data = res.data
          if(data.state) {
            this.$toast(data.role+'用户 登录成功');
            window.localStorage["token"] = JSON.stringify(data.token);
            window.localStorage["role"] = data.role
            this.$store.commit('role', data.role)
            console.log(this.$store.getters.getRole);
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

  .iconCss {
    vertical-align: middle;
  }
  .spanLabel {
    font-size: 16px;
    text-align: center;
    vertical-align: middle;
  }

  .fieldCss {
    border-bottom : 0.5px outset var(--theme-color);
  }

  .forgetCss {
    float: right;
    margin-top: 5px;
    margin-bottom: 10px;
  }



</style>