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


      <label class="forgetCss">忘记密码</label>
      <van-button type="primary" block class="margin-top-normal" @click="btnClick">验证码登录</van-button>
    </div>


  </div>
</template>

<script>

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
        this.$router.push('/login/checkcode/'+this.phone)
      },
    }
  }
</script>

<style scoped>
  .fieldCss {
    border-bottom : 0.5px outset var(--theme-color);
  }
  .forgetCss {
    float: right;
    margin-top: 5px;
    margin-bottom: 10px;
  }
</style>