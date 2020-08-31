<#assign jodd=JspTaglibs["http://www.springside.org.cn/jodd_form"] />
<div>
    <form id="manage_batchInvokeResult_editform" action="/manage/jorge/batchInvokeResult/<#if action=='create'>saveJson<#else>updateJson</#if>.html" method="post">
		<@jodd.form bean="batchInvokeResult" scope="request">
        <input name="id" type="hidden" />
        <table class="tableForm" width="100%">
			<tr>
				<th width="25%">批次号：</th>
				<td><input type="text" name="batchNo" placeholder="请输入批次号..." class="easyui-validatebox" data-options="validType:['length[1,20]'],required:true"/></td>
			</tr>					
			<tr>
				<th>用例编号：</th>
				<td><input type="text" name="caseNo" placeholder="请输入用例编号..." class="easyui-validatebox" data-options="validType:['length[1,64]'],required:true"/></td>
			</tr>					
			<tr>
				<th>参数编号：</th>
				<td><input type="text" name="parameterNo" placeholder="请输入参数编号..." class="easyui-validatebox" data-options="validType:['length[1,32]'],required:true"/></td>
			</tr>					
			<tr>
				<th>用例执行结果：</th>
				<td><input type="text" name="invokeStatus" placeholder="请输入用例执行结果..." class="easyui-numberbox" style="height: 30px;width: 260px;line-height: 1.3em;" data-options="validType:['number[0,999999999]'],required:true"/></td>
			</tr>					
			<tr>
				<th>用例请求入参：</th>
				<td><textarea rows="3" cols="40" placeholder="请输入用例请求入参..." name="parameterRequest" class="easyui-validatebox" data-options="validType:['length[1,999999999]'],required:true"></textarea></td>
			</tr>					
			<tr>
				<th>用例执行返回结果：</th>
				<td><textarea rows="3" cols="40" placeholder="请输入用例执行返回结果..." name="parameterResponse" class="easyui-validatebox" data-options="validType:['length[1,999999999]'],required:true"></textarea></td>
			</tr>					
        </table>
      </@jodd.form>
    </form>
</div>
