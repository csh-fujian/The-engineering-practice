<template>
  <div class="home">
    <van-nav-bar title="我加入的">
      <template #right>
        <van-icon name="plus"/>
      </template>
    </van-nav-bar>

    <van-search
            v-model="value"
            show-action
            placeholder="请输入搜索关键词"
            label="搜索"
    >
      <template #action>
        <div @click="onSort">调序</div>
      </template>
    </van-search>


    <student-class @click.native="classItemClick"/>

    <md-tab-bar activeValue="banke" />
  </div>
</template>

<script>
import StudentClass from "./components/StudentClass";
import MdTabBar from "components/tabbar/MdTabBar";

export default {
  name: 'Home',
  data() {
    return {
      value: '',
    }
  },
  created() {
    // console.log(this.$store.state.test);
  },
  components: {
    StudentClass,
    MdTabBar
  },
  methods: {
    classItemClick() {
      console.log('test');
      this.$router.push('/banke/123/activity')
    },
    onClickRight() {
      Toast('按钮');
    },
    onSearch() {
      console.log('search');
    },
    onSort() {
      console.log('调序');
    }
  }
}
</script>
