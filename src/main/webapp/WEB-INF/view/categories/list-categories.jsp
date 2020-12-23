<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<title>${title}</title>
<jsp:include page="../includes/header.jsp"></jsp:include>
	<h2 class="text-center">List categories page</h2>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-10 mx-auto">
				<table class="table table-striped">
					<thead class="thead-dark">
						<tr>
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
								<a class="btn btn-primary btn-sm">Edit</a>
								<a class="btn btn-danger btn-sm">Delete</a>
								<a class="btn btn-success btn-sm">view</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			</div>
		</div>
	</div>
	
<jsp:include page="../includes/footer.jsp"></jsp:include>