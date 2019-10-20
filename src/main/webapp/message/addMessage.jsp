<%@ page import="np.com.alon.enumlist.HttpRequestList" %>


<jsp:include page="../headers/header.jsp"/>
<div class="main">
    <div class="container">
        <div class="row">
            <a href="${pageContext.request.contextPath}/addMessage" class="btn btn-success float-right">Message List</a>
        </div>

        <form action="${pageContext.request.contextPath}/addMessage" method="post">
            <input type="hidden" name="action" value="${HttpRequestList.ADD.toString()}"/>
            <div class="row form-row">
                <label>Message Title</label>
                <input type="text" name="title" class="form-control"/>
            </div>

            <div class="row form-row">
                <label>Message Title</label>
                <textarea rows="5" cols="40" name="messageBody" class="form-control"></textarea>
            </div>
            <input type="submit" value="save" class="btn btn-primary"/>
        </form>
    </div>
</div>
