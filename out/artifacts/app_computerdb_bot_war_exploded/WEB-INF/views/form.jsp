<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div style="width: 500px; margin: 50px auto; text-align: center">

    <form method="post" action="/add-product">

        <label>code</label><br>
        <input type="text" name="code">


        <br><br><br><br>


        <label>type</label>
        <select name="type">
            <c:forEach items="${types}" var="type">
                <option value=${type}>${type}</option>
            </c:forEach>
        </select>

        <br><br><br><br>

        <label>model</label>
        <select name="model">
            <c:forEach items="${models}" var="model">
                <option value=${model}>${model}</option>
            </c:forEach>
        </select>

        <br><br><br><br>
        <label>maker</label>
        <select name="maker">
            <c:forEach items="${makers}" var="maker">
                <option value=${maker}>${maker}</option>
            </c:forEach>
        </select>

        <br><br><br><br>

        <label>price</label><br>
        <input type="number" name="price">

        <br><br><br><br>

        <button type="submit">ok</button>

    </form>



</div>
</body>
</html>