<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- /myapp 프로젝트 경로 리턴 -->
<c:set var = "contextPath" value = "${pageContext.request.contextPath}"/> 

<div id = "bodtwrap">
	<form id = "frm" method = "get" action = "write.do">
		<input type = "submit" id = "btnWrite" value = "글쓰기"/>
	</form>
	
	<table class = "table table-border mt-1">
		<tr>
			<th class = "col-md-1 text-center">번호</th>
			<th class = "col-md-7 text-center">제목</th>
			<th class = "col-md-2 text-center">메일</th>
			<th class = "col-md-2 text-center">조회수</th>
		</tr>
		
		<c:forEach items = "${aList}" var = "dto">
			<tr>
				<td class = "text-center">${dto.num}</td>
				<td class = "pl-2 text-left">
				<c:url var = "path" value = "view.do">
					<c:param name = "currentPage" value= "${pv.currentPage}"/>
					<c:param name = "num" value = "${dto.num}"/>
				</c:url>
				<c:if test="${dto.re_level>0}">
					<img src="../resources/images/level.gif" width="${20*dto.re_level}" height="15" />
					<img src="../resources/images/re.gif">
				</c:if>
				<a href ="${path}"> ${dto.subject}</td>
				<td class = "text-center">${dto.writer}</td>
				<td class = "text-center">${dto.readcount}</td>
			</tr>
		</c:forEach>
		
	</table>
		<ul class="pagination justify-content-center mt-5 mb-5">
		
			<!-- 이전 출력 시작 -->
				<c:if test="${pv.startPage>1}">
					<li class="page-item">
						<a class="page-link" href="list.do?currentPage=${pv.startPage-pv.blockPage}">Prev</a>
					</li>
				</c:if>
			<!-- 페이지 출력 시작 -->
				<c:forEach var="i" begin="${pv.startPage}" end="${pv.endPage}">
					<li>
						<c:choose>
							<c:when test="${i==pv.currentPage}">
								<a class="page-link page-item active" href="list.do?currentPage=${i}">${i}</a>
							</c:when>
							<c:otherwise>
								<a class="page-link" href="list.do?currentPage=${i}">${i}</a>
							</c:otherwise>
						</c:choose>
					</li>
				</c:forEach>
				
			<c:if test="${pv.endPage<pv.totalPage}">
				<li>
					<a class="page-link" href="list.do?currentPage=${pv.startPage + pv.blockPage}">Next</a>
				</li>
			</c:if>
			<!-- 페이지 출력 끝 -->
		</ul>
</div>
