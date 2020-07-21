<template>
  <div>
    <van-nav-bar title="发现">
      <template #right>
        帮助
      </template>
    </van-nav-bar>
    <van-cell-group>
      <van-cell title="课程圈" is-link class="margin-top-small"/>
    </van-cell-group>

    <van-cell-group>
      <van-cell title="第二课程" is-link class="margin-top-normal"/>
    </van-cell-group>
    <md-tab-bar activeValue="search" />
  </div>
</template>

<script>
  import MdTabBar from "components/tabbar/MdTabBar";
  export default {
    name: "SearchHome",
    data() {
      return {
      }
    },
    components: {
      MdTabBar
    }
  }
</script>

<style scoped>

</style>