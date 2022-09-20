<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page import="model.AdresseDAO"%> 
<%@page import="model.Adresse"%>


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
    
<section class="contact-section pt-80 pb-50">
  <div class="container">
    <div class="row">
          <div class="col-lg-8 col-12 mb-30 offset-lg-2">
        <!--  contact form content -->
        <div class="contact-form-content">
          <h3 class="contact-page-title">Ajouter une Adresse</h3>
          <div class="contact-form">
            <form
              
              
              method="get"
            >
              <div class="form-group">
                <label>Rue </label>
                <input type="text" name="rue"  />
              </div>
              <div class="form-group">
                <label>Code Postal </label>
                <input type="text" name="cp"  />
              </div>
              <div class="form-group">
                <label>Ville</label>
                <input type="text" name="ville"  />
              </div>
              <div class="form-group">
                <label>Pays</label>
                <input type="text" name="pays"  />
              </div>
            
              <div class="form-group mb-0">
                <button
                  type="submit"
                 
                class="btn btn-dark btn--lg"
                  name="ajouter_adresse"
                >
                  Ajouter
                </button>
              </div>
            </form>
          </div>
          <p class="form-message mt-10"></p>
        </div>
        <!-- End of contact -->
      </div>
    
    </div>
    </div>
  </section>
<!-- offcanvas-overlay start -->

<!-- offcanvas-overlay end -->


<!-- footer strat -->
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