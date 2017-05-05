<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>결제목록</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

</head>
<body>
	<div class="container">
    <h1>Payment List</h1>
    <div>전체행의 수 : ${totalRowCount}</div>
    <table class="table table-striped table-hover">
        <thead>
            <tr>
                <th>결제아이디</th>
                <th>테이블주문아이디</th>
                <th>금액총합</th>
                <th>지불금액</th>
                <th>결제일자</th>
                <th>결제유형</th>
                <th>결제상태</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="p" items="${list}">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/tori/payment/paymentView?paymentId=${p.payment_id}">${p.payment_id}</a></td>
                    <td>${p.table_order_id}</td>
                    <td>${p.payment_total}</td>
                    <td>${p.payment_pay}</td>
                    <td>${p.payment_date}</td>
                    <td>${p.payment_cate}</td>
                    <td>${p.payment_state}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <ul class="pager">
        <c:if test="${currentPage > 1}">
            <li class="previous"><a href="${pageContext.request.contextPath}/tori/payment/payment_list?currentPage=${currentPage-1}">이전</a></li>
        </c:if>
        <c:if test="${currentPage < lastPage}">
            <li class="next"><a href="${pageContext.request.contextPath}/tori/payment/payment_list?currentPage=${currentPage+1}">다음</a></li>
        </c:if>
    </ul>
    <div>
        <a class="btn btn-default" href="${pageContext.request.contextPath}/tori/payment/payment_add_form">게시글 입력</a>
    </div>
</div>
</body>
</html>