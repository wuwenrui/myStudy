<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	
	function searchCustomerLoss(){
		$("#dg").datagrid('load',{
			"cusName":$("#s_cusName").val(),
			"cusManager":$("#s_cusManager").val(),
			"state":$("#s_state").combobox("getValue")
		});
	}
	
	function formatState(val,row){
		if(val==0){
			return "暂缓流失";
		}else if(val==1){
			return "确认流失";
		}
	}
	
	function formatAction(val,row){
		if(row.state==0){
			return "<a href='javascript:openCustomerReprieve("+row.id+")'>暂缓流失</a>";
		}else if(row.state==1){
			return "客户确定流失";
		}
	}
	
	function openCustomerReprieve(id){
		window.parent.openTab('客户流失暂缓措施管理','customerRepreieveManage.jsp?lossId='+id,'icon-khlsgl');
	}
	
</script>
</head>
<body style="margin:1px;">
<table id="dg" title="客户流失管理" class="easyui-datagrid"
	pagination="true" rownumbers="true" fitColumns="true"
	url="${pageContext.request.contextPath}/customerLoss/list.do" fit="true" toolbar="#tb">
	<thead>
	   	<tr>
	   		<th field="cb" checkbox="true" align="center"></th>
	   		<th field="id" width="50" align="center" hidden="true">编号</th>
	   		<th field="cusName" width="150" align="center">客户名称</th>
	   		<th field="cusManager" width="200" align="center">客户经理</th>
	   		<th field="lastOrderTime" width="100" align="center">上次下单日期</th>
	   		<th field="confirmLossTime" width="100" align="center">确认流失时间</th>
	   		<th field="state" width="100" align="center" formatter="formatState">客户状态</th>
	   		<th field="lossreason" width="100" align="center">流失原因</th>
	   		<th field="a" width="100" align="center" formatter="formatAction">操作</th>
	   	</tr>
   </thead>
   
</table>
<div id="tb">
	<!-- &nbsp;<a href="javascript:open" class="easyui-linkbutton" iconCls="icon-zhls" plain="true">暂缓流失</a> -->
 	<div>
 		&nbsp;客户名称：&nbsp;<input type="text" id="s_cusName" size="20" onkeydown="if(event.keyCode==13) searchCustomerLoss()"/>
 		&nbsp;经理名称：&nbsp;<input type="text" id="s_cusManager" size="20" onkeydown="if(event.keyCode==13) searchCustomerLoss()"/>
 		&nbsp;客户状态：&nbsp;<select class="easyui-combobox" data-options="panelHeight:'auto',editable:false" id="s_state" size="20">
 			<option value="">请选择...</option>
 			<option value="0">暂缓流失</option>
 			<option value="1">确认流失</option>
 		</select>
 		<a href="javascript:searchCustomerLoss()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
 	</div>
 	
 </div>
</body>
</html>