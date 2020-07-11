import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Welcome',
    redirect: 'list'
  },
  {
    path: '/home',
    name: 'home',
    component: () => import('../views/Home')
  },
  {
    path: '/list',
    name: 'list',
    component: () => import('../views/list')
  },
  {
    path: '/list/:id',
    name: 'list2',
    component: () => import('../views/list')
  },
  {
    path: '/search',
    name: 'search',
    component: () => import('../views/Search.vue')
  },
  {
    path: '/search/:search',
    name: 'search2',
    component: () => import('../views/Search.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
