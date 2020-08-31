<#assign jodd=JspTaglibs["http://www.springside.org.cn/jodd_form"] />
<div>
    <form id="manage_caseRequestParameter_editform" action="/manage/jorge/caseRequestParameter/<#if action=='create'>saveJson<#else>updateJson</#if>.html" method="post">
		<@jodd.form bean="caseRequestParameter" scope="request">
        <input name="id" type="hidden" />
        <table class="tableForm" width="100%">
			<tr>
				<th width="25%">用例编码：</th>
				<td><input type="text" name="caseNo" placeholder="请输入用例编码..." class="easyui-validatebox" data-options="validType:['length[1,64]'],required:true"/></td>
			</tr>					
			<tr>
				<th>用例请求参数模板：</th>
				<td><textarea rows="3" cols="40" placeholder="请输入用例请求参数模板..." name="requestDemo"
							  class="easyui-validatebox" data-options="validType:['length[1,
							  5120]']"></textarea></td>
			</tr>					
        </table>
      </@jodd.form>
    </form>
</div>
