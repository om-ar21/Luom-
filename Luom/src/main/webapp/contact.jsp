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
    
<!-- offcanvas-mobile-menu end -->

<!-- header start -->
<jsp:include page="/Header"/>
<jsp:include page="/MiniCart"/>
<!-- breadcrumb-section start -->
<nav class="breadcrumb-section theme1 bg-lighten2 pt-30 pb-30" style="background-color: aliceblue;">
  <div class="container">
    <div class="row">
      <div class="col-12">
        <div class="section-title text-center">
          <h2 class="title pb-4 text-dark text-capitalize">Contact</h2>
        </div>
      </div>
      <div class="col-12">
        <ol
          class="breadcrumb bg-transparent m-0 p-0 align-items-center justify-content-center"
        >
          <li class="breadcrumb-item"><a href="Index">Home</a></li>
          <li class="breadcrumb-item active" aria-current="page">Contact</li>
        </ol>
      </div>
    </div>
  </div>
</nav>
<!-- breadcrumb-section end -->

<!-- contact-section satrt -->
<section class="contact-section pt-50 pb-50">
  <div class="container">
    <div class="row">
      
      <div class="col-lg-6 col-12 mb-30">
        <!--  contact form content -->
        <div class="contact-form-content">
          <h3 class="contact-page-title">Formulaire</h3>
          <c:if test="${sessionScope.creaok == false}">
             <!-- partie alerte -->
        <div class="alert alert-warning" role="alert">
  		Veuillez remplir l'ensemble des champs obligatoires merci.
		</div>
		</c:if>
		<c:if test="${sessionScope.creaok == true}">
             <!-- partie alerte -->
        <div class="alert alert-success" role="alert">
  		Merci pour ce retour, nous vous repondrons dès que possible.
		</div>
		</c:if>
          <div class="contact-form" style="background-color: aliceblue;">
            <form
              method="POST"
            >
              <div class="form-group">
                <label>Email<span class="required">*</span></label>
                <input type="email" name="email" required=""/>
              </div>
              <div class="form-group">
                <label>Sujet<span class="required">*</span></label>
                <input type="text" name="subject" required=""/>
              </div>
              <div class="form-group">
                <label>Votre message<span class="required">*</span></label>
                <textarea
                  name="contactMessage"
                  class="pb-10"
                  required=""
                ></textarea>
              </div>
              <div class="form-group mb-0">
                <button
                  type="submit"
                  class="btn btn-dark btn--lg"
                  name="submit"
                >
                  Envoyer
                </button>
              </div>
            </form>
          </div>
          <p class="form-message mt-10"></p>
        </div>
        <!-- End of contact -->
      </div>
      <div class="col-lg-6 col-12 mb-30">
        <!--  contact page side content  -->
        <div class="contact-page-side-content">
          <h3 class="contact-page-title">Nous Contacter</h3>
          <!--  single contact block  -->

          <div class="single-contact-block">
            <h4><i class="fa fa-fax"></i> ${cord.nom }</h4>
            <p>${cord.adresse }</p>
          </div>

          <!--  End of single contact block -->

          <!--  single contact block -->

          <div class="single-contact-block">
            <h4><i class="fa fa-phone"></i> Tel</h4>
            <p><a href="tel:${cord.tel }">Hotline: ${cord.tel }</a></p>
          </div>

          <!-- End of single contact block -->

          <!--  single contact block -->

          <div class="single-contact-block">
            <h4><i class="fas fa-envelope"></i> Email</h4>
            <p>
              <a href="mailto:${cord.email }">${cord.email }</a>
            </p>
          </div>

          <!--=======  End of single contact block  =======-->
        </div>

        <!--=======  End of contact page side content  =======-->
      </div>
    </div>
  </div>
</section>
<!-- contact-section end -->
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