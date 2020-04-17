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

    <div v-if="isTeacher" class="margin-top-large text-center text-white">
      <span class="text-normal">学生详情</span><br>
    </div>
    <div v-else class="margin-top-normal text-center text-white">
      <span class="text-max">第 {{member.rank}} 名</span><br>
      <span class="text-small">当前获得{{member.experience}}经验值</span>
    </div>

    <div class="border-radius shadow card flex">
      <div class="flex1 text-center flexItem cardItem" v-for="(item,index) in member.option" @click="itemClick(index)">
        <van-image
                round
                width="46px"
                height="46px"
                fit="fill"
                :src="item.imageUrl"
        /><br>
        <span class="text-small">{{item.title}}</span>
      </div>
    </div>

    <div v-if="isTeacher" class="background-theme">
      <van-field
              class="background-theme"
              v-model="searchData"
              center
              clearable
              placeholder="输入查询信息"
              :border="true"
      >
        <template #button>
          <van-icon name="search" style="line-height: inherit;" />
        </template>
      </van-field>

    </div>


    <van-sticky :offset-top="36">
      <div class="content border-bottom container-title" :class="{'margin-top-small': !isTeacher}">
        <span class="text-small left">成员总数：{{member.number}} 人</span>
        <span class="text-small font-gray right " @click="sortTypeClick">{{sortType}}</span>
      </div>
    </van-sticky>

    <van-cell-group>
      <member-item  v-for="item in member.members" :memberItem="item" />
    </van-cell-group>

    <md-banke-tab-bar activeValue="member"/>
  </div>
</template>

<script>
  import MdBankeTabBar from "components/banke-tabbar/MdBankeTabBar";
  import MemberList from "./components/MemberList";
  import MemberItem from "./components/MemberItem";

  import {member} from "mock/banke/oneclass/data.js"

  export default {
    name: "Member",
    data() {
      return {
        member: member,
        isTeacher: false,
        searchData: '',
        sortType: '切换为学号排序'
      }
    },
    created() {
      this.isTeacher = this.$store.getters.getStatus === 'teacher'
    },
    components: {
      MdBankeTabBar,
      MemberList,
      MemberItem
    },
    methods: {
      itemClick(index) {
        if (index == 0) {
          this.$router.push('/banke/'+this.$route.params.classId+'/member/launch-sign')
        }
      },
      sortTypeClick() {
        if (this.sortType == '切换为学号排序')
          this.sortType = '切换为经验值排序'
        else
          this.sortType = '切换为学号排序'
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