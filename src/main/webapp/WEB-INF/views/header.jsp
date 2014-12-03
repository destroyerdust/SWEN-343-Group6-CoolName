<nav class="navbar navbar-default" role="navigation">
  <div class="container-fluid">
    <!-- Brand sand toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/coolname">ThumbsUp</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
       	<li><a href="/coolname/ride/create">Create Ride</a></li>
        <li><a href="/coolname">Find Ride</a></li>
        <li><a href="/coolname/ride/history">History</a></li>
        <li><a href="/coolname/group/list">Groups</a></li>
      </ul>
      
      <ul class="nav navbar-nav navbar-right">
      <% Object authState = request.getSession().getAttribute("auth");
      	if(authState == null){%>
        <li><a href="/coolname/account/login">Login</a></li>
        <li><a href="/coolname/account/signup">Sign Up</a></li>
      <% } else { %>
      	<li><a href="/coolname/account/manage">My Account</a></li>
        <li><a href="/coolname/account/logout">Logout</a></li>
	  <% } %>
      </ul>
    </div>
  </div>
</nav><!-- End Navbar -->