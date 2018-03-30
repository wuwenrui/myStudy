<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script type="text/javascript" src="${pageContext.request.contextPath}/jquery-easyui-1.3.3/jquery.edatagrid.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/common.js"></script>
<script type="text/javascript">
$(function(){
	$.post('${pageContext.request.contextPath}/customer/findById.do',{id:'${param.cusId}'},function(result){
		$("#khno").val(result.khno);
		$("#name").val(result.name);
	},'json');
})

function formatState(val,row){
	if(val=='0'){
		return "未回款";
	}else{
		return "已回款";
	}
}

function formatAction(val,row){
	return "<a href='javascript:openOrderDetailsDialog("+row.id+")'>查看订单明细</a>";
}

function openOrderDetailsDialog(orderId){
	$("#dlg").dialog('open').dialog("setTitle","订单详情");
	$.post('${pageContext.request.contextPath}/order/findById.do',{id:orderId},function(result){
		$("#fm").form('load',result);
		if(result.state==0){
			$("#state").val("未回款");
		}else if(result.state==1){
			$("#state").val("已回款");
		}
	},"json");
	$.post('${pageContext.request.contextPath}/orderDetails/getTotalPrice.do',{"orderId":orderId},function(result){
		$("#totalMoney").val(result.totalMoney);
	},"json");
	$("#dg2").datagrid('reload',{
		"orderId":orderId
	});
}

function closeOrderDetailsDialog(){
	$("#dlg").dialog('close');
}

</script>
</head>
<body style="margin:15px;">

<div id="p" class="easyui-panel" title="客户基本信息" style="width:700px;height:100px; padding:10px;">
	<table cellspacing="8px">
 		<tr>
 			<td>客户编号：</td>
 			<td><input type="text" id="khno" name="khno" readonly="readonly"/></td>
 			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
 			<td>客户名称：</td>
 			<td><input type="text" id="name" name="name" readonly="readonly"/></td>
 		</tr>
 	 </table>
</div>
 
 <br/>
<table id="dg" title="客户历史订单信息查询" class="easyui-datagrid" style="width:700px;height:400px;"
	 fitColumns="true" pagination="true" rownumbers="true"
	url="${pageContext.request.contextPath}/order/list.do?cusId=${param.cusId}"
	>
	<thead>
	   	<tr>
	   		<th field="id" width="50" align="center">编号</th>
	   		<th field="orderNo" width="100" align="center">订单编号</th>
	   		<th field="orderDate" width="100" align="center">订单时间</th>
	   		<th field="address" width="200" align="center">送货地址</th>
	   		<th field="state" width="50" align="center" formatter="formatState">回款状态</th>
	   		<th field="a" width="80" align="center" formatter="formatAction">操作</th>
	   	</tr>
   </thead>
</table>

<div id="dlg" class="easyui-dialog" style="width:700px;height:450px;padding: 10px 20px"
 	closed="true" buttons="#dlg-buttons"
 >
 	 <form id="fm" method="post">
 	 	<table cellspacing="13px">
 	 		<tr>
 	 			<td>订单号：</td>
 	 			<td><input type="text" id="orderNo" name="orderNo" readonly="readonly"/></td>
 	 			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
 	 			<td>订购日期：</td>
 	 			<td><input type="text" id="orderDate" name="orderDate" readonly="readonly"/></td>
 	 		</tr>
 	 		<tr>
 	 			<td>送货地址：</td>
 	 			<td><input type="text" id="address" name="address" readonly="readonly"/></td>
 	 			<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
 	 			<td>总金额：</td>
 	 			<td><input type="text" id="totalMoney" name="totalMoney" readonly="readonly"/></td>
 	 		</tr>
 	 		<tr>
 	 			<td>状态：</td>
 	 			<td><input type="text" id="state" name="state" readonly="readonly"/></td>
 	 			<td colspan="3">&nbsp;&nbsp;&nbsp;&nbsp;</td>
 	 		</tr>
 	 	</table>
 	 </form>
 	 
<br/>
<table id="dg2" title="订购详情" class="easyui-datagrid" style="width:600px;height:220px;"
	 fitColumns="true" pagination="true" rownumbers="true" singleSelect="true"
	url="${pageContext.request.contextPath}/orderDetails/list.do"
	>
	<thead>
	   	<tr>
	   		<th field="id" width="50" align="center">编号</th>
	   		<th field="goodsName" width="100" align="center">商品名称</th>
	   		<th field="goodsNum" width="50" align="center">商品数量</th>
	   		<th field="unit" width="50" align="center">单位</th>
	   		<th field="price" width="50" align="center">单价（元）</th>
	   		<th field="sum" width="50" align="center">总金额（元）</th>
	   	</tr>
   </thead>
</table>
 	 
 </div>
 <div id="dlg-buttons">
 	<a class="easyui-linkbutton" href="javascript:closeOrderDetailsDialog()" iconCls="icon-cancel" plain="true">关闭</a>
 </div>

</body>
</html>