Ext.define('Dec22.view.querybuildernewmodel.querystructure.QueryStructureStore', {
    extend: 'Ext.data.Store',
    requires:['Dec22.view.querybuildernewmodel.querystructure.QueryStructureModel'],
    autoSync: false,
    model: 'Dec22.view.querybuildernewmodel.querystructure.QueryStructureModel',
    filters: []
  
});
