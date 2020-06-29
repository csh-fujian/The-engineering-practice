<template>
  <div>
    <div class="background" />
    <van-nav-bar title="工程实践"
                 left-arrow
                 left-text=""
                 @click-left="onClickLeft" >
    </van-nav-bar>

    <detail-top class="top-css" :data="dataTop" />
    <deatil-content :data="dataContent"/>
    <detail-bottom />
    <md-banke-tab-bar activeValue="detail"/>
  </div>
</template>

<script>
  import MdBankeTabBar from "components/banke-tabbar/MdBankeTabBar";
  import DetailTop from "./components/DetailTop";
  import DeatilContent from "./components/DeatilContent";
  import DetailBottom from "./components/DetailBottom";

  import {detail} from "mock/banke/oneclass/data";
  import {getOneClass} from "../../../network/banke/activity";

  export default {
    name: "Detail",
    data() {
      return {
        data: detail,
        dataTop: {},
        dataContent: {}
      }
    },
    created() {
      //网络获取首页数据
      this.getOneClassData()
      // this.dataTop = this.data.dataTop
      // this.dataContent = this.data.dataContent
    },
    components: {
      MdBankeTabBar,
      DetailTop,
      DeatilContent,
      DetailBottom
    },
    methods: {
      //获得页面数据
      getOneClassData() {
        // 请求首页数据
        console.log(this.$route.params.classId)
        const params = {
          classId:this.$route.params.classId,
          username: window.localStorage.userName
        }
        getOneClass(params).then(data => {
          console.log(data);
          this.data = data.detail
          this.dataTop = data.detail.dataTop
          this.dataContent = data.detail.dataContent
        }).catch(err => {
          console.log(err);
        })
      },
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