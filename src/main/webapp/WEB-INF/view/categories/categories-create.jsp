<!-- to do add spring mvc form tag -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<title>${title}</title>
<jsp:include page="../includes/header.jsp"></jsp:include>
	<h2 class="text-center">Add New categories</h2>
	<div class="container">
		<div class="row">
			<div class="col-md-6 mx-auto  p-2 m-2">
				<form:form method="post" action="/categories/save" modelAttribute="categories">
					<div class="form-group">
						<label for="categories">Categories Name</label>
						<form:input id="categories" path="categoriesName" class="form-control" placeholder="News-categories"/>
					</div>
					<input type="submit" class="btn btn-primary" value="Create New Categories">
				</form:form>
			</div>
		</div>
	</div>
<jsp:include page="../includes/footer.jsp"></jsp:include>