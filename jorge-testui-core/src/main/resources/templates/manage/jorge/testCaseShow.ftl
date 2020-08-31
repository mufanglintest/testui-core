<div style="padding: 5px;font-family:微软雅黑;">
<table class="tableForm" width="100%">
	<tr>
		<th>id:</th>
		<td>${testCase.id}</td>
	</tr>					
	<tr>
		<th width="25%">用例编号:</th>
		<td>${testCase.caseNo}</td>
	</tr>					
	<tr>
		<th>用例名称:</th>
		<td>${testCase.caseName}</td>
	</tr>					
	<tr>
		<th>用例类别:</th>
		<td>${testCase.caseType.message()}</td>
	</tr>					
	<tr>
		<th>请求地址:</th>
		<td>${testCase.url}</td>
	</tr>					
	<#--<tr>-->
		<#--<th>请求参数:</th>-->
		<#--<td>${testCase.input}</td>-->
	<#--</tr>					-->
	<tr>
		<th>协议类型:</th>
		<td>${testCase.protocolType.message()}</td>
	</tr>
    <tr>
        <th>创建者:</th>
        <td>${testCase.createUser}</td>
    </tr>
    <tr>
		<th>创建时间:</th>
		<td>${testCase.createTime?string('yyyy-MM-dd HH:mm:ss')}</td>
	</tr>					
	<tr>
		<th>修改时间:</th>
		<td>${testCase.updateTime?string('yyyy-MM-dd HH:mm:ss')}</td>
	</tr>					
</table>
</div>
