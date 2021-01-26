<jsp:include page="./includes/header.jsp"></jsp:include>

<body class="bg-danger text-white">
	<h1 class="text-center">Some Error Occurred</h1>
    <p class="text-center">${code}</p>
    <a class="btn btn-secondary d-block text-center" href="${pageContext.request.contextPath}/">Back to Home</a>
   </body> 
</html>