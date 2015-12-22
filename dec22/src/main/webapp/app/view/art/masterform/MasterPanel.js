Ext.define('Dec22.view.art.masterform.MasterPanel', {
	extend :'Ext.panel.Panel',
  
    waitMsgTarget: true,
    
    refId: null,
    
    requires: ['Dec22.view.art.masterform.MasterFormPanel','Dec22.view.art.masterform.MasterGridPanel','Dec22.view.art.masterform.MasterTreePanel','Dec22.view.art.masterform.QueryPanel','Dec22.view.art.masterform.MasterPanelController'],
    
    controller:'masterPanelController',
    
    serviceURL : null,
    
    layout:{
    	type:'border'
    },
    
    items: [{
    	region: 'west',
		width:'20%',
		split:true,
		xtype :'tabpanel',

    	items: [{
	    	title: 'Tree Modal',
	    	xtype: 'masterTreePanel'    		
    	},{
	    	title: 'Query',
	    	xtype: 'queryPanel',
			autoScroll:true
    	}]
    },{
    	region: 'center',
    	xtype :'tabpanel',
    	layout:'fit',
    	
    	tabPosition: 'bottom',
    	items:[{
    		title: 'Data Browser',
    		panelId :'masterPanelEditTab',
        	xtype: 'panel',
        	layout:'anchor',
        	autoScroll:true,
    	    items:[{
    	    	//region: 'center',
    	    	xtype: 'masterFormPanel',
    	    	anchor:'100% 50%',
    	    	autoScroll:true,
    	    	itemId: 'masterEditFormPanel',
    	    },{
    	    	//region: 'south',
    	    	anchor:'100% 50%',
    	    	xtype: 'masterGridPanel',
    	    	title: 'Details',    	
    	    	itemId: 'masterEditGridPanel',
    	    }],  
    	},{
        	title: 'Add New',
        	xtype: 'panel',
        	panelId :'masterPanelAddTab',
        	items:[{
            	fieldDefaults: {
        	        labelAlign: 'left',
        	        msgTarget: 'side'
            	},
        	    
        	    items:[{
        	    	xtype: 'masterFormPanel',
        	    	itemId: 'masterNewFormPanel'
        	    }],    		
        		
        	}]
    	}],
    }],
    
	listeners:
	{
		scope : 'controller',
		beforerender :'masterPanelBeforeRender'
	}
	
});
	