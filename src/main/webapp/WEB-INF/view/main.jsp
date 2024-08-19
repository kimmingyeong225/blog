<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    	<!-- header.jsp  -->
	<%@ include file="/WEB-INF/view/layout/header.jsp" %>	
	
	<div class="container p-5">

    <table class="table table-striped">
    
    	<c:choose>
		<c:when test="${boardList != null}">
			<table class="table">
				<thead>
					<tr>
                
					 <th>번호</th>
           			 <th>제목</th>
           			 <th>내용</th>
            		<th>작성자</th>
            		<th>
            		
					</tr>
				</thead>
				<tbody>
					<c:forEach  var="board"   items="${boardList}">
						<tr>
							<td>${board.id}</td>
							<td>${board.title}</td>
							<td>${board.content}</td>
							<td>${board.user}</td>
							
					<td>
                        <div class="d-flex">
                            <form action="/board/${board.id}/delete" method="post">
                                 <button class="btn btn-danger">삭제</button>
                            </form>
                            <form action="/board/${board.id}/updateForm" method="get">
                                <button class="btn btn-warning">수정</button>
                            </form>
                            </div>
                        </td>
							
						</tr>
					</c:forEach>
				</tbody>	
			</table>
					
		</c:when>
		<c:otherwise>
			<div class="no">
				<h5>아직 생성된 글이 없습니다.</h5>
				</div>
				   
		</c:otherwise>
	</c:choose>

            
        
        <tr>
           
              
        </tr>
        <tr>

	
	
<!-- footer.jsp  -->
<%@ include file="/WEB-INF/view/layout/footer.jsp" %>	
	