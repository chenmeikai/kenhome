<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>测试登录</title>
</head>
<body>
  <form action="login" method="post">
    用户名：<input type="text" name="managerName">
  <br>
     密  码 ：<input type="password" name="password"> 
  <br>
  <img src="identifyingCode" style="width:100px;"/>
  <input type="submit" value="登录">   
  </form>
</body>
</html>