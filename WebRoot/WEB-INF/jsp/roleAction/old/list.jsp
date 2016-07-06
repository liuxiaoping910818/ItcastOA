<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>My JSP 'index.jsp' starting page</title>
	</head>

	<body>

	<%-- 
		<s:iterator value="#roleList">
			<s:property value="id"/>,
			<s:property value="name"/>,
			<s:property value="description"/>,
			<a href="roleAction_delete.action?id=<s:property value='id'/>" onclick="return confirm('确定要删除吗？')">删除</a>
			<br/>
		</s:iterator>
	--%>


		<s:iterator value="#roleList">
			${id},
			${name},
			${description},
			<%--
			<a href="${pageContext.request.contextPath}/roleAction_delete.action?id=${id}" onclick="return confirm('确定要删除吗？')">删除</a>
			 --%>
			<%--
			<s:a action="roleAction_delete">
				<s:param name="id" value="%{id}"></s:param>
				删除
			</s:a>
			 --%>
			<s:a action="roleAction_delete?id=%{id}" onclick="return confirm('确定要删除吗？')">删除</s:a>
			<s:a action="roleAction_editUI?id=%{id}">修改</s:a>
			<br/>
		</s:iterator>  

		<s:a action="roleAction_addUI">添加</s:a>

	</body>
</html>
