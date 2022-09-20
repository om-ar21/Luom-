<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import= "model.User" %>
      <%@ page import= "model.Adresse" %>
      <%@ page import= "model.Commande" %>
      <%@ page import= "model.AdresseDAO" %>
      <%@ page import= "model.CommandeDAO" %>
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
             <div class="myaccount-table table-responsive text-center">
                <table class="table table-bordered">
                  <thead class="thead-light">
                    <tr>
                      
                      <th>Nom</th>
                      <th>Prénom</th>
                      <th>Email</th>
                      <th>Password</th>
                      
                    </tr>
                  </thead>

                  <tbody>
                  
                  
                    <tr>
                      
                      <td>${us.nom }</td>
                      <td>${us.prenom }</td>
                      <td>${us.email }</td>
                      <td>${us.mdp }</td>
                     
                    </tr>
                  </tbody>
                </table>
                <div class="col-12">
                <a href="Modifierinfo">
                  <button   class="d-flex justify-content-start btn btn-dark btn--md">Modifier mes informations</button>
                  </a>
                </div>
              </div>
          </div>
          
          
        </div>
        <!--  contact page side content  -->
      <div class="col-12 mb-30">
        <!--  contact form content -->
        <div class="contact-form-content">
          <h3 class="contact-page-title">Mes Adresses de livraison</h3>
          <div class="contact-form">
             <div class="myaccount-table table-responsive text-center">
            <% if((boolean)request.getAttribute("adressevide")==true){%> 
            <span class="mt-5 mb-5"> Vous n'avez pas d'adresse de livraison  </span>
            <%}else{ %>
                <table class="table table-bordered">
                  <thead class="thead-light">
                    <tr>
                      
                      <th>Adresse </th>
                      <th>Code Postal</th>
                      <th>Ville</th>
                      <th>Pays</th>
                      <th>Action</th>
                    </tr>
                  </thead>

                  <tbody>
                  
                  
                   
                      <%ArrayList<Adresse> adr=new ArrayList<Adresse>();
                      adr=(ArrayList)request.getAttribute("adresse");
                      for(Adresse adrs:adr){
                    	  
                      %>
                       <tr>
                      <td><%= adrs.getAdresse() %></td>
                      <td><%=adrs.getCp() %></td>
                      <td><%=adrs.getVille() %></td>
                      <td><%=adrs.getPays() %></td>
                      <td>
                        <a href="Modifieradr?idadr=<%= adrs.getId() %>" class="ht-btn black-btn"
                          ><i class="far fa-edit mr-5 "></i></a
                        >
                        <a  href="Moncompte?delete=<%= adrs.getId() %>" class=""
                          ><i  class="fa fa-trash  ml-5"></i></a
                        >
                      </td>
                       </tr>
                      
                      <%} %>
                   
                  </tbody>
                </table>
                <%} %>
                <div class="col-12">
                <a href="Ajouteradresse">
                  <button class="d-flex justify-content-start btn btn-dark btn--md">Ajouter une adresse</button>
                </a>
                </div>
              </div>
          </div>
          <p class="form-message mt-10"></p>
        </div>
        <!-- End of contact -->
      </div>
      
      <div class="col-12 mb-30">
        <!--  contact form content -->
        <div class="contact-form-content">
          <h3 class="contact-page-title">Mes Commandes</h3>
          <div class="contact-form">
             <div class="myaccount-table table-responsive text-center">
            <% if((boolean)request.getAttribute("cvide")==true){%> 
            <span class="mt-5 mb-5"> Vous n'avez pas effectué de commande  </span>
            <%}else{ %>
                <table class="table table-bordered">
                  <thead class="thead-light">
                    <tr>
                      
                      <th>Référence</th>
                      <th>Date</th>
                      <th>Total</th>
                      <th>Etat</th>
                      <th>Action</th>
                    </tr>
                  </thead>

                  <tbody>
                  
                   
                      <%ArrayList<Commande> com= (ArrayList)request.getAttribute("comm");
                      for(Commande coms:com){
                    	  
                      %>
                       <tr>
                      <td><%=coms.getId() %></td>
                      <td><%=coms.getDatec() %></td>
                      <td><%=coms.getTotal() %></td>
                      <td><%if(coms.isDel()==false){ %> 
                      <%if(coms.isEtat()==false){%>En attente<%}else{%>Validée<%}}else{ %>
                      Annulée
                      <%}%>
                      </td>
                      <td>
                        <a href="Commands?idc=<%= coms.getId() %>" class="ht-btn black-btn"
                          ><button class="btn btn-dark btn--md">Voir</button></a
                        >
                        
                      </td>
                       </tr>
                      
                      <%} %>
                   
                  </tbody>
                </table>
                <%} %>
                
              </div>
          </div>
          <p class="form-message mt-10"></p>
        </div>
        <!-- End of contact -->
      </div>
      
      <div class="col-12 mb-30">
      <div class="contact-form-content">
          <h3 class="contact-page-title">Supprimer mon compte</h3>
          <a class="action btn btn-danger btn--md" href="#" data-toggle="modal"
															data-target="#quick-viewsure"
															>Supprimer mon compte</a>
          </div>
      </div>
      
    </div>
  </div>
</section>

<jsp:include page="/Footer" />

<!-- modal -->
<div
  class="modal fade theme1 style1"
  id="quick-viewsure"
  tabindex="-1"
  role="dialog"
>
										<div class="modal-dialog modal-dialog-centered"
											role="document">
											<div class="modal-content">

												<div class="modal-header">
													<button type="button" class="close" data-dismiss="modal"
														aria-label="Close">
														<span aria-hidden="true">&times;</span>
													</button>
												</div>
												<div class="modal-body">
													<div class="row">
														
														<div class="col-lg-12">
															<div class="modal-product-info">
																<div class="product-head">
																<form method="POST">
              	
                              <div class="alert alert-warning text-center" role="alert">êtes-vous sûr ? cette opération est irréversible <button type="submit" name="btnsupp" class="btn btn-success btn-sm" style="margin-right:7px; margin-left:7px">Oui</button> <button type="button" name="non" data-dismiss="modal" class="btn btn-danger btn-sm">Non</button></div>
                            	</form>
																</div>
																
															</div>
														</div>
													</div>
												</div>

											</div>
										</div>
									</div>

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