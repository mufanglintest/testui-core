<script type="text/javascript">
    $(function () {
        $.acooly.framework.registerKeydown('manage_testCase_searchform', 'manage_testCase_datagrid');
    });

    /**
     * 管理每行的action动作
     */
    function manage_testCase_datagrid_rowAction_formatter(value,row,index){
        var status = row.goodsOrderStatus;
        var actionHtml = "";
        actionHtml += formatString($('#manage_goodsOrderInfo_action_show').html(), row.id);

        //待发货添加按钮
        if('PENDINGSHIPMENT'==status) {
            actionHtml += formatString($('#manage_goodsOrderInfo_action_deliver_finish').html(), row.id,row.goodsOrderNo);
        }

        //待出库增加打印按钮
        if('PREPARE_OUT_STOCK'==status) {
            actionHtml += formatString($('#manage_goodsOrderInfo_action_print').html(), row.id,row.goodsOrderNo);
        }
        //已发货增加确认收货按钮
        if('SHIPPED'==status) {
            actionHtml += formatString($('#manage_goodsOrderInfo_action_order_receive').html(), row.id,row.goodsOrderNo);

        }
        return actionHtml;
    }

</script>
<div class="easyui-layout" data-options="fit:true,border:false">
    <!-- 查询条件 -->
<div data-options="region:'north',border:false" style="padding:5px; overflow: hidden;" align="left">
    <form id="manage_testCase_searchform" onsubmit="return false">
        <table class="tableForm" width="100%">
            <tr>
                <td align="left">
                    <div>
                        所属系统: <select id="search_EQ_projectNo" style="width:150px;height:27px;" name="search_EQ_projectNo" editable="false"
                                      panelHeight="300" class="easyui-combobox">
                        <option value="">所有</option>
                        <#list allProjectNos as k,v>
                        <option value="${k}">${v}</option>
                        </#list>
                        </select>

                        所属接口:
                        <#--<select id="search_EQ_interfaceNo" style="width:120px;height:27px;" name="search_EQ_interfaceNo" editable="false"-->
                                      <#--panelHeight="300" class="easyui-combobox"  data-options="valueField:'id',textField:'text'">-->
                        <#--<option value="">所有</option>-->
                        <#--&lt;#&ndash;<#list allInterfaceNos as k,v>&ndash;&gt;-->
                        <#--&lt;#&ndash;<option value="${k}">${v}</option>&ndash;&gt;-->
                        <#--&lt;#&ndash;</#list>&ndash;&gt;-->
                        <#--</select>-->
                        <input id="search_EQ_interfaceNo" name="search_EQ_interfaceNo" class="easyui-combobox" data-options="" style="width:150px;height:27px;"/>


                        用例编号: <input type="text" class="text" size="15" name="search_LIKE_caseNo"/>
                        用例名称: <input type="text" class="text" size="15" name="search_LIKE_caseName"/>
                        创建者:
                        <select style="width:120px;height:27px;" name="search_LIKE_createUser" editable="false"
                                     panelHeight="auto" class="easyui-combobox">
                            <option value="">所有</option>
                            <#list allCreateUsers as user>
                            <option value="${user.realName}">${user.realName}</option>
                            </#list>
                        </select>

                        用例类别: <select style="width:80px;height:27px;" name="search_EQ_caseType" editable="false"
                                      panelHeight="auto" class="easyui-combobox">
                        <option value="">所有</option><#list allCaseTypes as k,v>
                        <option value="${k}">${v}</option></#list></select>

                        协议类型: <select style="width:80px;height:27px;" name="search_EQ_protocolType" editable="false"
                                      panelHeight="auto" class="easyui-combobox">
                        <option value="">所有</option><#list allProtocolTypes as k,v>
                        <option value="${k}">${v}</option></#list></select>
                        创建时间: <input type="text" class="text" size="15" name="search_LIKE_createTime"/>
                        修改时间: <input type="text" class="text" size="15" name="search_LIKE_updateTime"/>
                        <a href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:false"
                           onclick="$.acooly.framework.search('manage_testCase_searchform','manage_testCase_datagrid');"><i
                                class="fa fa-search fa-lg fa-fw fa-col"></i>查询</a>
                    </div>
                </td>
            </tr>
        </table>
    </form>
