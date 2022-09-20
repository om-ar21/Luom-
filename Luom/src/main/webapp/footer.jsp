<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>footer</title>
</head>
<body>

<footer class="theme1 position-relative" style="background-color: aliceblue;">
  <!-- footer bottom start -->
  <div class="footer-bottom pt-80 pb-30">
    <div class="container">
      <div class="row">
        <div class="col-12 col-sm-6 col-lg-4 mb-30">
          <div class="footer-widget mx-w-400">
            <div class="footer-logo mb-25">
              <a href="Index">
                <img src="assets/img/logo/logo.png" alt="footer logo" />
              </a>
            </div>
            <p>
              ${ cord.nom }
            </p>
            <p>
              ${ cord.adresse }
            </p>
            <p>
              ${ cord.tel }
            </p>
            <p class="text mb-30">
              ${ cord.email }
            </p>

            <div class="social-network">
              <ul class="d-flex">
                <li>
                  <a href="https://www.facebook.com/" target="_blank"
                    ><span class="icon-social-facebook"></span
                  ></a>
                </li>
                <li>
                  <a href="https://twitter.com/" target="_blank"
                    ><span class="icon-social-twitter"></span
                  ></a>
                </li>
                <li>
                  <a href="https://www.youtube.com/" target="_blank"
                    ><span class="icon-social-youtube"></span
                  ></a>
                </li>
                <li class="mr-0">
                  <a href="https://www.instagram.com/" target="_blank"
                    ><span class="icon-social-instagram"></span
                  ></a>
                </li>
              </ul>
            </div>
          </div>
        </div>
        <div class="col-12 col-sm-6 col-lg-2 mb-30">
          <div class="footer-widget">
            <div class="cbb1 mb-25">
              <div class="section-title">
                <h2 class="title">Catégories</h2>
              </div>
            </div>
            <!-- footer-menu start -->
            <ul class="footer-menu">
            <c:forEach var="cat" items="${requestScope['cats']}" >
              <li><a href="SeeCat?id=${cat.id }&titre=${cat.titre }">${ cat.titre }</a></li>
            </c:forEach>
            </ul>
            <!-- footer-menu end -->
          </div>
        </div>
        <div class="col-12 col-sm-6 col-lg-2 mb-30">
          <div class="footer-widget">
            <div class="cbb1 mb-25">
              <div class="section-title">
                <h2 class="title">social Links</h2>
              </div>
            </div>
            <!-- footer-menu start -->
            <ul class="footer-menu">
              <li><a href="contact.html">Contact us</a></li>
              <c:choose>
              <c:when test="${ !empty sessionScope.usernom }">
              <li><a href="Moncompte">Compte</a></li>
              </c:when>
              <c:otherwise>
              <li><a href="Connexion">Login</a></li>
              </c:otherwise>
              </c:choose>
            </ul>
            <!-- footer-menu end -->
          </div>
        </div>
        <div class="col-12 col-sm-6 col-lg-4 mb-30">
          <div class="footer-widget">
            <div class="cbb1 mb-25">
              <div class="section-title">
                <h2 class="title">Newsletter</h2>
              </div>
            </div>
            <p class="text mb-20">
              Subcribe to the TheFace mailing list to receive update on mnew
              arrivals, special offers and other discount information.
            </p>
            <div class="nletter-form mb-35">
              <form
                class="form-inline position-relative"
                action="http://devitems.us11.list-manage.com/subscribe/post?u=6bbb9b6f5827bd842d9640c82&amp;id=05d85f18ef"
                target="_blank"
                method="post"
              >
                <input
                  class="form-control"
                  type="text"
                  placeholder="Your email address"
                />
                <button
                  class="btn news-letter-btn text-capitalize"
                  type="submit"
                >
                  Sign up
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- footer bottom end -->
  <!-- coppy-right start -->
  <div class="coppy-right bg-dark py-15">
    <div class="container">
      <div class="row">
        <div class="col-12 col-md-6 col-xl-4 order-last order-md-first">
          <div class="text-md-left text-center mt-3 mt-md-0">
            <p>
              Copyright &copy; <a href="https://hasthemes.com/">HasThemes</a>.
              All Rights Reserved
            </p>
          </div>
        </div>
        
      </div>
    </div>
  </div>
  <!-- coppy-right end -->
</footer>

</body>
</html>