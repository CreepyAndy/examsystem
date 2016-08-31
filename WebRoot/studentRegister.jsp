<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'studentRegister.jsp' starting page</title>

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
<div align="center">
  <h1>学生注册</h1>
</div>
<div>
  <div align="center">
    <form action="registration/student!add" method="post" >
      <label>用户名
        <input type="text" name="stuname">
        <br>
      </label>
      <label>密码
      <input type="password" name="password">
      </label><br>
      <label>确认密码
        <input type="password" name="password2">
      <br>
        </label>
        <label>
        <input type="submit" name="submit" value="提交">
        </label>
    </form>
  </div>
</div>
<br>

  <div align="center">
<a href="index.action">返回主页</a>
</div>
</body>
</html>
