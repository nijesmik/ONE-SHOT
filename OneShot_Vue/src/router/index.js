import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '@/views/HomeView.vue'
import OrderMenuView from '@/views/OrderMenuView.vue'
import orderBrandView from '@/views/OrderBrandView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/order',
      name: 'order-brand',
      component: orderBrandView
    },
    {
      path: '/order/:orderCode',
      name: 'order-menu',
      component: OrderMenuView
    },
  ]
})

export default router
