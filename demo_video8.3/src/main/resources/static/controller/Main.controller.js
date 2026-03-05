sap.ui.define(
["sap/ui/core/mvc/Controller",
 "aayush/util/service",
 "sap/m/MessageBox"],
function(Controller, service, MessageBox){

    return Controller.extend("aayush.controller.Main", {

        onInit: function(){
            var oModel = new sap.ui.model.json.JSONModel();
            oModel.setData({
                "postPayload": {
                    "companyName": "",
                    "firstName": "",
                    "lastName": "",
                    "website": "",
                    "email": "",
                    "status": "A"
                },
                "vendor": {}
            });

            // set the model object to the entire app level
            this.getView().setModel(oModel);
        },

        onSave: function(){
            var oModel = this.getView().getModel();
            var payload = oModel.getProperty("/postPayload");

            service.callService("/newVendor", "POST", payload)
            .then(function(){
                MessageBox.success("Saved Successfully");
            })
            .catch(function(){
                MessageBox.error("Post failed");
            });
        },

        onLoadData: function(){
            // alert("todo: we will call our microservice to load vendors");
            var that = this;

            service.callService("/newVendor", "GET", {}).then(function(data){

                // console.log(data)

                // get the object of the table
                var oTable = that.getView().byId("idTable");

                // create a new ui5 model which contains data
                var oModel = that.getView().getModel();
                oModel.setProperty("/vendor", data._embedded.vendor);

                // Bind aggregation of the table
                oTable.bindRows("/vendor");

            })
            .catch(function(err){
                console.error(err);
            });
        },

        onDeleteSelected: function(){

            var that = this;
            var oTable = this.getView().byId("idTable");

            var aSelectedIndices = oTable.getSelectedIndices();

            if (aSelectedIndices.length === 0){
                sap.m.MessageBox.warning("Please select at least one row");
                return;
            }

            sap.m.MessageBox.confirm("Are you sure you want to delete selected record(s)?", {
                onClose: function(oAction){

                    if(oAction === "OK"){

                        aSelectedIndices.forEach(function(iIndex){

                            var oContext = oTable.getContextByIndex(iIndex);

                            if(oContext){

                                var oObject = oContext.getObject();

                                // Extract ID from self link
                                var sHref = oObject._links.self.href;

                                var sId = sHref.substring(sHref.lastIndexOf("/") + 1);

                                // console.log("Deleting ID:", sId);

                                service.callService("/newVendor/" + sId, "DELETE", {});
                            }
                        });

                        sap.m.MessageBox.success("Deleted Successfully");

                        that.onLoadData(); // refresh table
                    }
                }
            });
        }

    });

});