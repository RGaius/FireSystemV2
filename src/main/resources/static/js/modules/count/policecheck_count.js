$(document).ready(function () {
    $.ajax({
        url: baseURL + "fire/dailytable/count",
        timeout: 3000,
        async: false,
        type: "GET",
        dataType: "json",
        data: {
            all: {
                policeId: 11,
                begin: '2016-09-24',
                end: '2016-10-07'
            }
        },
        success: function (data) {
            console.log(data);
        }
    });
});