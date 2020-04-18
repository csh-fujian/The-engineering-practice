<template>
  <div>
    <div class="text-center margin-top-small">
      <van-image :src="imageUrl" width="65px" height="65px"  />
    </div>
    <van-cell-group class="margin-top-large">
      <van-cell title="班级">
        <template >
          <input class="input-css" placeholder="未设置" :value="myClass.className"/>
        </template>
      </van-cell>
      <van-cell title="课程">
        <template >
          <input class="input-css" placeholder="未设置" :value="myClass.courseName"/>
        </template>
      </van-cell>
      <van-cell title="学校名称">
        <template >
          <input class="input-css" placeholder="未设置" :value="myClass.schoolName"/>
        </template>
      </van-cell>
      <van-cell title="学院名称">
        <template >
          <input class="input-css" placeholder="未设置" :value="myClass.departmentName"/>
        </template>
      </van-cell>
      <van-cell title="学期">
        <template >
          <input class="input-css" placeholder="2020-2021-2" @click="showPicker = true" :value="myClass.semester"/>
        </template>
      </van-cell>
      <van-cell title="学习要求">
        <template >
          <input class="input-css" placeholder="未设置" :value="myClass.studyDemand"/>
        </template>
      </van-cell>
      <van-cell title="考试要求">
        <template >
          <input class="input-css" placeholder="未设置" :value="myClass.examDemand"/>
        </template>
      </van-cell>
    </van-cell-group>

    <van-popup v-model="showPicker" position="bottom">
      <van-picker
              show-toolbar
              :columns="columns"
              @cancel="showPicker = false"
              @confirm="onConfirm"
      />
    </van-popup>
  </div>
</template>

<script>
  export default {
    name: "TeacherClassInfo",
    data() {
      return {
        imageUrl: require('assets/image/mine/yunbanke.png'),
        showPicker: false,
        columns: ['2019-2020-1', '2019-2020-2', '2020-2021-1', '2020-2021-2', '2021-2022-1', '2021-2022-2'],
      }
    },
    props: {
      myClass: {
        type: Object,
        default() {
          return {
            className: '',
            courseName: '',
            schoolName: '',
            departmentName: '',
            semester: '2020-2021-2',
            studyDemand: '',
            examDemand: ''
          }
        }
      }
    },
    methods: {
      onConfirm(value) {
        this.myClass.semester = value;
        this.showPicker = false;
      }
    }
  }
</script>

<style scoped>
  .input-css {
    width: 100%;
    text-align:right;
    border: none;
  }
</style>