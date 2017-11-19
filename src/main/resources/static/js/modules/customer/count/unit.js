//加载函数实现默认项展示
$(document).ready(function () {
    list();
    count();
});

//列出所有派出所
function list() {
    $.ajax({
        url: baseURL + "fire/policestation/listPoliceStation",
        timeout: 3000,
        async: false,
        type: "GET",
        dataType: "json",
        success: function (data) {
            $("#list_policeStation").prepend("<option value='0'>请选择</option>");
            $.each(data, function (key, values) {
                $.each(values, function (key, values) {
                    //两次遍历取出存放在{code:data{policeStationId:bunchId:policeStation}}}的值并赋给option
                    $("#list_policeStation").append("<option value='" + values.policeStationId + "'>" + values.policeStation + "</option>");
                })
            })
        }
    });
}

//计算当前选中的value并处理赋给饼图
function count() {
    //获取当前选中的警局id
    var policeStationId = $("#list_policeStation").val();
    //根据id获取unit的类型、数量
    $.ajax({
        type: "get",
        url: baseURL + "fire/unit/count",
        data: {
            policeStationId: policeStationId
        },
        cache: false,    //禁用缓存
        dataType: "json",
        success: function (data) {
            //定义两个数组存放获取的值
            var names = [];
            var nums = [];
            $.each(data, function (key, values) {
                $.each(values, function (key, values) {
                    names.push(values.property);
                    var obj = new Object();
                    obj.name = values.property;
                    obj.value = values.number;
                    nums.push(obj);
                });
            });
            //调用画图
            draw(names, nums);
        },
        error: function (XMLHttpRequest, textStatus, errorThrown) {
            alert("查询失败");
        }
    })
}

//画出饼图
function draw(names, nums) {
    var dom = document.getElementById("unitChart");
    var myChart = echarts.init(dom);//初始化饼图
    var option = null;
    option = {
        title: {
            text: '场所类型统计',
            subtext: '',
            x: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: "{a} <br/>{b} : {c} ({d}%)"
        },
        legend: {
            orient: 'vertical',
            x: 'left',
            data: []
        },
        toolbox: {
            show: true,
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                magicType: {
                    show: true,
                    type: ['pie', 'funnel'],
                    option: {
                        funnel: {
                            x: '25%',
                            width: '50%',
                            funnelAlign: 'left',
                            max: 1548
                        }
                    }
                },
                saveAsImage: {show: true}
            }
        },
        calculable: true,
        series: [
            {
                name: '',
                type: 'pie',
                radius: '55%',
                center: ['50%', '60%'],
                data: []
            }
        ]
    };

    if (option && typeof option === "object") {
        myChart.setOption(option, true);
    }
    //加载数据图表
    myChart.setOption({
        legend: {
            data: names
        },
        series: {
            // 根据名字对应到相应的系列
            name: ['类型：数量(比例)'],
            data: nums
        }
    });
}

//选择当前下拉列表查询数据
$("#query").click(function () {
    count();
});