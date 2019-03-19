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
        <li>
          <a id="manageProducts" href="${contextRoot}/manage/products">Manage Products</a>
        </li>
        <li class="nav_right">
          <a id="basket" style="margin-right: 0;" href="${contextRoot}/basket">Basket</a>
        </li>
        <li class="nav_right">
          <a id="signIn" href="${contextRoot}/user/login">Sign In</a>
        </li>
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
  <a id="mobManageProducts" href="${contextRoot}/manage/products">Manage Products</a>
  <a id="mobSignIn" href="${contextRoot}/user/login">Sign In</a>
  <a id="mobBasket" href="${contextRoot}/basket">Basket</a>
</div>

<!-- Button to open side nav -->
<div class="container">
  <div class="sidenav_button">
    <span onclick="openNav()">&#9776;</span>
  </div>
</div>
