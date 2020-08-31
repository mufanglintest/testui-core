<#assign jodd=JspTaglibs["http://www.springside.org.cn/jodd_form"] />
<div>
    <form id="manage_batchInvoke_editform" action="/manage/jorge/batchInvoke/<#if action=='create'>saveJson<#else>updateJson</#if>.html" method="post">
		<@jodd.form bean="batchInvoke" scope="request">
        <input name="id" type="hidden" />
        <table class="tableForm" width="100%">
			<tr>
				<th width="25%">批次号：</th>
				<td><input type="text" name="batchNo" placeholder="请输入批次号..." class="easyui-numberbox" style="height: 30px;width: 260px;line-height: 1.3em;" data-options="validType:['number[0,999999999]'],required:true"/></td>
			</tr>					
			<tr>
				<th>总执行用例数：</th>
				<td><input type="text" name="totalCase" placeholder="请输入总执行用例数..." class="easyui-numberbox" style="height: 30px;width: 260px;line-height: 1.3em;" data-options="validType:['number[0,999999999]'],required:true"/></td>
			</tr>					
			<tr>
				<th>成功用例数：</th>
				<td><input type="text" name="successCase" placeholder="请输入成功用例数..." class="easyui-numberbox" style="height: 30px;width: 260px;line-height: 1.3em;" data-options="validType:['number[0,999999999]'],required:true"/></td>
			</tr>					
			<tr>
				<th>失败用例数：</th>
				<td><input type="text" name="failCase" placeholder="请输入失败用例数..." class="easyui-numberbox" style="height: 30px;width: 260px;line-height: 1.3em;" data-options="validType:['number[0,999999999]'],required:true"/></td>
			</tr>					
			<tr>
				<th>总执行时间：</th>
				<td><input type="text" name="totalTime" placeholder="请输入总执行时间..." class="easyui-numberbox" style="height: 30px;width: 260px;line-height: 1.3em;" data-options="validType:['number[0,999999999]'],required:true"/></td>
			</tr>					
        </table>
      </@jodd.form>
    </form>
</div>
