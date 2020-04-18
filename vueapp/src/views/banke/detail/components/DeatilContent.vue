<template>
  <div class="margin-top-small">
    <div v-if="isTeacher">
      <van-cell title="云教材"
                is-link
                :label="data.cloudBook"
                @click="couldBookShow=true" />
      <van-cell title="学校院系"
                is-link
                :label="data.school + data.department"
                @click="schoolDepartmentShow=true"/>

      <van-cell title="学习要求"
                is-link
                :label="data.studyRequire"
                :border="false"
                @click="studyRequireShow=true"/>

      <van-cell title="教学进度"
                is-link
                :label="data.teachProcss"
                :border="false"
                @click="teachProcssShow=true"/>

      <van-cell title="考试安排"
                is-link
                :label="data.exam"
                :border="false"
                @click="examArrangeShow=true"/>
    </div>
    <div v-else>
      <van-cell title="云教材" :label="data.cloudBook" />
      <van-cell title="学校院系" :label="data.school + data.department"/>
      <van-cell title="学习要求" :label="data.studyRequire" :border="false"/>
      <van-cell title="教学进度" :label="data.teachProcss" :border="false"/>
      <van-cell title="考试安排" :label="data.exam" :border="false"/>
    </div>

    <van-dialog v-model="couldBookShow"
                title="云教材"
                show-cancel-button
                @confirm="couldBookConfirm">
      <div>
        <van-field
                v-model="couldBookValue"
                :placeholder="data.cloudBook"
        />
      </div>
    </van-dialog>

    <van-dialog v-model="schoolDepartmentShow"
                title="学校院系"
                show-cancel-button
                @confirm="schoolDepartmentConfirm">
      <div class="content">
        <van-field
                label="学校"
                v-model="schoolValue"
                :placeholder="data.school"
        />
        <van-field
                label="学院"
                v-model="departmentValue"
                :placeholder="data.department"
        />
      </div>
    </van-dialog>

    <van-dialog v-model="studyRequireShow"
                title="学习要求"
                show-cancel-button
                @confirm="studyRequireConfirm">
      <div>
        <van-field
                v-model="studyRequireValue"
                rows="2"
                autosize
                type="textarea"
                maxlength="500"
                placeholder="考试安排内容"
                show-word-limit
        />
      </div>
    </van-dialog>

    <van-dialog v-model="teachProcssShow"
                title="教学进度"
                show-cancel-button
                @confirm="teachProcssConfirm">
      <div>
        <van-field
                v-model="teachProcssValue"
                rows="2"
                autosize
                type="textarea"
                maxlength="500"
                placeholder="教学进度"
                show-word-limit
        />
      </div>
    </van-dialog>

    <van-dialog v-model="examArrangeShow"
                title="考试安排"
                show-cancel-button
                @confirm="examArrangeConfirm">
      <div>
        <van-field
                v-model="examArrangeValue"
                rows="2"
                autosize
                type="textarea"
                maxlength="500"
                placeholder="考试安排内容"
                show-word-limit
        />
      </div>
    </van-dialog>

  </div>
</template>

<script>
  export default {
    name: "DeatilContent",
    data() {
      return {
        isTeacher: false,
        couldBookShow: false,
        couldBookValue: '',
        schoolDepartmentShow: false,
        departmentValue: '',
        schoolValue: '',
        studyRequireShow: false,
        studyRequireValue: '',
        teachProcssShow: false,
        teachProcssValue: '',
        examArrangeShow: false,
        examArrangeValue: ''
      }
    },
    created() {
      this.isTeacher = this.$store.getters.getStatus === 'teacher'
    },
    props: {
      data: {
        type: Object
      }
    },
    methods: {
      couldBookConfirm() {
        if (this.couldBookValue !== this.data.cloudBook) {
          console.log('更新')
          this.data.cloudBook = this.couldBookValue
        }
      },
      schoolDepartmentConfirm() {
        if (this.schoolValue !== this.data.school) {
          console.log('更新')
          this.data.school = this.schoolValue
        }
        else if (this.departmentValue !== this.data.department) {
          console.log('更新')
          this.data.department = this.departmentValue
        }
      },
      studyRequireConfirm() {
        if (this.studyRequireValue !== this.data.studyRequire) {
          console.log('更新')
          this.data.studyRequire = this.studyRequireValue
        }
      },
      teachProcssConfirm() {
        if (this.teachProcssValue !== this.data.teachProcss) {
          console.log('更新')
          this.data.teachProcss = this.teachProcssValue
        }
      },
      examArrangeConfirm() {
        if (this.examArrangeValue !== this.data.exam) {
          console.log('更新')
          this.data.exam = this.examArrangeValue
        }
      }
    }
  }
</script>

<style scoped>

</style>