<script type="text/javascript">
$(function() {
	$.acooly.framework.registerKeydown('manage_batchInvokeResult_searchform','manage_batchInvokeResult_datagrid');
});

</script>
<div class="easyui-layout" data-options="fit : true,border : false">
  <!-- 查询条件 -->
  <div data-options="region:'north',border:false" style="padding:5px; overflow: hidden;" align="left">
    <form id="manage_batchInvokeResult_searchform" onsubmit="return false">
      <table class="tableForm" width="100%">
        <tr>
          <td align="left">
          	<div>
					批次号: <input type="text" class="text" size="15" name="search_LIKE_batchNo"/>
					用例编号: <input type="text" class="text" size="15" name="search_LIKE_caseNo"/>
					参数编号: <input type="text" class="text" size="15" name="search_LIKE_parameterNo"/>
					创建时间: <input type="text" class="text" size="15" name="search_LIKE_createTime"/>
					修改时间: <input type="text" class="text" size="15" name="search_LIKE_updateTime"/>
					执行结果:
                <select id="search_EQ_invokeStatus" style="width:120px;height:27px;" name="search_EQ_invokeStatus" editable="false"
                        panelHeight="100" class="easyui-combobox">
                    <option value="">所有</option>
                        <#list invokeStatusList as k,v>
                        <option value="${k}">${v}</option>
                        </#list>
                </select>
          	<a href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:false" onclick="$.acooly.framework.search('manage_batchInvokeResult_searchform','manage_batchInvokeResult_datagrid');"><i class="fa fa-search fa-lg fa-fw fa-col"></i>查询</a>
          	</div>
          </td>
        </tr>
      </table>
    </form>
  </div>

  <!-- 列表和工具栏 -->
  <div data-options="region:'center',border:false">
    <table id="manage_batchInvokeResult_datagrid" class="easyui-datagrid" url="/manage/jorge/batchInvokeResult/listJson.html" toolbar="#manage_batchInvokeResult_toolbar" fit="true" border="false" fitColumns="false"
      pagination="true" idField="id" pageSize="20" pageList="[ 10, 20, 30, 40, 50 ]" sortName="id" sortOrder="desc" checkOnSelect="true" selectOnCheck="true" singleSelect="true">
      <thead>
        <tr>
        	<th field="showCheckboxWithId" checkbox="true" data-options="formatter:function(value, row, index){ return row.id }">编号</th>
			<th field="id" sortable="true">id</th>
			<th field="batchNo">批次号</th>
			<th field="caseNo">用例编号</th>
			<th field="parameterNo">参数编号</th>
			<th field="invokeStatus" formatter="logInfoformatResult" sortable="true">用例执行结果</th>
			<th field="parameterRequest" formatter="contentFormatter">用例请求入参</th>
			<th field="parameterResponse" formatter="contentFormatter">用例执行返回结果</th>
		    <th field="createTime" formatter="dateTimeFormatter">创建时间</th>
		    <th field="updateTime" formatter="dateTimeFormatter">修改时间</th>
          	<th field="rowActions" data-options="formatter:function(value, row, index){return formatAction('manage_batchInvokeResult_action',value,row)}">动作</th>
        </tr>
      </thead>
    </table>

    <!-- 每行的Action动作模板 -->
    <div id="manage_batchInvokeResult_action" style="display: none;">
      <a onclick="$.acooly.framework.edit({url:'/manage/jorge/batchInvokeResult/edit.html',id:'{0}',entity:'batchInvokeResult',width:500,height:500});" href="#" title="编辑"><i class="fa fa-pencil fa-lg fa-fw fa-col"></i></a>
      <a onclick="$.acooly.framework.show('/manage/jorge/batchInvokeResult/show.html?id={0}',500,500);" href="#" title="查看"><i class="fa fa-file-o fa-lg fa-fw fa-col"></i></a>
      <a onclick="$.acooly.framework.remove('/manage/jorge/batchInvokeResult/deleteJson.html','{0}','manage_batchInvokeResult_datagrid');" href="#" title="删除"><i class="fa fa-trash-o fa-lg fa-fw fa-col"></i></a>
    </div>

    <!-- 表格的工具栏 -->
    <div id="manage_batchInvokeResult_toolbar">
      <a href="#" class="easyui-linkbutton" plain="true" onclick="$.acooly.framework.create({url:'/manage/jorge/batchInvokeResult/create.html',entity:'batchInvokeResult',width:500,height:500})"><i class="fa fa-plus-circle fa-lg fa-fw fa-col"></i>添加</a>
      <a href="#" class="easyui-linkbutton" plain="true" onclick="$.acooly.framework.removes('/manage/jorge/batchInvokeResult/deleteJson.html','manage_batchInvokeResult_datagrid')"><i class="fa fa-trash-o fa-lg fa-fw fa-col"></i>批量删除</a>
      <a href="#" class="easyui-menubutton" data-options="menu:'#manage_batchInvokeResult_exports_menu'"><i class="fa fa-arrow-circle-o-down fa-lg fa-fw fa-col"></i>批量导出</a>
      <div id="manage_batchInvokeResult_exports_menu" style="width:150px;">
        <div onclick="$.acooly.framework.exports('/manage/jorge/batchInvokeResult/exportXls.html','manage_batchInvokeResult_searchform','批次执行结果数据')"><i class="fa fa-file-excel-o fa-lg fa-fw fa-col"></i>Excel</div>
        <div onclick="$.acooly.framework.exports('/manage/jorge/batchInvokeResult/exportCsv.html','manage_batchInvokeResult_searchform','批次执行结果数据')"><i class="fa fa-file-text-o fa-lg fa-fw fa-col"></i>CSV</div>
      </div>
      <a href="#" class="easyui-linkbutton" plain="true" onclick="$.acooly.framework.imports({url:'/manage/jorge/batchInvokeResult/importView.html',uploader:'manage_batchInvokeResult_import_uploader_file'});"><i class="fa fa-arrow-circle-o-up fa-lg fa-fw fa-col"></i>批量导入</a>
    </div>
  </div>

</div>
<script src="/js/testui.js"></script>
