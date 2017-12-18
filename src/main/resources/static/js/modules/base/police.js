$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'fire/police/list',
        datatype: "json",
        colModel: [			
			{ label: '警号', name: 'policeId', index: 'police_id', width: 50, key: true },
			{ label: '所属派出所', name: 'policeStationId', index: 'police_station_id', width: 80 }, 			
			{ label: '电话号码', name: 'moblie', index: 'moblie', width: 80 }, 			
			{ label: '名字', name: 'relName', index: 'rel_name', width: 80 }, 			
			{ label: '创建时间', name: 'createDate', index: 'create_date', width: 80 }			
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
		police: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.police = {};
		},
		update: function (event) {
			var policeId = getSelectedRow();
			if(policeId == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(policeId)
		},
		saveOrUpdate: function (event) {
			var url = vm.police.policeId == null ? "fire/police/save" : "fire/police/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.police),
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
			var policeIds = getSelectedRows();
			if(policeIds == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "fire/police/delete",
                    contentType: "application/json",
				    data: JSON.stringify(policeIds),
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
		getInfo: function(policeId){
			$.get(baseURL + "fire/police/info/"+policeId, function(r){
                vm.police = r.police;
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