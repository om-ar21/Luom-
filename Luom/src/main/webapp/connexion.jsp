<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<div class="login-register-area pt-80 pb-80">
  <div class="container">
    <div class="row">
      <div class="col-lg-7 col-md-12 ml-auto mr-auto">
        <div class="login-register-wrapper">
          <div class="login-register-tab-list nav">
            <a class="active" data-toggle="tab" href="#lg1">
              <h4>Connexion</h4>
            </a>
            <a data-toggle="tab" href="#lg2">
              <h4>Inscription</h4>
            </a>
             <% if((boolean)request.getAttribute("messageinscriptionok")==true){ %>
                                    <div class="alert alert-success mt-5" role="alert">				  
										Votre inscription est prise en compte, veuillez-vous connecter
									</div>
									<% } %>
			
          </div>
          <div class="tab-content">
            <div id="lg1" class="tab-pane active">
              <div class="login-form-container">
                <div class="login-register-form">
                 <% if((boolean)request.getAttribute("messageconnexionno")==true){ %>
                                <div class="alert alert-warning" role="alert">
								  Adresse e-mail et/ou mot de passe invalide, veuillez recommencer.
								</div>
								<% } %>
					<% if((boolean)request.getAttribute("messageconnexionbloque")==true){ %>
                                <div class="alert alert-danger" role="alert">
								  Compte suspendu, veuillez contacter un administrateur -> <a href="ContactServlet"><b>Ici</b></a>
								</div>
								<% } %>
                  <form  method="post">
                    <input
                      type="text"
                      name="cemail"
                      placeholder="Email"
                    />
                    <input
                      type="password"
                      name="cpassword"
                      placeholder="Password"
                    />
                    <div class="button-box">
                      
                      <button type="submit" name="bconnexion" class="btn btn-dark btn--md">
                        <span>Connexion</span>
                      </button>
                    </div>
                  </form>
                </div>
              </div>
            </div>
            <div id="lg2" class="tab-pane">
              <div class="login-form-container">
                <div class="login-register-form">
                                  
                  <form  method="post">
                    <input
                      type="text"
                      name="nom"
                      placeholder="Nom"
                    />
                     <input
                      type="text"
                      name="prenom"
                      placeholder="Prénom"
                    />
                   
                    <input name="email" placeholder="Email" type="email" />
                     <input
                      type="password"
                      name="password"
                      placeholder="Password"
                    />
                    <div class="button-box">
                      <button type="submit" name="binscription" class="btn btn-dark btn--md">
                        <span>Inscription</span>
                      </button>
                    </div>
                  </form>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<jsp:include page="/Footer" />
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