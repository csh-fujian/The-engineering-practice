<template>
  <div>
    <van-cell-group>
      <ClassItem v-for="item in data"
                 :key="item.classId"
                 @click.native="classItemClick(item.classId)">
        <div slot="title-content">
          <span class="custom-title bold">{{item.bankeName}}</span><br>
          <span class="text-small">{{item.teacher}}</span>
          <span class="text-small font-gray margin-left-small">{{item.semester}}</span><br>
        </div>
        <div slot="icon">
          <div class="flex">
            <div class="flex1">
              <van-icon name="label-o" class="vertical-middle" size="16" /><span class="text-small" @click.stop="signClick(item.classId)">签到</span>
            </div>
            <div class="flex1">
              <van-icon name="smile-o" class="vertical-middle" size="16" /><span class="text-small" @click.stop="handUpClick">举手</span>
            </div>
            <div class="flex1">
              <van-icon name="bullhorn-o" class="vertical-middle" size="16" /><span class="text-small" @click.stop="answerClick">抢答</span>
            </div>
          </div>
        </div>
      </ClassItem>

    </van-cell-group>
  </div>
</template>

<script>
  import ClassItem from "./ClassItem";
  export default {
    name: "studentClass",
    data() {
      return {

      }
    },
    props: {
      data: {
        type: Array,
        default() {
          return []
        }
      }
    },
    created() {
      console.log(this.data,'111111111');
    },
    components: {
      ClassItem
    },
    methods: {
      answerClick() {
        this.$toast('该功能未开发')
      },
      handUpClick() {
        this.$toast('该功能未开发')
      },
      //图标，直接进入签到
      signClick(classId) {
        console.log('signclick');
        this.$router.push('/banke/'+classId+'/member')
      },
      // 进入一个班课
      classItemClick(classId) {
        this.$emit('classItemClick', classId)
      },
    }
  }
</script>

<style scoped>

</style>