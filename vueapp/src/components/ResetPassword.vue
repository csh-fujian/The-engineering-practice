<template>
  <div class="content">
    <van-nav-bar title="修改密码"
                 left-arrow
                 left-text=""
                 @click-left="onClickLeft" >
    </van-nav-bar>
    <div class="content">
      <div class="margin-top-large">
        <van-icon  name="lock" class="iconCss" size="20px"/> <span class="spanLabel">密码</span><br>
        <van-field
                class="fieldCss"
                v-model="passWord"
                placeholder="请输入新密码"
                size="large"

        />
      </div>
      <div class="margin-top-normal" />
      <van-button type="primary" block class="margin-top-normal" @click="btnClick">修改密码</van-button>

    </div>
  </div>
</template>

<script>
  export default {
    data() {
      return {
        passWord: '',
      }
    },
    name: "ResetPassword",
    methods: {
      // 修改密码
      btnClick() {
        if (true) {
          this.$router.back();
        }
      },
      onClickLeft() {

        this.$router.back();
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


</style>