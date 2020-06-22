<template>
  <div>
    <div class="margin-top-large">
      <van-icon name="phone" class="iconCss" size="20px"/> <label class="spanLabel">手机号</label><br>

      <ValidationProvider rules="mobile"  ref="phonenumber" v-slot="{ errors }">
        <van-field
                class="fieldCss"
                name="phone"
                v-model="phone"
                placeholder="请输入电话号码"
                size="large"
                @click="fieldItemClick('phone')"
        />
        <span >{{ errors[0] }}</span>
      </ValidationProvider>


      <div class="forgetCss" />
      <van-button type="primary" block class="margin-top-normal" @click="btnClick">验证码登录</van-button>
    </div>


  </div>
</template>

<script>

  import {singleSendMessage} from "network/network";

  export default {
    name: "VerifyLogin",
    data() {
      return {
        phone: '',
      }
    },
    methods: {
      fieldItemClick(tag) {

      },
      btnClick() {
        let vf2 = this.$refs.phonenumber.$el.innerText
        if(this.$refs.phonenumber.$el.innerText !== '')
          console.log('error')
        else
          console.log('true')
        this.$store.commit('phone', this.phone)
        this.$router.push('/components/checkcode/'+this.phone + '/banke')
        singleSendMessage(this.phone, 1234)

      },
    }
  }
</script>

<style scoped>
  .fieldCss {
    border-bottom : 0.5px outset var(--theme-color);
  }
  .forgetCss {
    margin-top: 10px;
    margin-bottom: 25px;
  }
</style>