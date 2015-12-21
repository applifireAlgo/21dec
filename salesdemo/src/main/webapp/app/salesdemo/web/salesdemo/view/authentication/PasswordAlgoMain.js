Ext.define('Salesdemo.salesdemo.web.salesdemo.view.authentication.PasswordAlgoMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "PasswordAlgoMainController",
     "restURL": "/PasswordAlgo",
     "defaults": {
          "split": true
     },
     "requires": ["Salesdemo.salesdemo.shared.salesdemo.model.authentication.PasswordAlgoModel", "Salesdemo.salesdemo.web.salesdemo.controller.authentication.PasswordAlgoMainController", "Salesdemo.salesdemo.shared.salesdemo.viewmodel.authentication.PasswordAlgoViewModel"],
     "communicationLog": [],
     "tabPosition": "bottom",
     "items": [{
          "title": "Data Browser",
          "layout": "border",
          "defaults": {
               "split": true
          },
          "autoScroll": false,
          "customWidgetType": "vdBorderLayout",
          "items": [{
               "xtype": "tabpanel",
               "customWidgetType": "vdTabLayout",
               "margin": "5 0 5 5",
               "border": 1,
               "style": {
                    "borderColor": "#f6f6f6",
                    "borderStyle": "solid",
                    "borderWidth": "1px"
               },
               "displayName": "Password Algo",
               "name": "PasswordAlgoTreeContainer",
               "itemId": "PasswordAlgoTreeContainer",
               "restURL": "/PasswordAlgo",
               "autoScroll": false,
               "collapsible": true,
               "titleCollapse": true,
               "collapseMode": "header",
               "collapsed": false,
               "items": [{
                    "xtype": "treepanel",
                    "customWidgetType": "vdTree",
                    "title": "Browse",
                    "useArrows": true,
                    "rootVisible": false,
                    "itemId": "PasswordAlgoTree",
                    "listeners": {
                         "select": "treeClick"
                    },
                    "tbar": [{
                         "xtype": "triggerfield",
                         "customWidgetType": "vdTriggerField",
                         "emptyText": "Search",
                         "triggerCls": "",
                         "listeners": {
                              "change": "onTriggerfieldChange",
                              "buffer": 250
                         }
                    }, "->", {
                         "xtype": "tool",
                         "type": "refresh",
                         "tooltip": "Refresh Tree Data",
                         "handler": "onTreeRefreshClick"
                    }]
               }, {
                    "title": "Advance Search",
                    "xtype": "form",
                    "customWidgetType": "vdFormpanel",
                    "itemId": "queryPanel",
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "isDockedItem": true,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill"
                         }, {
                              "xtype": "button",
                              "customWidgetType": "vdButton",
                              "text": "Filter",
                              "handler": "onFilterClick"
                         }]
                    }],
                    "items": [{
                         "name": "algoName",
                         "itemId": "algoName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Name",
                         "fieldId": "5C6AA62C-8887-4783-8EEA-FFF380A357D8",
                         "minLength": "0",
                         "maxLength": "256"
                    }]
               }],
               "region": "west",
               "width": "20%"
          }, {
               "region": "center",
               "layout": "border",
               "defaults": {
                    "split": true
               },
               "customWidgetType": "vdBorderLayout",
               "items": [{
                    "customWidgetType": "vdFormpanel",
                    "viewModel": "PasswordAlgoViewModel",
                    "xtype": "form",
                    "displayName": "Password Algo",
                    "title": "Password Algo",
                    "name": "PasswordAlgo",
                    "itemId": "PasswordAlgo",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "algoId",
                         "itemId": "algoId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Algo Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Algo Id<font color='red'> *<\/font>",
                         "fieldId": "DC446FCA-4515-458E-84E7-73200A7AB164",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "algoId",
                         "bind": "{algoId}"
                    }, {
                         "name": "algorithm",
                         "itemId": "algorithm",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Algorithm",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Algorithm<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "FFEE6366-D543-4978-91EA-AAACD02EEDC1",
                         "minLength": "0",
                         "maxLength": "11",
                         "bindable": "algorithm",
                         "bind": "{algorithm}",
                         "columnWidth": 0.5
                    }, {
                         "name": "algoName",
                         "itemId": "algoName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "5C6AA62C-8887-4783-8EEA-FFF380A357D8",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "algoName",
                         "bind": "{algoName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "algoDescription",
                         "itemId": "algoDescription",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Description",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Description",
                         "fieldId": "DFAF3BBE-AD36-4E09-A9A0-BD5F5D3FBAC1",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "algoDescription",
                         "bind": "{algoDescription}",
                         "columnWidth": 0.5
                    }, {
                         "name": "algoIcon",
                         "itemId": "algoIcon",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Icon",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Icon",
                         "fieldId": "70E50251-ED87-4819-95DE-DD2535845BA9",
                         "minLength": "0",
                         "maxLength": "64",
                         "bindable": "algoIcon",
                         "bind": "{algoIcon}",
                         "columnWidth": 0.5
                    }, {
                         "name": "algoHelp",
                         "itemId": "algoHelp",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Help",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Help",
                         "fieldId": "4E857EC5-1A46-478C-9E85-C100CFDDAC40",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "algoHelp",
                         "bind": "{algoHelp}",
                         "columnWidth": 0.5
                    }, {
                         "name": "versionId",
                         "itemId": "versionId",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "versionId",
                         "margin": "5 5 5 5",
                         "value": "-1",
                         "fieldLabel": "versionId",
                         "fieldId": "6646C96F-BB3C-4550-B899-3B7D09FC69B9",
                         "bindable": "versionId",
                         "bind": "{versionId}",
                         "hidden": true
                    }],
                    "layout": "column",
                    "defaults": {
                         "columnWidth": 0.5,
                         "labelAlign": "left",
                         "labelWidth": 200
                    },
                    "autoScroll": true,
                    "dockedItems": [{
                         "xtype ": "toolbar",
                         "customWidgetType": "vdBBar",
                         "dock": "bottom",
                         "ui": "footer",
                         "isDockedItem": true,
                         "parentId": 1,
                         "customId": 138,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 138,
                              "customId": 838
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 138,
                              "customId": 839,
                              "listeners": {
                                   "click": "saveForm"
                              }
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Reset",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "resetFormButton",
                              "parentId": 138,
                              "customId": 840,
                              "listeners": {
                                   "click": "resetForm"
                              }
                         }],
                         "defaults": {}
                    }],
                    "listeners": {
                         "scope": "controller"
                    },
                    "tools": [{
                         "type": "help",
                         "tooltip": "Console",
                         "handler": "onConsoleClick"
                    }, {
                         "type": "refresh",
                         "tooltip": "Refresh Tab",
                         "handler": "init"
                    }],
                    "extend": "Ext.form.Panel",
                    "region": "center"
               }, {
                    "xtype": "gridpanel",
                    "customWidgetType": "vdGrid",
                    "displayName": "Password Algo",
                    "title": "Details Grid",
                    "name": "PasswordAlgoGrid",
                    "itemId": "PasswordAlgoGrid",
                    "restURL": "/PasswordAlgo",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Algo Id",
                         "dataIndex": "algoId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "primaryDisplay",
                         "dataIndex": "primaryDisplay",
                         "hidden": true
                    }, {
                         "header": "primaryKey",
                         "dataIndex": "primaryKey",
                         "hidden": true
                    }, {
                         "header": "Algorithm",
                         "dataIndex": "algorithm",
                         "flex": 1
                    }, {
                         "header": "Name",
                         "dataIndex": "algoName",
                         "flex": 1
                    }, {
                         "header": "Description",
                         "dataIndex": "algoDescription",
                         "flex": 1
                    }, {
                         "header": "Icon",
                         "dataIndex": "algoIcon",
                         "flex": 1
                    }, {
                         "header": "Help",
                         "dataIndex": "algoHelp",
                         "flex": 1
                    }, {
                         "header": "createdBy",
                         "dataIndex": "createdBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "createdDate",
                         "dataIndex": "createdDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedBy",
                         "dataIndex": "updatedBy",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "updatedDate",
                         "dataIndex": "updatedDate",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "versionId",
                         "dataIndex": "versionId",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "activeStatus",
                         "dataIndex": "activeStatus",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "header": "txnAccessCode",
                         "dataIndex": "txnAccessCode",
                         "hidden": true,
                         "flex": 1
                    }, {
                         "xtype": "actioncolumn",
                         "customWidgetType": "vdActionColumn",
                         "width": 30,
                         "sortable": false,
                         "menuDisable": true,
                         "items": [{
                              "icon": "images/delete.gif",
                              "tooltip": "Delete Record",
                              "handler": "onDeleteActionColumnClickMainGrid"
                         }]
                    }],
                    "listeners": {
                         "itemclick": "onGridItemClick"
                    },
                    "tools": [{
                         "type": "refresh",
                         "tooltip": "Refresh Grid Data",
                         "handler": "onGridRefreshClick"
                    }],
                    "collapsible": true,
                    "titleCollapse": true,
                    "collapseMode": "header",
                    "region": "south",
                    "height": "40%"
               }]
          }]
     }, {
          "title": "Add New",
          "itemId": "addNewForm",
          "layout": "border",
          "customWidgetType": "vdBorderLayout",
          "autoScroll": false,
          "items": [{
               "customWidgetType": "vdFormpanel",
               "viewModel": "PasswordAlgoViewModel",
               "xtype": "form",
               "displayName": "Password Algo",
               "title": "Password Algo",
               "name": "PasswordAlgo",
               "itemId": "PasswordAlgo",
               "bodyPadding": 10,
               "items": [{
                    "name": "algoId",
                    "itemId": "algoId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Algo Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Algo Id<font color='red'> *<\/font>",
                    "fieldId": "DC446FCA-4515-458E-84E7-73200A7AB164",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "algoId",
                    "bind": "{algoId}"
               }, {
                    "name": "algorithm",
                    "itemId": "algorithm",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Algorithm",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Algorithm<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "FFEE6366-D543-4978-91EA-AAACD02EEDC1",
                    "minLength": "0",
                    "maxLength": "11",
                    "bindable": "algorithm",
                    "bind": "{algorithm}",
                    "columnWidth": 0.5
               }, {
                    "name": "algoName",
                    "itemId": "algoName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "5C6AA62C-8887-4783-8EEA-FFF380A357D8",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "algoName",
                    "bind": "{algoName}",
                    "columnWidth": 0.5
               }, {
                    "name": "algoDescription",
                    "itemId": "algoDescription",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Description",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Description",
                    "fieldId": "DFAF3BBE-AD36-4E09-A9A0-BD5F5D3FBAC1",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "algoDescription",
                    "bind": "{algoDescription}",
                    "columnWidth": 0.5
               }, {
                    "name": "algoIcon",
                    "itemId": "algoIcon",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Icon",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Icon",
                    "fieldId": "70E50251-ED87-4819-95DE-DD2535845BA9",
                    "minLength": "0",
                    "maxLength": "64",
                    "bindable": "algoIcon",
                    "bind": "{algoIcon}",
                    "columnWidth": 0.5
               }, {
                    "name": "algoHelp",
                    "itemId": "algoHelp",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Help",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Help",
                    "fieldId": "4E857EC5-1A46-478C-9E85-C100CFDDAC40",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "algoHelp",
                    "bind": "{algoHelp}",
                    "columnWidth": 0.5
               }, {
                    "name": "versionId",
                    "itemId": "versionId",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "versionId",
                    "margin": "5 5 5 5",
                    "value": "-1",
                    "fieldLabel": "versionId",
                    "fieldId": "6646C96F-BB3C-4550-B899-3B7D09FC69B9",
                    "bindable": "versionId",
                    "bind": "{versionId}",
                    "hidden": true
               }],
               "layout": "column",
               "defaults": {
                    "columnWidth": 0.5,
                    "labelAlign": "left",
                    "labelWidth": 200
               },
               "autoScroll": true,
               "dockedItems": [{
                    "xtype ": "toolbar",
                    "customWidgetType": "vdBBar",
                    "dock": "bottom",
                    "ui": "footer",
                    "isDockedItem": true,
                    "parentId": 1,
                    "customId": 138,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 138,
                         "customId": 838
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 138,
                         "customId": 839,
                         "listeners": {
                              "click": "saveForm"
                         }
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Reset",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "resetFormButton",
                         "parentId": 138,
                         "customId": 840,
                         "listeners": {
                              "click": "resetForm"
                         }
                    }],
                    "defaults": {}
               }],
               "listeners": {
                    "scope": "controller"
               },
               "tools": [{
                    "type": "help",
                    "tooltip": "Console",
                    "handler": "onConsoleClick"
               }, {
                    "type": "refresh",
                    "tooltip": "Refresh Tab",
                    "handler": "init"
               }],
               "extend": "Ext.form.Panel",
               "region": "center"
          }]
     }]
});