<script type="text/javascript">
$(function() {
	$.acooly.framework.registerKeydown('manage_caseRequestParameter_searchform','manage_caseRequestParameter_datagrid');
});

</script>
<div class="easyui-layout" data-options="fit : true,border : false">
  <!-- 查询条件 -->
  <div data-options="region:'north',border:false" style="padding:5px; overflow: hidden;" align="left">
    <form id="manage_caseRequestParameter_searchform" onsubmit="return false">
      <table class="tableForm" width="100%">
        <tr>
          <td align="left">
          	<div>
					用例编码: <input type="text" class="text" size="15" name="search_LIKE_caseNo"/>
          	<a href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:false" onclick="$.acooly.framework.search('manage_caseRequestParameter_searchform','manage_caseRequestParameter_datagrid');"><i class="fa fa-search fa-lg fa-fw fa-col"></i>查询</a>
          	</div>
          </td>
        </tr>
      </table>
    </form>
  </div>

  <!-- 列表和工具栏 -->
  <div data-options="region:'center',border:false">
    <table id="manage_caseRequestParameter_datagrid" class="easyui-datagrid" url="/manage/jorge/caseRequestParameter/listJson.html" toolbar="#manage_caseRequestParameter_toolbar" fit="true" border="false" fitColumns="false"
      pagination="true" idField="id" pageSize="20" pageList="[ 10, 20, 30, 40, 50 ]" sortName="id" sortOrder="desc" checkOnSelect="true" selectOnCheck="true" singleSelect="true">
      <thead>
        <tr>
        	<th field="showCheckboxWithId" checkbox="true" data-options="formatter:function(value, row, index){ return row.id }">编号</th>
			<th field="id" sortable="true">id</th>
			<th field="caseNo">用例编码</th>
			<#--<th field="requestDemo" formatter="contentFormatter">用例请求参数模板</th>-->
			<th field="requestDemo" formatter="contentFormatter">用例请求参数模板</th>
          	<th field="rowActions" data-options="formatter:function(value, row, index){return formatAction('manage_caseRequestParameter_action',value,row)}">动作</th>
        </tr>
      </thead>
    </table>

    <!-- 每行的Action动作模板 -->
    <div id="manage_caseRequestParameter_action" style="display: none;">
      <a onclick="$.acooly.framework.edit({url:'/manage/jorge/caseRequestParameter/edit.html',id:'{0}',entity:'caseRequestParameter',width:500,height:500});" href="#" title="编辑"><i class="fa fa-pencil fa-lg fa-fw fa-col"></i></a>
      <a onclick="$.acooly.framework.show('/manage/jorge/caseRequestParameter/show.html?id={0}',500,500);" href="#" title="查看"><i class="fa fa-file-o fa-lg fa-fw fa-col"></i></a>
      <a onclick="$.acooly.framework.remove('/manage/jorge/caseRequestParameter/deleteJson.html','{0}','manage_caseRequestParameter_datagrid');" href="#" title="删除"><i class="fa fa-trash-o fa-lg fa-fw fa-col"></i></a>
    </div>

    <!-- 表格的工具栏 -->
    <div id="manage_caseRequestParameter_toolbar">
      <a href="#" class="easyui-linkbutton" plain="true" onclick="$.acooly.framework.create({url:'/manage/jorge/caseRequestParameter/create.html',entity:'caseRequestParameter',width:500,height:500})"><i class="fa fa-plus-circle fa-lg fa-fw fa-col"></i>添加</a>
      <a href="#" class="easyui-linkbutton" plain="true" onclick="$.acooly.framework.removes('/manage/jorge/caseRequestParameter/deleteJson.html','manage_caseRequestParameter_datagrid')"><i class="fa fa-trash-o fa-lg fa-fw fa-col"></i>批量删除</a>
      <a href="#" class="easyui-menubutton" data-options="menu:'#manage_caseRequestParameter_exports_menu'"><i class="fa fa-arrow-circle-o-down fa-lg fa-fw fa-col"></i>批量导出</a>
      <div id="manage_caseRequestParameter_exports_menu" style="width:150px;">
        <div onclick="$.acooly.framework.exports('/manage/jorge/caseRequestParameter/exportXls.html','manage_caseRequestParameter_searchform','case_request_parameter')"><i class="fa fa-file-excel-o fa-lg fa-fw fa-col"></i>Excel</div>
        <div onclick="$.acooly.framework.exports('/manage/jorge/caseRequestParameter/exportCsv.html','manage_caseRequestParameter_searchform','case_request_parameter')"><i class="fa fa-file-text-o fa-lg fa-fw fa-col"></i>CSV</div>
      </div>
      <a href="#" class="easyui-linkbutton" plain="true" onclick="$.acooly.framework.imports({url:'/manage/jorge/caseRequestParameter/importView.html',uploader:'manage_caseRequestParameter_import_uploader_file'});"><i class="fa fa-arrow-circle-o-up fa-lg fa-fw fa-col"></i>批量导入</a>
    </div>
  </div>

</div>

<script type="text/javascript">

    function f(vaule,  row, index) {

        var formattedStr = JSON.stringify(vaule, null, 2);
        return formattedStr;
    }

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

</script>
<style>
    pre {outline: 1px solid #ccc; padding: 5px; margin: 5px; }
    .string { color: green; }
    .number { color: darkorange; }
    .boolean { color: blue; }
    .null { color: magenta; }
    .key { color: red; }
</style>