/*
var vm = new Vue({
    el: '#app',
    data: {
        policeId: 0,
        datalist:{}
    },
    methods: {
        getParams: function () {
            vm.datalist = listParams();
        }
    }
});

function listParams(data) {
    var params = {
        policeId: '11',
        begindate: null,
        enddate: '2017-03-25'
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
}
*/
function getParams() {


var params = {
    policeId: '11',
    begindate: null,
    enddate: '2017-03-25'
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
}
$(document).ready(function(){
   getParams();
});