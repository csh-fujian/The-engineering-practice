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

      <van-button type="primary" block class="margin-top-normal">重新获取</van-button>
    </div>
  </div>
</template>

<script>
  import { PasswordInput, NumberKeyboard } from 'vant';

  export default {
    name: "CheckCode",
    data() {
      return {
        keySize: 4,
        value: '',
        showKeyboard: true,
        errorInfo: '',
        phone: ''
      }
    },
    props: {
    },
    created() {
      this.phone = this.$route.params.phone
    },
    components: {
      [PasswordInput.name]: PasswordInput,
      [NumberKeyboard.name]: NumberKeyboard
    },
    methods: {
      onClickLeft() {
        this.$router.back()
      },
      onInput(key) {
        this.value = (this.value + key).slice(0, this.keySize);
        if (this.value.length == this.keySize && true)
        {
          this.$router.replace('/home')
        }
      },
      onDelete() {
        this.value = this.value.slice(0, this.value.length - 1);
      }
    }
  }
</script>

<style scoped>
  .check-code {
    height: 100vh;
  }
</style>