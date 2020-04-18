<template>
  <div>
    <van-nav-bar title="关联手机"
                 left-arrow
                 @click-left="onClickLeft" >
    </van-nav-bar>

    <div class="content">
      <div class="margin-top-normal" />
      <van-cell-group>
        <van-field class="margin-topdown-normal" v-model="phoneNumber"  label="关联手机号"  label-class="text-normal"/>
      </van-cell-group>
      <van-button plain hairline type="primary" block @click="check">手机验证</van-button>
    </div>
  </div>
</template>

<script>
  export default {
    name: "AssociatePhone",
    data() {
      return {
        phoneNumber: '15960486819'
      }
    },
    methods: {
      check() {
        this.$router.push('/components/checkcode/'+this.phoneNumber)
      },
      onClickLeft() {
        this.$router.back()
      }
    }
  }
</script>

<style scoped>

</style>