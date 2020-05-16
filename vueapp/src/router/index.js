import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from "../views/account/login/Login";





// 懒加载
const BankeHome =() => import('../views/banke/home/Home.vue')
const BankeActivity =() => import('views/banke/activity/Activity.vue')
const CreateWork =() => import('views/banke/activity/components/CreateWork')
const BankeDetail =() => import('views/banke/detail/Detail.vue')
const EditClassInfo =() => import('views/banke/detail/components/EditClassInfo')
const BankeMember =() => import('views/banke/member/Member.vue')
const LaunchSignIn =() => import('views/banke/member/components/LaunchSignIn')
const LaunchSignPose  =() => import( "../views/banke/member/components/LaunchSignPose")

const SignIn =() => import("../views/banke/member/components/SignIn")
const SignInSuccess =() => import( "../views/banke/member/components/SignInSuccess")

const BankeMessage =() => import('views/banke/message/Message.vue')
const BankeResource =() => import('views/banke/resource/Resource.vue')
const AddClass = () => import("../views/banke/home/components/AddClass")
const AddClassDetail = () => import("../views/banke/home/components/AddClassDetail")
const TeacherCreateClass =() => import('../views/banke/home/components/TeacherCreateClass')

const CheckCode = () => import('../components/check-code/CheckCode')
const SearchHome = () => import('views/search/home/SearchHome')


const MineHome = () => import('views/mine/home/MineHome')
const Profile = () => import("views/mine/profile/Profile");
const PrivacyPolicy = () => import('views/mine/privacy-policy/PrivacyPolicy')
const AboutUs = () => import('../views/mine/about-us/AboutUs.vue')
const UserPolicy = () => import("../views/mine/user-policy/UserPolicy")
const AccountManage = ()=> import("views/mine/account-manage/AccountManage")
const AccountManageNav = ()=> import( "../views/mine/account-manage/components/AccountManageNav")
const IdentityCheck = ()=> import( "../views/mine/account-manage/components/IdentityCheck")
const ModifyPassword = () => import("../views/mine/account-manage/components/ModifyPassword")
const AssociatePhone = () => import("../views/mine/account-manage/components/AssociatePhone")
const AssociateMail = () => import("../views/mine/account-manage/components/AssociateMail")
const Set = () => import("../views/mine/setting/Set")



Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    component: BankeHome
  },
  {
    path: '/login',
    component: Login
  },
  {
    path: '/components/checkcode/:phone/',
    component: CheckCode
  },
  {
    path: '/banke',
    component: BankeHome,
  },
  {
    path: '/banke/create',
    component: TeacherCreateClass
  },
  {
    path: '/banke/:classId/oneclass',
    component: BankeActivity
  },
  {
    path: '/banke/:classId/oneclass/createWork',
    component: CreateWork
  },
  {
    path: '/banke/:classId/detail/',
    component: BankeDetail
  },
  {
    path: '/banke/:classId/detail/edit',
    component: EditClassInfo
  },
  {
    path: '/banke/:classId/member',
    component: BankeMember
  },
  {
    path: '/banke/:classId/member/launch-sign',
    component: LaunchSignIn
  },
  {
    path: '/banke/:classId/member/launch-sign/pose',
    component: LaunchSignPose
  },
  {
    path: '/banke/:classId/member/sign-in',
    component: SignIn
  },
  {
    path: '/banke/:classId/member/sign-in/success',
    component: SignInSuccess
  },
  {
    path: '/banke/:classId/message',
    component: BankeMessage
  },
  {
    path: '/banke/:classId/resource',
    component: BankeResource
  },
  {
    path: '/banke/add-class',
    component: AddClass
  },
  {
    path: '/banke/add-class/:classId/',
    component: AddClassDetail
  },
  {
    path: '/search',
    component: SearchHome
  },
  {
    path: '/mine',
    component: MineHome,
  },
  {
    path: '/mine/account-manage',
    component: AccountManage,
    children: [
      {
        path: '/',
        component: AccountManageNav
      },
      {
        path: '/mine/account-manage/nav',
        component: AccountManageNav
      },
      {
        path: '/mine/account-manage/identity-check/:type/',
        component: IdentityCheck
      },
      {
        path: '/mine/account-manage/identity-check/modify-password/password',
        component: ModifyPassword
      },
      {
        path: '/mine/account-manage/modify-phone',
        component: AssociatePhone
      },
      {
        path: '/mine/account-manage/modify-email',
        component: AssociateMail
      }
    ]
  },
  {
    path: '/mine/profile',
    component: Profile
  },
  {
    path: '/mine/privacy',
    component: PrivacyPolicy
  },
  {
    path: '/mine/about-us',
    name: 'about-us',
    component: AboutUs
  },
  {
    path: '/mine/user-policy',
    component: UserPolicy
  },
  {
    path: '/mine/setting',
    component: Set
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
