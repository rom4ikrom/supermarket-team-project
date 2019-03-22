<section>
	<div class="container">
		<div class="row">
			<div class="offset-md-3 col-md-6">
				<form class="form-container">

					<div class="row">
						<div class="col-md-12">


							<h3>Staff Sign In</h3>

							<label for="username">Email</label> <input type="text"
								name="username" placeholder="Email" /> <label for="password">Password</label>
							<input type="text" name="password" placeholder="Password" /> 
							
							<p class="admin-login">
								<a href="${contextRoot}/user/login">Not a Staff Member? Login here!</a>
							</p>

							<div class="row">
								<div class="col-md-6">
									<button type="submit" class="btn login">Login</button>
								</div>
								<div class="col-md-6">
									<button type="button" class="btn cancel" onclick="closeForm()">Clear</button>
								</div>
							</div>

						</div>
					</div>

				</form>
			</div>
		</div>
	</div>
</section>