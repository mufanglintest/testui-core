<script type="text/javascript">
$(function() {
	$.acooly.framework.registerKeydown('manage_project_searchform','manage_project_datagrid');
});

</script>
<div class="easyui-layout" data-options="fit : true,border : false">
  <!-- 查询条件 -->
  <div data-options="region:'north',border:false" style="padding:5px; overflow: hidden;" align="left">
    <form id="manage_project_searchform" onsubmit="return false">
      <table class="tableForm" width="100%">
        <tr>
          <td align="left">
          	<div>
					项目编号: <input type="text" class="text" size="15" name="search_LIKE_projectNo"/>
					项目名称: <input type="text" class="text" size="15" name="search_LIKE_projectName"/>
					创建时间: <input type="text" class="text" size="15" name="search_LIKE_createTime"/>
					修改时间: <input type="text" class="text" size="15" name="search_LIKE_updateTime"/>
          	<a href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:false" onclick="$.acooly.framework.search('manage_project_searchform','manage_project_datagrid');"><i class="fa fa-search fa-lg fa-fw fa-col"></i>查询</a>
          	</div>
          </td>
        </tr>
      </table>
    </form>
  </div>

  <!-- 列表和工具栏 -->
  <div data-options="region:'center',border:false" style="overflow: hidden;height:50%">
    <table id="manage_project_datagrid" class="easyui-datagrid" url="/manage/jorge/project/listJson.html" toolbar="#manage_project_toolbar" fit="true" border="false" fitColumns="false"
      pagination="true" idField="id" pageSize="20" pageList="[ 10, 20, 30, 40, 50 ]" sortName="id" sortOrder="desc" checkOnSelect="true" selectOnCheck="true" singleSelect="true"
           data-options="onClickRow:load_manage_project_datagrid_sub">
      <thead>
        <tr>
        	<th field="showCheckboxWithId" checkbox="true" data-options="formatter:function(value, row, index){ return row.id }">编号</th>
			<th field="id" sortable="true">主键ID</th>
			<th field="projectNo">项目编号</th>
			<th field="projectName">项目名称</th>
		    <th field="createTime" formatter="dateTimeFormatter">创建时间</th>
		    <th field="updateTime" formatter="dateTimeFormatter">修改时间</th>
          	<th field="rowActions" data-options="formatter:function(value, row, index){return formatString($('#manage_project_action').html(),row.id,row.projectNo);}">动作</th>
        </tr>
      </thead>
    </table>

    <!-- 每行的Action动作模板 -->
    <div id="manage_project_action" style="display: none;">
      <a onclick="$.acooly.framework.edit({url:'/manage/jorge/project/edit.html',id:'{0}',entity:'project',width:500,height:500});" href="#" title="编辑"><i class="fa fa-pencil fa-lg fa-fw fa-col"></i></a>
      <a onclick="$.acooly.framework.show('/manage/jorge/project/show.html?id={0}',500,500);" href="#" title="查看"><i class="fa fa-file-o fa-lg fa-fw fa-col"></i></a>
      <a onclick="$.acooly.framework.remove('/manage/jorge/project/deleteJson.html','{0}','manage_project_datagrid');" href="#" title="删除"><i class="fa fa-trash-o fa-lg fa-fw fa-col"></i></a>
        <a onclick="testCase_invoke('{1}','','project');" href="#"
           title="执行用例"><i class="fa fa-road fa-lg fa-fw fa-col"></i></a>
    </div>

    <!-- 表格的工具栏 -->
    <div id="manage_project_toolbar">
      <a href="#" class="easyui-linkbutton" plain="true" onclick="$.acooly.framework.create({url:'/manage/jorge/project/create.html',entity:'project',width:500,height:500})"><i class="fa fa-plus-circle fa-lg fa-fw fa-col"></i>添加</a>
      <a href="#" class="easyui-linkbutton" plain="true" onclick="$.acooly.framework.removes('/manage/jorge/project/deleteJson.html','manage_project_datagrid')"><i class="fa fa-trash-o fa-lg fa-fw fa-col"></i>批量删除</a>
    </div>
  </div>
    <div data-options="region:'south',border:false" style="height:45%;">
        <div id="manage_interfaceInfo_sub_tab" class="easyui-tabs" fit="true">
            <div title="系统接口列表" style="margin-left: 0px;">
                <table id="manage_interface_datagrid" class="easyui-datagrid" toolbar="#manage_interface_toolbar" fit="true" border="false" fitColumns="false"
                       pagination="true" idField="id" pageSize="50" pageList="[ 10, 20, 30, 40, 50 ]" sortName="id" sortOrder="desc" checkOnSelect="true" selectOnCheck="true" singleSelect="true">
                    <thead>
                    <tr>
                        <th field="showCheckboxWithId" checkbox="true" data-options="formatter:function(value, row, index){ return row.id }">编号</th>
                        <th field="id" sortable="true">id</th>
                        <th field="projectNo" formatter="mappingFormatter">所属项目</th>
                        <th field="interfaceNo">接口编号</th>
                        <th field="interfaceName">接口名称</th>
                        <th field="createTime" formatter="dateTimeFormatter">创建时间</th>
                        <th field="updateTime" formatter="dateTimeFormatter">修改时间</th>
                        <th field="rowActions" data-options="formatter:function(value, row, index){return formatString($('#manage_interface_action').html(),row.id,row.projectNo,row.interfaceNo);}">动作</th>
                    </tr>
                    </thead>
                </table>

                <!-- 每行的Action动作模板 -->
                <div id="manage_interface_action" style="display: none;">
                    <a onclick="$.acooly.framework.edit({url:'/manage/jorge/interface/edit.html',id:'{0}',entity:'interface',width:500,height:500});" href="#" title="编辑"><i class="fa fa-pencil fa-lg fa-fw fa-col"></i></a>
                    <a onclick="$.acooly.framework.show('/manage/jorge/interface/show.html?id={0}',500,500);" href="#" title="查看"><i class="fa fa-file-o fa-lg fa-fw fa-col"></i></a>
                    <a onclick="$.acooly.framework.remove('/manage/jorge/interface/deleteJson.html','{0}','manage_interface_datagrid');" href="#" title="删除"><i class="fa fa-trash-o fa-lg fa-fw fa-col"></i></a>
                    <a onclick="testCase_invoke('{1}','{2}','interface');" href="#"
                       title="执行用例"><i class="fa fa-road fa-lg fa-fw fa-col"></i></a>
                </div>

                <!-- 表格的工具栏 -->
                <div id="manage_interface_toolbar">
                    <a href="#" class="easyui-linkbutton" plain="true" onclick="manage_interface_create()"><i class="fa fa-plus-circle fa-lg fa-fw fa-col"></i>添加</a>
                    <a href="#" class="easyui-linkbutton" plain="true" onclick="$.acooly.framework.removes('/manage/jorge/interface/deleteJson.html','manage_interface_datagrid')"><i class="fa fa-trash-o fa-lg fa-fw fa-col"></i>批量删除</a>
                </div>
            </div>
        </div>
    </div>

