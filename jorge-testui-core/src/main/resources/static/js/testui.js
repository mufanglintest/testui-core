

function logInfoformatResult(val,row){
    if (val){
        return '<span style="color:greenyellow;">执行成功</span>';
    } else {
        return '<span style="color:red;">执行失败</span>';
    }

}

function formatResult(val,row){
    if (val){
        return '<span style="color:greenyellow;">通过</span>';
    } else {
        return '<span style="color:red;">未通过</span>';
    }
}


/**
 *执行用例
 */
function manage_testCase_invoke(gridId,projectNo,interfaceNo,caseNo,parametersNo,requestType) {
    $.get({
        url:'/case.do',
        data:{
            "requestType":requestType,
            "projectNo":projectNo,
            "interfaceNo":interfaceNo,
            "caseNo":caseNo,
            "parametersNo":parametersNo,

        },
        success:function (data) {
            if (!data.success){
                $.acooly.messager('提示','用例未全部执行成功!','success');
                // $.messager.show({title:'提示',msg:'用例未全部执行成功!'})
                // return null;
            }
            if (parametersNo==''){
                $.acooly.messager('提示','测试用例编号'+caseNo+'已执行','success');
                // $.messager.show({title: '提示', msg: '测试用例编号'+caseNo+'已执行'});
            } else {
                $.acooly.messager('提示','测试用例编号'+caseNo+'，参数编号为'+parametersNo+'已执行','success');
                // $.messager.show({title: '提示', msg: '测试用例编号'+caseNo+'，参数编号为'+parametersNo+'已执行'});

            }
            $.acooly.framework.loadGrid({
                gridId: gridId,
                url: '/manage/jorge/parameters/listJson.html',
                ajaxData: {"search_EQ_caseNo": caseNo}
            });

        },
        error:function (data,e) {
            $.acooly.messager('提示', '用例执行失败！','danger');
        }
    });

}