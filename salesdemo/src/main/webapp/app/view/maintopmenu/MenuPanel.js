Ext.define('Salesdemo.view.maintopmenu.MenuPanel', {
	extend : 'Ext.toolbar.Toolbar',
	
	xtype : 'menuPanel',
	itemId : 'menuPanel', 
	
	requires : [ 'Salesdemo.view.maintopmenu.MenuPanelController' //,'Ext.button.Split' 
	             ],
	controller : 'menuPanelController',
	
	baseCls : 'menuPanelBody',
	
	listeners : {
		scope : 'controller',
		afterrender : 'loadMenus'
	}	
});