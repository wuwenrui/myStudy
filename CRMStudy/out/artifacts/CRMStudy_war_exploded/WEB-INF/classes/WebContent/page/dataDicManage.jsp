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
	
	var url;
	
	/* $(function(){
		$(".combo").click(function(){
			$(this).prev().combobox('showPanel');
		});
	}) */
	
	function searchdataDic(){
		$("#dg").datagrid('load',{
			"dataDicName":$("#s_dataDicName").combobox("getValue"),		
			"dataDicValue":$("#s_dataDicValue").val()
		});
	}
	//打开新增数据字典
	function openDataDicAddDialog(){
		$("#dlg").dialog('open').dialog("setTitle","添加数据字典");
		url='${pageContext.request.contextPath}/dataDic/save.do';
	}
	//打开编辑数据字典
	function openDataDicModifyDialog(){
		var selectedRows = $("#dg").datagrid("getSelections");
		if(selectedRows.length!=1){
			$.messager.alert("系统提示","请选择一条要编辑的数据");
			return;
		}
		var row = selectedRows[0];
		$("#dlg").dialog('open').dialog("setTitle","编辑数据字典");
		$("#fm").form('load',row);
		url='${pageContext.request.contextPath}/dataDic/save.do?id='+row.id;
	}
	//清空数据方法
	function resetValue(){
		$("#fm").form('clear');
	}
	
	//保存数据的方法
	function saveDataDic(){
		var dataDicName=$("#dataDicName").combobox("getText");
		var dataDicValue=$("#dataDicValue").val();
		if(dataDicName==""){
			$.messager.alert("系统提示","数据字典名不能为空！");
			return;
		}
		if(dataDicValue==""){
			$.messager.alert("系统提示","数据字典值不能为空！");
			return;
		}
		$.post(url,{dataDicName:dataDicName,dataDicValue:dataDicValue},function(result){
			if(result.success){
				$.messager.alert("系统提示","保存成功！");
				$("#dlg").dialog('close');
				$("#dg").datagrid('reload');
				resetValue();
			}else{
				$.messager.alert("系统提示","保存失败！");
			}
		},"json");
	}
	
	function closeDataDicDialog(){
		resetValue();
		$("#dlg").dialog('close');
	}
	//删除数据字典的方法
	function deleteDataDic(){
		var selectedRows = $("#dg").datagrid("getSelections");
		if(selectedRows.length==0){
			$.messager.alert("系统提示","请选择您要删除的数据");
			return;
		}
		var strIds = [];
		for(var i =0;i<selectedRows.length;i++){
			strIds.push(selectedRows[i].id);
		}
		var ids = strIds.join(",");
		$.messager.confirm("系统提示","您确定要删除这<font color=red>"+selectedRows.length+"</font>条数据吗？",function(r){
			if(r){
				$.post("${pageContext.request.contextPath}/dataDic/delete.do",{ids:ids},function(result){
					if(result.success){
						$.messager.alert("系统提示","删除成功！");
						$("#dg").datagrid('reload');
					}else{
						$.messager.alert("系统提示","删除失败，请联系系统管理员！");
					}
				},"json");
			}
		});
	}
</script>
</head>
<body style="margin:1px;">
<table id="dg" title="数据字典信息查询" class="easyui-datagrid"
	fitColumns="true" pagination="true" rownumbers="true"
	url="${pageContext.request.contextPath}/dataDic/list.do"
	fit="true" toolbar="#tb"
	>
	<thead>
   	<tr>
   		<th field="cb" checkbox="true" align="center"></th>
   		<th field="id" width="50" align="center">编号</th>
   		<th field="dataDicName" width="200" align="center">数据字典名</th>
   		<th field="dataDicValue" width="100" align="center">数据字典值</th>
   	</tr>
   </thead>
</table>
<div id="tb">
	<div>
		<a href="javascript:openDataDicAddDialog()" class="easyui-linkbutton" iconCls="icon-add" plain="true">添加</a>
		<a href="javascript:openDataDicModifyDialog()" class="easyui-linkbutton" iconCls="icon-edit" plain="true">修改</a>
		<a href="javascript:deleteDataDic()" class="easyui-linkbutton" iconCls="icon-remove" plain="true">删除</a>
	</div>
 	<div>
 		&nbsp;数据字典名称：&nbsp;<input class="easyui-combobox" id="s_dataDicName" data-options="panelHeight:'auto',valueField:'dataDicName',textField:'dataDicName',url:'${pageContext.request.contextPath}/dataDic/findDataDicName.do'"/>
 		&nbsp;数据字典值：&nbsp;<input type="text" id="s_dataDicValue" size="20" onkeydown="if(event.keyCode==13) searchdataDic()"/>
 		<a href="javascript:searchdataDic()" class="easyui-linkbutton" iconCls="icon-search" plain="true">搜索</a>
 	</div>
 </div>
 
 <div id="dlg" class="easyui-dialog" style="width:620px;height:150px;padding:10px 20px;"
 		closed="true" buttons="#dlg_buttons"
 >
 	<form id="fm" method="post">
 		<table cellspacing="0px">
 			<tr>
 				<td>数据字典名：</td>
 				<td><input class="easyui-combobox" name="dataDicName" id="dataDicName" data-options="panelHeight:'aito',valueField:'dataDicName',textField:'dataDicName',url:'${pageContext.request.contextPath}/dataDic/findDataDicName.do' "/><font color="red">*</font></td>
 				<td>&nbsp;&nbsp;&nbsp;&nbsp;</td>
 				<td>数据字典值：</td>
 				<td><input type="text" id="dataDicValue" name="dataDicValue" class="easyui-validatebox" required="true"/><font color="red">*</font></td>
 			</tr>
 		</table>
 	</form>
 </div>
 <div id="dlg_buttons">
 	<a class="easyui-linkbutton" href="javascript:saveDataDic()" iconCls="icon-ok" plain="true">保存</a>
 	<a class="easyui-linkbutton" href="javascript:closeDataDicDialog()" iconCls="icon-cancel" plain="true">取消</a>
 </div>
</body>
</html>