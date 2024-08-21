<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
<script
  src="https://code.jquery.com/jquery-3.5.1.js"
  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
  crossorigin="anonymous"></script>
  <title>Heroic Features - Start Bootstrap Template</title>

  <!-- Bootstrap core CSS -->
  <link href="../resources/mainPage/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

  <!-- Custom styles for this template -->
  <link href="../resources/mainPage/css/heroic-features.css" rel="stylesheet">
  
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>

</head>

<body>
  <jsp:include page="/WEB-INF/views/common/nav.jsp"></jsp:include>
 
  
<!-- Page Content -->
<div class="container">
  <!-- Jumbotron Header -->
  <header class="jumbotron my-4 text-center">
    <h5 class="display-4 font-weight-bold">나의 관심매물</h5>
    <br>
      
      
      
    </header>

    <!-- Page Features -->
    <div class="row text-center">
    
    <c:forEach items="${watchList}" var="watchList" varStatus="loop">
        <c:if test="${loop.index % 4 == 0}">
            <tr>
        </c:if>
        <td>
        	<div class="col-lg-3 col-md-6 mb-4 watch-item" data-property-id="${watchList.property_id}">
        		<div class="card h-100">
          			<img src="../resources/propertyImg/${watchList.property_realfname}" style="height: 200px">
          			<div class="card-body">
            			<h5 style="font-weight: bold;" class="card-title">${watchList.property_title }</h5>
            			<p class="card-text">${watchList.description }</br></p>
            			<input type="hidden" id="property_id" name="property_id" value="${watchList.property_id }">
          			</div>
          		<div class="card-footer">
            		<a class="btn btn-primary search"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
  					<path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001q.044.06.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1 1 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0"/>
					</svg></a>
            		<a class="btn btn-primary delete"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3-fill" viewBox="0 0 16 16">
  						<path d="M11 1.5v1h3.5a.5.5 0 0 1 0 1h-.538l-.853 10.66A2 2 0 0 1 11.115 16h-6.23a2 2 0 0 1-1.994-1.84L2.038 3.5H1.5a.5.5 0 0 1 0-1H5v-1A1.5 1.5 0 0 1 6.5 0h3A1.5 1.5 0 0 1 11 1.5m-5 0v1h4v-1a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5M4.5 5.029l.5 8.5a.5.5 0 1 0 .998-.06l-.5-8.5a.5.5 0 1 0-.998.06m6.53-.528a.5.5 0 0 0-.528.47l-.5 8.5a.5.5 0 0 0 .998.058l.5-8.5a.5.5 0 0 0-.47-.528M8 4.5a.5.5 0 0 0-.5.5v8.5a.5.5 0 0 0 1 0V5a.5.5 0 0 0-.5-.5"/>
					</svg></a>
         		 </div>
       		 </div>
      		</div>
            
        </td>
        
        <c:if test="${loop.index % 4 == 3 or loop.last}">
            </tr>
        </c:if>
    </c:forEach>
    </div>
    <!-- /.row -->
<br /> <br /> <br /> <br /><br /> <br /> <br /> <br /><br /> <br /> <br /> <br />
				<br /> <br /> <br /> <br /><br /> <br /> <br /> <br /><br /> <br /> <br /> <br />
    
  </div>
  <!-- /.container -->
 <jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>


  <!-- Bootstrap core JavaScript -->
  <script src="../resources/mainPage/vendor/jquery/jquery.min.js"></script>
  <script src="../resources/mainPage/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="../resources/nav/js/nav.js"></script>
  <script type="text/javascript">
  $(".search").click(function(){
	  var propertyId = $("#property_id").val();
		//var propertyId = $(this).find("#property_id").val();
	    
		
	    location.href = "/middleTest/propertydetails?property_id=" + propertyId;
  });
  $(".delete").click(function(){
	  var propertyId = $("#property_id").val();
	  
	  $.ajax({
			type 	: "get"
			,url 	: "/middleTest/watchListDelete"
			,data	: {"property_id" : propertyId}
			,success : function(result){
				if (result === "1"){
	                alert("관심매물에서 제거되었습니다.");
	                $("div.watch-item[data-property-id='" + propertyId + "']").remove();
	                
	            } else if (result === "0"){
	                alert("로그인한 회원만 이용 가능합니다.");
	                location.href = "login";
	            }
			}
			,error:function(err){
				console.log(err);
			}
			
		});
	  
	  
	 
  });

  </script>

</body>

</html>

