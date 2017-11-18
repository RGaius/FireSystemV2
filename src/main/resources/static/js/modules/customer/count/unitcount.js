$.ajax({
    type: "get",
    data: "countKey",
    url: baseURL + "fire/unit/queryCount",
    cache: false,    //禁用缓存
    dataType: "json",
    success: function (data) {
        console.log(data);
    },
});


var dom = document.getElementById("unitChart");
var myChart = echarts.init(dom);
//var app = {};
option = null;
option = {
    title : {
        text: '场所类型统计',
        subtext: '',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient : 'vertical',
        x : 'left',
        data:[]
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {
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
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    series : [
        {
            name:'',
            type:'pie',
            radius : '55%',
            center: ['50%', '60%'],
            data:[]
        }
    ]
};
;
if (option && typeof option === "object") {
    myChart.setOption(option, true);
}
//饼图动态赋值
$.ajax({
    type: "get",
    url: baseURL + "fire/unit/count",
    cache : false,    //禁用缓存
    dataType: "json",
    success: function(data) {
        var names=[];//定义两个数组
        var nums=[];
        $.each(data,function(key,values) { //此处我返回的是list<String,map<String,String>>循环map
            $.each(values, function (key, values) {
            names.push(values.property);
            var obj = new Object();
            obj.name = values.property;
            obj.value = values.number;
            nums.push(obj);
        });
            });
            myChart.setOption({ //加载数据图表
                legend: {
                    data: names
                },
                series: {
                    // 根据名字对应到相应的系列
                    name: ['数量'],
                    data: nums
                }
            });
    },
    error: function(XMLHttpRequest, textStatus, errorThrown) {
        alert("查询失败");
    }
});