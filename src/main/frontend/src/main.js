import Vue from 'Vue'
import App from './components/App.vue'
import VueResource from 'vue-resource'
import BootstrapVue from 'bootstrap-vue'
import { alert } from 'vue-strap'

Vue.use(VueResource);
Vue.use(BootstrapVue);

new Vue({
    components: {
        alert
    },
    el: '#app',
    render: h => h(App)
})

Vue.prototype.$eventHub= new Vue()