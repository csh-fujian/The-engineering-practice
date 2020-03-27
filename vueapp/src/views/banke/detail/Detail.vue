<template>
  <div>
    <div class="background" />
    <van-nav-bar title="工程实践"
                 left-arrow
                 left-text=""
                 @click-left="onClickLeft" >
    </van-nav-bar>

    <detail-top class="top-css" />
    <deatil-content />
    <detail-bottom />
    <md-banke-tab-bar activeValue="detail"/>
  </div>
</template>

<script>
  import MdBankeTabBar from "components/banke-tabbar/MdBankeTabBar";
  import DetailTop from "./components/DetailTop";
  import DeatilContent from "./components/DeatilContent";
  import DetailBottom from "./components/DetailBottom";

  export default {
    name: "Detail",
    components: {
      MdBankeTabBar,
      DetailTop,
      DeatilContent,
      DetailBottom
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
    height: 140px;
  }
  .top-css {
    position: relative;
    z-index: 9;
    background-color: white;
    margin-top: 50px;
  }

</style>