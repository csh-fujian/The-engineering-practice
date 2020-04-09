<template>
  <div>
    <van-sticky>
      <van-nav-bar title="隐私政策"
                   left-text="关闭"
                   @click-left="onClickLeft" >
      </van-nav-bar>
    </van-sticky>

    <div class="content">
      <h2 class="text-center margin-top-large">{{data.title}}</h2>
      <p class="text-small text-center margin-topdown-small">{{data.version}}</p>

      <div class="content abstract">
        <p v-html="data.abstract">{{data.abstract}}</p>
      </div>
      <div class="content directory">
        <p class="text-line-large" v-html="data.directory">{{data.directory}}</p>
      </div>

      <div class="content define">
        <p v-html="data.content">{{data.content}}</p>
      </div>
    </div>

  </div>
</template>

<script>
  import {privacyContent} from 'mock/mine/privacy-policy.js'
  export default {
    name: "PrivacyPolicy",
    data() {
      return {
        data: privacyContent
      }
    },
    methods: {
      onClickLeft() {
        this.$router.back()
      }
    }
  }
</script>

<style scoped>
  .abstract p {
    text-indent: 1.8rem;
    line-height: 1.4;
  }
  .directory p {
    line-height: 1.5;
  }
  .define p {
    line-height: 1.5;
  }

</style>