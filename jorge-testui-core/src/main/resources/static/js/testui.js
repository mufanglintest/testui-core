

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

/**
 * 批量执行用例
 * @param datagrid
 * @param batchType {caseNo,interfaceNo,projectNo}
 * @param invokeType {batch,single}
 * @param parameterNo {当invokeType为single时才需要传入}
 * @param singleTypeNo {执行单项目、单接口、单用例时的projectNo、interfaceNo、caseNo编号}
 */
function batchExecuteTestcase(datagrid,batchType,invokeType,parameterNo,singleTypeNo) {
    var rows = [];
    var caseData = [];
    var parameterNos = [];
    if (invokeType == 'batch') {
        rows = $('#'+datagrid).datagrid('getChecked');
        if (rows.length > 0) {
            var rowSize = rows.length;
            for (var i = 0; i < rowSize; i++) {
                caseData.push(rows[i][batchType]);
            }
        }else{
            $.acooly.messager('提示','请选择批量执行数据','danger');
            return;
        }
    }else {
        caseData.push(singleTypeNo);
    }
    if (parameterNo!=null && parameterNo!='') {
        parameterNos.push(parameterNo);
    }
    $.ajax({
        url:'/manage/jorge/parameters/batchExecuteTestcase',
        data:{
            'caseData':caseData,
            'parameterNo':parameterNos,
            'batchType':batchType
        },
        success:function (data) {
            $('#'+datagrid).datagrid('reload');
            $.acooly.messager('提示','用例正在执行！','success');
        }
    });
}