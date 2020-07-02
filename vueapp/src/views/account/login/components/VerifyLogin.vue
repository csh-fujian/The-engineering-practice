<template>
  <div>
    <div class="margin-top-large">
      <van-icon name="phone" class="iconCss" size="20px"/> <label class="spanLabel">手机号</label><br>


<!--      <ValidationProvider name="手机号" rules="required|phone" v-slot="{ errors }" slim>-->
<!--        <van-field-->
<!--                v-model="form.phone"-->
<!--                label="手机号"-->
<!--                placeholder="请输入手机号"-->
<!--                required-->
<!--                :error-message="errors[0]"-->
<!--        />-->
<!--      </ValidationProvider>-->

      <ValidationObserver slim ref="form">
        <ValidationProvider name="手机号" rules="required|phone" v-slot="{ errors }" slim>
          <van-field
                  class="fieldCss"
                  name="phone"
                  v-model="form.phone"
                  placeholder="请输入电话号码"
                  size="large"
                  :error-message="errors[0]"
          />
        </ValidationProvider>
      </ValidationObserver>

      <div class="forgetCss" />
      <van-button type="primary" block class="margin-top-normal" @click="btnClick">验证码登录</van-button>
    </div>


  </div>
</template>

<script>

  import {singleSendMessage} from "network/network";
  import {getLogin} from "../../../../network/account/home";

  export default {
    name: "VerifyLogin",
    data() {
      return {
        form:{
          phone: '',
        }
      }
    },
    created() {
    },
    methods: {

      btnClick() {
        this.$refs.form.validate().then(success => {
          // success结果返回布尔值
          if (!success) return

          // 处理请求
            this.$store.commit('phone', this.phone)
            this.$router.push('/components/checkcode/'+this.form.phone + '/banke')
            singleSendMessage(this.phone, 1234)
          this.$nextTick(() => {
            // 清除验证状态，需注意值不会清除要自己手动清除
            this.$refs.form.reset()
          })
        }).catch(err => {
          console.log(err);
        })



        // let vf2 = this.$refs.phonenumber.$el.innerText
        // if(this.$refs.phonenumber.$el.innerText !== '')
        // {
        //   console.log('error')
        // }
        // else {
        //   this.$store.commit('phone', this.phone)
        //   this.$router.push('/components/checkcode/'+this.phone + '/banke')
        //   singleSendMessage(this.phone, 1234)
        // }



        // 验证成果
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