<div style="padding: 5px;font-family:微软雅黑;">
<table class="tableForm" width="100%">
	<tr>
		<th>id:</th>
		<td>${logInfo.id}</td>
	</tr>					
	<tr>
		<th width="25%">项目名:</th>
		<td>${logInfo.projectNo}</td>
	</tr>					
	<tr>
		<th>接口名:</th>
		<td>${logInfo.interfaceNo}</td>
	</tr>					
	<tr>
		<th>用例编号:</th>
		<td>${logInfo.caseNo}</td>
	</tr>					
	<tr>
		<th>用例执行参数编号:</th>
		<td>${logInfo.parametersNo}</td>
	</tr>					
	<tr>
		<th>请求接口参数:</th>
		<td>${logInfo.requestInfo}</td>
	</tr>					
	<tr>
		<th>接口返回参数:</th>
		<td>${logInfo.resultInfo}</td>
	</tr>					
	<tr>
		<th>create_time:</th>
		<td>${logInfo.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
	</tr>					
	<tr>
		<th>update_time:</th>
		<td>${logInfo.updateTime?string('yyyy-MM-dd HH:mm:ss')}</td>
	</tr>					
	<tr>
		<th>用例说明:</th>
		<td>${logInfo.memo}</td>
	</tr>					
</table>
</div>
