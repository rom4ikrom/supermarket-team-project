<%@taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<div class="navigation clearfix">
  <div class="container">
    <!-- Main navigation bar -->
    <nav>
      <ul class="menu">
        <li>
          <a id="home" href="${contextRoot}/home">Home</a>
        </li>
        <li>
          <a id="allProducts" href="${contextRoot}/show/all/products">View Products</a>
        </li>
        <li>
          <a id="aboutUs" href="${contextRoot}/about">About Us</a>
        </li>
        
        <security:authorize access="hasAuthority('ADMIN')">
        <li>
          <a id="manageProducts" href="${contextRoot}/manage/products">Manage Products</a>
        </li>
        </security:authorize>
        
        <security:authorize access="hasAuthority('SUP')">
        <li>
          <a id="supplyProducts" href="${contextRoot}/supply/products">Supply Products</a>
        </li>
        </security:authorize>
        
        <security:authorize access="hasAuthority('USER')">
        <li class="nav_right">
          <a id="basket" style="margin-right: 0;" href="${contextRoot}/cart/show">Cart</a>
        </li>
        </security:authorize>
        
        <security:authorize access="isAnonymous()">
        	<li class="nav_right">
          		<a id="signIn" href="${contextRoot}/login">Sign In</a>
        	</li>
        </security:authorize>
        
        <security:authorize access="isAuthenticated()">
        	<li class="nav_right">
        	<div class="dropdown">
        			<a id="userName" href="javascript:void(0)" class="dropbtn">${userModel.fullName}</a>
        			
        			<div class="dropdown-content">
        				<a id="account" href="${contextRoot}/account/personal">Account</a>
        				<a id="logout" href="${contextRoot}/perform-logout">Logout</a>
        			</div>
        			</div>
        		
        	</li>
        </security:authorize>
        
      </ul>
    </nav>
  </div>
</div>

<!-- Side navigation, which is appeared when the size of screen
is less then 771px -->
<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a id="mobHome" href="${contextRoot}/home">Home</a>
  <a id="mobAllProducts" href="${contextRoot}/show/all/products">View Products</a>
  <a id="mobAboutUs" href="${contextRoot}/about">About Us</a>
  
  <security:authorize access="hasAuthority('ADMIN')">
  	<a id="mobManageProducts" href="${contextRoot}/manage/products">Manage Products</a>
  </security:authorize>
  
  <security:authorize access="hasAuthority('SUP')">
  	<a id="mobSupplyProducts" href="${contextRoot}/supply/products">Supply Products</a>
  </security:authorize>
  
  <security:authorize access="isAnonymous()">
  	<a id="mobSignIn" href="${contextRoot}/login">Sign In</a>
  </security:authorize>
  
  <security:authorize access="hasAuthority('USER')">
  	<a id="mobBasket" href="${contextRoot}/cart/show">Cart</a>
  </security:authorize>

	<security:authorize access="isAuthenticated()">
		<a id="mobAccount" href="${contextRoot}/account">Account</a>
		<a id="mobLogout" href="${contextRoot}/perform-logout">Logout</a>
	</security:authorize>
	
</div>

<!-- Button to open side nav -->
<div class="container">
  <div class="sidenav_button">
    <span onclick="openNav()">&#9776;</span>
  </div>
</div>

<script type="text/javascript">
	window.userRole = '${userModel.role}';
</script>
