var vm = new Vue({
    el: '#app',
    data: {
        params:{},
        datalist:{}
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
                    handleData(data);
                },
                error:function () {
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
function handleData(datalist){

    Histogram(datalist);
}

/**
 * 画柱状图
 * @param checklist
 */
function Histogram(checklist){
    var dataAxis = ['点', '击', '柱', '子', '或', '者', '两', '指', '在', '触', '屏', '上', '滑', '动', '能', '够', '自', '动', '缩', '放'];
    var data = [220, 182, 191, 234, 290, 330, 310, 123, 442, 321, 90, 149, 210, 122, 133, 334, 198, 123, 125, 220];
    var yMax = 500;
    var dataShadow = [];

    for (var i = 0; i < data.length; i++) {
        dataShadow.push(yMax);
    }

    option = {
        title: {
            text: '警员查询记录',
        },
        xAxis: {
            data: dataAxis,
            axisLabel: {
                inside: true,
                textStyle: {
                    color: '#fff'
                }
            },
            axisTick: {
                show: false
            },
            axisLine: {
                show: false
            },
            z: 10
        },
        yAxis: {
            axisLine: {
                show: false
            },
            axisTick: {
                show: false
            },
            axisLabel: {
                textStyle: {
                    color: '#999'
                }
            }
        },
        dataZoom: [
            {
                type: 'inside'
            }
        ],
        series: [
            { // For shadow
                type: 'bar',
                itemStyle: {
                    normal: {color: 'rgba(0,0,0,0.05)'}
                },
                barGap:'-100%',
                barCategoryGap:'40%',
                data: dataShadow,
                animation: false
            },
            {
                type: 'bar',
                itemStyle: {
                    normal: {
                        color: new echarts.graphic.LinearGradient(
                            0, 0, 0, 1,
                            [
                                {offset: 0, color: '#83bff6'},
                                {offset: 0.5, color: '#188df0'},
                                {offset: 1, color: '#188df0'}
                            ]
                        )
                    },
                    emphasis: {
                        color: new echarts.graphic.LinearGradient(
                            0, 0, 0, 1,
                            [
                                {offset: 0, color: '#2378f7'},
                                {offset: 0.7, color: '#2378f7'},
                                {offset: 1, color: '#83bff6'}
                            ]
                        )
                    }
                },
                data: data
            }
        ]
    };
  /*  // Enable data zoom when user click bar.
    var zoomSize = 6;
    myChart.on('click', function (params) {
        console.log(dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)]);
        myChart.dispatchAction({
            type: 'dataZoom',
            startValue: dataAxis[Math.max(params.dataIndex - zoomSize / 2, 0)],
            endValue: dataAxis[Math.min(params.dataIndex + zoomSize / 2, data.length - 1)]
        });
    });*/
}

/*function getParams() {
var params = {
    policeId: '7',
    begindate:  '2016-03-22',
    enddate:  '2017-12-10'
};
$.ajax({
    url: baseURL + "fire/dailytable/count",
    timeout: 3000,
    async: false,
    type: "POST",
    dataType: "json",
    data: params,
    success: function (data) {
        console.log(data);
    }
});
}*/
$(document).ready(function(){
   vm.query();
});