<div style="padding: 5px;font-family:微软雅黑;">
<table class="tableForm" width="100%">
	<tr>
		<th>主键ID:</th>
		<td>${project.id}</td>
	</tr>					
	<tr>
		<th width="25%">项目编号:</th>
		<td>${project.projectNo}</td>
	</tr>					
	<tr>
		<th>项目名称:</th>
		<td>${project.projectName}</td>
	</tr>					
	<tr>
		<th>创建时间:</th>
		<td>${project.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
	</tr>					
	<tr>
		<th>修改时间:</th>
		<td>${project.updateTime?string('yyyy-MM-dd HH:mm:ss')}</td>
	</tr>					
</table>
</div>
