<template>
  <div>
    <van-nav-bar title="消息"
                 left-arrow
                 left-text=""
                 @click-left="onClickLeft"
                 @click-right="onClickRight">
      <template #right>
        私聊
      </template>
    </van-nav-bar>
    <md-banke-tab-bar activeValue="message"/>
  </div>
</template>

<script>
  import MdBankeTabBar from "components/banke-tabbar/MdBankeTabBar";

  export default {
    name: "Message",
    components: {
      MdBankeTabBar
    },
    methods: {
      onClickLeft() {
        this.$router.back()
      },
      onClickRight() {
        this.$toast('私聊功能暂未开启');
      }
    }
  }
</script>

<style scoped>

</style>