</div>

<script type="text/javascript">
    function load_manage_project_datagrid_sub() {
        $("#manage_interfaceInfo_sub_tab").parent().show();
        var rowData = $.acooly.framework.getSelectedRow("manage_project_datagrid");
        if (!rowData){
            $.messager.show({title:'提示',msg:'请选择所属系统'})
            return null;
        }
        $.acooly.framework.fireSelectRow('manage_project_datagrid', function (row) {
            console.info(row.projectNo);
            $.acooly.framework.loadGrid({
                gridId: "manage_interface_datagrid",
                url: '/manage/jorge/interface/listJson.html',
                ajaxData: {
                    "search_EQ_projectNo": row.projectNo,
                    "rows": 50,
                }
            });
        }, '请先选择操作的项目');
    }

    function manage_interface_create() {
        var rowData = $.acooly.framework.getSelectedRow("manage_project_datagrid");
        if (!rowData) {
            $.messager.show({title: '提示', msg: '请先选择需要添加的系统'});
            return null;
        }
        $.acooly.framework.create({
            url: '/manage/jorge/interface/create.html',
            entity: 'interface',
            width: 500,
            height: 500,
            ajaxData: {
                "projectNo": rowData.projectNo
            }
        });

    }

    /**
     * 执行用例
     * @param projectNo
     * @param interfaceNo
     * @param requestType
     */
    function testCase_invoke(projectNo,interfaceNo,requestType) {
        $.get({
            url: '/case.do',
            data: {
                "requestType": requestType,
                "projectNo": projectNo,
                "interfaceNo": interfaceNo,
            },
            success: function (data) {
                if (data==''){
                    $.messager.show({title:'提示',msg:'该项目或接口没有添加用例，请添加后执行'})
                    return null;
                }
                if (!data.success) {
                    $.messager.show({title: '提示', msg: '用例未全部执行成功!'})
                    return null;
                }
                if (interfaceNo == '') {
                    $.messager.show({title: '提示', msg: '系统编号' + projectNo + '已执行'});
                } else {
                    $.messager.show({title: '提示', msg: '系统编号' + projectNo + '，接口编号为' + interfaceNo + '已执行'});

                }
            },
            error: function (data, e) {
                $.messager.show({title: '提示', msg: "用例执行失败！"});
            }
        });
    }




</script>
