import { defineStore } from 'pinia'
import { login, getUserInfo, logout } from '@/api/auth'
import { ref } from 'vue'

export const useUserStore = defineStore('user', () => {
  const token = ref(localStorage.getItem('token') || '')
  const userInfo = ref(null)

  async function loginAction(loginForm) {
    try {
      const data = await login(loginForm)
      token.value = data
      localStorage.setItem('token', data)
      return true
    } catch (error) {
      return false
    }
  }

  async function getUserInfoAction() {
    try {
      const data = await getUserInfo()
      userInfo.value = data
      return true
    } catch (error) {
      return false
    }
  }

  async function logoutAction() {
    try {
      await logout()
      token.value = ''
      userInfo.value = null
      localStorage.removeItem('token')
      return true
    } catch (error) {
      return false
    }
  }

  return {
    token,
    userInfo,
    loginAction,
    getUserInfoAction,
    logoutAction
  }
}) 