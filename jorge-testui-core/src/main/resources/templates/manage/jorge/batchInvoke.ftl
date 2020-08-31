<script type="text/javascript">
$(function() {
	$.acooly.framework.registerKeydown('manage_batchInvoke_searchform','manage_batchInvoke_datagrid');
});

</script>
<div class="easyui-layout" data-options="fit : true,border : false">
  <!-- 查询条件 -->
  <div data-options="region:'north',border:false" style="padding:5px; overflow: hidden;" align="left">
    <form id="manage_batchInvoke_searchform" onsubmit="return false">
        <table class="tableForm" width="100%">
        <tr>
          <td align="left">
          	<div>
                批次号: <input type="text" class="text" size="15" name="search_LIKE_batchNo"/>
          	<a href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:false" onclick="$.acooly.framework.search('manage_batchInvoke_searchform','manage_batchInvoke_datagrid');"><i class="fa fa-search fa-lg fa-fw fa-col"></i>查询</a>
          	</div>
          </td>
        </tr>
      </table>
    </form>
  </div>

  <!-- 列表和工具栏 -->
  <div data-options="region:'center',border:false">
    <table id="manage_batchInvoke_datagrid" class="easyui-datagrid" url="/manage/jorge/batchInvoke/listJson.html" toolbar="#manage_batchInvoke_toolbar" fit="true" border="false" fitColumns="false"
      pagination="true" idField="id" pageSize="20" pageList="[ 10, 20, 30, 40, 50 ]" sortName="id" sortOrder="desc" checkOnSelect="true" selectOnCheck="true" singleSelect="true">
      <thead>
        <tr>
        	<th field="showCheckboxWithId" checkbox="true" data-options="formatter:function(value, row, index){ return row.id }">编号</th>
			<th field="id" sortable="true">id</th>
			<th field="batchNo" sortable="true">批次号</th>
			<th field="totalCase" sortable="true">总执行用例数</th>
			<th field="successCase" sortable="true">成功用例数</th>
			<th field="failCase" sortable="true">失败用例数</th>
			<th field="totalTime" sortable="true">总执行时间</th>
          	<th field="rowActions" data-options="formatter:function(value, row, index){return formatAction('manage_batchInvoke_action',value,row)}">动作</th>
        </tr>
      </thead>
    </table>

    <!-- 每行的Action动作模板 -->
    <div id="manage_batchInvoke_action" style="display: none;">
      <a onclick="$.acooly.framework.edit({url:'/manage/jorge/batchInvoke/edit.html',id:'{0}',entity:'batchInvoke',width:500,height:500});" href="#" title="编辑"><i class="fa fa-pencil fa-lg fa-fw fa-col"></i></a>
      <a onclick="$.acooly.framework.show('/manage/jorge/batchInvoke/show.html?id={0}',500,500);" href="#" title="查看"><i class="fa fa-file-o fa-lg fa-fw fa-col"></i></a>
      <a onclick="$.acooly.framework.remove('/manage/jorge/batchInvoke/deleteJson.html','{0}','manage_batchInvoke_datagrid');" href="#" title="删除"><i class="fa fa-trash-o fa-lg fa-fw fa-col"></i></a>
    </div>

    <!-- 表格的工具栏 -->
    <div id="manage_batchInvoke_toolbar">
      <a href="#" class="easyui-linkbutton" plain="true" onclick="$.acooly.framework.create({url:'/manage/jorge/batchInvoke/create.html',entity:'batchInvoke',width:500,height:500})"><i class="fa fa-plus-circle fa-lg fa-fw fa-col"></i>添加</a>
      <a href="#" class="easyui-linkbutton" plain="true" onclick="$.acooly.framework.removes('/manage/jorge/batchInvoke/deleteJson.html','manage_batchInvoke_datagrid')"><i class="fa fa-trash-o fa-lg fa-fw fa-col"></i>批量删除</a>
      <a href="#" class="easyui-menubutton" data-options="menu:'#manage_batchInvoke_exports_menu'"><i class="fa fa-arrow-circle-o-down fa-lg fa-fw fa-col"></i>批量导出</a>
      <div id="manage_batchInvoke_exports_menu" style="width:150px;">
        <div onclick="$.acooly.framework.exports('/manage/jorge/batchInvoke/exportXls.html','manage_batchInvoke_searchform','用例执行批次表')"><i class="fa fa-file-excel-o fa-lg fa-fw fa-col"></i>Excel</div>
        <div onclick="$.acooly.framework.exports('/manage/jorge/batchInvoke/exportCsv.html','manage_batchInvoke_searchform','用例执行批次表')"><i class="fa fa-file-text-o fa-lg fa-fw fa-col"></i>CSV</div>
      </div>
      <a href="#" class="easyui-linkbutton" plain="true" onclick="$.acooly.framework.imports({url:'/manage/jorge/batchInvoke/importView.html',uploader:'manage_batchInvoke_import_uploader_file'});"><i class="fa fa-arrow-circle-o-up fa-lg fa-fw fa-col"></i>批量导入</a>
    </div>
  </div>

</div>
