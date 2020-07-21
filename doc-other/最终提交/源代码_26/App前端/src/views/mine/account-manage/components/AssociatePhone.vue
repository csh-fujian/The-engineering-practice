<template>
  <div>
    <van-nav-bar title="关联手机"
                 left-arrow
                 @click-left="onClickLeft" >
    </van-nav-bar>

    <div class="content">
      <div class="margin-top-normal" />


      <ValidationObserver slim ref="form">
        <ValidationProvider name="手机号" rules="required|phone" v-slot="{ errors }" slim>
          <van-cell-group>
            <van-field class="margin-topdown-normal"
                       v-model="form.phoneNumber"
                       label="关联手机号"
                       :error-message="errors[0]"
                       label-class="text-normal"/>
          </van-cell-group>
        </ValidationProvider>
      </ValidationObserver>

      <van-button plain hairline type="primary" block @click="check">手机验证</van-button>
    </div>
  </div>
</template>

<script>
  export default {
    name: "AssociatePhone",
    data() {
      return {
        form: {
          phoneNumber: ''
        }
      }
    },
    methods: {
      check() {
        this.$refs.form.validate().then(success => {
          // success结果返回布尔值
          if (!success) return

          // 处理请求
          this.$store.commit('phone', this.phone)
          this.$router.push('/components/checkcode/'+this.form.phoneNumber + '/account-manage')
          singleSendMessage(this.phone, 1234)
          this.$toast('接口未实现')

          this.$nextTick(() => {
            // 清除验证状态，需注意值不会清除要自己手动清除
            this.$refs.form.reset()
          })
        }).catch(err => {
          console.log(err);
        })
      },
      onClickLeft() {
        this.$router.back()
      }
    }
  }
</script>

<style scoped>

</style>