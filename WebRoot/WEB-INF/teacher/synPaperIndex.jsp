<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'synPaperIndex.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
      题库
<a href="<%=basePath%>admin/loadQuestion.action">添加题目到题库</a>

<hr/>
<table>
    <td>试卷ID</td>
<s:iterator value="papers" var="p">
    <tr>
      <td><s:property value="id"/></td> 
	  <td><a href="<%=basePath%>paperManage/synPaper_chose?paperId=<s:property value="id"/>">修改试卷</a></td>
	  <td><a href="<%=basePath%>paperManage/synPaper_del?paperId=<s:property value="id"/>">删除试卷</a></td>
	</tr>
</s:iterator>
</table>
<p align="center"><a href="<%=basePath%>paperManage/synPaper_add.action">添加试卷</a></p>
<p align="center"><a href="<%=basePath%>paperManage/index.action">返回</a></p>
<s:debug></s:debug>
  </body>
</html>
