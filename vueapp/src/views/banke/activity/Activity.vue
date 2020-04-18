<template>
  <div>
    <van-nav-bar title="工程实践"
                 left-arrow
                 left-text=""
                 @click-left="onClickLeft"
                 @click-right="onClickRight">
      <template #right>
        课堂表现
      </template>
    </van-nav-bar>

    <van-tabs v-model="activeTab" animated>
      <van-tab v-for="(item,index) in tabs" :key="index">
        <template #title>
          <div>
            {{item.title}}({{item.count}})
          </div>
        </template>

        <!-- 作业任务-->
        <work-activity v-show="index===1" :tasks="tasks" :note="note"/>

      </van-tab>
    </van-tabs>

    <md-banke-tab-bar activeValue="activity"/>

  </div>
</template>

<script>
  import { Toast } from 'vant';
  import {tabs, note, tasks} from "mock/banke/oneclass/data.js";
  import MdBankeTabBar from "components/banke-tabbar/MdBankeTabBar";
  import WorkActivity from "./components/WorkActivity";

  export default {
    name: "Activity",
    data() {
      return {
        activeTab: 1,
        tabs: tabs,
        note: note,
        tasks: tasks,
        isTeacher: false,
      }
    },
    created() {
      // console.log(this.tasks);
      this.isTeacher = this.$store.getters.getStatus === 'teacher'
    },
    components: {
      MdBankeTabBar,
      WorkActivity
    },
    methods: {
      onClickLeft()
      {
        this.$router.replace('/banke')
      },
      onClickRight() {
        Toast('课堂表现');
      }
    }
  }
</script>

<style scoped>

</style>