<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>ȸ�� ����Ʈ ȭ��</title>
<!-- bootstrap�� ����ϱ� ���� CDN�ּ� -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
 
</head>
<body>
<div class="container">
    <h1>MEMBER LIST</h1>
    <div>��ü���� �� : ${SmemberCount}</div>
    <table class="table table-striped">
        <thead>
            <tr>
                <th>member_phone</th>
                <th>member_name</th>
                <th>member_point</th>
                <th>member_sign</th>
                <th>member_join</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="m" items="${Mlist}">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/member_information_view?member_phone=${m.member_phone}">${m.member_phone}</a></td>
                    <td>${m.member_name}</td>
                    <td>${m.member_point}</td>
                    <td>${m.member_sign}</td>
                    <td>${m.member_join}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <ul class="pager">
    <%--     <c:if test="${ScurrentPage < Slastpage}">
            <li class="previous"><a href="${pageContext.request.contextPath}/member_select?ScurrentPage=${ScurrentPage-1}&selBox=${sessionScope.m.selBox}&search=${sessionScope.m.search}">����</a></li>
        </c:if> --%>
      
      	<c:forEach var="i" begin="${Sexpage}" end="${Slastpage}" step="1">
             <c:choose>
                <c:when test="${i eq ScurrentPage}"><li class="previous"><a href="${pageContext.request.contextPath}/member_select?ScurrentPage=${i}&selBox=${sessionScope.m.selBox}&search=${sessionScope.m.search}" class="choice">[${i}]</a></li></c:when>
                <c:otherwise><li class="previous"><a href="${pageContext.request.contextPath}/member_select?ScurrentPage=${i}&selBox=${sessionScope.m.selBox}&search=${sessionScope.m.search}">[${i}]</a></li></c:otherwise>
            </c:choose>

        </c:forEach>
        
       <%--  <c:if test="${ScurrentPage > 4}">
            <li class="next"><a href="${pageContext.request.contextPath}/member_select?ScurrentPage=${currentPage+1}&selBox=${sessionScope.m.selBox}&search=${sessionScope.m.search}">����</a></li>
        </c:if> --%>
    </ul>
    
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script type="text/javascript"> 
$(document).ready(function(){
	$('#button').click(function(){
		
		var va = $("#selBox option:selected").val();
		 var regExp = /\s/g;
		if(va != null || va != "" || va !=regExp){
			/* alert(va); */
			frm.submit();	
		}else{
			 alert('�˻������� �����ϼ���');
		}
		
	});
});
</script>

    <div>
    <form id="frm" name="frm" action="${pageContext.request.contextPath}/member_select" method="get">
    	<select  id="selBox" name="selBox">
    	<option>-- �����ϼ���--</option>
        <option  value="member_phone">�ڵ�����ȣ</option>
        <option  value="member_name">�̸�</option>
        <option  value="member_sign">��������</option>
        <option  value="member_join">�ֱٹ湮����</option>
        </select>
        <input type="search" name="search" id="search">
        <input type="button" name="button" id="button" value="�˻�">
    	 <button><a href="${pageContext.request.contextPath}/member_list">��ü����Ʈ</a></button>
     </form>
    
    </div>
</div>
</body>
</html>
