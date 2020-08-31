<script type="text/javascript">
$(function() {
	$.acooly.framework.registerKeydown('manage_logInfo_searchform','manage_logInfo_datagrid');
});

</script>
<div class="easyui-layout" data-options="fit : true,border : false">
  <!-- 查询条件 -->
  <div data-options="region:'north',border:false" style="padding:5px; overflow: hidden;" align="left">
    <form id="manage_logInfo_searchform" onsubmit="return false">
      <table class="tableForm" width="100%">
        <tr>
          <td align="left">
          	<div>
					项目名: <input type="text" class="text" size="15" name="search_LIKE_projectNo"/>
					接口名: <input type="text" class="text" size="15" name="search_LIKE_interfaceNo"/>
					用例编号: <input type="text" class="text" size="15" name="search_LIKE_caseNo"/>
					用例执行参数编号: <input type="text" class="text" size="15" name="search_LIKE_parametersNo"/>
                    用例执行状态:<input type="text" class="testx" name="search_LIKE_exexuteStatus"/>
					create_time: <input size="15" class="text" id="search_GTE_createTime" name="search_GTE_createTime" onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" />
					至<input size="15" class="text" id="search_LTE_createTime" name="search_LTE_createTime" onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" />
					update_time: <input size="15" class="text" id="search_GTE_updateTime" name="search_GTE_updateTime" onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" />
					至<input size="15" class="text" id="search_LTE_updateTime" name="search_LTE_updateTime" onFocus="WdatePicker({readOnly:true,dateFmt:'yyyy-MM-dd'})" />
					用例说明: <input type="text" class="text" size="15" name="search_LIKE_memo"/>
          	<a href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:false" onclick="$.acooly.framework.search('manage_logInfo_searchform','manage_logInfo_datagrid');"><i class="fa fa-search fa-lg fa-fw fa-col"></i>查询</a>
          	</div>
          </td>
        </tr>
      </table>
    </form>
  </div>

  <!-- 列表和工具栏 -->
  <div data-options="region:'center',border:false">
    <table id="manage_logInfo_datagrid" class="easyui-datagrid" url="/manage/jorge/logInfo/listJson.html" toolbar="#manage_logInfo_toolbar" fit="true" border="false" fitColumns="false"
      pagination="true" idField="id" pageSize="20" pageList="[ 10, 20, 30, 40, 50 ]" sortName="id" sortOrder="desc" checkOnSelect="true" selectOnCheck="true" singleSelect="true">
      <thead>
        <tr>
        	<th field="showCheckboxWithId" checkbox="true" data-options="formatter:function(value, row, index){ return row.id }">编号</th>
			<th field="id" sortable="true">id</th>
			<th field="projectNo">项目名</th>
			<th field="interfaceNo">接口名</th>
			<th field="caseNo">用例编号</th>
			<th field="parametersNo">用例执行参数编号</th>
			<th field="requestInfo" formatter="contentFormatter">请求接口参数</th>
			<th field="resultInfo" formatter="contentFormatter">接口返回参数</th>
			<th field="exexuteStatus" formatter="logInfoformatResult">用例执行状态</th>
		    <th field="createTime" formatter="dateFormatter">create_time</th>
		    <th field="updateTime" formatter="dateFormatter">update_time</th>
			<th field="memo">用例说明</th>
          	<th field="rowActions" data-options="formatter:function(value, row, index){return formatAction('manage_logInfo_action',value,row)}">动作</th>
        </tr>
      </thead>
    </table>

    <!-- 每行的Action动作模板 -->
    <div id="manage_logInfo_action" style="display: none;">
      <a onclick="$.acooly.framework.edit({url:'/manage/jorge/logInfo/edit.html',id:'{0}',entity:'logInfo',width:500,height:500});" href="#" title="编辑"><i class="fa fa-pencil fa-lg fa-fw fa-col"></i></a>
      <a onclick="$.acooly.framework.show('/manage/jorge/logInfo/show.html?id={0}',500,500);" href="#" title="查看"><i class="fa fa-file-o fa-lg fa-fw fa-col"></i></a>
      <a onclick="$.acooly.framework.remove('/manage/jorge/logInfo/deleteJson.html','{0}','manage_logInfo_datagrid');" href="#" title="删除"><i class="fa fa-trash-o fa-lg fa-fw fa-col"></i></a>
    </div>

    <!-- 表格的工具栏 -->
    <div id="manage_logInfo_toolbar">
      <a href="#" class="easyui-linkbutton" plain="true" onclick="addDatas()"><i class="fa fa-plus-circle fa-lg fa-fw fa-col"></i>添加测试数据</a>

    <#--<a href="#" class="easyui-linkbutton" plain="true" onclick="$.acooly.framework.create({url:'/manage/jorge/logInfo/create.html',entity:'logInfo',width:500,height:500})"><i class="fa fa-plus-circle fa-lg fa-fw fa-col"></i>添加</a>-->
      <#--<a href="#" class="easyui-linkbutton" plain="true" onclick="$.acooly.framework.removes('/manage/jorge/logInfo/deleteJson.html','manage_logInfo_datagrid')"><i class="fa fa-trash-o fa-lg fa-fw fa-col"></i>批量删除</a>-->
      <#--<a href="#" class="easyui-menubutton" data-options="menu:'#manage_logInfo_exports_menu'"><i class="fa fa-arrow-circle-o-down fa-lg fa-fw fa-col"></i>批量导出</a>-->
      <#--<div id="manage_logInfo_exports_menu" style="width:150px;">-->
        <#--<div onclick="$.acooly.framework.exports('/manage/jorge/logInfo/exportXls.html','manage_logInfo_searchform','log_info')"><i class="fa fa-file-excel-o fa-lg fa-fw fa-col"></i>Excel</div>-->
        <#--<div onclick="$.acooly.framework.exports('/manage/jorge/logInfo/exportCsv.html','manage_logInfo_searchform','log_info')"><i class="fa fa-file-text-o fa-lg fa-fw fa-col"></i>CSV</div>-->
      <#--</div>-->
      <#--<a href="#" class="easyui-linkbutton" plain="true" onclick="$.acooly.framework.imports({url:'/manage/jorge/logInfo/importView.html',uploader:'manage_logInfo_import_uploader_file'});"><i class="fa fa-arrow-circle-o-up fa-lg fa-fw fa-col"></i>批量导入</a>-->
    </div>
  </div>

</div>
<script src="/js/testui.js"></script>
<script type="text/javascript">
    function addDatas() {
        $.acooly.framework.create({
            url: '/manage/jorge/logInfo/returnAddDatas.html',
            form:'manage_testDatas_editform',
            datagrid:'manage_logInfo_datagrid',
            width: 500,
            height: 700,
            reload:true
        });
    }
</script>
