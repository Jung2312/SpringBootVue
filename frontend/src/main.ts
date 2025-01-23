import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import { createPinia } from 'pinia'
import './assets/global.css'

// Vuetify 추가
import { createVuetify } from 'vuetify'
import 'vuetify/styles'

const vuetify = createVuetify()

createApp(App)
  .use(createPinia())
  .use(router)
  .use(vuetify) // Vuetify 등록
  .mount('#app')
