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

    <div class="content margin-center">
      <div class="imageclass">
        <van-image width="128" height="128" :src="require('assets/image/resource/making.png')" />
        <p class="text-center">尚未开发</p>
      </div>

    </div>
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
  .imageclass {
    position: absolute;
    left: 50%;
    top: 50%;
    width:200px;
    height:100px;
    margin-left:-100px;
    margin-top:-50px;
  }
</style>