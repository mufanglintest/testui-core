<div style="padding: 5px;font-family:微软雅黑;">
<table class="tableForm" width="100%">
	<tr>
		<th>id:</th>
		<td>${parameters.id}</td>
	</tr>					
	<tr>
		<th width="25%">系统编号:</th>
		<td>${parameters.projectNo}</td>
	</tr>					
	<tr>
		<th>接口编号:</th>
		<td>${parameters.interfaceNo}</td>
	</tr>					
	<tr>
		<th>测试用例编号:</th>
		<td>${parameters.caseNo}</td>
	</tr>					
	<tr>
		<th>请求入参编号:</th>
		<td>${parameters.parametersNo}</td>
	</tr>					
	<tr>
		<th>请求入参:</th>
		<td>${parameters.parameters}</td>
	</tr>					
	<tr>
		<th>创建时间:</th>
		<td>${parameters.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
	</tr>					
	<tr>
		<th>更新时间:</th>
		<td>${parameters.updateTime?string('yyyy-MM-dd HH:mm:ss')}</td>
	</tr>					
</table>
</div>
