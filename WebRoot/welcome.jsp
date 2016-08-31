<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Welcome</title>
    <style type="text/css">
.formstyle {  font-family: "宋体"; font-size: 15pt; color: #FF0000; background-color: #FFFFCC}
</style>
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
    <div align="center" class="STYLE1">
  <h1>在线题库及练习考试登录</h1>
</div>
<div align="center">
<form action="util.action" method="post" >

  用户名：
    <input type="text" name="username">
  密码：
  <input type="password" name="password">
  <br>
  <p>
    <input type="radio" name="loginType" value="student" >
    学生登录
  <input type="radio" name="loginType" value="teacher">
    教师登录
  <input type="radio" name="loginType" value="admin">
    管理员登录  </p>
  <p>
    <label>
    <input type="submit" name="submit" value="登录" class="formstyle">
    </label>
</form>
<a href="registration/index">用户注册</a>
  </div>
  </body>
</html>
