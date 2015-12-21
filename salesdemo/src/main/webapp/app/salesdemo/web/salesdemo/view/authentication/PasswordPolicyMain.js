Ext.define('Salesdemo.salesdemo.web.salesdemo.view.authentication.PasswordPolicyMain', {
     "extend": "Ext.tab.Panel",
     "customWidgetType": "vdTabLayout",
     "autoScroll": false,
     "controller": "PasswordPolicyMainController",
     "restURL": "/PasswordPolicy",
     "defaults": {
          "split": true
     },
     "requires": ["Salesdemo.salesdemo.shared.salesdemo.model.authentication.PasswordPolicyModel", "Salesdemo.salesdemo.web.salesdemo.controller.authentication.PasswordPolicyMainController", "Salesdemo.salesdemo.shared.salesdemo.viewmodel.authentication.PasswordPolicyViewModel"],
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
               "displayName": "Password Policy",
               "name": "PasswordPolicyTreeContainer",
               "itemId": "PasswordPolicyTreeContainer",
               "restURL": "/PasswordPolicy",
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
                    "itemId": "PasswordPolicyTree",
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
                         "name": "policyName",
                         "itemId": "policyName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Name",
                         "fieldId": "7FEEF33D-E9AF-4387-9937-55BBE59A1275",
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
                    "viewModel": "PasswordPolicyViewModel",
                    "xtype": "form",
                    "displayName": "Password Policy",
                    "title": "Password Policy",
                    "name": "PasswordPolicy",
                    "itemId": "PasswordPolicy",
                    "bodyPadding": 10,
                    "items": [{
                         "name": "policyId",
                         "itemId": "policyId",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Policy Id",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Policy Id<font color='red'> *<\/font>",
                         "fieldId": "96BCD22F-872A-46E9-91F7-9B18F0599810",
                         "minLength": "0",
                         "maxLength": "64",
                         "hidden": true,
                         "value": "",
                         "bindable": "policyId",
                         "bind": "{policyId}"
                    }, {
                         "name": "policyName",
                         "itemId": "policyName",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "Name",
                         "margin": "5 5 5 5",
                         "fieldLabel": "Name<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "7FEEF33D-E9AF-4387-9937-55BBE59A1275",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "policyName",
                         "bind": "{policyName}",
                         "columnWidth": 0.5
                    }, {
                         "name": "policyDescription",
                         "itemId": "policyDescription",
                         "xtype": "textareafield",
                         "customWidgetType": "vdTextareafield",
                         "displayName": "policyDescription",
                         "margin": "5 5 5 5",
                         "fieldLabel": "policyDescription",
                         "fieldId": "ACB60A47-5F6C-4F6B-864D-79005E7969AA",
                         "bindable": "policyDescription",
                         "bind": "{policyDescription}",
                         "columnWidth": 0.5
                    }, {
                         "name": "maxPwdLength",
                         "itemId": "maxPwdLength",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "maxPwdLength",
                         "margin": "5 5 5 5",
                         "fieldLabel": "maxPwdLength",
                         "fieldId": "48B4019A-6C07-47BA-90A4-2EE13FEB3085",
                         "minValue": "0",
                         "maxValue": "32",
                         "bindable": "maxPwdLength",
                         "bind": "{maxPwdLength}",
                         "columnWidth": 0.5
                    }, {
                         "name": "minPwdLength",
                         "itemId": "minPwdLength",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "minPwdLength",
                         "margin": "5 5 5 5",
                         "fieldLabel": "minPwdLength<font color='red'> *<\/font>",
                         "allowBlank": false,
                         "fieldId": "D60D6779-2BC5-4D41-BEF8-CCF6C0633835",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "minPwdLength",
                         "bind": "{minPwdLength}",
                         "columnWidth": 0.5
                    }, {
                         "name": "minCapitalLetters",
                         "itemId": "minCapitalLetters",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "minCapitalLetters",
                         "margin": "5 5 5 5",
                         "fieldLabel": "minCapitalLetters",
                         "fieldId": "7EC8B9B8-3198-42EF-8935-125968882928",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "minCapitalLetters",
                         "bind": "{minCapitalLetters}",
                         "columnWidth": 0.5
                    }, {
                         "name": "minSmallLetters",
                         "itemId": "minSmallLetters",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "minSmallLetters",
                         "margin": "5 5 5 5",
                         "fieldLabel": "minSmallLetters",
                         "fieldId": "00CEEBE8-0E3C-4734-892D-537D6065729C",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "minSmallLetters",
                         "bind": "{minSmallLetters}",
                         "columnWidth": 0.5
                    }, {
                         "name": "minNumericValues",
                         "itemId": "minNumericValues",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "minNumericValues",
                         "margin": "5 5 5 5",
                         "fieldLabel": "minNumericValues",
                         "fieldId": "4955018F-7BD1-4767-9587-08182310C4FA",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "minNumericValues",
                         "bind": "{minNumericValues}",
                         "columnWidth": 0.5
                    }, {
                         "name": "minSpecialLetters",
                         "itemId": "minSpecialLetters",
                         "xtype": "numberfield",
                         "customWidgetType": "vdNumberfield",
                         "displayName": "minSpecialLetters",
                         "margin": "5 5 5 5",
                         "fieldLabel": "minSpecialLetters",
                         "fieldId": "CCE4A23D-FACC-4994-A6A9-6DCED9BB73F9",
                         "minValue": "0",
                         "maxValue": "11",
                         "bindable": "minSpecialLetters",
                         "bind": "{minSpecialLetters}",
                         "columnWidth": 0.5
                    }, {
                         "name": "allowedSpecialLetters",
                         "itemId": "allowedSpecialLetters",
                         "xtype": "textfield",
                         "customWidgetType": "vdTextfield",
                         "displayName": "allowedSpecialLetters",
                         "margin": "5 5 5 5",
                         "fieldLabel": "allowedSpecialLetters",
                         "fieldId": "A88B3780-C7C1-4EA1-8D22-43214A1BE144",
                         "minLength": "0",
                         "maxLength": "256",
                         "bindable": "allowedSpecialLetters",
                         "bind": "{allowedSpecialLetters}",
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
                         "fieldId": "5DFF39FF-C089-45D6-A989-5FA0211025FB",
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
                         "customId": 688,
                         "items": [{
                              "xtype": "tbfill",
                              "customWidgetType": "vdTbFill",
                              "parentId": 688,
                              "customId": 179
                         }, {
                              "customWidgetType": "vdButton",
                              "xtype": "button",
                              "margin": "0 5 0 5",
                              "text": "Save",
                              "hiddenName": "button",
                              "canHaveParent": false,
                              "itemId": "saveFormButton",
                              "parentId": 688,
                              "customId": 180,
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
                              "parentId": 688,
                              "customId": 181,
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
                    "displayName": "Password Policy",
                    "title": "Details Grid",
                    "name": "PasswordPolicyGrid",
                    "itemId": "PasswordPolicyGrid",
                    "restURL": "/PasswordPolicy",
                    "store": [],
                    "bodyPadding": 10,
                    "columns": [{
                         "header": "Policy Id",
                         "dataIndex": "policyId",
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
                         "header": "Name",
                         "dataIndex": "policyName",
                         "flex": 1
                    }, {
                         "header": "policyDescription",
                         "dataIndex": "policyDescription",
                         "flex": 1
                    }, {
                         "header": "maxPwdLength",
                         "dataIndex": "maxPwdLength",
                         "flex": 1
                    }, {
                         "header": "minPwdLength",
                         "dataIndex": "minPwdLength",
                         "flex": 1
                    }, {
                         "header": "minCapitalLetters",
                         "dataIndex": "minCapitalLetters",
                         "flex": 1
                    }, {
                         "header": "minSmallLetters",
                         "dataIndex": "minSmallLetters",
                         "flex": 1
                    }, {
                         "header": "minNumericValues",
                         "dataIndex": "minNumericValues",
                         "flex": 1
                    }, {
                         "header": "minSpecialLetters",
                         "dataIndex": "minSpecialLetters",
                         "flex": 1
                    }, {
                         "header": "allowedSpecialLetters",
                         "dataIndex": "allowedSpecialLetters",
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
               "viewModel": "PasswordPolicyViewModel",
               "xtype": "form",
               "displayName": "Password Policy",
               "title": "Password Policy",
               "name": "PasswordPolicy",
               "itemId": "PasswordPolicy",
               "bodyPadding": 10,
               "items": [{
                    "name": "policyId",
                    "itemId": "policyId",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Policy Id",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Policy Id<font color='red'> *<\/font>",
                    "fieldId": "96BCD22F-872A-46E9-91F7-9B18F0599810",
                    "minLength": "0",
                    "maxLength": "64",
                    "hidden": true,
                    "value": "",
                    "bindable": "policyId",
                    "bind": "{policyId}"
               }, {
                    "name": "policyName",
                    "itemId": "policyName",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "Name",
                    "margin": "5 5 5 5",
                    "fieldLabel": "Name<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "7FEEF33D-E9AF-4387-9937-55BBE59A1275",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "policyName",
                    "bind": "{policyName}",
                    "columnWidth": 0.5
               }, {
                    "name": "policyDescription",
                    "itemId": "policyDescription",
                    "xtype": "textareafield",
                    "customWidgetType": "vdTextareafield",
                    "displayName": "policyDescription",
                    "margin": "5 5 5 5",
                    "fieldLabel": "policyDescription",
                    "fieldId": "ACB60A47-5F6C-4F6B-864D-79005E7969AA",
                    "bindable": "policyDescription",
                    "bind": "{policyDescription}",
                    "columnWidth": 0.5
               }, {
                    "name": "maxPwdLength",
                    "itemId": "maxPwdLength",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "maxPwdLength",
                    "margin": "5 5 5 5",
                    "fieldLabel": "maxPwdLength",
                    "fieldId": "48B4019A-6C07-47BA-90A4-2EE13FEB3085",
                    "minValue": "0",
                    "maxValue": "32",
                    "bindable": "maxPwdLength",
                    "bind": "{maxPwdLength}",
                    "columnWidth": 0.5
               }, {
                    "name": "minPwdLength",
                    "itemId": "minPwdLength",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "minPwdLength",
                    "margin": "5 5 5 5",
                    "fieldLabel": "minPwdLength<font color='red'> *<\/font>",
                    "allowBlank": false,
                    "fieldId": "D60D6779-2BC5-4D41-BEF8-CCF6C0633835",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "minPwdLength",
                    "bind": "{minPwdLength}",
                    "columnWidth": 0.5
               }, {
                    "name": "minCapitalLetters",
                    "itemId": "minCapitalLetters",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "minCapitalLetters",
                    "margin": "5 5 5 5",
                    "fieldLabel": "minCapitalLetters",
                    "fieldId": "7EC8B9B8-3198-42EF-8935-125968882928",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "minCapitalLetters",
                    "bind": "{minCapitalLetters}",
                    "columnWidth": 0.5
               }, {
                    "name": "minSmallLetters",
                    "itemId": "minSmallLetters",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "minSmallLetters",
                    "margin": "5 5 5 5",
                    "fieldLabel": "minSmallLetters",
                    "fieldId": "00CEEBE8-0E3C-4734-892D-537D6065729C",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "minSmallLetters",
                    "bind": "{minSmallLetters}",
                    "columnWidth": 0.5
               }, {
                    "name": "minNumericValues",
                    "itemId": "minNumericValues",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "minNumericValues",
                    "margin": "5 5 5 5",
                    "fieldLabel": "minNumericValues",
                    "fieldId": "4955018F-7BD1-4767-9587-08182310C4FA",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "minNumericValues",
                    "bind": "{minNumericValues}",
                    "columnWidth": 0.5
               }, {
                    "name": "minSpecialLetters",
                    "itemId": "minSpecialLetters",
                    "xtype": "numberfield",
                    "customWidgetType": "vdNumberfield",
                    "displayName": "minSpecialLetters",
                    "margin": "5 5 5 5",
                    "fieldLabel": "minSpecialLetters",
                    "fieldId": "CCE4A23D-FACC-4994-A6A9-6DCED9BB73F9",
                    "minValue": "0",
                    "maxValue": "11",
                    "bindable": "minSpecialLetters",
                    "bind": "{minSpecialLetters}",
                    "columnWidth": 0.5
               }, {
                    "name": "allowedSpecialLetters",
                    "itemId": "allowedSpecialLetters",
                    "xtype": "textfield",
                    "customWidgetType": "vdTextfield",
                    "displayName": "allowedSpecialLetters",
                    "margin": "5 5 5 5",
                    "fieldLabel": "allowedSpecialLetters",
                    "fieldId": "A88B3780-C7C1-4EA1-8D22-43214A1BE144",
                    "minLength": "0",
                    "maxLength": "256",
                    "bindable": "allowedSpecialLetters",
                    "bind": "{allowedSpecialLetters}",
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
                    "fieldId": "5DFF39FF-C089-45D6-A989-5FA0211025FB",
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
                    "customId": 688,
                    "items": [{
                         "xtype": "tbfill",
                         "customWidgetType": "vdTbFill",
                         "parentId": 688,
                         "customId": 179
                    }, {
                         "customWidgetType": "vdButton",
                         "xtype": "button",
                         "margin": "0 5 0 5",
                         "text": "Save",
                         "hiddenName": "button",
                         "canHaveParent": false,
                         "itemId": "saveFormButton",
                         "parentId": 688,
                         "customId": 180,
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
                         "parentId": 688,
                         "customId": 181,
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