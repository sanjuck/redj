<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="ax" uri="/redj/Ajc" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" src="<%=request.getContextPath()%>/common/js/json2.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/common/js/jquery.min.js"></script>
<ax:import home="/common/ajc" engine="true" />
<ax:var name="x" cls="com.redjframeworksample.test.web.ajax.WebController" importable="true" />

<c:forEach items="${rows }" var="r" >
	${r }<br/>
</c:forEach>

<a href="#" onclick="
	if(x.save(1,'data'))
		location.reload(true);
	return false;
" >save</a>