<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="tpl" uri="/redj/Template" %>
<%@taglib prefix="ax" uri="/redj/Ajc" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script type="text/javascript" src="<%=request.getContextPath()%>/common/js/json2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/common/js/jquery.min.js"></script>
<ax:import home="/common/ajc" engine="true" />
<title>template</title>
</head>
template frame
<body>
	<div id="container"><tpl:region id="menu" /> </div>
	<div id="container"><tpl:region id="jsp" /> </div>
</body>
</html>
