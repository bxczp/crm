<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
	var url;
    
    function searchUser ()
    {
	    $ ("#dg").datagrid ('load',
	    {
		    'userName' : $ ("#s_userName").val ()
	    });
    }

    function openUserModifyDialog ()
    {
	    var selectedRows = $ ("#dg").datagrid ("getSelections");
	    if (selectedRows.length != 1)
	    {
		    $.messager.alert ("系统提示", "请选择一条数据");
		    return;
	    }
	    var row = selectedRows[0];
	    $ ("#dlg").dialog ("open").dialog ("setTitle", "修改用户信息");
	    url = "${pageContext.request.contextPath}/user/save.do?id=" + row.id;
	    $ ("#fm").form ("load", row);
    }

    function openUserAddDialog ()
    {
	    $ ("#dlg").dialog ("open").dialog ("setTitle", "添加用户信息");
	    url = "${pageContext.request.contextPath}/user/save.do";
    }

    function resetValues ()
    {
	    $ ("#userName").val ("");
	    $ ("#password").val ("");
	    $ ("#trueName").val ("");
	    $ ("#email").val ("");
	    $ ("#phone").val ("");
	    //下拉框的重置
	    $ ("#roleName").combobox ("setValue", "");
    }

    function closeUserDialog ()
    {
	    resetValues ();
	    $ ("#dlg").dialog ("close");
    }

    function deleteUser ()
    {
	    var selectedRows = $ ("#dg").datagrid ("getSelections");
	    if (selectedRows.length == 0)
	    {
		    $.messager.alert ("系统提示", "请选择数据");
		    return;
	    }
	    //定义数组
	    var idStr = [];
	    for (var i = 0; i < selectedRows.length; i++)
	    {
		    idStr.push (selectedRows[i].id);
	    }
	    var ids = idStr.join (",");
	    
	    // 也可以这样写，只是提示框风格不同		
	    // 		if (confirm("确认删除？")) {
	    // 			$.post("${pageContext.request.contextPath}/user/delete.do", {ids : ids}, function(result) {
	    // 				var result = eval("(" + result + ")");
	    // 				if (result.success) {
	    // 					$.messager.alert("系统提示", "删除成功");
	    // 					$("#dg").datagrid("reload");
	    // 				} else {
	    // 					$.mssager.alert("系统提示", "操作失败");
	    // 				}
	    // 			});
	    // 		}
	    
	    // 回调函数是写在confirm中的
	    if ($.messager.confirm ("系统提示", "确认删除？", function (r)
	    {
		    if (r)
		    {
			    $.post ("${pageContext.request.contextPath}/user/delete.do",
			    {
				    ids : ids
			    }, function (result)
			    {
				    var r = eval ("(" + result + ")");
				    if (r.success)
				    {
					    $.messager.alert ("系统提示", "删除成功");
					    $ ("#dg").datagrid ("reload");
				    }
				    else
				    {
					    $.messager.alert ("系统提示", "操作失败");
				    }
			    })
		    }
	    }))
		    ;
	    
    }

    function saveUser ()
    {
	    $ ("#fm").form ("submit",
	    {
	        url : url,
	        onSubmit : function ()
	        {
		        if ($ ("#roleName").combobox ("getValue") == '')
		        {
			        $.messager.alert ("系统提示", "请选择职位身份");
			        return false;
		        }
		        //返回配置在form中的验证结果
		        return $ (this).form ("validate");
	        },
	        success : function (result)
	        {
		        var result = eval ("(" + result + ")");
		        if (result.success)
		        {
			        $.messager.alert ("系统提示", "操作成功");
			        resetValues ();
			        $ ("#dlg").dialog ("close");
			        $ ("#dg").datagrid ("reload");
		        }
		        else
		        {
			        $.messager.alert ("系统提示", "操作失败");
			        return;
		        }
	        }
	    });
    }
</script>

</head>
<body style="margin: 1px;">
	<table id="dg" title="用户管理" class='easyui-datagrid' fitColumns="true" pagination="true" rownumbers='true' fit="true" toolbar="#tb"
		url="${pageContext.request.contextPath }/user/list.do">
		<thead>
			<tr>
				<th field='cb' checkbox='true' align="center"></th>
				<th field="id" width="50" align="center">编号</th>
				<th field="userName" width="50" align="center">用户名</th>
				<th field="password" width="50" align="center">密码</th>
				<th field="trueName" width="50" align="center">真实姓名</th>
				<th field="email" width="50" align="center">电子邮箱</th>
				<th field="phone" width="50" align="center">联系电话</th>
				<th field="roleName" width="50" align="center">职位身份</th>
			</tr>
		</thead>
	</table>

	<div id="dlg" class="easyui-dialog" style="width: 620px; height: 250px; padding: 10px;20px;" closed="true" buttons="#dlg-buttons">
		<form action="" method="post" id="fm">
			<table cellspacing="8px;">
				<tr>
					<td>用户名：</td>
					<td><input type="text" id="userName" name="userName" class="easyui-validatebox" required="true" /> &nbsp;<font
							color="red">*</font>&nbsp;</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>密码：</td>
					<td><input type="text" id="password" name="password" class="easyui-validatebox" required="true" /> &nbsp;<font
							color="red">*</font>&nbsp;</td>
				</tr>
				<tr>
					<td>真实姓名：</td>
					<td><input type="text" id="trueName" name="trueName" class="easyui-validatebox" required="true" /> &nbsp;<font
							color="red">*</font>&nbsp;</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>电子邮箱：</td>
					<td><input type="text" id="email" name="email" class="easyui-validatebox" validType="email" required="true" /> &nbsp;<font
							color="red">*</font>&nbsp;</td>
				</tr>
				<tr>
					<td>联系电话：</td>
					<td><input type="text" id="phone" name="phone" class="easyui-validatebox" required="true" /> &nbsp;<font color="red">*</font>&nbsp;</td>
					<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td>职务身份：</td>
					<td><select class="easyui-combobox" id="roleName" name="roleName" style="width: 154px;" editable="false"
							panelHeight="auto">
							<option value="">请选择...</option>
							<option value="系统管理员">系统管理员</option>
							<option value="高管">高管</option>
							<option value="客户经理">客户经理</option>
							<option value="销售主管">销售主管</option>
						</select> &nbsp;<font color="red">*</font>&nbsp;</td>
				</tr>
			</table>
		</form>
	</div>

	<div id="dlg-buttons">
		<a href="javascript:saveUser()" class="easyui-linkbutton" iconCls="icon-ok">保存</a>
		<a href="javascript:closeUserDialog()" class="easyui-linkbutton" iconCls="icon-cancel">关闭</a>
	</div>

	<div id="tb">
		<div>
			<a href="javascript:openUserAddDialog()" class="easyui-linkbutton" iconCls='icon-add' plain="true">添加</a>
			&nbsp;&nbsp;
			<a href="javascript:openUserModifyDialog()" class="easyui-linkbutton" iconCls='icon-edit' plain="true">修改</a>
			&nbsp;&nbsp;
			<a href="javascript:deleteUser()" class="easyui-linkbutton" iconCls='icon-remove' plain="true">删除</a>
		</div>
		<div>
			&nbsp;用户名：&nbsp;
			<input type="text" id="s_userName" name="userName" size="20" onkeydown="if(event.keyCode==13) searchUser()" />
			<a href="javascript:searchUser()" class="easyui-linkbutton" iconCls='icon-search' plain="true">查询</a>
		</div>
	</div>
</body>
</html>