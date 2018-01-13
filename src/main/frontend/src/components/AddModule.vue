  <template id="new-edit-modal-template">
   
   <div>
      <div class="modal-header">
        <h3>Add Report </h3>
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
        <label class="form-label">
                    Date of B-day
                    <input v-model="dateOfBirth" class="form-control">
                </label>
      </div>

      <div class="modal-footer text-right">
        <button class="btn btn-default" @click="close">Cancel</button>
        <button class="btn btn-primary modal-default-button" @click="addPost()">
                <span class="glyphicon glyphicon-save" style="margin-top: 3px;"></span> Add
                </button>
      </div>
  </div>
    
</template>
  
 
 
<script>
export default {
  props: ["show"],
  data: function() {
    return {
      id: "",
      name: "",
      surname: "",
      patronymic: "",
      dateOfBirth: ""
    };
  },
  created() {
    console.log("created");
    this.$root.$on("add", report => { //todo возможно это не надо
      console.log(report);
      this.name = report.name;
      this.surname = report.surname;
      this.patronymic = report.patronymic;
      this.dateOfBirth = report.dateOfBirth;
    });
  },

  beforeDestroy() {
    this.$root.$off("edit");
  },

  methods: {
    close: function() {
      this.name = "";
      this.surname = "";
      this.patronymic = "";
      this.dateOfBirth = "";
    },

    refresh: function() {
      this.$dispatch("refreshReports");
    },



    savePost: function() {
      var me = this;

      var dataparams = {
        name: this.name,
        surname: this.surname,
        patronymic: this.patronymic,
        dateOfBirth: this.dateOfBirth
      };
      console.log("Updating Post");
    
      this.$http.post(
        "http://crossorigin.me/http://codepen.io/billmurrin/pen/EKXbyZ.js",
        dataparams,
        {
          xhr: {
            onreadystatechange: function(response) {
              if (this.readyState === 4) {
                console.log("Updated Post");
                console.log(response);
                console.log(this.status);
                console.log(this.response);
                console.log("Sending Refresh Dispatch");
                setTimeout(function() {
                  me.$dispatch("refreshReports");
                }, 1500);
                return;
              }
            }
          }
        }
      );
      this.close();
    }
  }
};
</script>
