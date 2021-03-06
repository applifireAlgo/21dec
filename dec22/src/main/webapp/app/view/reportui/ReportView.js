Ext.define('Dec22.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Dec22.view.reportui.querycriteria.QueryCriteriaView',
			'Dec22.view.reportui.datachart.DataChartViewTab',
			'Dec22.view.reportui.datachart.DataChartViewPanel',
			'Dec22.view.reportui.ReportViewController' ,
			'Dec22.view.fw.MainDataPointPanel',
			'Dec22.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:1000,
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
