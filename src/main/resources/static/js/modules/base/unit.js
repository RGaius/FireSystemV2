$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'fire/unit/list',
        datatype: "json",
        colModel: [
            {label: 'unitId', name: 'unitId', index: 'unit_id', width: 50, key: true, hidden: true,frozen:true},
            {label: '所属派出所', name: 'policeStation', index: 'police_station', width: 300, frozen:true},
            {label: '场所名称', name: 'unitName', index: 'unit_name', width: 300, frozen:true},
            {label: '法定代表人', name: 'master', index: 'master', width: 100},
            {label: '场所地址', name: 'address', index: 'address', width: 390},
            {label: '场所性质', name: 'unitProperty', index: 'unit_property', width: 100},
            {label: '场所面积', name: 'area', index: 'area', width: 80},
            {label: '楼层', name: 'floors', index: 'floors', width: 80},
            {label: '高度', name: 'height', index: 'height', width: 80},
            {
                label: '检查状态', name: 'status', index: 'status', width: 80, formatter: function (value) {
                return value === 0 ?
                    '<span class="label label-danger">未检查</span>' :
                    '<span class="label label-success">已检查</span>';
            }
            },
            {label: '检查类型', name: 'checkType', index: 'check_type', width: 80},
            {label: '创建日期', name: 'createDate', index: 'create_date', width: 170}
        ],
        viewrecords: true,
        height: 385,
        sortname:'police_station_id',
        rowNum: 40,
        rowList: [40, 60, 80, 100],
        rownumbers: true,
        rownumWidth: 50,
        autowidth: true,
        multiselect: true,
        shrinkToFit: false,
        pager: "#jqGridPager",
        jsonReader: {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            // $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });
});
$("#jqGrid").jqGrid('setFrozenColumns');

var vm = new Vue({
    el: '#rrapp',
    data: {
        showList: true,
        title: null,
        unit: {}
    },
    methods: {
        query: function () {
            vm.reload();
        },
        add: function () {
            vm.unit = {};
            layer.open({
                type: 1,
                skin: 'layui-layer-molv',
                title: '新增',
                area: ['600px', '510px'],
                shadeClose: false,
                content: jQuery("#modifyInfo"),
                btn: ['添加','取消'],
                btn1: function(){
                    vm.saveOrUpdate(index);
                }
            });
        },
        update: function (event) {
            var unitId = getSelectedRow();
            if (unitId == null) {
                return;
            }
            vm.getInfo(unitId);
            layer.open({
                type: 1,
                skin: 'layui-layer-molv',
                title: '修改',
                area: ['600px', '510px'],
                shadeClose: false,
                content: jQuery("#modifyInfo"),
                btn: ['修改','取消'],
                btn1: function(){
                    vm.saveOrUpdate()
                }
            });
        },
        saveOrUpdate: function (index) {
            var url = vm.unit.unitId == null ? "fire/unit/save" : "fire/unit/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.unit),
                success: function (r) {
                    if (r.code === 0) {
                        layer.close(index);
                        layer.alert('修改成功', function(){
                            location.reload();
                            vm.reload();
                        });
                    } else {
                        layer.alert(r.msg);
                    }
                }
            });
        },
        del: function (event) {
            var unitIds = getSelectedRows();
            if (unitIds == null) {
                return;
            }

            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: baseURL + "fire/unit/delete",
                    contentType: "application/json",
                    data: JSON.stringify(unitIds),
                    success: function (r) {
                        if (r.code == 0) {
                            alert('操作成功', function (index) {
                                $("#jqGrid").trigger("reloadGrid");
                            });
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        getInfo: function (unitId) {
            $.get(baseURL + "fire/unit/info/" + unitId, function (r) {
                vm.unit = r.unit;
            });
        },
        reload: function (event) {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                page: page
            }).trigger("reloadGrid");
        }
    }
});