<template>
  <div>
    <van-cell-group>
      <ClassItem>
        <div slot="title-content">
          <span class="custom-title bold">工程实践</span><br>
          <span class="text-small">池sh</span>
          <span class="text-small font-gray margin-left-small">2019工程实训</span><br>
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
    components: {
      ClassItem
    }
  }
</script>

<style scoped>

</style>