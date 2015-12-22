Ext.define('Dec22.dec22.shared.dec22.model.location.TalukaModel', {
     "extend": "Ext.data.Model",
     "fields": [{
          "name": "primaryKey",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "talukaId",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "countryid",
          "reference": "Country",
          "defaultValue": ""
     }, {
          "name": "stateid",
          "reference": "State",
          "defaultValue": ""
     }, {
          "name": "regionid",
          "reference": "Region",
          "defaultValue": ""
     }, {
          "name": "districtid",
          "reference": "District",
          "defaultValue": ""
     }, {
          "name": "talukaName",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "talukaCode",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "talukaDescription",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "talukaFlag",
          "type": "string",
          "defaultValue": ""
     }, {
          "name": "talukaLatitude",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "talukaLongitude",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "versionId",
          "type": "int",
          "defaultValue": ""
     }, {
          "name": "entityAudit",
          "reference": "EntityAudit"
     }, {
          "name": "primaryDisplay",
          "type": "string",
          "defaultValue": ""
     }]
});