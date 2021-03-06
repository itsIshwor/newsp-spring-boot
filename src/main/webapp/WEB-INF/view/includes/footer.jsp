<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<footer class="bg-dark text-white pt-2 px-1">
	<div class="container">
		<div class="row">
			<div class="col-md-4">
				<div class="text-underline ">Quick Links</div>
				<ul class="list-unstyled ml-2">
					<li class="nav-items"><a href="">Flash News</a></li>
					<li class="nav-items"><a href="">Politics</a></li>
					<li class="nav-items"><a href="">Science And Technology</a></li>
					<li class="nav-items"><a href="">National</a></li>
					<li class="nav-items"><a href="">International</a></li>
				</ul>
			</div>
			<div class="col-md-4">
				<div class="text-center text-underline">Social</div>
			</div>
			<div class="col-md-4">
				<div class="text-underline ">Get Update</div>
				<a href="${pageContext.request.contextPath}/subscribe">Subscribe News Later</a>
			</div>
			<div class="container-fluid border-top py-auto">
				<div class="row">
					<div class=" col-12 text-center py-auto">
						<p class="align-center">
							Copyright reserved- <span class="text"></span>
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</footer>
<script src="${pageContext.request.contextPath}/resources/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/app.js"></script>
</body>
</html>