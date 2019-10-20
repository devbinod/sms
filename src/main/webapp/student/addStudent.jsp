<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="np.com.alon.enumlist.HttpRequestList" %>


<jsp:include page="../headers/header.jsp"/>
<div class="main">
    <div class="container">
        <div class="row">
            <a href="${pageContext.request.contextPath}/students" class="btn btn-success float-right">Message List</a>
        </div>

        <form action="${pageContext.request.contextPath}/students" method="post">
            <input type="hidden" name="action" value="${HttpRequestList.ADD.toString()}"/>
            <div class="row form-row">
                <label>First Name</label>
                <input type="text" name="firstName" class="form-control"/>
            </div>

            <div class="row form-row">
                <label>Last Name</label>
                <input type="text" name="lastName" class="form-control"/>
            </div>

            <div class="row form-row">
                <label>Parent name</label>
                <input type="text" name="parentName" class="form-control"/>
            </div>


            <div class="row form-row">
                <label>Parent Phone Number</label>
                <input type="text" name="parentPhoneNumber" class="form-control"/>
            </div>


            <div class="row form-row">
                <label>Roll No</label>
                <input type="text" name="rollNo" class="form-control"/>
            </div>


            <div class="row form-row">
                <label>Grade</label>
                <select name="grade" class="form-control">
                <c:forEach items="${grades}" var="g">

                        <option value="${g.id}">${g.name}</option>
                </c:forEach>
                </select>
            </div>




            <input type="submit" value="save" class="btn btn-primary"/>
        </form>
    </div>
</div>
