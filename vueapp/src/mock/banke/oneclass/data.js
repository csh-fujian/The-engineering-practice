const tabs = [
  {
    title: '全部',
    count: 5
  },
  {
    title: '进行中',
    count: 5
  },
  {
    title: '已结束',
    count: 0
  }
]

const note = "第五次作业已经发布"

const tasks =[
  {
    workId:1,
    taskName: '第一周XXXX',
    number: 150,
    state: '已参与',
    experience: 10,
    timeState: '已超时'
  },
  {
    workId:2,
    taskName: '第二周XXXX',
    number: 150,
    state: '已参与',
    experience: 10,
    timeState: '已超时'
  },
  {
    workId:3,
    taskName: '第三周XXXX',
    number: 150,
    state: '已参与',
    experience: 10,
    timeState: '已超时'
  },
  {
    workId:4,
    taskName: '第四周XXXX',
    number: 150,
    state: '已参与',
    experience: 10,
    timeState: '已超时'
  },
  {
    workId:5,
    taskName: '第五周XXXX',
    number: 150,
    state: '已参与',
    experience: 10,
    timeState: '已超时'
  },
]

const detail = {
  dataTop: {
    description: '2019级工程',
    className: '工程实践',
    teacher: '池XX',
    time: '2019-2020-2 学校课表班课',
  },
  dataContent: {
    classId: '123456',
    cloudBook: '未设置',
    school: '福州大学',
    department: '数计学院',
    studyRequire: '暂无内容',
    teachProcss: '暂无内容',
    exam: '暂无安排'
  }
}


const member = {
  rank: 4,
  experience: 40,
  number: 3,
  option: [
    {
      imageUrl: require('assets/image/banke/member/sign.png'),
      title: '发起签到',
    },
    {
      imageUrl: require('assets/image/banke/member/card.png'),
      title: '心意卡片',
    },
    {
      imageUrl: require('assets/image/banke/member/group.png'),
      title: '小组方案',
    },
    {
      imageUrl: require('assets/image/banke/member/danger.png'),
      title: '挂科预警',
    }
  ],
  option_student: [
    {
      imageUrl: require('assets/image/banke/member/sign.png'),
      title: '签到',
    },
    {
      imageUrl: require('assets/image/banke/member/card.png'),
      title: '心意卡片',
    },
    {
      imageUrl: require('assets/image/banke/member/group.png'),
      title: '小组方案',
    },
  ],
  launchSignInOption: [
    {
      imageUrl: require('assets/image/banke/member/signNow.png'),
      title: '一键签到',
    },
    {
      imageUrl: require('assets/image/banke/member/signPose.png'),
      title: '手势签到',
    },
    {
      imageUrl: require('assets/image/banke/member/signHand.png'),
      title: '手工登记',
    },
  ],
  launchHistory: [
    {
      signDate: '2020-0414',
      signWeek: '星期二',
      signTime: '15:03',
      signType: '一键签到',
      statistic: '20人/25人'
    },
    {
      signDate: '2020-0414',
      signWeek: '星期二',
      signTime: '15:03',
      signType: '一键签到',
      statistic: '20人/25人'
    },
    {
      signDate: '2020-0414',
      signWeek: '星期二',
      signTime: '15:03',
      signType: '一键签到',
      statistic: '20人/25人'
    }
  ],

  members: [
    {
      profilePhoto: 'xx',
      name: '池xx',
      studentId: '1903270xx',
      experience: 35,
      cloudBookStudy: 0
    },
    {
      profilePhoto: 'xx',
      name: '池xx',
      studentId: '1903270xx',
      experience: 35,
      cloudBookStudy: 0
    },
    {
      profilePhoto: 'xx',
      name: '池xx',
      studentId: '1903270xx',
      experience: 35,
      cloudBookStudy: 0
    }
  ]
}

export {tabs, note, tasks, detail, member}