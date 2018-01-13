<template>
    <!-- demo root element -->
    <div class="demo">
        <form id="search">
            Search <input name="query" v-model="searchQuery">
        </form>
        <demo-grid
            :data="gridData"
            :columns="gridColumns"
            :filter-key="searchQuery"
            :selected="selected"
          :showNewEditModal = "showNewEditModal">   <!-- fixme  !!!!!-->
        </demo-grid>
        <edit-module :show.sync="this.showNewEditModal"> </edit-module>

    </div>
</template>

<script>
import DemoGrid from "./DemoGrid.vue";
import EditModule from "./EditModule.vue";

export default {
  name: "demo",
  components: { DemoGrid, EditModule },
  data() {
    return {
      searchQuery: "",
      gridColumns: {
        id: "Surname",
        title: "name",
        body: "patronymic"
        // dateOfBirth: "Date Of Birth"
      },
      gridData: [
        {
          id: "1",
          surname: "Smith",
          name: "Adam",
          patronymic: "Ara",
          dateOfBirth: "12-12-2001"
        },
        {
          id: "2",
          surname: "Black",
          name: "Petr",
          patronymic: "Eres",
          dateOfBirth: "07-04-2001"
        },
        {
          id: "3",
          surname: "White",
          name: "Carl",
          patronymic: "Fare",
          dateOfBirth: "07-04-2001"
        },
        {
          id: "4",
          surname: "Lens",
          name: "Sara",
          patronymic: "Ynsa",
          dateOfBirth: "07-04-2001"
        }
      ],
      selected: [],
       showNewEditModal: false  // fixme  !!!
    };
  },
  methods: {
  },
  created () {
    this.$http.get('https://jsonplaceholder.typicode.com/posts')
      .then(function(data) {
        // this.gridData.id = data.id;
        //  this.gridData.surname = data.id;
        //  this.gridData.name =data.userId;
        //  this.gridData.patronymic =data.title;
        //  this.gridData.dateOfBirth =data.body;
         console.log(data);
        this.gridData = data.body.slice(0,10);
        console.log(data.body.slice(0,10));
          console.log(data.body.slice(0,10).title);
      });
  }
};
</script>

<style lang="scss">
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
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}
</style>
