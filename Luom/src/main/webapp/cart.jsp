<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="zxx">

<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <meta name="description" content="" />
    <title>Luom</title>
    <!-- Favicon -->
    <link rel="shortcut icon" type="image/x-icon" href="assets/img/favicon.ico" />

    <!--********************************** 
        all css files 
    *************************************-->

    <!--*************************************************** 
       fontawesome,bootstrap,plugins and main style css
     ***************************************************-->
    <!-- cdn links -->

    <link rel="stylesheet" href="assets/css/fontawesome.min.css" />
    <link rel="stylesheet" href="assets/css/ionicons.min.css" />
    <link rel="stylesheet" href="assets/css/simple-line-icons.css" />
    <link rel="stylesheet" href="assets/css/plugins/jquery-ui.min.css">
    <link rel="stylesheet" href="assets/css/bootstrap.min.css" />
    <link rel="stylesheet" href="assets/css/plugins/plugins.css" />
    <!-- <link rel="stylesheet" href="assets/css/plugins/aos.css" /> -->
    <link rel="stylesheet" href="assets/css/style.min.css" />

    <!-- Use the minified version files listed below for better performance and remove the files listed above -->

    <!--**************************** 
         Minified  css 
    ****************************-->

    <!--*********************************************** 
       vendor min css,plugins min css,style min css
     ***********************************************-->
    <!-- <link rel="stylesheet" href="assets/css/vendor/vendor.min.css" />
    <link rel="stylesheet" href="assets/css/plugins/plugins.min.css" />
    <link rel="stylesheet" href="assets/css/style.min.css" /> -->
</head>

<body>

<!-- header start -->
<jsp:include page="/Header"/>
<jsp:include page="/MiniCart"/>
<!-- header end -->
<!-- breadcrumb-section start -->
<nav class="breadcrumb-section theme1 bg-lighten2 pt-30 pb-30" style="background-color: aliceblue;">
  <div class="container">
    <div class="row">
      <div class="col-12">
        <div class="section-title text-center">
          <h2 class="title pb-4 text-dark text-capitalize">Panier</h2>
        </div>
      </div>
      <div class="col-12">
        <ol
          class="breadcrumb bg-transparent m-0 p-0 align-items-center justify-content-center"
        >
          <li class="breadcrumb-item"><a href="Index">Home</a></li>
          <li class="breadcrumb-item active" aria-current="page">Panier</li>
        </ol>
      </div>
    </div>
  </div>
</nav>
<!-- breadcrumb-section end -->
<!-- product tab start -->
<section class="whish-list-section theme1 pt-80 pb-80">
  <div class="container">
    <div class="row">
      <div class="col-12">
        <h3 class="title mb-30 pb-25 text-capitalize">Votre Panier</h3>
        <div class="table-responsive">
          <table class="table">
            <thead class="thead-light">
              <tr>
                <th class="text-center" scope="col">Image Produit</th>
                <th class="text-center" scope="col">Nom Produit</th>
                <!-- <th class="text-center" scope="col">Statut Stock</th> -->
                <th class="text-center" scope="col">Quantité</th>
                <th class="text-center" scope="col">Validation changement</th>
                <th class="text-center" scope="col">Prix</th>
                <th class="text-center" scope="col">Retirer</th>
              </tr>
            </thead>
            <tbody>
            <c:forEach var="fe" items="${requestScope['fe']}">
              <tr>
                <th class="text-center" scope="row">
                  <img src="${ fe.produit.img }" alt="img" />
                </th>
                <td class="text-center">
                  <span class="whish-title"
                    >${ fe.produit.titre }</span
                  >
                </td>
                <!-- <td class="text-center">
                  <span class="badge badge-danger position-static"
                    >En Stock</span
                  >
                </td> -->
                <td class="text-center">
                  <div class="product-count style">
                    <div class="count d-flex justify-content-center">
                    <form method="POST">
                    <a href="PanierServlet?idtoup=${ fe.produit.id }" class="count-btn increment" style="margin-bottom:-27px; margin-left:80px">
                          <i class="fas fa-chevron-up"></i>
                        </a>
                      <input
                        name="newqte"
                        type="number"
                        min="1"
                        step="1"
                        value="${fe.qte}"
                      />
                        <a href="PanierServlet?idtominus=${ fe.produit.id }" class="count-btn decrement" style="margin-top:-27px; margin-left:80px">
                          <i class="fas fa-chevron-down"></i>
                        </a>
                      <td class="text-center">
                  <button type="submit" name="paddqte" value="${fe.produit.id}" class="btn btn-dark btn--lg">MAJ QTE</button>
                </td>
                      </form>
                    </div>
                  </div>
                </td>
                <td class="text-center">
                  <span class="whish-list-price">${fe.qte} x ${ fe.produit.prix }€ = ${ fe.qte * fe.produit.prix }€</span>
                </td>

                <td class="text-center">
                  <a href="PanierServlet?idtosuppr=${ fe.produit.id }">
                    <span class="trash"><i class="fas fa-trash-alt"></i> </span
                  ></a>
                </td>
                
              </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</section>
