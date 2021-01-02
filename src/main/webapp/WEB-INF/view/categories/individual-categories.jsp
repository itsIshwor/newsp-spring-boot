<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<title>${title}</title>
<jsp:include page="../includes/header.jsp"></jsp:include>
<!--
1.get categoriesegory from controller
2. get id to redirect it to delete and update routing
3.show individual categoriesegory in table

-->
<h2 class="text-center">List categories page</h2>
<div class="text-center">
    <a href="${pageContext.request.contextPath}/categories/list" class="btn btn-primary d-inline-block mb-2">View
        All</a>
    <a href="${pageContext.request.contextPath}/categories/update/${categories.cId}"
       class="btn btn-primary d-inline-block mb-2">Update</a>
    <a href="${pageContext.request.contextPath}/categories/delete/${categories.cId}"
       class="btn btn-danger d-inline-block mb-2">Delete Categories</a>
</div>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-10 mx-auto">
            <table class="table table-striped table-bordered">
                <thead class="thead-dark">
                <tr class="text-center">
                    <th>#</th>
                    <th>Name</th>
                    <th>Created At</th>
                    <th>Updated At</th>
                </tr>
                </thead>
                <tbody>
                <tr class="text-center">
                    <td>${categories.cId}</td>
                    <td>${categories.categoriesName}</td>
                    <td>${categories.createdDate}</td>
                    <td>${categories.lastUpdatedDate}</td>
                </tr>

                </tbody>
            </table>

        </div>
    </div>
</div>

<jsp:include page="../includes/footer.jsp"></jsp:include>