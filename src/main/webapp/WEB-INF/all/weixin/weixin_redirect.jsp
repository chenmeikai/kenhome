<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>微信</title>
<script src="http://res.wx.qq.com/connect/zh_CN/htmledition/js/wxLogin.js"></script>
<script type="text/javascript">
  
var obj = new WxLogin({
    id:"login_container", 
    appid: "wxfa3d9ef86a840107", 
    scope: "snsapi_login", 
    redirect_uri: "https://www.chenmeikai.com/kenhome-1.0/"
});

</script>
</head>
<body>
  <div id="login_container">登录微信</div>
</body>
</html>