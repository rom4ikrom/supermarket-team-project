<div class="navigation clearfix">
  <div class="container">
    <!-- Main navigation bar -->
    <nav>
      <ul class="menu">
        <li>
          <a href="${contextRoot}/home">Home</a>
        </li>
        <li>
          <a href="${contextRoot}/show/all/products">View Products</a>
        </li>
        <li>
          <a href="${contextRoot}/about">About Us</a>
        </li>
        <li class="nav_right">
          <a style="margin-right: 0;" href="${contextRoot}/basket">Basket</a>
        </li>
        <li class="nav_right">
          <a href="${contextRoot}/user/login">Sign In</a>
        </li>
      </ul>
    </nav>
  </div>
</div>

<!-- Side navigation, which is appeared when the size of screen
is less then 771px -->
<div id="mySidenav" class="sidenav">
  <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
  <a href="${contextRoot}/home">Home</a>
  <a href="${contextRoot}/show/all/products">View Products</a>
  <a href="${contextRoot}/about">About Us</a>
  <a href="${contextRoot}/user/login">Sign In</a>
  <a href="${contextRoot}/basket">Basket</a>
</div>

<!-- Button to open side nav -->
<div class="container">
  <div class="sidenav_button">
    <span onclick="openNav()">&#9776;</span>
  </div>
</div>
