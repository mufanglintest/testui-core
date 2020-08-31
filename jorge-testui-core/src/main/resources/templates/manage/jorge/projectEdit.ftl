<#assign jodd=JspTaglibs["http://www.springside.org.cn/jodd_form"] />
<div>
    <form id="manage_project_editform" action="/manage/jorge/project/<#if action=='create'>saveJson<#else>updateJson</#if>.html" method="post">
		<@jodd.form bean="project" scope="request">
        <input name="id" type="hidden" />
        <table class="editForm" width="100%">
			<tr>
				<th width="25%">项目编号：</th>
				<td><input type="text" name="projectNo" placeholder="请输入项目编号..." class="easyui-validatebox" data-options="validType:['length[1,64]'],required:true"/></td>
			</tr>					
			<tr>
				<th>项目名称：</th>
				<td><input type="text" name="projectName" placeholder="请输入项目名称..." class="easyui-validatebox" data-options="validType:['length[1,32]'],required:true"/></td>
			</tr>					
        </table>
      </@jodd.form>
    </form>
</div>
