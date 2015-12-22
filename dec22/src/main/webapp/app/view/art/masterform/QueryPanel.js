Ext.define('Dec22.view.art.masterform.QueryPanel', {
	extend :'Ext.form.Panel',
	xtype: 'queryPanel',
	itemId: 'queryPanel',
	requires: ['Dec22.view.art.masterform.QueryPanelController','Dec22.view.art.masterform.QueryPanelViewModel'],
	controller: 'queryPanelController',
	viewModel:'queryPanelViewModel',
	serviceURL:null,
	buttons : [{
		text : 'Filter',
		listeners:{
			click:'submitQuery'
		}	
		
	}]	
});