</div>

    <!-- 列表和工具栏 -->
    <div data-options="region:'center',border:false" style="overflow: hidden;height:50%;" align="left">
        <table id="manage_testCase_datagrid" class="easyui-datagrid" url="/manage/jorge/testCase/listJson.html"
               toolbar="#manage_testCase_toolbar" fit="true" border="false" fitColumns="false"
               pagination="true" idField="id" pageSize="20" pageList="[ 10, 20, 30, 40, 50 ]" sortName="id"
               sortOrder="desc" checkOnSelect="false" selectOnCheck="false" singleSelect="true"
        >
            <thead>
            <tr>
                <th field="showCheckboxWithId" checkbox="true"
                    data-options="formatter:function(value, row, index){ return row.id }">编号
                </th>
                <th field="id" sortable="true">id</th>
                <th field="projectNo" formatter="mappingFormatter">系统名称</th>
                <th field="interfaceNo" formatter="mappingFormatter">接口名称</th>
                <th field="caseNo">用例编号</th>
                <th field="caseName">用例名称</th>
                <th field="caseType" formatter="mappingFormatter">用例类别</th>
                <th field="url" formatter="contentFormatter">请求地址</th>
                <#--<th field="input" formatter="contentFormatter">请求参数</th>-->
                <th field="protocolType" formatter="mappingFormatter">协议类型</th>
                <th field="createUser" >创建者</th>
                <th field="createTime" formatter="dateTimeFormatter">创建时间</th>
                <th field="updateTime" formatter="dateTimeFormatter">修改时间</th>
                <th field="rowActions"
                    data-options="formatter:function(value, row, index){return formatString($('#manage_testCase_action').html(),row.id,row.projectNo,row.interfaceNo,row.caseNo,'');}">
                    动作
                </th>
            </tr>
            </thead>
        </table>

        <!-- 每行的Action动作模板 -->
        <div id="manage_testCase_action" style="display: none;">
            <a onclick="$.acooly.framework.edit({url:'/manage/jorge/testCase/edit.html',id:'{0}',entity:'testCase',width:500,height:500});"
               href="#" title="编辑"><i class="fa fa-pencil fa-lg fa-fw fa-col"></i></a>
            <a onclick="$.acooly.framework.show('/manage/jorge/testCase/show.html?id={0}',500,500);" href="#"
               title="查看"><i class="fa fa-file-o fa-lg fa-fw fa-col"></i></a>
            <a onclick="$.acooly.framework.remove('/manage/jorge/testCase/deleteJson.html','{0}','manage_testCase_datagrid');"
               href="#" title="删除"><i class="fa fa-trash-o fa-lg fa-fw fa-col"></i></a>
            <a onclick="manage_testCase_invoke('sub_manage_parameters_datagrid','{1}','{2}','{3}','{4}','case')" href="#"
              title="执行用例"><i class="fa fa-road fa-lg fa-fw fa-col"></i></a>
            <a onclick="manage_testCase_copy('{3}','{4}','testcase')" href="#"
               title="复制用例"><i class="fa fa-amazon fa-lg fa-fw fa-col"></i></a>
        </div>

        <!-- 表格的工具栏 -->
        <div id="manage_testCase_toolbar">
            <a href="#" class="easyui-linkbutton" plain="true"
               onclick="manage_testCase_create()"><i
                    class="fa fa-plus-circle fa-lg fa-fw fa-col"></i>添加</a>
            <#--<a href="#" class="easyui-linkbutton" plain="true"-->
               <#--onclick="$.acooly.framework.removes('/manage/jorge/testCase/deleteJson.html','manage_testCase_datagrid')"><i-->
                    <#--class="fa fa-trash-o fa-lg fa-fw fa-col"></i>批量删除</a>-->

            <a href="#" class="easyui-linkbutton" plain="true"
               onclick="batchExecuteTestcase('manage_testCase_datagrid')"><i
                    class="fa fa-road fa-lg fa-fw fa-col"></i>批量执行</a>
        </div>
    </div>

    <div data-options="region:'south',border:false" style="height: 40%;">
        <div id="manage_goodsOrderInfo_sub_tab" class="easyui-tabs" fit="true">
            <div title="用例参数列表" style="margin-left: 0px;">
                <table id="sub_manage_parameters_datagrid" class="easyui-datagrid" toolbar="#sub_manage_parameters_toolbar"
                       fit="true" border="false" fitColumns="false"
                       pagination="true" idField="id" pageSize="50" pageList="[ 10, 20, 30, 40, 50 ]" sortName="id"
                       sortOrder="desc" checkOnSelect="false" selectOnCheck="true" singleSelect="true">
                    <thead>
                    <tr>
                        <th field="showCheckboxWithId" checkbox="true"
                            data-options="formatter:function(value, row, index){ return row.id }">编号
                        </th>
                        <th field="id" sortable="true">id</th>
                        <#--<th field="projectNo">系统编号</th>-->
                        <#--<th field="interfaceNo">接口编号</th>-->
                        <#--<th field="caseNo">测试用例编号</th>-->
                        <th field="parametersNo">请求入参编号</th>
                        <th field="description" formatter="contentFormatter">用例说明</th>
                        <th field="parameters" formatter="contentFormatter">请求入参</th>
                        <#--<th field="parameters" formatter="syntaxHighlight">请求入参</th>-->
                        <th field="callCount" sortable="true">用例执行次数</th>
                        <th field="callSuccessCount" sortable="true">用例执行成功次数</th>
                        <th field="callFailCount" sortable="true">用例执行失败次数</th>
                        <th field="lastImplementResult" sortable="true" formatter="formatResult" >最近执行结果</th>
                        <th field="createTime" formatter="dateFormatter">创建时间</th>
                        <th field="updateTime" formatter="dateFormatter">更新时间</th>
                        <th field="rowActions"
                            data-options="formatter:function(value, row, index){return formatString($('#sub_manage_parameters_action').html(),row.id,row.projectNo,row.interfaceNo,row.caseNo,row.parametersNo);}">
                            动作
                        </th>
                    </tr>
                    </thead>
                </table>
                <!-- 每行的Action动作模板 -->
                <div id="sub_manage_parameters_action" style="display: none;">
                    <a onclick="$.acooly.framework.edit({url:'/manage/jorge/parameters/edit.html',id:'{0}',entity:'parameters',width:500,height:500,onSuccess:load_sub_manage_parameters_datagrid});"
                       href="#" title="编辑"><i class="fa fa-pencil fa-lg fa-fw fa-col"></i></a>
                    <a onclick="$.acooly.framework.show('/manage/jorge/parameters/show.html?id={0}',500,500);" href="#"
                       title="查看"><i class="fa fa-file-o fa-lg fa-fw fa-col"></i></a>
                    <a onclick="$.acooly.framework.remove('/manage/jorge/parameters/deleteJson.html','{0}','sub_manage_parameters_datagrid',null,null,load_sub_manage_parameters_datagrid);"
                       href="#" title="删除"><i class="fa fa-trash-o fa-lg fa-fw fa-col"></i></a>
                    <a onclick="manage_testCase_invoke('sub_manage_parameters_datagrid','{1}','{2}','{3}','{4}','parameters')" href="#"
                       title="执行用例"><i class="fa fa-road fa-lg fa-fw fa-col"></i></a>
                    <a onclick="manage_testCase_copy('{3}','{4}','parameter')" href="#"
                       title="复制用例"><i class="fa fa-amazon fa-lg fa-fw fa-col"></i></a>
                </div>
                <!-- 表格的工具栏 -->
                <div id="sub_manage_parameters_toolbar">
                    <a href="#" class="easyui-linkbutton" plain="true"
                       onclick="manage_parameters_create()"><i
                            class="fa fa-plus-circle fa-lg fa-fw fa-col"></i>添加</a>
                    <a href="#" class="easyui-linkbutton" plain="true"
                       onclick="manage_parameters_addOrDeleteMessage('add')"><i
                            class="fa fa-plus-circle fa-lg fa-fw fa-col"></i>批量添加请求参数</a>
                    <a href="#" class="easyui-linkbutton" plain="true"
                       onclick="manage_parameters_addOrDeleteMessage('delete')"><i
                            class="fa fa-plus-circle fa-lg fa-fw fa-col"></i>批量删除请求参数</a>
                    <#--<a href="#" class="easyui-linkbutton" plain="true" iconCls="icon-add"-->
                       <#--onclick="manage_parameters_create()">添加</a>-->
                <#--<a href="#" class="easyui-linkbutton" plain="true" onclick="$.acooly.framework.create({url:'/manage/jorge/parameters/create.html',entity:'parameters',width:500,height:500})"><i class="fa fa-plus-circle fa-lg fa-fw fa-col"></i>添加</a>-->
                <#--<a href="#" class="easyui-linkbutton" plain="true" onclick="$.acooly.framework.removes('/manage/jorge/parameters/deleteJson.html','sub_manage_parameters_datagrid')"><i class="fa fa-trash-o fa-lg fa-fw fa-col"></i>批量删除</a>-->
                </div>
            </div>
        </div>
    </div>
