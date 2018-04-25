var param={}

$('#select').combobox({
    prompt:"input",
    required:true,
    mode:'remote',
    type:"get",
    loader:function (q) {
        $.each(q,function (key,values) {
             param.countKeys=values;
            }
        )
        param.startTime=null;
        param.endTime=null;
        $.ajax({
            url:baseURL+"fire/unit/queryCount",
            type:"get",
            dataType:"json",
            data:param,
            success:function (rdata) {
              showOption(rdata.data);
            },
            error:function () {
                console.log("error");
            }
        })
    }
    }
)

function showOption(rdata) {
    var data=[];
    $.each(rdata,function (i,val) {
        data.push({"text":val.unitName,"id":val.unitId});
    })
    $("#select").combobox("loadData",data);
    $("#query").click(function () {
        query(rdata);
    })
}

function query(rdata) {
    var options=$("#select").combobox("getValue");
    $.each(rdata,function (i,val) {
        if(val.unitId==options){
            var param=val;
            console.log(param);
        }
    })
}

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