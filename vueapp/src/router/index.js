import Vue from 'vue'
import VueRouter from 'vue-router'


// 懒加载
const About = () => import('../views/mine/about/About.vue')
const Home =() => import('../views/banke/home/Home.vue')

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/home',
    component: Home
  },
  {
    path: '/about',
    name: 'about',
    component: About
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
