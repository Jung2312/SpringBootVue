import { createRouter, createWebHistory } from 'vue-router'
import LoginView from '../views/LoginView.vue'
import BoardView from '../views/BoardView.vue'
import MemberMenagementView from '../views/MemberMenagementView.vue'
import MemberDetailView from '../views/MemberDetailView.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    { path: '/login', component: LoginView },
    { path: '/board', component: BoardView },
    { path: '/memberMenagement', component: MemberMenagementView },
    { path: '/member?email=:email', component: MemberDetailView },
  ],
})

export default router
