<#assign jodd=JspTaglibs["http://www.springside.org.cn/jodd_form"] />
<div>
    <form id="manage_logInfo_editform" action="/manage/jorge/logInfo/<#if action=='create'>saveJson<#else>updateJson</#if>.html" method="post">
		<@jodd.form bean="logInfo" scope="request">
        <input name="id" type="hidden" />
        <table class="tableForm" width="100%">
			<tr>
				<th width="25%">项目名：</th>
				<td><input type="text" name="projectNo" placeholder="请输入项目名..." class="easyui-validatebox" data-options="validType:['length[1,64]']"/></td>
			</tr>					
			<tr>
				<th>接口名：</th>
				<td><input type="text" name="interfaceNo" placeholder="请输入接口名..." class="easyui-validatebox" data-options="validType:['length[1,64]']"/></td>
			</tr>					
			<tr>
				<th>用例编号：</th>
				<td><input type="text" name="caseNo" placeholder="请输入用例编号..." class="easyui-validatebox" data-options="validType:['length[1,64]']"/></td>
			</tr>					
			<tr>
				<th>用例执行参数编号：</th>
				<td><input type="text" name="parametersNo" placeholder="请输入用例执行参数编号..." class="easyui-validatebox" data-options="validType:['length[1,64]']"/></td>
			</tr>					
			<tr>
				<th>请求接口参数：</th>
				<td><textarea rows="3" cols="40" placeholder="请输入请求接口参数..." name="requestInfo" class="easyui-validatebox" data-options="validType:['length[1,1024]']"></textarea></td>
			</tr>					
			<tr>
				<th>接口返回参数：</th>
				<td><textarea rows="3" cols="40" placeholder="请输入接口返回参数..." name="resultInfo" class="easyui-validatebox" data-options="validType:['length[1,1024]']"></textarea></td>
			</tr>					
			<tr>
				<th>用例说明：</th>
				<td><input type="text" name="memo" placeholder="请输入用例说明..." class="easyui-validatebox" data-options="validType:['length[1,64]']"/></td>
			</tr>					
        </table>
      </@jodd.form>
    </form>
</div>
