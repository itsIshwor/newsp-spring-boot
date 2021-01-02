<!-- to do add spring mvc form tag -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<title>${title}</title>
<jsp:include page="../includes/header.jsp"></jsp:include>
	<h2 class="text-center">Update Categories</h2>
	<div class="container">
		<div class="row">
			<div class="col-md-6 mx-auto  p-2 m-2">
				<form:form action="/categories/save" method="POST" modelAttribute="categories">
					<div class="form-group">
						<label for="categories">Categories Name</label>
						<form:input id="categories" path="cId"  class="form-control" placeholder="News-categories" readonly="true"/>
					</div>
					<div class="form-group">
						<label for="categories">Categories Name</label>
						<form:input id="categories" path="categoriesName" class="form-control" placeholder="News-categories"/>
					</div>
					<input type="submit" value="Update Categories" class="btn btn-sm btn-primary">
				</form:form>
			</div>
		</div>
	</div>
<jsp:include page="../includes/footer.jsp"></jsp:include>