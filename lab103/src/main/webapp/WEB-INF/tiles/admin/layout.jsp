<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"
%><!DOCTYPE html>
<html lang="ko">
<head>
	<meta http-equiv="content-type" content="text/html; charset=UTF-8"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<meta name="format-detection" content="telephone=no" />
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=no" />
	<meta property="og:title" content="">
	<meta property="og:image" content="">
	<meta property="og:description" content="">
	<meta name="description" content=""/>
	<meta name="keywords" content="">
	<title>lab03</title>
	<script src="/resources/js/jquery-3.6.0.min.js"></script>
	<style>
		.header {
			background-color:red;
			height:50px;
		}
		.footer {
			background-color:blue;
			clear:both;
		}
		#leftMenu{
			float:left;
			width:500px;
			background-color:orange;
		}
		#bodyArea{
			float:left;
		}
		.header>.headerText {float:left;}
		.header>.loginArea{float:right; color:#FFF;}
	</style>
</head>
<body>
	<div id="wrap">
		<tiles:insertAttribute name="header" />
		<div id="content">
		 	<tiles:insertAttribute name="leftMenu" />
		 	<div id="bodyArea">
		 		<tiles:insertAttribute name="body" />
		 	</div>
		</div>
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>
