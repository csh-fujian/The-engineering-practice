<template>
  <div>
    <van-cell-group>
      <ClassItem v-for="item in data"
                 :key="item"
                 :imgSrc="item.profilePhoto"
                 @click.native="classItemClick(item.classId)">
        <div slot="title-content">
          <span class="custom-title bold">{{item.bankeName}}</span><br>
          <span class="text-small">{{item.teacher}}</span>
          <span class="text-small font-gray margin-left-small">{{item.description}}</span><br>
        </div>
        <div slot="icon">
          <div class="flex">
            <div class="flex1">
              <van-icon name="label-o" class="vertical-middle" size="16" /><span class="text-small">签到</span>
            </div>
            <div class="flex1">
              <van-icon name="smile-o" class="vertical-middle" size="16" /><span class="text-small">举手</span>
            </div>
            <div class="flex1">
              <van-icon name="bullhorn-o" class="vertical-middle" size="16" /><span class="text-small">抢答</span>
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
      // 进入一个班课
      classItemClick(classId) {
        this.$emit('classItemClick', classId)

      },
    }
  }
</script>

<style scoped>

</style>