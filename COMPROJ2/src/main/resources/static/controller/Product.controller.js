sap.ui.define(
["sap/ui/core/mvc/Controller",
 "aayush/util/ProductService",
 "sap/m/MessageBox"],
function(Controller, service, MessageBox){

    return Controller.extend("aayush.controller.Product", {

		
		//Setting global template
        onInit: function(){
            var oModel = new sap.ui.model.json.JSONModel();
            oModel.setData({
                "postPayload": {
					
					 "productId": "",
					 "name": "",
					 "type": "",
					 "sector": "",
					 "group": "",
					 "uom": ""
					
                },
                "product": {},
				"editPayload": {},
				"editVisible": false,
				"editButtonVisible": true
            });

            // set the model object to the entire app level
            this.getView().setModel(oModel);
        },

        onSave: function(){
            var oModel = this.getView().getModel();
            var payload = oModel.getProperty("/postPayload");

            service.callService("/product", "POST", payload)
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

            service.callService("/product", "GET", {}).then(function(data){

                // console.log(data)

                // get the object of the table
                var oTable = that.getView().byId("idTable");

                // create a new ui5 model which contains data
                var oModel = that.getView().getModel();
                oModel.setProperty("/product", data);

                // Bind aggregation of the table
                oTable.bindRows("/product");

            })
            .catch(function(err){
                console.error(err);
            });
        },
		
		
		onEditProduct: function () {

		    var id = this.byId("searchId").getValue();
		    var that = this;

		    fetch("/product/" + id)
		    .then(res => res.json())
		    .then(function(data){

		        if(data.productId === 0){
		            sap.m.MessageBox.error("Product ID does not exist");
		            return;
		        }

/*		        var oModel = new sap.ui.model.json.JSONModel({
		            editPayload : data
		        });

		        that.getView().setModel(oModel);*/
				
				var oModel = that.getView().getModel();

				oModel.setProperty("/editPayload", data);
				oModel.setProperty("/editVisible", true);
				oModel.setProperty("/editButtonVisible", false);

		    });

		},
		
/*		onUpdateProduct: function(){

		    var payload = this.getView().getModel().getProperty("/editPayload");

		    fetch("/product",{
		        method:"PUT",
		        headers:{
		            "Content-Type":"application/json"
		        },
		        body:JSON.stringify(payload)
		    })
		    .then(res=>res.json())
		    .then(function(){
		        sap.m.MessageToast.show("Product Updated");
		    });
			
			var oModel = this.getView().getModel();
			oModel.setProperty("/editVisible", false);

		},
		*/
		
		onUpdateProduct: function(){

		    var that = this;
		    var payload = this.getView().getModel().getProperty("/editPayload");

		    fetch("/product",{
		        method:"PUT",
		        headers:{
		            "Content-Type":"application/json"
		        },
		        body:JSON.stringify(payload)
		    })
		    .then(res=>res.json())
		    .then(function(){

		        sap.m.MessageToast.show("Product Updated");

		        var oModel = that.getView().getModel();
		        oModel.setProperty("/editVisible", false);
		        oModel.setProperty("/editButtonVisible", true);

		    });

		},
/*		onDeleteProduct: function(){

		    var id = this.getView().getModel().getProperty("/editPayload/productId");

		    fetch("/product/" + id,{
		        method:"DELETE"
		    })
		    .then(res=>res.text())
		    .then(function(msg){
		        sap.m.MessageToast.show(msg);
		    });

		},*/

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

								var sId = oObject.productId;

	
                                // console.log("Deleting ID:", sId);

                                service.callService("/product/" + sId, "DELETE", {});
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