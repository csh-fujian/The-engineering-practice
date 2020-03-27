<template>
  <div>
    <van-notice-bar mode="closeable">
      第五次作业已发布
    </van-notice-bar>

    <van-cell-group>
      <van-cell center is-link>
        <template #title>
          <div class="cellItem">
            <van-image :src="require('assets/image/banke/activity/task.png')" width="32px" height="32px" class="vertical-middle"/>
            <span class="margin-left-small">第五周课堂练习</span>
          </div>
          <div class="flex cell-bottom">
            <div class="flex1 font-gray text-small">150 人参与</div>
            <div class="flex1 text-small"><span class="text-green">已参与</span> <span class="text-danger right">10 经验</span></div>
            <div class="flex1 text-small"> <span class="right"><van-icon name="play-circle" class="vertical-middle icon-css"/>已超时</span></div>
          </div>
        </template>
      </van-cell>
    </van-cell-group>
  </div>
</template>

<script>
  export default {
    name: "WorkActivity"
  }
</script>

<style scoped>
  .icon-css {
    margin-bottom: 2px;
    margin-right: 2px;
  }

</style>