<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'loadQuestion.jsp' starting page</title>
    
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
	<form action="questionManager/admin!addquestion" method="post">
		<table width="629" height="177" border="1">
			<tr>
				<th width="191" scope="col">题干</th>
				<th width="422" scope="col"><input type="text" name="qc.stem" />
				</th>
			</tr>
			<tr>
				<td><div align="center">选项A</div>
				</td>
				<td><div align="center">
						<input type="text" name="qc.choiceA" />
					</div>
				</td>
			</tr>
			<tr>
				<td><div align="center">选项B</div>
				</td>
				<td><div align="center">
						<input type="text" name="qc.choiceB" />
					</div>
				</td>
			</tr>
			<tr>
				<td><div align="center">选项C</div>
				</td>
				<td><div align="center">
						<input type="text" name="qc.choiceC" />
					</div>
				</td>
			</tr>
			<tr>
				<td><div align="center">答案</div>
				</td>
				<td><div align="center">
						<input type="text" name="qc.answer" />
					</div>
				</td>
			</tr>
			<tr>
				<td><div align="center">知识点</div>
				</td>
				<td><div align="center">
						<input type="text" name="qc.knowledgePoint" />
					</div>
				</td>
			</tr>
			<tr>
				<td><div align="center">是否是选择题</div>
				</td>
				<td><div align="center">
						<p>
							<label> <input type="radio" name="qc.isReading" value="y" />
								是</label> <br /> <label> <input type="radio" name="isReading"
								value="n" /> 阅读题</label> <br />
						</p>
					</div>
				</td>
			</tr>
			<tr>
				<td></td>
			</tr>
			
		</table>
		<p align="center">
			<input type="submit" name="submit" value="提交" />
		</p>
	</form>
	<p align="center"><a href="<%=basePath%>admin/index.action">返回</a></p>
</body>
</html>
