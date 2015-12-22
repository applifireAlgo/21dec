Ext.define('Dec22.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsStore', {
    extend: 'Ext.data.Store',
    requires:['Dec22.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel'],
    autoSync: false,
    model: 'Dec22.view.querybuildernewmodel.queryentitiesjoins.QueryFieldsModel',
    filters: []
  
});
