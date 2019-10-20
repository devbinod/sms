<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="np.com.alon.enumlist.HttpRequestList" %>

<jsp:include page="../headers/header.jsp"/>
<div class="main">
    <div class="container">
        <div class="row">
            <a href="${pageContext.request.contextPath}/students?action=${HttpRequestList.ADD.toString()}" class="btn btn-success float-right">Add Student</a>
        </div>
        <table class="table table-bordered">
            <tr>
                <td>S.N</td>
                <td>First name</td>
                <td>Last name</td>
                <td>Parent Name</td>
                <td>Parent phone no</td>
                <td>Action</td>
            </tr>
            <c:forEach items="${studentList}" varStatus="i"  var="s">
                <tr>
                    <td>${i.index+1}</td>
                    <td>${s.firstName}</td>
                    <td>${s.lastName}</td>
                    <td>${s.parentName}</td>
                    <td>${s.parentPhoneNumber}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/students?action=${HttpRequestList.UPDATE.toString()}&id=${s.id}"
                           class="btn btn-success"
                        >
                            Update
                        </a>

                        <a href="${pageContext.request.contextPath}/students?action=${HttpRequestList.DELETE.toString()}&id=${s.id}"
                           class="btn btn-danger"
                        >
                            Delete
                        </a>
                    </td>
                </tr>
            </c:forEach>


        </table>
    </div>
    </body>
</div>