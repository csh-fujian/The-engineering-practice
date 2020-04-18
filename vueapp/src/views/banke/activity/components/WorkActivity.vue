<template>
  <div>
    <van-notice-bar mode="closeable">
      {{note}}
    </van-notice-bar>

    <van-cell-group>
      <van-cell center is-link v-for="item in tasks">
        <template #title>
          <div class="cellItem">
            <van-image :src="require('assets/image/banke/activity/task.png')" width="32px" height="32px" class="vertical-middle"/>
            <span class="margin-left-small">{{item.taskName}}</span>
          </div>
          <div class="flex cell-bottom">
            <div class="flex1 font-gray text-small">{{item.number}} 人参与</div>
            <div class="flex1 text-small"><span class="text-green">{{item.state}}</span> <span class="text-danger right">{{item.experience}} 经验</span></div>
            <div class="flex1 text-small"> <span class="right"><van-icon name="play-circle" class="vertical-middle icon-css"/>{{item.timeState}}</span></div>
          </div>
        </template>
      </van-cell>
    </van-cell-group>
  </div>
</template>

<script>
  export default {
    name: "WorkActivity",
    props: {
      tasks: {
        type: Array,
        default() {
          return []
        }
      },
      note: {
        type: String,
        default: ''
      }
    },
    created() {
      // console.log(this.tasks);
    },
    methods: {

    }
  }
</script>

<style scoped>
  .icon-css {
    margin-bottom: 2px;
    margin-right: 2px;
  }

</style>