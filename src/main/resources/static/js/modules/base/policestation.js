$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'fire/policestation/list',
        datatype: "json",
        colModel: [			
			{ label: 'policeStationId', name: 'policeStationId', index: 'police_station_id', width: 50, key: true, hidden: true },
			{ label: '分局编号', name: 'branchId', index: 'branch_id', width: 80 },
			{ label: '派出所名称', name: 'policeStation', index: 'police_station', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		policeStation: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.policeStation = {};
		},
		update: function (event) {
			var policeStationId = getSelectedRow();
			if(policeStationId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(policeStationId)
		},
		saveOrUpdate: function (event) {
			var url = vm.policeStation.policeStationId == null ? "fire/policestation/save" : "fire/policestation/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.policeStation),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var policeStationIds = getSelectedRows();
			if(policeStationIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "fire/policestation/delete",
                    contentType: "application/json",
				    data: JSON.stringify(policeStationIds),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(policeStationId){
			$.get(baseURL + "fire/policestation/info/"+policeStationId, function(r){
                vm.policeStation = r.policeStation;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});