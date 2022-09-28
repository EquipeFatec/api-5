import { createRouter, createWebHashHistory } from 'vue-router'
import AboutView from '../views/AboutView.vue'
import HomeView from '../views/HomeView.vue'
import TelaUpload from '../views/TelaUpload.vue'
import Login from '../views/Login.vue'


const routes = [
  {
    path: '/',
    name: 'about',
    component: AboutView
  },
  {
    path: '/tela-upload',
    name: 'tela-upload',
    component: TelaUpload
  },
  {
    path: '/login',
    name: 'login',
    component: Login
  }


  // {
  //   path: '/about',
  //   name: 'about',
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  // }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

router.beforeEach((to, from) => {
  // ...
  // explicitly return false to cancel the navigation
  const estaAutenticado = localStorage.getItem('userToken');

  if (to.name.includes('tela-upload') && !estaAutenticado) {
    return { name: 'about' }
  }
})

export default router
