<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="./includes/header.jsp"></jsp:include>
	<h2>welcome page</h2>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-10">
				<div class="text-center my-2">
					<a class="btn btn-primary mr-2" href="${pageContext.request.contextPath}/categories/add">Create New Category</a>
					<a class="btn btn-primary" href="${pageContext.request.contextPath}/news/create">Create New news</a>
					<c:forEach var="OneNews" items="${allNews}">
						<div class="card my-4">
							<!-- <img class="card-img-top img-responsive" src="imgs/landscape.jpg"> -->
							<div class="card-block">
									<h4 class="card-title">${OneNews.title}</h4>
									<p class="card-text">${OneNews.newsBody}</p>
									<a href="/news/view/${OneNews.id}" class="btn btn-primary mb-4">view More</a>
							</div>
						</div>
					
					</c:forEach>
				</div>
			
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
                    					<a href="${pageContext.request.contextPath}?page=${currentPage}" class="page-link">${i}</a>
                    				</li>
                        			
                    			</c:when>
                   			 <c:otherwise>
                   			 	<li class="page-item">
                   			 		<a href="${pageContext.request.contextPath}?page=${i}" class="page-link">${i}</a>	
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
	</div>
<jsp:include page="./includes/footer.jsp"></jsp:include>