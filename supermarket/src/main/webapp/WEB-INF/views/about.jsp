<link rel="stylesheet" href="${cssCustom}/about_us.css">

<header>
	<div class="container">

		<div class="titles">
			Find out why more than <br> 100,000 customers are already with
			us !
		</div>

	</div>
</header>

<section>
	<div class="container">
		<div class="row">

			<div class="col-md-12">

				<h2>History</h2>
				<p class="history">Lorem ipsum dolor sit amet, consectetur
					adipiscing elit, sed do eiusmod tempor incididunt ut labore et
					dolore magna aliqua. Ut enim ad minim veniam, quis nostrud
					exercitation ullamco laboris nisi ut aliquip ex ea commodo
					consequat. Duis aute irure dolor in reprehenderit in voluptate
					velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint
					occaecat cupidatat non proident, sunt in culpa qui officia deserunt
					mollit anim id est laborum.</p>

			</div>

		</div>
	</div>
</section>

<section>
	<div class="container">

		<h2>Meet Our Team</h2>

		<div class="row members">

			<div class="col-md-3 center-block">

				<div class="member">
					<img src="${imgIcons}/person.png" alt="Person">
					<div class="member_info">
						<p class="name">Name</p>
						<p class="role">Role</p>
					</div>
				</div>

			</div>

			<div class="col-md-3">

				<div class="member">
					<img src="${imgIcons}/person.png" alt="Person">
					<div class="member_info">
						<p class="name">Name</p>
						<p class="role">Role</p>
					</div>
				</div>

			</div>

			<div class="col-md-3">

				<div class="member">
					<img src="${imgIcons}/person.png" alt="Person">
					<div class="member_info">
						<p class="name">Name</p>
						<p class="role">Role</p>
					</div>
				</div>

			</div>

			<div class="col-md-3">

				<div class="member">
					<img src="${imgIcons}/person.png" alt="Person">
					<div class="member_info">
						<p class="name">Name</p>
						<p class="role">Role</p>
					</div>
				</div>

			</div>

		</div>
	</div>
</section>

<section>
	<div class="container">
		<div class="row">

			<div class="col-md-6">
				<h2>Contact Us</h2>

				<form action="#" class="contact_us_form_container">

					<label for="fname">First Name <span
						class="obligatory_field">*</span></label> <input type="text"
						placeholder="First Name" name="fname" required> <label
						for="lname">Last Name</label> <input type="text"
						placeholder="Last Name" name="lname" required> <label
						for="email">Email <span class="obligatory_field">*</span></label>
					<input type="email" placeholder="Email" name="email" required>

					<label for="message">Message <span class="obligatory_field">*</span></label>
					<textarea type="text" name="message" rows="8" cols="1"
						placeholder="Be nice!"></textarea>

					<div class="buttons">
						<button class="register btn " type="submit" name="register">Send</button>
						<button class="clear btn" type="clear" name="clear">Clear</button>
					</div>

				</form>

			</div>

			<div class="col-md-6">
				<h2>Find Us</h2>

				<!--The div element for the map -->
				<div id="map"></div>

				<div class="row">
					<div class="col-sm-6">
						<div class="address">
							<h3>Full address</h3>
							Fresh Fruits Company<br> 11 Baker Street<br> London<br>
							AA11 22BB<br> United Kingdom
						</div>
					</div>

					<div class="col-sm-6">

						<div class="contacts">
							<h3>Contacts</h3>
							<table>
								<tr>
									<td>Email:</td>
									<td>freshfruits@gmail.com</td>
								</tr>
								<tr>
									<td>Tel:</td>
									<td>07812345678</td>
								</tr>
							</table>

						</div>

					</div>

				</div>
			</div>

		</div>
	</div>
</section>

<script src="https://maps.googleapis.com/maps/api/js?key=YOUR-KEY"></script>
