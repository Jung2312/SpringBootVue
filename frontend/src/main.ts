import { createApp } from 'vue'
import App from './App.vue'
import router from './router'

// Vuetify 추가
import { createVuetify } from 'vuetify'
import 'vuetify/styles'

const vuetify = createVuetify()

createApp(App)
  .use(router)
  .use(vuetify) // Vuetify 등록
  .mount('#app')
