<template>
  <div>
    <van-nav-bar title="关联邮箱"
                 left-arrow
                 @click-left="onClickLeft" >
    </van-nav-bar>

    <div class="content">
      <div class="margin-top-normal" />
      <van-cell-group>
        <van-field class="margin-topdown-normal" v-model="email"  label="关联Email"  label-class="text-normal"/>
      </van-cell-group>
      <van-button plain hairline type="primary" block @click="check">邮箱验证</van-button>
    </div>
  </div>
</template>

<script>
  export default {
    name: "AssociateMail",
    data() {
      return {
        email: ''
      }
    },
    methods: {
      check() {
      },
      onClickLeft() {
        this.$router.back()
      }
    }
  }
</script>

<style scoped>

</style>