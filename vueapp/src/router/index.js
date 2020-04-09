import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from "../views/account/login/Login";





// 懒加载


const BankeHome =() => import('../views/banke/home/Home.vue')
const BankeActivity =() => import('views/banke/activity/Activity.vue')
const BankeDetail =() => import('views/banke/detail/Detail.vue')
const BankeMember =() => import('views/banke/member/Member.vue')
const BankeMessage =() => import('views/banke/message/Message.vue')
const BankeResource =() => import('views/banke/resource/Resource.vue')

const CheckCode = () => import('../views/account/login/CheckCode')
const SearchHome = () => import('views/search/home/SearchHome')


const MineHome = () => import('views/mine/home/MineHome')
const Profile = () => import("views/mine/profile/Profile");
const PrivacyPolicy = () => import('views/mine/privacy-policy/PrivacyPolicy')
const AboutUs = () => import('../views/mine/about-us/AboutUs.vue')
const UserPolicy = () => import("../views/mine/user-policy/UserPolicy")
const AccountManage = ()=> import("views/mine/account-manage/AccountManage")
const AccountManageNav = ()=> import( "../views/mine/account-manage/components/AccountManageNav")
const IdentityCheck = ()=> import( "../views/mine/account-manage/components/IdentityCheck")



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
    path: '/login/checkcode/:phone',
    component: CheckCode
  },
  {
    path: '/banke',
    component: BankeHome,
  },
  {
    path: '/banke/:classId/activity',
    component: BankeActivity
  },
  {
    path: '/banke/:classId/detail',
    component: BankeDetail
  },
  {
    path: '/banke/:classId/member',
    component: BankeMember
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
        path: '/mine/account-manage/identity-check',
        component: IdentityCheck
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
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
