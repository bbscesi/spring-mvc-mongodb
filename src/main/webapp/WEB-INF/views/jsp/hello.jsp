<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="baseURL" value="localhost:8084/spring3"/>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Maven + Spring MVC</title>

        <spring:url value="/resources/core/css/hello.css" var="coreCss" />
        <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
        <link href="${bootstrapCss}" rel="stylesheet" />
        <link href="${coreCss}" rel="stylesheet" />
    </head>

    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">Spring 3 MVC Project</a>
            </div>
        </div>
    </nav>

    <div class="jumbotron">
        <div class="container">
            <h1>${title}</h1>
            <p>
                <c:if test="${not empty name}">
                    Hello ${name}
                </c:if>

                <c:if test="${empty name}">
                    Welcome Welcome!
                </c:if>
            </p>

            <form method="post" th:object="${customers}" action="http://${baseURL}/add">
                <input type="text" name="name" placeholder="name"/>
                <input type="text" name="firstname" placeholder="firstname"/>
                <input type="text" name="email" placeholder="email"/>
                <input type="submit" value="Submit">
            </form>
        </div>
    </div>

    <div class="container">

        <div class="row">
            <h2>Customers</h2>
            <p>Edit</p>
            <table class="table">
                <thead>
                    <tr>
                        <th>Firstname</th>
                        <th>Lastname</th>
                        <th>Email</th>
                    </tr>
                </thead>
                <tbody>

                    <c:forEach var="customer" items="${customers}">
                        <tr>
                            <td><c:out value="${customer.firstname}"/></td>
                            <td><c:out value="${customer.name}"/></td>
                            <td><c:out value="${customer.email}"/></td>
                            <td><a href="http://${baseURL}/delete/${customer.id}">Delete</a></td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </div>


        <hr>
    </div>

    <spring:url value="/resources/core/css/hello.js" var="coreJs" />
    <spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" />

    <script src="${coreJs}"></script>
    <script src="${bootstrapJs}"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>

</body>
</html>