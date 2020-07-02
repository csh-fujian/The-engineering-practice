<template>
  <div>
    <van-nav-bar title="创建作业/小组任务"
                 left-arrow
                 left-text=""
                 @click-left="onClickLeft"
                 @click-right="onClickRight">
      <template #right>
      </template>
    </van-nav-bar>

    <div class="content">

      <van-cell-group class="margin-topdown-small">
        <van-cell title="标题">
          <template >
            <input class="input-css" placeholder="作业任务" v-model="work.title"/>
          </template>
        </van-cell>
        <van-cell title="分组">
        <template >
          <input class="input-css" placeholder="未分组的 " v-model="work.group"/>
        </template>
      </van-cell>
        <van-cell title="任务详情">
          <template >
            <input class="input-css" placeholder="未设置 " v-model="work.detail"/>
          </template>
        </van-cell>
      </van-cell-group>

      <van-cell-group class="margin-top-normal">
        <van-cell title="评分方式" is-link v-model="scoreType" @click="scoreTypeShow = true" />
        <van-cell title="最晚提交时间" is-link v-model="work.uploadTime" @click="showPicker = true" />
      </van-cell-group>
    </div>

    <van-popup v-model="showPicker" position="bottom">
      <van-picker
              show-toolbar
              :columns="columns"
              @cancel="showPicker = false"
              @confirm="onConfirm"
      />
    </van-popup>

    <van-dialog v-model="scoreTypeShow"
                title="评分方式"
                show-cancel-button
                @confirm="scoreTypeConfirm">
      <div>
        <div class="content">
          <van-radio-group v-model="scoreTypeValue">
            <van-radio name="1" shape="square" class="margin-top-small">老师评分</van-radio>
            <van-radio name="2" shape="square"  class="margin-top-small" disabled>指定助教/学生评分</van-radio>
            <van-radio name="3" shape="square"  class="margin-top-small" disabled>学生互评</van-radio>
          </van-radio-group>
        </div>

        <div class="text-normal">
          <van-cell-group>
            <van-field
                       label="作业最大分值"
                       v-model="scoreMax"
                       input-align="right"
                       placeholder="未设置"
            />
          </van-cell-group>
        </div>

      </div>
    </van-dialog>
    <div class="content margin-top-small">
      <div class="content">
        <van-button plain hairline type="primary" block @click="enableWork">发布任务</van-button>
      </div>
    </div>
  </div>
</template>

<script>
  import {formatDate} from 'common/utils'
  import {createWork} from "../../../../network/banke/activity";

  export default {
    name: "CreateWork",
    data() {
      return {
        scoreTypeShow:false,
        scoreTypeValue: '',
        scoreMax: "",
        showPicker: false,
        columns: [
        ],
        work: {
          title: '',
          group: '',
          detail: '',
          uploadTime: '',
          scoreMax: '',
          scoreType: ''
        },

      }
    },
    computed: {
      scoreType() {
        switch (this.scoreTypeValue) {
          case "1":
            return '老师评分';
          case "2":
            return '指定助教/学生评分'
          case "3":
            return '学生互评'
        }
      }
    },
    created() {
      this.columns = this.pickerDirectory()
    },
    methods: {
      //发布任务
      enableWork() {
        const params = {
          classId:this.$route.params.classId,
          username: window.localStorage.userName,
          title: this.work.title,
          detail: this.work.detail,
          scoreMax: this.work.scoreMax,
          endtime: this.work.uploadTime
        }
        console.log(params);
        createWork(params).then(data => {
          console.log(data);
          if (data == "ok") {
            this.$toast('作业发布成功')
            this.$router.back()
          }else {
            this.$toast('作业发布失败, 除了分组，其他内容必填')
          }
        }).then(err => {
          console.log(err);
        })
      },
      scoreTypeConfirm() {
        this.work.scoreType = this.scoreTypeValue
        this.work.scoreMax = this.scoreMax
      },
      onConfirm(value) {
        this.work.uploadTime = value + '时';
        this.showPicker = false;
      },
      onClickLeft() {
        this.$router.back()
      },
      // 创建
      onClickRight() {

      },
      //构建联级目录
      pickerDirectory(dateTimes = 180) {
        let columns = []
        let date = this.pickerDate(dateTimes)

        //处理联级时间
        let pickerTime = this.pickerTime()
        pickerTime = pickerTime.map((item)=> {
          let o = {}
          o.text = item
          return o
        })

        for (let i = 0; i < dateTimes; i++) {
          let directory = {}
          directory.text = date[i]
          directory.children = pickerTime
          columns.push(directory)
        }
        return columns
      },
      // 联级日期的构建
      pickerDate(times) {
        let date = []
        // date.push('今天')
        for (let i=0; i<times; i++)
        {
          let dateTime = new Date()
          dateTime=dateTime.setDate(dateTime.getDate()+i);
          dateTime = new Date(dateTime)
          date.push(formatDate(dateTime, 'MM月dd日'))
        }
        return date
      },
      //联级时间 24小数
      pickerTime() {
        let time = []
        for (let i=0; i<24; i++) {
          time.push(('00'+i).substr(new String(i).length))
        }
        return time
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