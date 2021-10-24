<%--
  Created by IntelliJ IDEA.
  User: rishabh
  Date: 02/10/21
  Time: 1:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-F3w7mX95PdgyTmZZMECAngseQB83DfGTowi0iMjiWaeVhAn4FJkqJByhZMI3AhiU" crossorigin="anonymous">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="/resources/css/customcss.css" />
    <link rel="stylesheet" href="/resources/css/perfect-scrollbar.css" />


    <link
            rel="stylesheet"
            href="https://cdnjs.cloudflare.com/ajax/libs/izitoast/1.4.0/css/iziToast.min.css"
    />
    <title>Hello, world!</title>
</head>
<body background="https://images.unsplash.com/photo-1492052722242-2554d0e99e3a?ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjB8fGJsb2clMjBiYWNrZ3JvdW5kfGVufDB8fDB8fA%3D%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60">
<input type="hidden" value="${showNotification}" name="showNotification">
<div class="container mt-3">
    <h1 class="text-center">Welcome to Todo manager</h1>

        <div class="row mt-5" style="margin-left: 5%; margin-right: 5%">
            <div class="col-md-2 mt-5">
                <div class="list-group">
                    <button type="button" class="list-group-item list-group-item-action active">
                        Menu
                    </button>
                    <a href="<c:url value="/add" />" class="list-group-item list-group-item-action addColor" >Add</a>
                    <a href="<c:url value="/home" />" class="list-group-item list-group-item-action addColor" >View</a>
                </div>
            </div>
            <div class="col-md-10">
                <c:if test="${page=='addTodo'}">
                    <h3 class="text-center">Add Todo</h3>
                    <form:form action="/saveTodo" method="post" modelAttribute="todo">
                        <div class="form-group">
                            <form:input path="title" cssClass="form-control addColor" placeholder = "Enter title"></form:input>
                        </div>
                        <div class="form-group mt-3">
                            <form:textarea path="description" cssClass="form-control addColor" placeholder = "Enter description" cssStyle="height: 300px"></form:textarea>
                        </div>
                        <div class="container text-center mt-3">
                            <button class="btn btn-success">Save Todo</button>
                        </div>
                    </form:form>
                </c:if>
                <c:if test="${page == 'viewTodo'}">
                    <h3 class="text-center">View Todo</h3>

                <div class="customScroll" style="overflow-x: hidden;overflow-y: scroll; max-height: 400px">
                    <c:forEach items="${list}" var="item">
                        <div class="card mt-3 addColor">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-md-8" style="margin-right: -10px">
                                        <h3><c:out value="${item.title}" /></h3>
                                        <p><c:out value="${item.description}" /></p>
                                    </div>
                                    <div class="col-md-4" style="margin-right: 5px;margin-left: -10px">
                                        <p style="float: right"><c:out value="${item.dateCreated}"/></p>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </c:forEach>
                </div>
                </c:if>

            </div>

        </div>


</div>

<!-- Optional JavaScript; choose one of the two! -->

<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-/bQdsTh/da6pkI1MST/rWKFNjaCP5gBSY4sEBT38Q/9RBh9AH40zEOg7Hlq2THRZ" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/izitoast/1.4.0/js/iziToast.min.js"></script>
<script src="/resources/js/perfect-scrollbar.min.js"></script>
<script src="/resources/js/custom.js"></script>

<!-- Option 2: Separate Popper and Bootstrap JS -->
<!--
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-W8fXfP3gkOKtndU4JGtKDvXbO53Wy8SZCQHczT5FMiiqmQfUpWbYdTil/SxwZgAN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.min.js" integrity="sha384-skAcpIdS7UcVUC05LJ9Dxay8AXcDYfBJqt1CJ85S/CFujBsIzCIv+l9liuYLaMQ/" crossorigin="anonymous"></script>
-->
</body>
</html>
