<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>${title}</title>
<jsp:include page="../includes/header.jsp"></jsp:include>
<a href="${pageContext.request.contextPath}/news/create"
	class="btn btn-primary d-inline-block m-4">Create News</a>
<div class="container-fluid">
	<div class="row">
		<div class="col-12 mx-auto">
			<table class="table table-striped table-bordered">
				<thead class="thead-dark">
					<tr class="text-center">
						<th>#</th>
						<th>title</th>
						<th>NewsDetails</th>
						<th>CId</th>
						<th>Create At</th>
						<th>Update At</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach var="news" items="${allNews}">
						<tr>
							<td>${news.id}</td>
							<td>${news.title}</td>
							<td>${news.newsBody}</td>
							<td>${news.categories.cId}</td>
							<td>${news.createdDate}</td>
							<td>${news.lastUpdatedDate}</td>
							<td><a class="btn btn-primary btn-sm d-inline-block"
								href="/news/update/${news.id}"><i class="  fas fa-edit"></i></a> <a
								class="btn btn-danger btn-sm d-inline-block" href="/news/delete/${news.id}"><i
									class="fas fa-trash"></i></a> <a class="btn btn-success btn-sm d-inline-block"
								href="/news/view/${news.id}"><i class="fas fa-eye"></i></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</div>
	</div>
	<div class="row mx-auto">
		<div class="col-sm-6 mx-auto">
			<c:if test="${totalPages >1}">
				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<li class="page-item">
							<a class="page-link" href="#" aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
								<span class="sr-only">Previous</span>
							</a>
						</li>
						
						<c:forEach begin="1" end="${totalPages}" var="i">
                			<c:choose>
                    			<c:when test="${currentPage eq i}">
                    				<li class="page-item">
                    					<a href="${pageContext.request.contextPath}/news/list?page=${currentPage}" class="page-link">${i}</a>
                    				</li>
                        			
                    			</c:when>
                   			 <c:otherwise>
                   			 	<li class="page-item">
                   			 		<a href="${pageContext.request.contextPath}/news/list?page=${i}" class="page-link">${i}</a>	
                   			 	</li>
                        		
                    			</c:otherwise>
                			</c:choose>
            			</c:forEach>
						
						
						<li class="page-item">
							<a class="page-link" href="#" aria-label="Previous"> <span aria-hidden="true">&raquo;</span>
								<span class="sr-only">Previous</span>
							</a>
						</li>
						
					</ul>
				</nav>
			</c:if>
		</div>

	</div>
	<div class="row mx-auto">
		<p class=" btn btn-primary d-inline-block mr-4">Total News: ${totalElement}</p>
		<p class=" btn btn-primary">Total Page: ${totalPages}</p>
		<p class=" btn btn-primary mx-4">Current Page:  ${currentPage}</p>
	</div>
</div>

<jsp:include page="../includes/footer.jsp"></jsp:include>