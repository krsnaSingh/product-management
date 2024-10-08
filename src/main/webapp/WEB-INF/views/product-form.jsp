<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Product</title>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container mt-4">

<h2>New Product</h2>
<a href="${pageContext.request.contextPath}/products" class="btn btn-primary mb-3">Back to Product List</a>

<form action="${pageContext.request.contextPath}/products" method="post">

    <label for="name">Name:</label>
    <input type="text" class="form-control" id="name" name="name" required /><br>

    <label for="price">Price:</label>
    <input type="number" class="form-control" id="price" name="price" step="0.01" required /><br>

    <label for="description">Description:</label>
    <textarea id="description" class="form-control" name="description"></textarea><br>

    <input type="submit" class="btn btn-success mt-2" value="Save Product" />
</form>
</div>

</body>
</html>
