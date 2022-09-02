import { createApp } from 'vue'
import App from './App.vue'
import PrimeVue from 'primevue/config'
import router from './router'
import store from './store'
import 'primevue/resources/themes/saga-blue/theme.css'     //theme
import 'primevue/resources/primevue.min.css'                 //core css
import 'primeicons/primeicons.css'                          //icons
import FileUpload from 'primevue/fileupload'

//<<<<<<< HEAD
const app = createApp(App)
app.use(PrimeVue)
app.use(router)
app.component('FileUpload', FileUpload);
app.mount('#app');
//=======
//createApp(App).use(PrimeVue).use(router).mount('#app');
//>>>>>>> 41ad00aed712e9da5ca96c0eb8096146c95e3d0b
