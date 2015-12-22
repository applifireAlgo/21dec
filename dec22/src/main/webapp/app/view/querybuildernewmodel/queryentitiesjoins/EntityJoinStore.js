Ext.define('Dec22.view.querybuildernewmodel.queryentitiesjoins.EntityJoinStore', {
    extend: 'Ext.data.Store',
    requires:['Dec22.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel'],
    autoSync: false,
    model: 'Dec22.view.querybuildernewmodel.queryentitiesjoins.EntityJoinModel',
    data:[]
});
