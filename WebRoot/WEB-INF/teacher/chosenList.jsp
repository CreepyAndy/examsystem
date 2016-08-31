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
    
    <title>My JSP 'chosenList.jsp' starting page</title>
    
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
    <h1>这是试卷<%=session.getAttribute("paperId")%> </h1>

<hr/>
<table>
    <td>ID</td>
    <td>题干</td>
    <td>选项A</td>
    <td>选项B</td>
    <td>选项C</td>
    <td>知识点</td>
    <td>删除操作</td>
    <td>更新操作</td>
<s:iterator value="qcs" var="qc">
    <tr>
      <td><s:property value="id"/></td>
	  <td><s:property value="stem"/></td>
	  <td><s:property value="choiceA"/></td>
	  <td><s:property value="choiceB"/></td>
	  <td><s:property value="choiceC"/></td>
	  <td><s:property value="knowledgePoint"/></td>
	  <td><a href="<%=basePath%>paperManage/synPaper_delQuestionInPaper?qid=<s:property value="id"/>&paperId=<%=session.getAttribute("paperId")%>">删除</a></td>
	</tr>
</s:iterator>
</table>
<p align="center"><a href="<%=basePath%>paperManage/synPaper.action">返回选题试卷</a></p>
<s:debug></s:debug>
  </body>
</html>
