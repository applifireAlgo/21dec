Ext.define('Dec22.view.databrowsercalendar.DBCalendar', {
	extend : 'Dec22.view.databrowsercalendar.DBCalendarView',
	requires : [ 'Dec22.view.databrowsercalendar.DBCalendarController',
	             'Dec22.view.databrowsercalendar.DBCalendarView'],
	controller : 'databrowsercalendar',
	items : [ ],
	listeners : {
		afterrender : 'loadData',
		scope : "controller"
	}
});
