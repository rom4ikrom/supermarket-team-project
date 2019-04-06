<link rel="stylesheet" href="${cssCustom}/create_account.css">
   
    <header>

      <div class="container">

        <div class="titles">
          <div class="top_title">
            Create Account with us <br>
            to enjoy fresh fruits <br>
            wherever and whenever you like!
          </div>
          <div class="second_title">
            Yes, it's free ;)
          </div>
        </div>
      </div>

    </header>

    <section>
      <div class="container">

        <form action="#" class="create_acc_form_container">

          <div class="row">
            <div class="col-md-12">
              <h2>Create Account</h2>
            </div>
          </div>

          <div class="row">
            <div class="col-md-6">
              <h4>Personal Information</h4>

              <label for="fname">First Name <span class="required-red">*</span></label>
              <input type="text" placeholder="First Name" name="fname" required>

              <label for="mname">Middle Name</label>
              <input type="text" placeholder="Middle Name" name="mname">

              <label for="lname">Last Name <span class="required-red">*</span></label>
              <input type="text" placeholder="Last Name" name="lname" required>

              <label for="email">Email <span class="required-red">*</span></label>
              <input type="email" placeholder="Email" name="email" required>

              <label for="telephone">Telephone</label>
              <input type="tel" placeholder="Telephone" name="telephone">

              <h4>Security</h4>

              <label for="pass">Password <span class="required-red">*</span></label>
              <input type="password" placeholder="Password" name="pass" required>

              <label for="pass_check">Re-type Password <span class="required-red">*</span></label>
              <input type="password" placeholder="Password" name="pass_check" required>

              <label for="hint">Enter Password Hint <span class="required-red">*</span></label>
              <input type="text" placeholder="Password Hint" name="hint" required>

            </div>
            <div class="col-md-6">

              <h4>Main Address</h4>

              <label for="street">Street <span class="required-red">*</span></label>
              <input type="text" placeholder="Street" name="street" required>

              <label for="houseNo">House No <span class="required-red">*</span></label>
              <input type="text" placeholder="House No" name="houseNo" required>

              <label for="flatNo">Flat No</label>
              <input type="text" placeholder="Flat No" name="flatNo">

              <label for="town">Town <span class="required-red">*</span></label>
              <input type="text" placeholder="Town" name="town" required>

              <label for="postcode">Postcode <span class="required-red">*</span></label>
              <input type="text" placeholder="Postcode" name="postcode" required>

            </div>
          </div> <!-- End of row -->

          <div class="row">
            <div class="col-md-12">
              <button class="register btn "type="submit" name="register">Create Account</button>
              <button class="clear btn" type="reset" name="clear">Clear</button>
            </div>
          </div>

        </form>

      </div>

    </section>