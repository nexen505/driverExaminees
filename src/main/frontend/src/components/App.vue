<template>
    <!-- demo root element -->
    <div id="demo">
        <form id="search">
            Search <input name="query" v-model="searchQuery">
        </form>
        <button v-on:click="removeElement(key)">Delete</button>
        <button>Edit</button>
        <button>Add</button>

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
                gridColumns: ['name', 'power', 'age'],
                gridData: [
                    {name: 'Chuck Norris', power: Infinity, age: 23},
                    {name: 'Bruce Lee', power: 9000, age: 21},
                    {name: 'Jackie Chan', power: 7000, age: 20},
                    {name: 'Jet Li', power: 8000, age: 2},
                ],
                selected: []
            }
        },
        methods: {
            removeElement: function (index) {
                this.items.splice(index, 1);
            }
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
