<template>
  <div>

    <md-nav-bar title="加入班课" />

    <div class="content">
      <div class="margin-top-normal">
        <p class="text-normal">请输入班课号：</p>
      </div>

      <van-cell-group>
        <van-field class="margin-topdown-normal" v-model="classId" label="班课号" label-class="text-normal"/>
      </van-cell-group>
      <van-button plain hairline type="primary" block @click="nextClick">下一步</van-button>
    </div>
  </div>
</template>

<script>
  import MdNavBar from "components/MdNavBar";
  import {joinClass} from "../../../../network/banke/home";
  export default {
    name: "AddClass",
    data() {
      return {
        classId: ''
      }
    },
    components: {
      [MdNavBar.name] : MdNavBar
    },
    methods: {
      nextClick() {
        // 加入班课
        joinClass(this.classId).then(res=>{
          console.log(res);
        }).catch(err=>{
          console.log(err);
        })


        this.$router.push('/banke/add-class/' + this.classId)

      },
    }
  }
</script>

<style scoped>

</style>