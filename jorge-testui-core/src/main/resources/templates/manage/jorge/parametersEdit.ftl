<#assign jodd=JspTaglibs["http://www.springside.org.cn/jodd_form"] />
<div>
    <form id="manage_parameters_editform" action="/manage/jorge/parameters/<#if action=='create'>saveJson<#else>updateJson</#if>.html" method="post">
		<@jodd.form bean="parameters" scope="request">
        <input name="id" type="hidden" />
		<input name="createUser"  type="hidden" value="${createUser}"/>
        <table class="tableForm" width="100%">
			<tr>
				<th width="25%">系统编号：</th>
                <#--<td><select name="projectNo" editable="false" panelHeight="auto" class="easyui-combobox" style="min-width: 235px;" data-options="required:true">-->
					<#--<#list allProjectNos as k,v><option value="${k}">${v}</option></#list>-->
                <#--</select></td>-->
                <td><input id="projectNo" type="text" readonly="readonly" name="projectNo" class="easyui-validatebox"  data-options="validType:['length[1,64]'],required:true"/></td>
            </tr>
			<tr>
				<th>接口编号：</th>
                <#--<td><select name="interfaceNo" editable="false" panelHeight="auto" class="easyui-combobox" style="min-width: 235px;" data-options="required:true">-->
					<#--<#list allInterfaceNos as k,v><option value="${k}">${v}</option></#list>-->
                <#--</select></td>-->
                <td><input id="interfaceNo" type="text" readonly="readonly" name="interfaceNo" class="easyui-validatebox" data-options="validType:['length[1,64]'],required:true"/></td>
			</tr>
			<tr>
				<th>测试用例编号：</th>
                <#--<td><select name="caseNo" editable="false" panelHeight="auto" class="easyui-combobox" style="min-width: 235px;" data-options="required:true">-->
					<#--<#list allTestCaseNos as k,v><option value="${k}">${v}</option></#list>-->
                <#--</select></td>-->
                <td><input id="caseNo" type="text"  name="caseNo" class="easyui-validatebox"  data-options="validType:['length[1,64]'],required:true"/></td>
			</tr>
			<tr>
				<th>请求入参编号：</th>
				<td><input type="text" name="parametersNo" placeholder="请输入请求入参编号..." class="easyui-validatebox" data-options="validType:['length[1,20]'],required:true"/></td>
			</tr>
            <tr>
                <th>请求用例说明：</th>
                <td><input type="text" name="description" placeholder="请输入用例说明..." class="easyui-validatebox" data-options="validType:['length[1,64]'],required:true"/></td>
            </tr>
			<tr>
				<th>请求入参：</th>
				<td><textarea rows="20" cols="70" placeholder="请输入请求入参..." name="parameters"
							  class="easyui-validatebox" data-options=" required:true" ></textarea></td>
			</tr>
        </table>
      </@jodd.form>
    </form>
</div>

<script type="text/javascript">
	$(function () {
	    //解决在添加时这三个参数从选中行带过来，不可修改编辑
		console.info('${caseNo}')
        var caseNo='${caseNo}'; //这种方法取出来是user是String类型
		var projectNo ='${projectNo}';
		var interfaceNo='${interfaceNo}';
		if (caseNo != "") {
            $("#caseNo").val(caseNo);
        }
        if (projectNo != ""){
            $("#projectNo").val(projectNo);
		}
		if (interfaceNo !=""){
		    $("#interfaceNo").val(interfaceNo);
		}
    })
</script>
