/**
 * Created by jing on 2017/11/23.
 */

$("#selectName").on('shown.bs.select',function(e){
    console.log('展开之后');
    $('#selectName').prev().find("input").keydown(function(){
        $('#selectName').prev().find("input").attr('id',"unitId"); //为input增加id属性
        console.log($('#unitId').val()); //获取输入框值输出到控制台
        getUnitName();
    })
})


function getUnitName() {
    var param={};
    param.countKeys=$('#unitId').val();

    param.startTime=null;
    param.endTime=null;
    console.log(param);
    $.ajax({
        url: "fire/unit/queryCount",
        type:"get",
        dataType: "json",
        data:param,
        success: function (data) {
            console.log(data);
            $.each(data, function (index, unit) {
                $("#selectName").append("<option value=" + unit.id + ">" + unit.unit + "</option>");
                $("#selectName" ).selectpicker('refresh');
            });
        },
    })
}