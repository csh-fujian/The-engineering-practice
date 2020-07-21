<template>
  <div>
    <van-cell-group>
      <ClassItem v-for="item in data"
                 :key="item.classId"
                 @click.native="classItemClick(item.classId)">
<!--        :imgSrc="item.profilePhoto"-->
        <div slot="title-content">
          <span class="custom-title bold">{{item.bankeName}}</span><br>
          <span class="text-small">{{item.master}}</span>
          <span class="text-small font-gray margin-left-small">{{item.semster}}</span><br>
        </div>

        <div slot="icon">
          <div class="flex">
            <div class="flex1">
              <van-icon name="label-o" class="vertical-middle" size="16" /><span class="text-small" @click.stop="signClick(item.classId)">签到</span>
            </div>
            <div class="flex1">
              <van-icon name="tv-o" class="vertical-middle" size="16" /><span class="text-small" @click.stop = "slideClick">幻灯片</span>
            </div>
            <div class="flex1">
              <van-icon name="flower-o" class="vertical-middle" size="16" /><span class="text-small" @click.stop = "showClick">课堂表现</span>
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
    name: "teacherClass",
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
    components: {
      ClassItem
    },
    methods: {
      // 图标 课程表现
      showClick() {
        this.$toast('该功能未开发')
      },
      //图标幻灯片
      slideClick() {
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
  /*.icon-position{*/
  /*  width: 100%;*/
  /*  margin: 0 auto;*/
  /*  text-align: center;*/
  /*}*/
</style>