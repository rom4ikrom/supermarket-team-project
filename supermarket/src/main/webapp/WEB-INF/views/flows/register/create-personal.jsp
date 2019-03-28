<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp"%>

<section>
	<div class="container">
		
	<sf:form method="POST" class="create-acc-form personal"
			id="regiterForm"
			modelAttribute="user">

          <div class="row">
            <div class="col-md-12">
              <h2>Create Account</h2>
            </div>
          </div>

          <div class="row">
            <div class="col-md-6">
              <h4>Personal Information</h4>

              <label for="fname">First Name <span class="obligatory_field">*</span></label>
              <sf:errors path="firstName" cssClass="help-block" element="em"></sf:errors>
              <sf:input type="text" path="firstName" placeholder="First Name" name="fname"/>

              <label for="lname">Last Name <span class="obligatory_field">*</span></label>
              <sf:errors path="lastName" cssClass="help-block" element="em"></sf:errors>
              <sf:input type="text" path="lastName" placeholder="Last Name" name="lname" />

              <label for="email">Email <span class="obligatory_field">*</span></label>
              <sf:errors path="email" cssClass="help-block" element="em"></sf:errors>
              <sf:input type="email" path="email" placeholder="Email" name="email" />

              <label for="telephone">Telephone <span class="obligatory_field">*</span></label>
              <sf:errors path="tel" cssClass="help-block" element="em"></sf:errors>
              <sf:input type="text" path="tel" placeholder="Telephone" name="telephone" />
              
            </div>
            
            <div class="col-md-6">
            
              <h4>Security</h4>

              <label for="pass">Password <span class="obligatory_field">*</span></label>
              <sf:errors path="password" cssClass="help-block" element="em"></sf:errors>
              <sf:input type="password" path="password" placeholder="Password" />
              
              <label for="pass_check">Re-type Password <span class="obligatory_field">*</span></label>
              <sf:errors path="confirmPassword" cssClass="help-block" element="em"></sf:errors>
              <sf:input type="password" path="confirmPassword" placeholder="Password" />
              
              <label for="hint">Enter Password Hint <span class="obligatory_field">*</span></label>
              <sf:errors path="hint" cssClass="help-block" element="em"></sf:errors>
              <sf:input type="text" path="hint" placeholder="Password Hint" />
              
            </div>
            
          </div> <!-- End of row -->

          <div class="row">
            <div class="col-md-12">
              <button class="register btn" type="submit" name="_eventId_billing">Next - Billing
              	<span class="fa fa-chevron-right"></span>
              </button>
              <button class="clear btn" type="reset" name="clear">Clear</button>
            </div>
          </div>

        </sf:form>
		
	</div>
</section>

<%@include file="../shared/flows-footer.jsp"%>