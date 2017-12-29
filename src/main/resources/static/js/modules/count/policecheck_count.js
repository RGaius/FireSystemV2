var vm = new Vue({
    el: '#app',
    data: {
        params: {},
        datalist: {}
    },
    methods: {
        query: function () {
            $.ajax({
                url: baseURL + "fire/dailytable/count",
                timeout: 3000,
                async: false,
                type: "POST",
                dataType: "json",
                data: vm.params,
                success: function (data) {
                    //对前台输入数据查询后是否有数据进行检查
                    if (data.data != null) {
                        if (data.data == 0) {
                            alert("您所输入的警员不存在！")
                        } else
                            handleData(data);
                    }

                },
                error: function () {
                    alert("获取数据失败！")
                }
            });

        }
    }

});

/**
 * 处理数据
 * @param datalist
 */
function handleData(datalist) {
    var xaxis = [];
    var yaxis = [];
    $.each(datalist.data, function (key, values) {
        xaxis.push(values.dimensionValue);
        yaxis.push(values.ammount);
    });
    Histogram(xaxis, yaxis);
}

/**
 * 画柱状图
 * @param xaxis
 * @param yaxis
 */
function Histogram(xaxis, yaxis) {
    // 基于准备好的dom，初始化echarts图表
    var myChart = echarts.init(document.getElementById("myChart"));
    option = {
        title: {
            text: '警员检查统计图',
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['检查数量']
        },
        toolbox: {
            show: true,
            feature: {
                mark: {show: true},
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        calculable: true,
        xAxis: [
            {
                type: 'category',
                data: xaxis
            }
        ],
        yAxis: [
            {
                type: 'value'
            }
        ],
        series: [
            {
                name: '检查数量',
                type: 'bar',
                data: yaxis
            }
        ]
    };

    // 为echarts对象加载数据
    myChart.setOption(option);

}

$(document).ready(function () {
    vm.query();
});