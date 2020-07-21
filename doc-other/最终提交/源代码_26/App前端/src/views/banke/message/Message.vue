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

    <div class="imageclass">
      <div class="margin-left-normal">
        <van-image width="128" height="128" :src="require('assets/image/resource/making.png')" />
      </div>
      <p class="text-center text-big bold"><br></br>尚未开发</p>
    </div>

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
  .imageclass {
    position: absolute;
    left: 53%;
    top: 40%;
    width:200px;
    height:100px;
    margin-left:-100px;
    margin-top:-50px;
  }
</style>