<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>���� ȭ��</title>
</head>
<body>
<h1>������ - ${food.food_id} ���� ȭ��</h1>
<br>

<form id="addform" action="${pageContext.request.contextPath}/food_modify" method="post">
		
		<div>��ǰ��ȣ : <input name ="food_id" id ="food_id" type ="text" value="${food.food_id}" readonly="readonly"/></div>
		<div>��ǰ�� : <input name ="food_name" id ="food_name" type ="text" value="${food.food_name}"/></div>
		<div>�԰� : <input name ="food_size" id ="food_size" type ="text" value="${food.food_size}"/></div>
		<div>���� : <input name ="food_unit" id ="food_unit" type ="text" value="${food.food_unit}"/></div>
		<div>������� : <input name ="food_shelflife" id ="food_shelflife" type ="text" value="${food.food_shelflife}"/></div>
		<div>����� : <input name ="staff_id" id ="staff_id" type ="text" value="${food.staff_id}" readonly="readonly"/></div>
		
		

<br>
		<div>
			<input type="submit" id="addfood" value="����">
			<input type="reset" id="reset" value="�ʱ�ȭ">
			<a href="${pageContext.request.contextPath}/food_list">���</a>
			<a href="${pageContext.request.contextPath}/food_delete?food_id=${food.food_id}">����</a>
		</div>
	</form>



</body>
</html>