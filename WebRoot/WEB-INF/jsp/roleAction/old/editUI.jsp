<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'index.jsp' starting page</title>
	</head>

	<body>

		<s:form action="roleAction_edit">
			<s:hidden name="id"></s:hidden>
			<s:textfield name="name" label="名称"></s:textfield>
			<s:textarea name="description" label="说明"></s:textarea>
			<s:submit value="提交"></s:submit>
		</s:form>
		
		
	</body>
</html>
