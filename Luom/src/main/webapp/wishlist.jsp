<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="model.FavorisDAO"%> 
<%@page import="model.Favoris"%>
<%@page import="java.util.ArrayList"%>
<%ArrayList<Favoris> fav = new ArrayList<Favoris>();%>


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
    <link rel="stylesheet" href="assets/css/custom.css" />
    <link rel="stylesheet" href="assets/sass/pages/shopPages/_shop.scss"/>

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
<!--header a mettre ici -->
<jsp:include page="/Header"/>
<jsp:include page="/MiniCart"/>

<section class="whish-list-section theme1 pt-80 pb-80">
  <div class="container">
    <div class="row">
      <div class="col-12">
        <h3 class="title mb-30 pb-25 text-capitalize">Wishlist</h3>
        <div class="table-responsive">
          <table class="table">
            <thead class="thead-light">
              <tr>
                <th class="text-center" scope="col">Image</th>
                <th class="text-center" scope="col">Titre</th>
                <!-- <th class="text-center" scope="col">Stock Status</th> -->
                <th class="text-center" scope="col">Prix</th>
                <th class="text-center" scope="col">action</th>
                <th class="text-center" scope="col">Checkout</th>
              </tr>
            </thead>
            <tbody>
            <% 
            	
       		fav=(ArrayList)request.getAttribute("fav");
       		for( Favoris favs:fav){
       		%>
              <tr>
                <th class="text-center" scope="row">
                  <img src="<%= favs.getProduit(favs.getId_produit()).getImg() %>" alt="img" />
                </th>
                <td class="text-center">
                  <span class="whish-title"
                    ><%= favs.getProduit(favs.getId_produit()).getTitre() %></span
                  >
                </td>
           <!--      <td class="text-center">
                  <span class="badge badge-danger position-static"
                    >In Stock</span
                  >
                </td> -->
                
                <td class="text-center">
                  <span class="whish-list-price"> <%= favs.getProduit(favs.getId_produit()).getPrix() %> € </span>
                </td>

                <td class="text-center">
                  <a href="Wishlist?delete=<%= favs.getId() %>">
                    <span class="trash"><i class="fas fa-trash-alt"></i> </span
                  ></a>
                </td>
                <td class="text-center">
                  <a href="#" class="btn btn-dark btn--lg">add to cart</a>
                </td>
              </tr>
             
           <%} %>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</section>


<jsp:include page="/Footer"/>
<!-- footer end -->

<!-- modals start -->
<!-- first modal -->

<!-- second modal -->

<!-- second modal -->

<!-- modals end -->

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


</body>
</html>
