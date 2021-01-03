<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>${title}</title>
<jsp:include page="../includes/header.jsp"></jsp:include>
	<a href="${pageContext.request.contextPath}/news/create" class="btn btn-primary d-inline-block mt-2 mb-2">Create News</a>
	<div class="container-fluid">
		<div class="row">
			<div class="col-12 mx-auto">
				<table class="table table-striped table-bordered">
					<thead class="thead-dark">
						<tr class="text-center">
							<th>#</th>
							<th>title</th>
							<th>NewsDetails</th>
							<th>Image</th>
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
							<td>${news.image}</td>
							<td>${news.categories.cId}</td>
							<td>${news.createdDate}</td>
							<td>${news.lastUpdatedDate}</td>
							<td>
								<a class="btn btn-primary btn-sm" href="/news/update/${news.id}"><i class="fas fa-edit"></i></a>
								<a class="btn btn-danger btn-sm" href="/news/delete/${news.id}"><i class="fas fa-trash"></i></a>
								<a class="btn btn-success btn-sm" href="/news/view/${news.id}"><i class="fas fa-eye"></i></a>
								
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	</div>
			
<jsp:include page="../includes/footer.jsp"></jsp:include>