$(document).ready(function(){
    $.ajax({
        url: baseURL + "fire/dailytable/count",
        timeout: 3000,
        async: false,
        type: "GET",
        dataType: "json",
        data:{policeId:7},
        success: function (data) {
            console.log(data);
        }
    });
});