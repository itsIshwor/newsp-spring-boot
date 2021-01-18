<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<title>${title}</title>
<style>
	.error {
 		color: #ff0000;
 		font-weight: bold;
 		border: red 2px solid;
 		color: red;
 		border-radius: 5px;
 		
	}
</style>
<jsp:include page="./includes/header.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-md-6 mt-5 mx-auto">
				<div class="mx-auto">
					<form:form method="post" action="/subscribe-success" modelAttribute="subs">
						<form:errors path="*" cssClass="error"/>
						<div>
							<span class="error">${error}</span>
						</div>
						<div class="form-group">
								<div class="input-group">
									<div class="input-group-prepend">
										<div class="btn btn-primary">
											@
										</div>
									</div>
									<form:input id="email" path="email" class="form-control" placeholder="Enter your email"/>
									<div>
										<form:errors path="email" class="danger"/>
									</div>
									<div class="input-group-append">
										<input type="submit" class="btn btn-primary" value="Subscribe">
									</div>
								</div>
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
<jsp:include page="./includes/footer.jsp"></jsp:include>