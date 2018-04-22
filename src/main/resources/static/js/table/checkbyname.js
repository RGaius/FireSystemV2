var param={}
$('#select').combobox({
    prompt:"input",
    required:true,
    mode:'remote',
    type:"get",
    loader:function (q) {
        $.ajax({
            url:baseURL+"fire/unit/queryCount",
            type:"get",
            dataType:"json",
            data:{
                countKeys:JSON.stringify(q),
                startTime:null,
                endTime:null
            },
            success:function (rdata) {
              console.log(rdata);
            },
            error:function () {
                console.log("error");
            }


        })
    }

    }
)

/*var vm=new Vue(
    {
        el:'#select1',
        data:{
            message:{}
        },
        methods:{
            query:function () {
                $.ajax({
                        url: baseURL + "fire/unit/queryCount",
                        type: "post",
                        dataType:"json",
                        data:{
                            countKeys :vm.message,
                            startTime:null,
                            endTime:null
                        },
                        success:function (){

                        },
                        error:function () {
                            alert("error")
                        }
                    }
                )
            }
        }
    }
)
*/





/*$(document).ready(function () {
    vm.query();
});*/




/* var param={};
 param.countKeys=$('#unitId').val();
 param.startTime=null;
 param.endTime=null;

$.ajax({
    url: baseURL + "fire/unit/queryCount",
    type: "get",
    dataType: "json",
    data: {
        countKeys :"面馆",
        startTime:null,
        endTime:null
    },
    success: function (rdata) {
        console.log(rdata);
    },
    error: function () {
        console.log("error")
    }
});*/