<%@ page import="np.com.alon.enumlist.HttpRequestList" %>


<jsp:include page="../headers/header.jsp"/>
<div class="main">
    <div class="container">
        <div class="row">
            <a href="${pageContext.request.contextPath}/grades?action=${HttpRequestList.ALL.toString()}" class="btn btn-success float-right">Grade List</a>
        </div>

        <form action="${pageContext.request.contextPath}/grades" method="post">
            <input type="hidden" name="action" value="${HttpRequestList.UPDATE.toString()}"/>
            <input type="hidden" name="id" value="${grade.id}"/>
            <div class="row form-row">
                <label>Grade name</label>
                <input type="text" name="name" class="form-control" value="${grade.name}"/>
            </div>


            <input type="submit" value="Update" class="btn btn-primary"/>
        </form>
    </div>
</div>
