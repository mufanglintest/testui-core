<#assign jodd=JspTaglibs["http://www.springside.org.cn/jodd_form"] />
<div>
    <form id="manage_executeLog_editform" action="/manage/jorge/executeLog/<#if action=='create'>saveJson<#else>updateJson</#if>.html" method="post">
		<@jodd.form bean="executeLog" scope="request">
        <input name="id" type="hidden" />
        <table class="tableForm" width="100%">
			<tr>
				<th width="25%">project_no：</th>
				<td><input type="text" name="projectNo" placeholder="请输入project_no..." class="easyui-validatebox" data-options="validType:['length[1,64]']"/></td>
			</tr>					
			<tr>
				<th>interface_no：</th>
				<td><input type="text" name="interfaceNo" placeholder="请输入interface_no..." class="easyui-validatebox" data-options="validType:['length[1,64]']"/></td>
			</tr>					
			<tr>
				<th>case_no：</th>
				<td><input type="text" name="caseNo" placeholder="请输入case_no..." class="easyui-validatebox" data-options="validType:['length[1,64]']"/></td>
			</tr>					
			<tr>
				<th>parameter_no：</th>
				<td><input type="text" name="parameterNo" placeholder="请输入parameter_no..." class="easyui-validatebox" data-options="validType:['length[1,1]']"/></td>
			</tr>					
			<tr>
				<th>parameters：</th>
				<td><textarea rows="3" cols="40" placeholder="请输入parameters..." name="parameters" class="easyui-validatebox" data-options="validType:['length[1,100000]']"></textarea></td>
			</tr>					
        </table>
      </@jodd.form>
    </form>
</div>
