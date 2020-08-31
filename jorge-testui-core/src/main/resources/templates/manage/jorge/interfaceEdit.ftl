<#assign jodd=JspTaglibs["http://www.springside.org.cn/jodd_form"] />
<div>
    <form id="manage_interface_editform" action="/manage/jorge/interface/<#if action=='create'>saveJson<#else>updateJson</#if>.html" method="post">
		<@jodd.form bean="interface" scope="request">
        <input name="id" type="hidden" />
        <table class="editForm" width="100%">
            <tr>
                <th>所属项目：</th>
                <td><select name="projectNo" editable="false" panelHeight="auto" class="easyui-combobox" style="min-width: 235px;" data-options="required:true">
					<#list allProjectNos as k,v><option value="${k}">${v}</option></#list>
                </select></td>
            </tr>
			<tr>
				<th width="25%">接口编号：</th>
				<td><input type="text" name="interfaceNo" placeholder="请输入接口编号..." class="easyui-validatebox" data-options="validType:['length[1,64]'],required:true"/></td>
			</tr>
			<tr>
				<th>接口名称：</th>
				<td><input type="text" name="interfaceName" placeholder="请输入接口名称..." class="easyui-validatebox" data-options="validType:['length[1,32]'],required:true"/></td>
			</tr>
        </table>
      </@jodd.form>
    </form>
</div>
