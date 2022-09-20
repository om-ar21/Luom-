<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import= "model.User" %>
      <%@ page import= "model.Adresse" %>
      <%@ page import= "model.AdresseDAO" %>
      <%@page import="java.util.ArrayList"%>
      
<!DOCTYPE html>
<html>
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
<jsp:include page="/Header" />
<jsp:include page="/MiniCart"/>

<section class="contact-section pt-80 pb-50">
  <div class="container">
    <div class="row">
      

        <div class="  col-12 mb-30">
        
          <h3  class="contact-page-title" >Mon Compte</h3>
          
          
          <div class="contact-form">
       
            <form method="get">
              <div class="row">
                <div class="col-lg-6 col-12 mb-30">
                  <input
                    id="first-name"
                    placeholder="Nom"
                    value="${us.nom }"
                    name="nom"
                    type="text"
                  />
                </div>

                <div class="col-lg-6 col-12 mb-30">
                  <input
                    id="last-name"
                    placeholder="prénom"
                    value="${us.prenom }"
                    name="prenom"
                    type="text"
                  />
                </div>

             

                <div class="col-12 mb-30">
                  <input
                    id="email"
                    name="email"
                    placeholder="Email"
                    value="${us.email}"
                    type="email"
                  />
                </div>

                

                <div class="col-12 mb-30">
                  <input
                    id="current-pwd"
                    name="password"
                    value="${us.mdp}"
                    placeholder="Current Password"
                    type="password"
                  />
                </div>

                <div class="col-12">
                  <button name="btncompte" class="btn btn-dark btn--md">Sauvegarder</button>
                </div>
              </div>
            </form>
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