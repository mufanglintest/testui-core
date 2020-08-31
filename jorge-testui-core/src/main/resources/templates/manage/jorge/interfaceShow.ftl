<div style="padding: 5px;font-family:微软雅黑;">
<table class="tableForm" width="100%">
	<tr>
		<th>id:</th>
		<td>${interface.id}</td>
	</tr>					
	<tr>
		<th width="25%">接口编号:</th>
		<td>${interface.interfaceNo}</td>
	</tr>					
	<tr>
		<th>接口名称:</th>
		<td>${interface.interfaceName}</td>
	</tr>					
	<tr>
		<th>所属项目编号:</th>
		<td>${interface.projectNo}</td>
	</tr>					
	<tr>
		<th>创建时间:</th>
		<td>${interface.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
	</tr>					
	<tr>
		<th>修改时间:</th>
		<td>${interface.updateTime?string('yyyy-MM-dd HH:mm:ss')}</td>
	</tr>					
</table>
</div>
