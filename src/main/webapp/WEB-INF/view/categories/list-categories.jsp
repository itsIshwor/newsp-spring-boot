<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<title>${title}</title>
<jsp:include page="../includes/header.jsp"></jsp:include>
	<h2 class="text-center">List categories page</h2>
	<a href="${pageContext.request.contextPath}/categories/add" class="btn btn-primary d-inline-block mb-2">Create New Categories</a>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-10 mx-auto">
				<table class="table table-striped table-bordered">
					<thead class="thead-dark">
						<tr class="text-center">
							<th>#</th>
							<th>Name</th>
							<th>Create At</th>
							<th>Update At</th>
							<th>Actions</th>
						</tr>
					</thead>
				<tbody>
		
					<c:forEach var="cat" items="${listAll}">
						<tr>
							<td>${cat.cId}</td>
							<td>${cat.categoriesName}</td>
							<td>${cat.createdDate}</td>
							<td>${cat.lastUpdatedDate}</td>
							<td>
								<a class="btn btn-primary btn-sm" href="/categories/update/${cat.cId}"><i class="fas fa-edit"></i></a>
								<a class="btn btn-danger btn-sm" href="/categories/delete/${cat.cId}"><i class="fas fa-trash"></i></a>
								<a class="btn btn-success btn-sm" href="/categories/view/${cat.cId}"><i class="fas fa-eye"></i></a>
								
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			</div>
		</div>
	</div>
	
<jsp:include page="../includes/footer.jsp"></jsp:include>