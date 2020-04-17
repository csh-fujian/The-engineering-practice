<template>
  <div>
    <md-nav-bar title="签到" />


    <p class="content background-gray text-small">选择签到方式</p>

    <div class="shadow card flex">
      <div class="flex1 text-center flexItem cardItem"
           v-for="(item,index) in member.launchSignInOption"
           @click="itemClick(index)">
        <van-image
                width="46px"
                height="46px"
                fit="fill"
                :src="item.imageUrl"
        /><br>
        <span class="text-small">{{item.title}}</span>
      </div>
    </div>

    <p class="content background-gray text-small">历史签到记录，左滑可删除</p>

    <van-swipe-cell v-for="(item, index) in member.launchHistory">
      <van-cell size="" :value="item.statistic" >
        <template #title>
          <span class="text-small">{{item.signDate}} {{item.signWeek}} </span>
          <span class="text-small font-gray">{{item.signTime}} {{item.signType}}</span>
        </template>
      </van-cell>
      <template #right>
        <van-button square type="danger" text="删除" class="swipe-height"/>
      </template>
    </van-swipe-cell>

    <pwd v-model="showPwd" />
  </div>
</template>

<script>
  import {member} from "mock/banke/oneclass/data.js"
  import MdNavBar from "components/nav-bar/MdNavBar";
  import Pwd from "../../../../components/pwd/Pwd";


  export default {
    name: "LaunchSignIn",
    data() {
      return {
        member: member,
        showPwd: false
      }
    },
    created() {

    },
    components: {
      Pwd,
      MdNavBar

    },
    methods: {
      itemClick(index) {
        if (index == 1) {
          this.showPwd = true
        }
      }
    }
  }
</script>

<style scoped>

  .card {
    position: relative;
    z-index: 9;
    background-color: white;
    height: 88px;
    margin: 0 auto;
    padding: 10px 12px;
  }
  .cardItem {
    line-height: 1.3;
  }
  .swipe-height {
    height: 100%;
  }

</style>