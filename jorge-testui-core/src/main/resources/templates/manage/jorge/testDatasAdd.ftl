<#assign jodd=JspTaglibs["http://www.springside.org.cn/jodd_form"] />
<div>
    <form id="manage_testDatas_editform" action="/manage/jorge/logInfo/testDatasAdd.html" method="post">
        <input name="id" type="hidden" />
        <table class="tableForm" width="100%">
			<tr>
				<th width="25%">service：</th>
				<td><input style="width: 260px;" type="text" name="service" placeholder="请输入service..." class="easyui-validatebox" data-options="validType:['length[1,64]']"/></td>
			</tr>					
			<tr>
				<th>version：</th>
				<td><input style="width: 260px;" type="text" name="version" value="1.0" placeholder="请输入version..." class="easyui-validatebox" data-options="validType:['length[1,64]']"/></td>
			</tr>					
			<tr>
				<th>partnerId：</th>
				<td><input style="width: 260px;" type="text" name="partnerId" value="19092311080520110003" placeholder="请输入partnerId..." class="easyui-validatebox" data-options="validType:['length[1,64]']"/></td>
			</tr>					
			<tr>
				<th>signType：</th>
				<td><input style="width: 260px;" type="text" name="signType" value="MD5" placeholder="请输入signType..." class="easyui-validatebox" data-options="validType:['length[1,64]']"/></td>
			</tr>					
			<tr>
				<th>merchOrderNo：</th>
				<td><input style="width: 260px;" type="text" name="merchOrderNo" value="${merchOderNo}" placeholder="请输入merchOrderNo..." class="easyui-validatebox" data-options="validType:['length[1,64]']"/></td>
			</tr>
			<tr>
				<th>notifyUrl：</th>
				<td><input style="width: 260px;" type="text" name="notifyUrl" value="http://127.0.0.1:8999/openapi/testApiNotify" placeholder="请输入notifyUrl..." class="easyui-validatebox" data-options="validType:['length[1,64]']"/></td>
			</tr>
			<tr>
				<th>returnUrl：</th>
				<td><input style="width: 260px;" type="text" name="returnUrl" value="http://127.0.0.1:8999/openapi/testApiNotify" placeholder="请输入returnUrl..." class="easyui-validatebox" data-options="validType:['length[1,64]']"/></td>
			</tr>
			<tr>
				<th>gatewayUrl：</th>
				<td><input style="width: 260px;" type="text" name="gatewayUrl" value="http://localhost:8036/gateway.do" placeholder="请输入gatewayUrl..." class="easyui-validatebox" data-options="validType:['length[1,64]']"/></td>
			</tr>
			<tr>
				<th>securityCheckKey：</th>
				<td><input style="width: 260px;" type="text" name="securityCheckKey" value="06f7aab08aa2431e6dae6a156fc9e0b4" placeholder="请输入securityCheckKey..." class="easyui-validatebox" data-options="validType:['length[1,64]']"/></td>
			</tr>
			<tr>
				<th>accessKey：</th>
				<td><input style="width: 260px;" type="text" name="accessKey" value="19092311080520110003" placeholder="请输入accessKey..." class="easyui-validatebox" data-options="validType:['length[1,64]']"/></td>
			</tr>
			<tr>
				<th>resultCode：</th>
				<td><input style="width: 260px;" type="text" name="resultCode" value="SUCCESS" placeholder="请输入resultCode..." class="easyui-validatebox" data-options="validType:['length[1,64]']"/></td>
			</tr>
			<tr>
				<th>请求入参:</th>
                <td><textarea rows="5" cols="40" placeholder="请输入请求入参..." name="values"
                          class="easyui-validatebox" data-options=" required:true"></textarea></td>
			</tr>
        </table>
    </form>
</div>
