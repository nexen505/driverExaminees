  <template id="new-edit-modal-template">
   
   <div>
      <div class="modal-header">
        <h3>Edit Report {{ id }}</h3>
      </div>

      <div class="modal-body">
        <label class="form-label">
                    Name
                    <input v-model="name" class="form-control">
                </label>
        <label class="form-label">
                    Surname
                    <input v-model="surname" class="form-control">
                </label>
        <label class="form-label">
                    Patronymic
                    <input v-model="patronymic" class="form-control">
                </label>
        <!-- <label class="form-label">
                    Date of B-day
                    <input v-model="dateOfBirth" class="form-control">
                </label> -->
      </div>

      <div class="modal-footer text-right">
        <button class="btn btn-default" @click="close">Cancel</button>
        <button class="btn btn-primary modal-default-button" @click="savePost()">
                <span class="glyphicon glyphicon-save" style="margin-top: 3px;"></span> Save
                </button>
      </div>
  </div>
    
</template>

<script>
// import Modal from "./Modal.vue";
export default {
  // components: { Modal },
  props: ["show"],
  data: function() {
    return {
      id: "",
      name: "",
     surname: "",
      patronymic: ""
    //  dateOfBirth: ""
    };
  },
  created() {
    console.log("created");
    this.$root.$on("edit", report => {
      console.log(report);
      // this.id = report.id;
      // this.name = report.name;
      //  this.surname = report.surname;
      // this.patronymic = report.patronymic;
      // this.dateOfBirth = report.dateOfBirth;
      this.id = report.id;
      this.name = report.title;
      this.surname = report.body;
      // this.patronymic = report.patronymic;
      // this.dateOfBirth = report.dateOfBirth;
    });
  },

  beforeDestroy() {
    this.$root.$off("edit");
  },

  methods: {
    close: function() {
      this.id = "";
      this.name = "";
      // this.surname = "";
      this.patronymic = "";
    //  this.dateOfBirth = "";
    },

    refresh: function() {
      this.$dispatch("refreshReports");
    },

    savePost: function() {
      var me = this;
    //   var dataparams = {
    //     id: this.id,
    //     name: this.name,
    //     surname: this.surname,
    //     patronymic: this.patronymic
    //  //   dateOfBirth: this.dateOfBirth
    //   };
       var dataparams = {
        userId: 1,
        id:  this.id,
        title: this.name,
        body: this.surname
     //   dateOfBirth: this.dateOfBirth
      };
      console.log("Updating Post");
      this.$http.post("https://jsonplaceholder.typicode.com/posts", dataparams)
      .then(
        (res)=> console.log (res.body)
        // function(response) { //fixme вставить ответ от сервака
        //       console.log("111");
        //       if (this.readyState === 4) {
        //         console.log("Updated Post");
        //         console.log(response);
        //         console.log(this.status);
        //         console.log(this.response);
        //         console.log("Sending Refresh Dispatch");
        //         setTimeout(function() {
        //           me.$dispatch("refreshReports");
        //         }, 1500);
        //         return;
        //       }
        //     }
      )
      .catch ((error)=> console.log(error));
      this.close();
    }
  }
};
</script>
