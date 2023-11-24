import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/views/HomeView.vue'

import LoginView from '@/views/LoginView.vue'
import SignupView from '@/views/SignupView.vue'

import BrandView from '@/views/BrandView.vue'

import OrderView from '@/views/OrderView.vue'
import OrderMenuView from '@/views/OrderMenuView.vue'
import OrderResultView from '@/views/OrderResultView.vue'
import OrderErrorView from '@/views/OrderErrorView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/login',
      name: 'login',
      component: LoginView
    },
    {
      path: '/signup',
      name: 'signup',
      component: SignupView
    },
    {
      path: '/order',
      name: 'order-brand',
      component: BrandView
    },
    {
      path: '/order/:orderCode',
      name: 'order',
      component: OrderView,
      children: [
        {
          path: '',
          name: 'order-result',
          component: OrderResultView
        },
        {
          path: '',
          name: 'order-menu',
          component: OrderMenuView
        },
        {
          path: '',
          name: 'order-error',
          component: OrderErrorView
        },
      ]
    },
  ]
})

export default router
