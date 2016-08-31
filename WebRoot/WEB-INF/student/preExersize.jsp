<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <style type="text/css">
    div{width:300px;height:200px;background:pink;border:1px solid #000;}
    </style>
    <base href="<%=basePath%>">
    <script src="http://ajax.aspnetcdn.com/ajax/jquery/jquery-1.6.4.min.js"></script>
    <script type="text/javascript">
    $(function(){
    	$('button').click(function(e) {
    		//alert($('div').css('width'));
    		$('div').css({width:'100px',height:'5px'})
    	});
    })
    </script>
    <title>My JSP 'preExam.jsp' starting page</title>
    
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
    This is my JSP page. <br>
    <button>anniu</button>
    <div>hezi</div>
  </body>
</html>
