<template>
  <div>
    <div class="background" />
    <van-sticky>
      <van-nav-bar title="工程实践"
                   left-arrow
                   left-text=""
                   @click-left="onClickLeft" >
      </van-nav-bar>
    </van-sticky>

    <div class="margin-top-normal text-center text-white">
      <span class="text-max">第 4 名</span><br>
      <span class="text-small">当前获得28经验值</span>
    </div>

    <div class="border-radius shadow card flex">
      <div class="flex1 text-center flexItem cardItem" v-for="index in 3">
        <van-image
                round
                width="46px"
                height="46px"
                fit="fill"
                src="https://img.yzcdn.cn/vant/cat.jpeg"
        /><br>
        <span class="text-small">参与签到</span>
      </div>
    </div>
    <van-sticky :offset-top="36">
      <div class="content margin-top-small border-bottom container-title">
        <span class="text-small left">成员总数</span>
        <span class="text-small font-gray right">155 人</span>
      </div>
    </van-sticky>
    <member-list  v-for="index in 50"/>

    <md-banke-tab-bar activeValue="member"/>
  </div>
</template>

<script>
  import MdBankeTabBar from "components/banke-tabbar/MdBankeTabBar";
  import MemberList from "./components/MemberList";
  export default {
    name: "Member",
    components: {
      MdBankeTabBar,
      MemberList
    },
    methods: {
      onClickLeft()
      {
        this.$router.replace('/banke')
      }
    }
  }
</script>

<style scoped>
  .background {
    position: absolute;
    z-index:-100;
    background-color: var(--blue);
    width: 100%;
    height: 168px;
  }
  .card {
    position: relative;
    z-index: 9;
    background-color: white;
    height: 88px;
    width: 94%;
    margin: 0 auto;
    margin-top: 10px;
    padding: 10px 12px;
  }
  .cardItem {
    line-height: 1.3;
  }
  .container-title {
    width: 100%;
    background-color: #fff;
    height: 36px;
  }
</style>