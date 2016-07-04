<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jquery-easyui-1.3.3/themes/icon.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/locale/easyui-lang-zh_CN.js"></script>
<!-- 引入可编辑表格edatagrid -->
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.edatagrid.js"></script>
<!-- 引入自定义的Js方法 -->
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript">
	$ (function ()
    {
	    // param用于获取请求的参数值，param.xxx 相当于XXXX.getParameter("xxx") XXXX可以是request session application等
	    $.post ("${pageContext.request.contextPath}/saleChance/findById.do",
	    {
		    id : '${param.saleChanceId}'
	    }, function (result)
	    {
		    // 		 var r=eval("("+result+")");
		    // 		 var result=r[0];
		    var result = eval ("(" + result + ")");
		    $ ("#customerName").val (result.customerName);
		    $ ("#chanceSource").val (result.chanceSource);
		    $ ("#linkMan").val (result.linkMan);
		    $ ("#linkPhone").val (result.linkPhone);
		    $ ("#cgjl").val (result.cgjl);
		    $ ("#overView").val (result.overView);
		    $ ("#description").val (result.description);
		    $ ("#createMan").val (result.createMan);
		    $ ("#createTime").val (result.createTime);
		    $ ("#assignMan").val (result.assignMan);
		    $ ("#assignTime").val (result.assignTime);
	    });
	    
	    //是 可编辑表格Editable DataGrid  需要 额外引入Editable DataGrid的js包
	    $ ("#dg").edatagrid (
	    {
	        // 	    	通过URL向服务器检索数据。
	        url : '${pageContext.request.contextPath}/cusDevPlan/list.do?saleChanceId=${param.saleChanceId}',
	        // 	        通过URL保存数据到服务器并返回添加的行
	        saveUrl : '${pageContext.request.contextPath}/cusDevPlan/save.do?saleChance.id=${param.saleChanceId}',
	        // 	        通过URL更新数据到服务器并返回更新的行。
	        updateUrl : '${pageContext.request.contextPath}/cusDevPlan/save.do?saleChance.id=${param.saleChanceId}',
	        // 		delete操作时会自动把主键值（idField）传到后台 参数名与主键名相同
	        // 	        通过URL将'id'参数发送到服务器以销毁行。
	        destroyUrl : '${pageContext.request.contextPath}/cusDevPlan/delete.do'
	    });
    });
    
    function savePlan ()
    {
	    $ ('#dg').edatagrid ('saveRow');
	    $.messager.confirm ("tip", "保存成功正在刷新...", function (r)
	    {
		    if (r)
		    {
			    $ ('#dg').edatagrid ('reload')
		    }
	    });
	    
    }

    function updateSaleChanceDevResult (val)
    {
	    $.post ("${pageContext.request.contextPath}/cusDevPlan/updateSaleChanceDevResult.do",
	    {
	        id : '${param.saleChanceId}',
	        devResult : val
	    }, function (result)
	    {
		    var result = eval ("(" + result + ")");
		    if (result.success)
		    {
			    $.messager.alert ("系统提示", "操作成功");
		    }
		    else
		    {
			    $.messager.alert ("系统提示", "操作失败");
		    }
	    });
    }
</script>
<title>Insert title here</title>
</head>
<body style="margin: 15px">

	<div id="p" class="easyui-panel" title="销售机会信息" style="width: 700px; height: 400px; padding: 10px">
		<table cellspacing="8px">
			<tr>
				<td>客户名称：</td>
				<td><input type="text" id="customerName" name="customerName" readonly="readonly" /></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>机会来源</td>
				<td><input type="text" id="chanceSource" name="chanceSource" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>联系人：</td>
				<td><input type="text" id="linkMan" name="linkMan" readonly="readonly" /></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>联系电话：</td>
				<td><input type="text" id="linkPhone" name="linkPhone" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>成功几率(%)：</td>
				<td><input type="text" id="cgjl" name="cgjl" readonly="readonly" /></td>
				<td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;</td>
			</tr>
			<tr>
				<td>概要：</td>
				<td colspan="4"><input type="text" id="overView" name="overView" style="width: 420px" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>机会描述：</td>
				<td colspan="4"><textarea rows="5" cols="50" id="description" name="description" readonly="readonly"></textarea></td>
			</tr>
			<tr>
				<td>创建人：</td>
				<td><input type="text" readonly="readonly" id="createMan" name="createMan" /></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>创建时间：</td>
				<td><input type="text" id="createTime" name="createTime" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>指派给：</td>
				<td><input type="text" readonly="readonly" id="assignMan" name="assignMan" /></td>
				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td>指派时间：</td>
				<td><input type="text" id="assignTime" name="assignTime" readonly="readonly" /></td>
			</tr>
		</table>
	</div>

	<br />
	<!--  可编辑表格 idField是指主键列名-->
	<table id="dg" title="开发计划项" style="width: 700px; height: 250px" toolbar="#toolbar" idField="id" rownumbers="true"
		fitColumns="true" singleSelect="true">
		<thead>
			<tr>
				<th field="id" width="50">编号</th>
				<th field="planDate" width="50" editor="{type:'datebox',options:{required:true}}">日期</th>
				<th field="planItem" width="100" editor="{type:'validatebox',options:{required:true}}">计划内容</th>
				<th field="exeAffect" width="100" editor="{type:'validatebox',options:{required:true}}">执行效果</th>
			</tr>
		</thead>
	</table>


	<div id="toolbar">
		<c:if test="${param.show !='true'}">
			<!--  其中onclick事件中的 JavaScript 是固定写法 -->
			<!-- addRow 添加一个新的空行。 destroyRow 销毁当前选择的行。 saveRow保存编辑行并发送到服务器。 cancelRow取消编辑行。-->
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true"
				onclick="javascript:$('#dg').edatagrid('addRow')">添加计划</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true"
				onclick="javascript:$('#dg').edatagrid('destroyRow')">删除计划</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-save" plain="true" onclick="javascript:savePlan()">保存计划</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-undo" plain="true"
				onclick="javascript:$('#dg').edatagrid('cancelRow')">撤销行</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-kfcg" plain="true"
				onclick="javascript:updateSaleChanceDevResult(2)">开发成功</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-zzkf" plain="true"
				onclick="javascript:updateSaleChanceDevResult(3)">终止开发</a>
		</c:if>
	</div>


</body>
</html>