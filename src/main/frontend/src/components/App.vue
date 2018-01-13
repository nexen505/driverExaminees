<template>
    <!-- demo root element -->
    <div class="demo">
        <div class="owners-wrapper">
            <form class="search" id="searchOwner">
                Найти <input name="query" v-model="searchQuery">
            </form>
            <demo-grid
                    v-on:edit="editOwner"
                    :data="ownersData"
                    :columns="ownerColumns"
                    :filter-key="searchQuery"
                    :delete-url="'http://localhost:8080/driverApp/rest/owners'">
            </demo-grid>
        </div>
        <div class="owner-wrapper" v-show="isSelected">
            <vue-tabs>
                <v-tab title="Данные о владельце">
                    <edit-module v-on:closeOwner="closeOwner"
                                 v-if="owner!=null"
                                 :owner="owner"></edit-module>
                </v-tab>
                <v-tab title="Данные о ТС">
                    <form class="search"
                          id="searchVehicle"
                          v-if="ownerVehiclesData.length">
                        Найти <input name="query" v-model="searchVehiclesQuery">
                    </form>
                    <demo-grid
                            :data="ownerVehiclesData"
                            :columns="vehicleColumns"
                            :filter-key="searchVehiclesQuery"
                            :delete-url="'http://localhost:8080/driverApp/rest/owners'">
                    </demo-grid>
                </v-tab>
            </vue-tabs>
        </div>
    </div>
</template>

<script>
    import DemoGrid from "./DemoGrid.vue";
    import EditModule from "./EditModule.vue";
    import {VTab, VueTabs} from 'vue-nav-tabs'
    import 'vue-nav-tabs/themes/vue-tabs.css'
    import moment from 'moment';

    export default {
        name: "demo",
        components: {
            DemoGrid,
            EditModule,
            VueTabs,
            VTab
        },
        data() {
            return {
                searchQuery: '',
                searchVehiclesQuery: '',
                isSelected: false,

                ownersData: [],
                ownerColumns: {
                    surname: "Фамилия",
                    name: "Имя",
                    patronymic: "Отчество",
                    dateOfBirth: "Дата рождения"
                },

                owner: null,
                ownerVehiclesData: [],
                vehicleColumns: {
                    name: 'Название',
                    brand: 'Марка',
                    yearOfIssue: 'Год выпуска'
                },
            };
        },
        methods: {
            closeOwner: function () {
                console.log('closing owner form..');
                this.isSelected = false;
                this.owner = null;
            },
            editOwner: function(owner) {
                console.log("need to load owner full", owner);
                let url = 'http://localhost:8080/driverApp/rest/owners';
                this.$http.get(url, {
                    params: {
                        id: owner.id
                    }
                })
                    .then(
                        res => {
                            console.log(res);
                            this.owner = res.body.result;
                            this.owner.dateOfBirth = moment(this.owner.dateOfBirth, 'YYYY-MM-DD').toDate();
                            this.isSelected = true;
                            console.log("owner is loaded");
                        },
                        error => console.log(error)
                    );
            }
        },
        beforeCreate() {
            this.$root.$on('loadOwners', evt => {
                let url = 'http://localhost:8080/driverApp/rest/owners';
                this.$http.get(url)
                    .then(function (data) {
                        console.log(data);
                        this.ownersData = data.body.result;
                    });
            });
        },
        beforeDestroy() {
            this.$root.$off('loadOwners');
        },
        created() {
            this.$root.$emit('loadOwners', {});
        }
    };
</script>

<style lang="scss">
    .demo {
        display: flex;
        flex-direction: row;
        .owners-wrapper, .owner-wrapper {
            display: flex;
            flex-direction: column;
            flex: 1 1 100%;
            padding: 10px;
        }
        .owners-wrapper {
            .search {
                margin: 5px 0;
                input {
                    width: 250px;
                }
            }
        }
        .owner-wrapper {
            vue-tabs {
                v-tab {
                    padding: 10px 0;
                }
            }
        }
    }

    #app {
        font-family: "Avenir", Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
        margin-top: 60px;
    }

    h1,
    h2 {
        font-weight: normal;
    }

    ul {
        list-style-type: none;
        padding: 0;
        li {
            display: inline-block;
            margin: 0 10px;
        }
    }

    a {
        color: #42b983;
    }
</style>
