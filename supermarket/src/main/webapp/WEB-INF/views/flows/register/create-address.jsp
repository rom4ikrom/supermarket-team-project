<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@include file="../shared/flows-header.jsp"%>

<section>
	<div class="container">
		
	<sf:form method="POST" class="create-acc-form billing"
			id="registerForm"
			modelAttribute="billing">

          <div class="row">
            <div class="col-md-12">
              <h2>Billing Address Information</h2>
            </div>
          </div>

          <div class="row">
            
            <div class="col-md-6">

              <label for="addLineOne">Address Line One <span class="obligatory_field">*</span></label>
              <sf:errors path="addressLineOne" cssClass="help-block" element="em"></sf:errors>
              <sf:input type="text" path="addressLineOne" placeholder="Address Line One" name="addLineOne" />

              <label for="addLineTwo">Address Line Two <span class="obligatory_field">*</span></label>
              <sf:errors path="addressLineTwo" cssClass="help-block" element="em"></sf:errors>
              <sf:input type="text" path="addressLineTwo" placeholder="Address Line Two" name="addLineTwo" />
              
              <label for="town">Town <span class="obligatory_field">*</span></label>
              <sf:errors path="town" cssClass="help-block" element="em"></sf:errors>
              <sf:input type="text" path="town" placeholder="Town" name="town" />
                         
            </div>
            
            <div class="col-md-6">
            
              <label for="county">County / State</label>
              <sf:input type="text" path="county" placeholder="County" name="county" />

              <label for="postcode">Postcode <span class="obligatory_field">*</span></label>
              <sf:errors path="postcode" cssClass="help-block" element="em"></sf:errors>
              <sf:input type="text" path="postcode" placeholder="Postcode" name="postcode" />
              
              <label for="country">Country <span class="obligatory_field">*</span></label>
              <sf:errors path="country" cssClass="help-block" element="em"></sf:errors>
              <sf:input type="text" path="country" placeholder="Country" name="country" />
              
            </div>
            
          </div> <!-- End of row -->

          <div class="row">
            <div class="col-md-4 text-center">
           	  <button class="btn" id="back" type="submit" name="_eventId_personal">
           	  	<span class="fa fa-chevron-left"></span> Personal
           	  </button>
           	 </div>
           	 
           	 <div class="col-md-4 text-center">
              <button class="register btn "type="submit" name="_eventId_confirm">Confirm
              	<span class="fa fa-chevron-right"></span>
              </button>
             </div>
             
             <div class="col-md-4 text-center">
              <button class="clear btn" type="reset" name="clear">Clear</button>
            </div>
          </div>

        </sf:form>
		
	</div>
</section>

<%@include file="../shared/flows-footer.jsp"%>