</div>
<script src="/js/testui.js"></script>
<script type="text/javascript">

    // function manage_parametersDetailInfo_loadSubTabs(rowIndex, rowData) {
    //     //加载用例参数列表
    //     console.info(rowData.caseNo);
    //     load_sub_manage_parameters_datagrid();
    //
    // }
    /**
     * 加载选中
     */
    $("#manage_testCase_datagrid").datagrid({
        onClickRow: function (index, row) {
            $.acooly.framework.loadGrid({
                gridId: "sub_manage_parameters_datagrid",
                url: '/manage/jorge/parameters/listJson.html',
                ajaxData: {
                    "search_EQ_caseNo": row.caseNo,
                    "rows": 50,
                }
            });
        }
    });

    //加载请求参数子列表
    function load_sub_manage_parameters_datagrid() {
        var rowData = $.acooly.framework.getSelectedRow("sub_manage_parameters_datagrid");
        console.info(rowData.caseNo);
        if (!rowData) {
            $.acooly.messager('提示','请先选择测试用例','danger');
            return null;
        }
        $.acooly.framework.loadGrid({
            gridId: "sub_manage_parameters_datagrid",
            url: '/manage/jorge/parameters/listJson.html',
            ajaxData: {
                "search_EQ_caseNo": rowData.caseNo,
                "rows": 50,
            }
        });
    }
    function manage_testCase_create() {
        $.acooly.framework.create({
            url:'/manage/jorge/testCase/create.html',
            form:'manage_testCase_editform',
            datagrid:'manage_testCase_datagrid',
            width: 500,
            height: 500,
            reload: true
        });
    }

    /**
     * 添加用例参数
     */
    function manage_parameters_create() {
        var rowData = $.acooly.framework.getSelectedRow("manage_testCase_datagrid");
        console.info(rowData);
        if (!rowData) {
            $.acooly.messager('提示','请先选择测试用例','danger');
            return null;
        }
        $.acooly.framework.create({
            url: '/manage/jorge/parameters/create.html',
            form:'manage_parameters_editform',
            datagrid:'sub_manage_parameters_datagrid',
            width: 500,
            height: 500,
            reload: true,
            ajaxData: {
                "projectNo": rowData.projectNo,
                "interfaceNo": rowData.interfaceNo,
                "caseNo": rowData.caseNo
            }
        })

    }


    /**
     *执行用例
     */
    // function manage_testCase_invoke(projectNo,interfaceNo,caseNo,parametersNo,requestType) {
    //     $.get({
    //         url:'/case.do',
    //         data:{
    //             "requestType":requestType,
    //             "projectNo":projectNo,
    //             "interfaceNo":interfaceNo,
    //             "caseNo":caseNo,
    //             "parametersNo":parametersNo,
    //
    //         },
    //         success:function (data) {
    //             if (!data.success){
    //                 $.acooly.messager('提示','用例未全部执行成功!','success');
    //                 // $.messager.show({title:'提示',msg:'用例未全部执行成功!'})
    //                 // return null;
    //             }
    //             if (parametersNo==''){
    //                 $.acooly.messager('提示','测试用例编号'+caseNo+'已执行','success');
    //                 // $.messager.show({title: '提示', msg: '测试用例编号'+caseNo+'已执行'});
    //             } else {
    //                 $.acooly.messager('提示','测试用例编号'+caseNo+'，参数编号为'+parametersNo+'已执行','success');
    //                 // $.messager.show({title: '提示', msg: '测试用例编号'+caseNo+'，参数编号为'+parametersNo+'已执行'});
    //
    //             }
    //             $.acooly.framework.loadGrid({
    //                 gridId: "sub_manage_parameters_datagrid",
    //                 url: '/manage/jorge/parameters/listJson.html',
    //                 ajaxData: {"search_EQ_caseNo": caseNo}
    //             });
    //
    //         },
    //         error:function (data,e) {
    //             $.acooly.messager('提示', '用例执行失败！','danger');
    //         }
    //     });
    //
    // }

    /**
     * @param caseNo
     * @param parametersNo
     * @param copyType（可选值parameter,testcase）
     * 复制用例
     */
    function manage_testCase_copy(caseNo,parametersNo,copyType){
        $.ajax({
            url:'/manage/jorge/parameters/copy.html',
            data:{
                "caseNo":caseNo,
                "parametersNo":parametersNo,
                "copyType":copyType,
            },
            success:function(data){
                if (data.success){
                    $.acooly.messager('提示','用例复制成功','success');
                }else {
                    $.acooly.messager('提示','用例复制失败','danger');
                }
                if (copyType == "parameter") {
                    $.acooly.framework.loadGrid({
                        gridId: "sub_manage_parameters_datagrid",
                        url: '/manage/jorge/parameters/listJson.html',
                        ajaxData: {"search_EQ_caseNo": data.data.caseNo}
                    });
                }else {
                    $('#manage_testCase_datagrid').datagrid('reload');
                }

            },
            error:function (data,e) {
                $.acooly.messager('提示','用例复制失败'+e,'danger');
            }
        });
    }

    /**
     * 格式化显示json值
     * @param json
     * @param row
     * @returns {string}
     */
    function syntaxHighlight(json,row) {
        if (typeof json != 'string') {
            json = JSON.stringify(json, undefined, 2);
        }
        json = json.replace(/&/g, '&').replace(/</g, '<').replace(/>/g, '>');
        return json.replace(/("(\\u[a-zA-Z0-9]{4}|\\[^u]|[^\\"])*"(\s*:)?|\b(true|false|null)\b|-?\d+(?:\.\d*)?(?:[eE][+\-]?\d+)?)/g, function(match) {
            var cls = 'number';
            if (/^"/.test(match)) {
                if (/:$/.test(match)) {
                    cls = 'key';
                } else {
                    cls = 'string';
                }
            } else if (/true|false/.test(match)) {
                cls = 'boolean';
            } else if (/null/.test(match)) {
                cls = 'null';
            }
            return '<span class="' + cls + '">' + match + '</span>';
        });
    }

    //加载搜索框的关联关系
        //下拉框修改后重新加载接口数据
        $("#search_EQ_projectNo").combobox({
            onChange: function (newProjectNo, oldProjectNo) {
                $("#search_EQ_interfaceNo").empty();
                getQueryInterfaceNos(newProjectNo);
            }
        });

    function getQueryInterfaceNos(projectNo) {
        $.ajax({
            url: '/manage/jorge/testCase/relaodInterfaceNos.html',
            data: {
                'projectNo': projectNo
            },
            success: function (data) {
                if (data.success) {
                    var dataList;
                    dataList = [];
                    // dataList.push({"id": "---", "text": "请选择"});
                    dataList.push({"id": "", "text": "所有"})
                    $.each(data.data, function (key, value) {
                        dataList.push({"id": key, "text": value});
                    })
                    $("#search_EQ_interfaceNo").combobox( {
                        required: true,
                        valueField: "id",
                        textField: "text",
                        height: 32,
                        method: "get",
                        editable: true,
                        delay: 600, //最后一次输入事件与执行搜索之间的延迟间隔（执行自动完成功能的延迟间隔）
                        filter: function (value, row) {
                        var opts = $('#search_EQ_interfaceNo').combobox('options');
                        return row[opts.textField].indexOf(value) >= 0;
                    },
                    data:dataList
                });
                    //默认选中第一条数据
                    $("#search_EQ_interfaceNo").combobox("select", dataList[0].text);
                    $("#search_EQ_interfaceNo").combobox("setValue", "");
                }
            }

        });
    }

    $(function(){
        $('#sub_manage_parameters_datagrid').datagrid({
            view: detailview,
            detailFormatter:function(index,row){
                return '<div class="ddv"></div>';
            },
            onExpandRow: function(index,row){
                var htmlContent = '' +
                        '<h3 style="border-bottom: 1px solid #dddddd;">请求参数:</h3>' +
                        '<div><pre>' + syntaxHighlight(row.parameters) + '</pre></div></div>' +
                        '<div style="float:left;">'
                var ddv = $(this).datagrid('getRowDetail',index).find('div.ddv');
                ddv.panel({
                    border:false,
                    cache:false,
                    content: htmlContent
                });
                $('#sub_manage_parameters_datagrid').datagrid('fixDetailRowHeight',index);
            }
        });
    });


    /**
     * 用例批量增加参数
     * @returns {null}
     */
    function manage_parameters_addOrDeleteMessage(actionName) {
        var rowData = $.acooly.framework.getSelectedRow("manage_testCase_datagrid");
        if (!rowData) {
            $.acooly.messager('提示','请先选择测试用例','danger');
            return null;
        }
        var width = 700;
        if(actionName == 'add'){
            width = 1000;
        }
        $.acooly.framework.create({
            url: '/manage/jorge/parameters/addOrDeleteMessage.html',
            form:'manage_parameters_addmessageform',
            datagrid:'sub_manage_parameters_datagrid',
            width: width,
            height: 500,
            reload:true,
            title : (actionName == 'add') ? '添加':'删除',
            addButton:(actionName == 'add') ? '增加':'删除',
            ajaxData: {
                "caseNo": rowData.caseNo,
                "actionName":actionName
            }
        })
    }

    /**
     * 批量执行用例
     * @param datagrid
     */
    function batchExecuteTestcase(datagrid) {
        // var rows = $.acooly.framework._getCheckedRows(datagrid);
        var rows = $('#'+datagrid).datagrid('getChecked');
        var caseNos = [];
        if (rows.length > 0) {
            for (var i = 0; i < rows.length; i++) {
                caseNos.push(rows[i].caseNo);
            }
        }
        $.ajax({
            url:'/manage/jorge/parameters/batchExecuteTestcase',
            data:{
                'caseNos':caseNos,
                'batchType':'123456'
            },
            success:function (data) {
                $('#manage_testCase_datagrid').datagrid('reload');
            }
        });
    }

</script>
<style>
    pre {outline: 1px solid #ccc; padding: 5px; margin: 5px; }
    .string { color: green; }
    .number { color: darkorange; }
    .boolean { color: blue; }
    .null { color: magenta; }
    .key { color: red; }
</style>
