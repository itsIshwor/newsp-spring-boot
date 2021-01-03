<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<title>${title}</title>
<jsp:include page="../includes/header.jsp"></jsp:include>
	<h2 class="text-center text-underline px-2">Update  News: ${news.id}: ${news.title}</h2>
<div class="container">
	<div class="row">
		<div class="col-md-6 mx-auto  p-2 m-2">
			<form:form method="post" action="/news/save" modelAttribute="news">
				<div class="form-group">
					<label>News Id</label>
					<form:input path="id" readonly="true" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="title">NewsTitle</label>
					<form:input id="title" path="title" class="form-control"
						placeholder="News Title" />
				</div>

				<div class="form-group">
					<label for="">News Body</label>

					<form:textarea id="categories" path="newsBody" class="form-control"
						placeholder="News Details" rows="6" />
				</div>
				<div class="form-group">
					<label id="">Categories Id:</label>
					<form:select path="categories" class="form-control">
						<c:forEach var="cat" items="${listAll}">
							<form:option value="${cat.cId}">${cat.categoriesName}</form:option>
						</c:forEach>
					</form:select>
				</div>

				<div class="form-group">
					<label id="">Photo</label> <input type="file">
				</div>
				
				<input type="submit" class="btn btn-primary" value="Create New News">
			</form:form>
		</div>
	</div>
</div>
<jsp:include page="../includes/footer.jsp"></jsp:include>