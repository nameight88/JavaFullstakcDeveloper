<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored = "false" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<!DOCTYPE html>
<html lang="ko">

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
	
<script
  src="https://code.jquery.com/jquery-3.5.1.js"
  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
  crossorigin="anonymous"></script>
  
  <title>Shop Homepage - Start Bootstrap Template</title>

  <!-- Bootstrap core CSS -->
  <link href="resources/ProductList/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  
  <!-- Custom styles for this template -->
  <link href="resources/common/css/shop-homepage.css" rel="stylesheet">
  <link href="resources/common/css/common.css" rel="stylesheet">
  <link rel="stylesheet" href="resources/ProductList/css/productList.css">

</head>

<body>

  <jsp:include page="/WEB-INF/views/common/nav.jsp"></jsp:include>

  <!-- Page Content -->
  <div id="container" class="container">

    <div class="row">

      <div class="col-lg-3 nav-col-lg-3">

        <h1 class="my-4 nav-title">Shop Name</h1>
        <div id="categories" class="list-group">
	        <c:forEach items="${ categories }" var="category">
	          	<a href="/ProductList/${ category.category_code }" class="list-group-item">${ category.category_name }</a>
	        </c:forEach>
        </div>

      </div>
      <!-- /.col-lg-3 -->

      <div class="col-lg-9 main-col-lg-9">

        <!-- <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
          </ol>
          <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
              <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="First slide">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Second slide">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="http://placehold.it/900x350" alt="Third slide">
            </div>
          </div>
          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div> -->
        
        <!-- 상품 -->
        <div id="productRow" class="row">
		<%-- <c:forEach items = "${products}" var = "product">
          <div class="col-lg-4 col-md-6 mb-4">
            <div class="card h-100">
            <c:if test="${product.thumbnail_url != 'none.png'}">
              <a href="#"><img class="card-img-top" src="${product.thumbnail_url}" alt=""></a></c:if>
            <c:if test="${product.thumbnail_url == 'none.png'}">
              <a href="#"><img class="card-img-top" src="<%=request.getContextPath() %>/resources/ProductList/image/noimage.png" alt="no_image"></a>
            </c:if>
              <div class="card-body">
                <h4 class="card-title">
                <div style = "visibility : hidden">${product.product_code }</div>
                  <a href="/ProductDetail/${product.product_code}">${product.product_name}</a>
                </h4>
                <h5>${product.product_price }원</h5>
                <c:if test="${ product.product_stock==0 }">
                	<p class="card-text" style="color:red">품절된 상품입니다.</p>
                </c:if>
                <p class="card-text">${product.product_manufacturer }</p>
              </div>
            </div>
          </div>
		</c:forEach> --%>
        </div>
        <!-- 상품end -->
        
        <!-- /.row -->
		<div class="row">
			<div class="col-md-12 text-center">
				<div id="pageButtonGroup" class="btn-group me-2" role="group" aria-label="First group">
					<%-- <button type="button" class="btn btn-light pageButton clicked_pageButton" index="1">1</button>
					<c:if test="${ pageNum<=5 }">
						<c:forEach var="page" begin="2" end="${ pageNum }" step="1">
							<button type="button" class="btn btn-light pageButton" index="${ page%5 }">${ page }</button>
						</c:forEach>
					</c:if>
					<c:if test="${ pageNum>5 }">
						<c:forEach var="page" begin="2" end="5" step="1">
							<button type="button" class="btn btn-light pageButton" index="${ page%5 }">${ page }</button>
						</c:forEach>
						<button id="nextButton" type="button" class="btn btn-light">다음</button>
					</c:if> --%>
				</div>
			</div>
		</div>
		<!-- /.row -->
      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->

  <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>

  <!-- Bootstrap core JavaScript -->
  <script src="resources/ProductList/vendor/jquery/jquery.min.js"></script>
  <script src="resources/ProductList/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <!-- JavaScript -->
  <script src="https://unpkg.com/axios/dist/axios.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
  <script src="resources/ProductList/js/ProductList.js"></script>
</body>

</html>