<script type="text/javascript">
$(function() {
	$.acooly.framework.registerKeydown('manage_parameters_searchform','manage_parameters_datagrid');
    <#--$("#search_EQ_lastImplementResult").combobox("select", ${lastImplementResultKey});-->
    <#--$("#search_EQ_lastImplementResult").combobox("setValue", ${lastImplementResultValue});-->

    $.acooly.framework.search('manage_parameters_searchform','manage_parameters_datagrid');

});

</script>
<div class="easyui-layout" data-options="fit : true,border : false">
  <!-- 查询条件 -->
  <div data-options="region:'north',border:false" style="padding:5px; overflow: hidden;" align="left">
    <form id="manage_parameters_searchform" onsubmit="return false">
      <table class="tableForm" width="100%">
        <tr>
          <td align="left">
          	<div>
					系统编号:
                <select  style="width:120px;height:27px;" name="search_EQ_projectNo" editable="false"
                        panelHeight="300" class="easyui-combobox">
                    <option value="">所有</option>
                        <#list allProjectNos as k,v>
                        <option value="${k}">${v}</option>
                        </#list>
                </select>
					接口编号: <input type="text" class="text" size="15" name="search_LIKE_interfaceNo"/>
					测试用例编号: <input type="text" class="text" size="15" name="search_LIKE_caseNo" />
					请求入参编号: <input type="text" class="text" size="15" name="search_LIKE_parametersNo"/>
					执行结果:
                <select id="search_EQ_lastImplementResult" style="width:120px;height:27px;" name="search_EQ_lastImplementResult" editable="false"
                        panelHeight="100" class="easyui-combobox">
                    <#if lastImplementResultKey!=''>
                        <option value="${lastImplementResultKey}">${lastImplementResultValue}</option>
                    <#else >
                    <option value="">所有</option>
                        <#list implementResult as k,v>
                        <option value="${k}">${v}</option>
                        </#list>
                    </#if>
                </select>
					<#--创建时间: <input size="15" class="text" id="search_GTE_createTime" name="search_GTE_createTime" onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" />-->
					<#--至<input size="15" class="text" id="search_LTE_createTime" name="search_LTE_createTime" onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" />-->
					<#--更新时间: <input size="15" class="text" id="search_GTE_updateTime" name="search_GTE_updateTime" onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" />-->
					<#--至<input size="15" class="text" id="search_LTE_updateTime" name="search_LTE_updateTime" onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" />-->
          	<a href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:false" onclick="$.acooly.framework.search('manage_parameters_searchform','manage_parameters_datagrid');"><i class="fa fa-search fa-lg fa-fw fa-col"></i>查询</a>
          	</div>
          </td>
        </tr>
      </table>
    </form>
  </div>

  <!-- 列表和工具栏 -->
  <div data-options="region:'center',border:false">
    <table id="manage_parameters_datagrid" class="easyui-datagrid" url="/manage/jorge/parameters/listJson.html" toolbar="#manage_parameters_toolbar" fit="true" border="false" fitColumns="false"
      pagination="true" idField="id" pageSize="20" pageList="[ 10, 20, 30, 40, 50 ]" sortName="id" sortOrder="desc" checkOnSelect="true" selectOnCheck="true" singleSelect="true">
      <thead>
        <tr>
        	<th field="showCheckboxWithId" checkbox="true" data-options="formatter:function(value, row, index){ return row.id }">编号</th>
			<th field="id" sortable="true">id</th>
			<th field="projectNo">系统编号</th>
			<th field="interfaceNo">接口编号</th>
			<th field="caseNo">测试用例编号</th>
			<th field="parametersNo">请求入参编号</th>
			<th field="parameters" formatter="contentFormatter">请求入参</th>
            <th field="callCount" sortable="true">用例执行次数</th>
            <th field="callSuccessCount" sortable="true">用例执行成功次数</th>
            <th field="callFailCount" sortable="true">用例执行失败次数</th>
            <th field="lastImplementResult" sortable="true" formatter="formatResult" >最近执行结果</th>
		    <th field="createTime" formatter="dateFormatter">创建时间</th>
		    <th field="updateTime" formatter="dateFormatter">更新时间</th>
          	<th field="rowActions" data-options="formatter:function(value, row, index){return formatString($('#manage_parameters_action').html(),row.id,row.projectNo,row.interfaceNo,row.caseNo,row.parametersNo);}">动作</th>
        </tr>
      </thead>
    </table>

    <!-- 每行的Action动作模板 -->
    <div id="manage_parameters_action" style="display: none;">
      <a onclick="$.acooly.framework.edit({url:'/manage/jorge/parameters/edit.html',id:'{0}',entity:'parameters',width:500,height:500});" href="#" title="编辑"><i class="fa fa-pencil fa-lg fa-fw fa-col"></i></a>
      <a onclick="$.acooly.framework.show('/manage/jorge/parameters/show.html?id={0}',500,500);" href="#" title="查看"><i class="fa fa-file-o fa-lg fa-fw fa-col"></i></a>
      <a onclick="$.acooly.framework.remove('/manage/jorge/parameters/deleteJson.html','{0}','manage_parameters_datagrid');" href="#" title="删除"><i class="fa fa-trash-o fa-lg fa-fw fa-col"></i></a>
        <a onclick="manage_testCase_invoke('manage_parameters_datagrid','{1}','{2}','{3}','{4}','parameters')" href="#"
           title="执行用例"><i class="fa fa-road fa-lg fa-fw fa-col"></i></a>
    </div>

    <!-- 表格的工具栏 -->
    <div id="manage_parameters_toolbar">
      <a href="#" class="easyui-linkbutton" plain="true" onclick="$.acooly.framework.create({url:'/manage/jorge/parameters/create.html',entity:'parameters',width:500,height:500})"><i class="fa fa-plus-circle fa-lg fa-fw fa-col"></i>添加</a>
      <#--<a href="#" class="easyui-linkbutton" plain="true" onclick="$.acooly.framework.removes('/manage/jorge/parameters/deleteJson.html','manage_parameters_datagrid')"><i class="fa fa-trash-o fa-lg fa-fw fa-col"></i>批量删除</a>-->
      <#--<a href="#" class="easyui-menubutton" data-options="menu:'#manage_parameters_exports_menu'"><i class="fa fa-arrow-circle-o-down fa-lg fa-fw fa-col"></i>批量导出</a>-->
      <#--<div id="manage_parameters_exports_menu" style="width:150px;">-->
        <#--<div onclick="$.acooly.framework.exports('/manage/jorge/parameters/exportXls.html','manage_parameters_searchform','用例入参表')"><i class="fa fa-file-excel-o fa-lg fa-fw fa-col"></i>Excel</div>-->
        <#--<div onclick="$.acooly.framework.exports('/manage/jorge/parameters/exportCsv.html','manage_parameters_searchform','用例入参表')"><i class="fa fa-file-text-o fa-lg fa-fw fa-col"></i>CSV</div>-->
      <#--</div>-->
      <#--<a href="#" class="easyui-linkbutton" plain="true" onclick="$.acooly.framework.imports({url:'/manage/jorge/parameters/importView.html',uploader:'manage_parameters_import_uploader_file'});"><i class="fa fa-arrow-circle-o-up fa-lg fa-fw fa-col"></i>批量导入</a>-->
    </div>
  </div>



</div>
<script src="/js/testui.js"></script>

