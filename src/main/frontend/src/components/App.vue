<template>
    <!-- demo root element -->
    <div id="demo">
        <form id="search">
            Search <input name="query" v-model="searchQuery">
        </form>
        <demo-grid
                :data="gridData"
                :columns="gridColumns"
                :filter-key="searchQuery"
                :selected="selected">
        </demo-grid>

    </div>
</template>

<script>
    import DemoGrid from './DemoGrid.vue'
    import MainGrid from './MainGrid.vue'

    export default {
        name: '#demo',
        components: {DemoGrid},
        data() {
            return {
                searchQuery: '',
                gridColumns: {
                    surname: "Surname",
                    name : 'name',
                    patronymic:'patronymic',
                    dateOfBirth: 'Date Of Birth'},
                gridData: [
                    {id: "fdsdf", surname:'Smith', name:'Adam', patronymic:'Ara', dateOfBirth:'12-12-2001'},
                    {surname:'Black', name:'Petr', patronymic:'Eres', dateOfBirth:'07-04-2001'},
                    {surname:'White', name:'Carl', patronymic:'Fare', dateOfBirth:'07-04-2001'},
                    {surname:'Lens', name:'Sara', patronymic:'Ynsa', dateOfBirth:'07-04-2001'},
                ],
                selected: []
            }
        },
        methods: {
            // removeElement: function (index) {
            //     this.items.splice(index, 1);
            // }
        }
    }
</script>

<style lang="scss">
    #app {
        font-family: 'Avenir', Helvetica, Arial, sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        text-align: center;
        color: #2c3e50;
        margin-top: 60px;
    }

    h1, h2 {
        font-weight: normal;
    }

    ul {
        list-style-type: none;
        padding: 0;
    }

    li {
        display: inline-block;
        margin: 0 10px;
    }

    a {
        color: #42b983;
    }

</style>
