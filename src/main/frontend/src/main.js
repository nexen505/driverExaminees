import Vue from 'Vue';
import App from './components/App.vue';
import VueResource from 'vue-resource';
import VeeValidate from './assets/vee-validate.js';
import BootstrapVue from 'bootstrap-vue';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue/dist/bootstrap-vue.css';
import {alert} from 'vue-strap';

Vue.use(VueResource);
Vue.use(VeeValidate);
Vue.use(BootstrapVue);

new Vue({
    components: {
        alert
    },
    el: '#app',
    render: h => h(App)
});