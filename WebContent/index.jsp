<%@page import="com.redjframework.xos.annotations.RequestMapping"%>
<%@page import="java.lang.reflect.Modifier"%>
<%@page import="org.junit.Test"%>
<%@page import="java.lang.reflect.Method"%>
<%@page import="com.redjframework.xos.annotations.Controller"%>
<%@page import="com.redjframework.util.ReflectUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="cr" uri="/redj/Core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
haroppon framework sample code <br />
<ol>
	<%
	for(Class<?> cls : ReflectUtil.findClasses("com.redjframeworksample.test")){
		if(cls.isAnnotationPresent(Controller.class)){
			out.println("<li>");
			out.println(cls);

			String name = cls.getAnnotation(Controller.class).value();

			out.println("<ul>");
			for(Method method: cls.getDeclaredMethods()){
				if(method.isAnnotationPresent(Test.class)
						|| !Modifier.isPublic(method.getModifiers()))
					continue;

				String path = name+"/"+method.getName();
				if(method.isAnnotationPresent(RequestMapping.class))
					path = method.getAnnotation(RequestMapping.class).path()[0];

				out.println("<li>");
				out.println("<a href='"+path+"'>");
				out.println(method.getName());
				out.println("</a>");
				out.println("</li>");
			}
			out.println("</ul>");

			out.println("</li>");
		}
	}
	%>
</ol>
</body>
</html>
