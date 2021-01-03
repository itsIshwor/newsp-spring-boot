<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="./includes/header.jsp"></jsp:include>
	<h2>welcome page</h2>
	<div class="container">
		<div class="row">
			<div class="col-md-8 mx-auto">
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
	</div>
<jsp:include page="./includes/footer.jsp"></jsp:include>