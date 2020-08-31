<script type="text/javascript">
$(function() {
	$.acooly.framework.registerKeydown('manage_executeLog_searchform','manage_executeLog_datagrid');
});

</script>
<div class="easyui-layout" data-options="fit : true,border : false">
  <!-- 查询条件 -->
  <div data-options="region:'north',border:false" style="padding:5px; overflow: hidden;" align="left">
    <form id="manage_executeLog_searchform" onsubmit="return false">
      <table class="tableForm" width="100%">
        <tr>
          <td align="left">
          	<div>
					系统名称: <input type="text" class="text" size="15" name="search_LIKE_projectNo"/>
					接口名称: <input type="text" class="text" size="15" name="search_LIKE_interfaceNo"/>
					用例编码: <input type="text" class="text" size="15" name="search_LIKE_caseNo"/>
					参数编号: <input type="text" class="text" size="15" name="search_LIKE_parameterNo"/>
                创建时间: <input size="15" class="text" id="search_GTE_createTime" name="search_GTE_createTime" onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" />
                至<input size="15" class="text" id="search_LTE_createTime" name="search_LTE_createTime" onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" />
                修改时间: <input size="15" class="text" id="search_GTE_updateTime" name="search_GTE_updateTime" onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" />
                至<input size="15" class="text" id="search_LTE_updateTime" name="search_LTE_updateTime" onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" />
          	<a href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:false" onclick="$.acooly.framework.search('manage_executeLog_searchform','manage_executeLog_datagrid');"><i class="fa fa-search fa-lg fa-fw fa-col"></i>查询</a>
          	</div>
          </td>
        </tr>
      </table>
    </form>
  </div>

  <!-- 列表和工具栏 -->
  <div data-options="region:'center',border:false">
    <table id="manage_executeLog_datagrid" class="easyui-datagrid" url="/manage/jorge/executeLog/listJson.html" toolbar="#manage_executeLog_toolbar" fit="true" border="false" fitColumns="false"
      pagination="true" idField="id" pageSize="20" pageList="[ 10, 20, 30, 40, 50 ]" sortName="id" sortOrder="desc" checkOnSelect="true" selectOnCheck="true" singleSelect="true">
      <thead>
        <tr>
        	<th field="showCheckboxWithId" checkbox="true" data-options="formatter:function(value, row, index){ return row.id }">编号</th>
			<th field="id" sortable="true">id</th>
			<th field="projectNo">系统名称</th>
			<th field="interfaceNo">接口名称</th>
			<th field="caseNo">用例编码</th>
			<th field="parameterNo">参数编号</th>
			<th field="parameters" formatter="contentFormatter">原始请求参数</th>
            <th field="createTime" formatter="dateTimeFormatter">创建时间</th>
            <th field="updateTime" formatter="dateTimeFormatter">修改时间</th>
          	<th field="rowActions" data-options="formatter:function(value, row, index){return formatAction('manage_executeLog_action',value,row)}">动作</th>
        </tr>
      </thead>
    </table>

    <!-- 每行的Action动作模板 -->
    <div id="manage_executeLog_action" style="display: none;">
      <a onclick="$.acooly.framework.edit({url:'/manage/jorge/executeLog/edit.html',id:'{0}',entity:'executeLog',width:500,height:500});" href="#" title="编辑"><i class="fa fa-pencil fa-lg fa-fw fa-col"></i></a>
      <a onclick="$.acooly.framework.show('/manage/jorge/executeLog/show.html?id={0}',500,500);" href="#" title="查看"><i class="fa fa-file-o fa-lg fa-fw fa-col"></i></a>
      <a onclick="$.acooly.framework.remove('/manage/jorge/executeLog/deleteJson.html','{0}','manage_executeLog_datagrid');" href="#" title="删除"><i class="fa fa-trash-o fa-lg fa-fw fa-col"></i></a>
    </div>

    <!-- 表格的工具栏 -->
    <div id="manage_executeLog_toolbar">
      <a href="#" class="easyui-linkbutton" plain="true" onclick="$.acooly.framework.create({url:'/manage/jorge/executeLog/create.html',entity:'executeLog',width:500,height:500})"><i class="fa fa-plus-circle fa-lg fa-fw fa-col"></i>添加</a>
      <a href="#" class="easyui-linkbutton" plain="true" onclick="$.acooly.framework.removes('/manage/jorge/executeLog/deleteJson.html','manage_executeLog_datagrid')"><i class="fa fa-trash-o fa-lg fa-fw fa-col"></i>批量删除</a>
      <a href="#" class="easyui-menubutton" data-options="menu:'#manage_executeLog_exports_menu'"><i class="fa fa-arrow-circle-o-down fa-lg fa-fw fa-col"></i>批量导出</a>
      <div id="manage_executeLog_exports_menu" style="width:150px;">
        <div onclick="$.acooly.framework.exports('/manage/jorge/executeLog/exportXls.html','manage_executeLog_searchform','execute_log')"><i class="fa fa-file-excel-o fa-lg fa-fw fa-col"></i>Excel</div>
        <div onclick="$.acooly.framework.exports('/manage/jorge/executeLog/exportCsv.html','manage_executeLog_searchform','execute_log')"><i class="fa fa-file-text-o fa-lg fa-fw fa-col"></i>CSV</div>
      </div>
      <a href="#" class="easyui-linkbutton" plain="true" onclick="$.acooly.framework.imports({url:'/manage/jorge/executeLog/importView.html',uploader:'manage_executeLog_import_uploader_file'});"><i class="fa fa-arrow-circle-o-up fa-lg fa-fw fa-col"></i>批量导入</a>
    </div>
  </div>

</div>
