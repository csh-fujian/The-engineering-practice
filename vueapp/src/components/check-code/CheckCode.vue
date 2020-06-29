<template>
  <div class="background-gray check-code">
    <van-nav-bar
            title="获取验证"
            left-text="返回"
            left-arrow
            @click-left="onClickLeft"
    />

    <div class="margin-top-max content">
      <div class="text-big margin-left-small">验证手机号：<span class="text-normal">{{phone}}</span></div>

      <!-- 密码输入框 -->
      <van-password-input
              class="margin-topdown-normal"
              :value="value"
              :length="4"
              :gutter="15"
              :error-info="errorInfo"
              :focused="showKeyboard"
              @focus="showKeyboard = true"
      />
      <!-- 数字键盘 -->
      <van-number-keyboard
              :show="showKeyboard"
              @input="onInput"
              @delete="onDelete"
              @blur="showKeyboard = false"
      />

      <van-button type="primary" block
                  class="margin-top-normal"
                  :disabled="cannt_click"
                  @click="btnClick">{{content}}</van-button>
    </div>
  </div>
</template>

<script>
  import { PasswordInput, NumberKeyboard } from 'vant';
  import {getVerifyLogin} from "../../network/account/home";

  export default {
    name: "CheckCode",
    data() {
      return {
        keySize: 4,
        value: '',
        showKeyboard: true,
        errorInfo: '',
        phone: '',
        cannt_click: true,
        totalTime: 30,
        TOTALTIME: 30,
        content: '',
        goto: '',
      }
    },
    props: {
    },
    created() {
      this.phone = this.$route.params.phone
      this.goto = this.$route.params.thing
      console.log(this.goto);
      this.onCalcTime();

    },
    components: {
      [PasswordInput.name]: PasswordInput,
      [NumberKeyboard.name]: NumberKeyboard
    },
    methods: {
      btnClick() {
        this.cannt_click = true
        this.onCalcTime();
      },
      onCalcTime() {
        this.content = this.totalTime + 's后重新发送'  //这里解决60秒不见了的问题
        let clock = window.setInterval(() => {
          this.totalTime--
          this.content = this.totalTime + 's后重新发送'
          this.cannt_click=true
          if (this.totalTime < 0) {         //当倒计时小于0时清除定时器
            window.clearInterval(clock)
            this.content = '重新发送验证码'
            this.cannt_click = false
            this.totalTime = this.TOTALTIME
          }
        },1000)
      },
      onClickLeft() {
        this.$router.back()
      },
      onInput(key) {
        this.value = (this.value + key).slice(0, this.keySize);
        if (this.value.length == this.keySize && true)
        {
          this.value = ''
          //通用性变低，为了简单，普遍多申请一次http获得用户信息
          const params = {
            phone : this.phone
          }
          this.getVerifyLoginInfo(params)
        }
      },
      onDelete() {
        this.value = this.value.slice(0, this.value.length - 1);
      },
      getVerifyLoginInfo(params) {
        getVerifyLogin(params).then(res=>{
          const data = res.data
          if(data.state) {
            this.$toast(data.role+'用户 登录成功');
            window.localStorage["token"] = data.token
            window.localStorage["userName"] = data.username
            if (data.role == '学生')
              window.localStorage["role"] = 'student'
            else if (data.role == '老师')
              window.localStorage["role"] = 'teacher'

            this.$store.commit('role', data.role)
            this.$store.commit('userName', data.username)

            // 验证码验证成果，回去的地址
            this.$router.replace('/'+this.goto)
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
      },
    }
  }
</script>

<style scoped>
  .check-code {
    height: 100vh;
  }
</style>