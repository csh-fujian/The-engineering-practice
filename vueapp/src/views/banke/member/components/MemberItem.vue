<template>
  <div>
    <van-cell class="item" label-class="right-content">
      <!-- 使用 title 插槽来自定义标题 -->
      <template #icon>
        <div>
          <span class="left text-danger vertical-middle margin-top-small">1</span>
          <img src="~assets/image/banke/home/class.png" alt="" class="item-img margin-left-small">
        </div>
      </template>
      <template #title>
        <div class="title">
          <div class="left-css left">
            <span class="text-normal">{{memberItem.name}}</span><br>
            <span class="text-small font-gray">{{memberItem.studentId}}</span>
          </div>
          <div class="right">
            <span class="text-small font-gray">云教材学习 {{memberItem.cloudBookStudy}}%</span><br>
            <span class="text-big text-green">{{memberItem.experience}}  </span> <span class="text-small text-green">经验值</span>

          </div>
        </div>
      </template>
      <template #right-icon>
        <div class="into-position font-gray">
          <van-icon name="arrow" />
        </div>
      </template>
    </van-cell>

  </div>
</template>

<script>
  export default {
    name: "MemberItem",
    data() {
      return {

      }
    },
    props: {
      memberItem: {
        type: Object
      }
    }
  }
</script>

<style scoped>
  .item {
    height: 70px;
  }
  .item-img {
    margin-top: 2px;
    height: 50px;
    width: 50px;
  }
  .title {
    padding-left: 4%;
    line-height: 1.9;
  }
  .into-position {
    margin-top: 18px;
    font-size: 18px;
  }
  .left-css {
    margin-left: 2px;
  }
</style>