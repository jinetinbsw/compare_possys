<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>�������� ǰ�����</title>
</head>
<body>
<h1>�������� ǰ�����</h1>
	<form id="addform" action="${pageContext.request.contextPath}/drop_add_form" method="post">
		
		<div>���� �ڵ� ��ȣ : <input name ="food_id" id ="food_id" type ="text"/></div>
		<div>��� ���� : <input name ="drop_ea" id ="drop_ea" type ="text"/></div>
		<div>��� ���� : <input name ="drop_reason" id ="drop_reason" type ="text"/></div>
		<div>����� : <input name ="staff_id" id ="staff_id" type ="text"/></div>
		<div>��� ���� : <input name ="drop_date" id ="drop_date" type ="text"/></div>
		
		

<br>
		<div>
			<input type="submit" id="addfood" value="�����">
			<input type="reset" id="reset" value="�ʱ�ȭ">
			<a href="#">���</a>
		</div>
	</form>
</body>
</html>