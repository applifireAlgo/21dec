Ext.define('Dec22.view.mobileview.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Dec22.view.mobileview.reportui.querycriteria.QueryCriteriaView',
			'Dec22.view.mobileview.reportui.datachart.DataChartViewTab',
			'Dec22.view.mobileview.reportui.datachart.DataChartViewPanel',
			'Dec22.view.mobileview.reportui.ReportViewController' ,
			'Dec22.view.mobileview.fw.DataPointPanel',
			'Dec22.view.mobileview.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',

	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
