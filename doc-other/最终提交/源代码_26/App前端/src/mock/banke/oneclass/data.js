const tabs = [
  {
    title: '全部',
    count: 0
  },
  {
    title: '进行中',
    count: 0
  },
  {
    title: '已结束',
    count: 0
  }
]

const note = "通知栏："

const tasks =[
]

const detail = {
  dataTop: {
    description: '',
    className: '',
    teacher: '',
    time: '',
  },
  dataContent: {
    classId: '',
    cloudBook: '',
    school: '',
    department: '',
    studyRequire: '',
    teachProcss: '',
    exam: ''
  }
}


const member = {
  rank: null,
  experience: null,
  number: null,
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
  ],

  members: [
  ]
}

export {tabs, note, tasks, detail, member}