<!-- product tab end -->
<div class="check-out-section pb-80">
  <div class="container">
    <div class="row">
      <div class="col-lg-7">
        <!-- <div class="billing-info-wrap">
          <form class="personal-information" action="assets/php/contact.php">
            <div class="row">
              <div class="col-12">
                <h3 class="coupon-title">Discount coupon Code</h3>
              </div>
              <div class="col-lg-6 col-md-6">
                <div class="billing-info mb-20px">
                  <input placeholder="coupon Code" type="text" />
                </div>
              </div>
              <div class="col-lg-6 col-md-6">
                <a href="#" class="btn btn-primary check-out-btn">apply code</a>
              </div>
            </div>
          </form>
        </div> -->
      </div>
      <div class="col-lg-5 mt-4 mt-lg-0">
        <div class="your-order-area">
          <div class="your-order-wrap gray-bg-4">
            <div class="your-order-product-info">
              <div class="your-order-top">
                <ul>
                  <li>Produits: ${countallart}, Reférences: ${countart}</li>
                  <li>Total</li>
                </ul>
              </div>

              <div class="your-order-bottom">
                <ul>
                <c:forEach var="fe" items="${requestScope['fe']}">
                  <li class="your-order-shipping">${ fe.produit.titre }</li>
                  <li>${ fe.qte * fe.produit.prix }€</li>
                </c:forEach>
                </ul>
              </div>
              <div class="your-order-total mb-0">
                <ul>
                  <li class="order-total">Total</li>
                  <li>${ T }€</li>
                </ul>
              </div>
            </div>
          </div>
          <div class="Place-order mt-25">
          <c:choose>
	<c:when test="${ !empty sessionScope.usernom }">
	<a href="PanierServlet?com=ok" class="btn btn-dark btn--lg d-block d-sm-inline-block mt-4 mt-sm-0">Payer</a>
	</c:when>
	<c:otherwise>
	<a href="Connexion" class="btn btn-dark btn--lg d-block d-sm-inline-block mt-4 mt-sm-0">Connexion/Inscription</a>
	</c:otherwise>
	</c:choose>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<!-- footer strat -->
<jsp:include page="/Footer"/>
<!-- footer end -->
<!-- search-box and overlay start -->

<!-- search-box and overlay end -->


    <!--*********************** 
        all js files
     ***********************-->

    <!--****************************************************** 
        jquery,modernizr ,poppe,bootstrap,plugins and main js
     ******************************************************-->

    <script src="assets/js/vendor/jquery-3.5.1.min.js"></script>
    <script src="assets/js/vendor/modernizr-3.7.1.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/plugins/jquery-ui.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/plugins/plugins.js"></script>
    <script src="assets/js/plugins/ajax-contact.js"></script>
    <!-- <script src="assets/js/plugins/aos.js"></script> -->
    <script src="assets/js/main.js"></script>

    <!-- Use the minified version files listed below for better performance and remove the files listed above -->

    <!--*************************** 
          Minified  js 
     ***************************-->

    <!--*********************************** 
         vendor,plugins and main js
      ***********************************-->

    <!-- <script src="assets/js/vendor/vendor.min.js"></script>
    <script src="assets/js/plugins/plugins.min.js"></script>
    <script src="assets/js/main.js"></script> -->


</body>

</html>