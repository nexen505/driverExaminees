  <template id="new-edit-modal-template">
   
   <div>
      <div class="modal-header">
        <h3>Edit Report {{ id }}</h3>
      </div>

      <div class="modal-body">
        <label class="form-label">
                    Title
                    <input v-model="title" class="form-control">
                </label>
        <label class="form-label">
                    Body
                    <textarea v-model="body" rows="5" class="form-control"></textarea>
                </label>
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
      title: "",
      body: ""
    };
  },
  created() {
    console.log("created");
    this.$root.$on("edit", report => {
      console.log(report);
      this.id = report.id;
      this.title = report.name;
      this.body = report.surname;
      this.show = true;
    });
  },

  beforeDestroy() {
    this.$root.$off("edit");
  },

  methods: {
    close: function() {
      this.show = false;
      this.title = "";
      this.body = "";
      this.id = "";
    },

    refresh: function() {
      this.$dispatch("refreshReports");
    },

    savePost: function() {
      var me = this;

      var dataparams = {
        id: this.id,
        name: this.title,
        description: this.body
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
