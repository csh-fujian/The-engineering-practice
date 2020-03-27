<template>
  <div>
    <van-nav-bar title="工程实践"
                 left-arrow
                 left-text=""
                 @click-left="onClickLeft"
                 >
      <template #right>
        <van-icon name="search"/>
      </template>
    </van-nav-bar>

    <md-banke-tab-bar activeValue="resource"/>
  </div>
</template>

<script>
  import MdBankeTabBar from "components/banke-tabbar/MdBankeTabBar";
  export default {
    name: "Resource",
    components: {
      MdBankeTabBar
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

</style>