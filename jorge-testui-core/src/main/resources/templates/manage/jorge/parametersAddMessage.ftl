<#assign jodd=JspTaglibs["http://www.springside.org.cn/jodd_form"] />
<div>
    <form id="manage_parameters_addmessageform" action="/manage/jorge/parameters/<#if action=='add'>addRequestParameters<#else>deleteRequestParameters</#if>.html" method="post">
		<#--<@jodd.form bean="parameters" scope="request">-->
        <input name="id" type="hidden" />
		<input name="createUser"  type="hidden" value="${createUser}"/>
		<input name="caseNo"  type="hidden" value="${caseNo}"/>

        <table class="tableForm" width="100%">
			<tr id = "parametersEdit">
				<th >父节点：</th>
                <td><input  type="text" value="/" placeholder="请输入参数父节点..." name="parentJsonName" class="easyui-validatebox"  data-options="required:true"/></td>
				<th>子结点名称：</th>
                <td><input id="sonJsonName" type="text" placeholder="请输入参数子节点..." name="sonJsonName" class="easyui-validatebox" data-options="required:true"/></td>
			<#if action == 'add'>
				<th>子结点值：</th>
                <td><input id="sonJsonValue" type="text" placeholder="请输入参数子节点值..." name="sonJsonValue" class="easyui-validatebox"  data-options=""/></td>
			</#if>
				<td><a href="javascript:void(0)" class="easyui-linkbutton" onclick="addDeviceInfo()" style="margin-top:2px;height:25px;width:25px;color:#fff;border:none;background:#63B8FF">+</a></td>
            </tr>
        </table>
      <#--</@jodd.form>-->
    </form>
</div>

<script type="text/javascript">
	$(function () {
	    //解决在添加时这三个参数从选中行带过来，不可修改编辑
        var caseNo='${caseNo}'; //这种方法取出来是user是String类型
		if (caseNo != "") {
            $("#caseNo").val(caseNo);
        }
    })

    function addDeviceInfo(){
		var addhtml = "<tr>"+
				"<th >父节点：</th>"+
				"<td><input  type=\"text\" value=\"/\" placeholder=\"请输入参数父节点...\" name=\"parentJsonName\" class=\"easyui-validatebox\"  data-options=\"required:true\"/></td>\n"+
				"<th>子结点名称：</th>\n"+
                "<td><input id=\"sonJsonName\" type=\"text\" placeholder=\"请输入参数子节点...\" name=\"sonJsonName\" class=\"easyui-validatebox\" data-options=\"required:true\"/></td>\n" +
     			"<#if action == 'add'>\n"+
                "<th>子结点值：</th>\n" +
                "<td><input id=\"sonJsonValue\" type=\"text\" placeholder=\"请输入参数子节点值...\" name=\"sonJsonValue\" class=\"easyui-validatebox\"  data-options=\"required:true\"/></td>\n" +
                "</#if>\n" +
				"<td><a href=\"javascript:void(0)\" class=\"easyui-linkbutton l-btn l-btn-small\" onclick=\"delDeviceInfo(this)\" style=\"margin-top:2px;height:25px;width:25px;color:#fff;border:none;background:#63B8FF\" group=\"\" id=\"\"><span class=\"l-btn-left\" style=\"margin-top: -1px;\"><span class=\"l-btn-text\">-</span></span></a></td>"+
                "</tr>"
        ;
        $("#parametersEdit").after(addhtml);
    }

    function delDeviceInfo(e){
        $(e).parent().parent().remove();
    }
</script>
