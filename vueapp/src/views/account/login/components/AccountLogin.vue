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
              type="password"
              @click="fieldItemClick('passWord')"
      />
    </div>

    <label class="forgetCss" @click="forgetPw">忘记密码</label>
    <van-button type="primary" block class="margin-top-normal" @click="btnClick">登录</van-button>
  </div>
</template>

<script>


  import {setSha256} from "../../../../common/utils";

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

        console.log(setSha256("123"));
        const res = setSha256(this.passWord)
        const params = {
          'phone':this.userName,
          'password':res
        }
        console.log("emit")
        this.$emit('accountLogin', params)
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