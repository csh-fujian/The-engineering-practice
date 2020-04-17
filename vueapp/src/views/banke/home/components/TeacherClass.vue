<template>
  <div>
    <van-cell-group>
      <ClassItem v-for="item in data"
                 :imgSrc="item.profilePhoto"
                 :key="item"
                 @click.native="classItemClick(item.classId)">
        <div slot="title-content">
          <span class="custom-title bold">{{item.bankeName}}</span><br>
          <span class="text-small">{{item.semester}}</span>
          <span class="text-small font-gray margin-left-small">{{item.description}}</span><br>
        </div>

        <div slot="icon">
          <div class="flex">
            <div class="flex1">
              <van-icon name="label-o" class="vertical-middle" size="16" /><span class="text-small">签到</span>
            </div>
            <div class="flex1">
              <van-icon name="tv-o" class="vertical-middle" size="16" /><span class="text-small">幻灯片</span>
            </div>
            <div class="flex1">
              <van-icon name="flower-o" class="vertical-middle" size="16" /><span class="text-small">课堂表现</span>
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
      // 进入一个班课
      classItemClick(classId) {
        this.$router.push('/banke/'+classId+'/oneclass')
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