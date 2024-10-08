<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Product</title>
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">

<h2>Edit Product</h2>
<a href="${pageContext.request.contextPath}/products" class="btn btn-primary mb-3">Back to Product List</a>

<form action="${pageContext.request.contextPath}/products/${product.id}" method="post">

    <input type="hidden" name="id" value="${product.id}" />

    <label for="name" class="form-label">Product Name:</label>
   <input type="text" id="name" name="name" class="form-control" value="${product.name}" required /><br>
   
    <label for="price" class="form-label" >Price:</label>
    <input type="number" id="price" name="price" class="form-control" step="0.01" value="${product.price}" required /><br>
    
    <label for="description" class="form-label mt-2">Description:</label>
    <textarea id="description" class="form-control" name="description" rows="3">${product.description}</textarea><br>

	<input type="submit" class="btn btn-danger mt-2" value="Update Product" />
</form>

</div>


</body>
</html>
