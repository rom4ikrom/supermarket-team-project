<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<section>
	<div class="container">

		<!-- Form elements -->
		<sf:form modelAttribute="product"
			action="${contextRoot}/manage/products" method="POST"
			enctype="multipart/form-data"
			class="form-manage-products">
			<h3>Product Management</h3>
			<div class="row">
			
				<c:if test="${not empty message}">
				<c:choose>
				<c:when test="${status == false}">
					<div class="col-md-12">
						<div class="alert alert-success alert-dismissible valid-failed">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							
							${message}
							
						</div>
					</div>
				</c:when>
				<c:otherwise>
					<div class="col-md-12">
						<div class="alert alert-success alert-dismissible">
							<button type="button" class="close" data-dismiss="alert">&times;</button>
							
							${message}
							
						</div>
					</div>
				</c:otherwise>
				</c:choose>
					
				</c:if>
				

				<div class="col-md-6">

					<label for="name">Fruit Name</label>
					<sf:errors path="name" cssClass="help-block" element="em"></sf:errors>
					<sf:input class="form-input" type="text" path="name" placeholder="Fruit Name" name="name"/>
					
					<label for="variety">Variety</label>
					<sf:errors path="variety" cssClass="help-block" element="em"></sf:errors>
					<sf:input class="form-input" type="text" path="variety" placeholder="Variety" name="variety"/>

					<label for="file">Select an Image</label>
					<sf:errors path="file" cssClass="help-block" element="em"></sf:errors>
					<sf:input class="form-input" path="file" style="height: 54px;" type="file" name="file"/>

					<label for="description">Description</label>
					<sf:errors path="description" cssClass="help-block" element="em"></sf:errors>
					<sf:textarea class="form-input" path="description" rows="5" cols="1" placeholder="Description" name="description"></sf:textarea>
					
				</div>

				<div class="col-md-6">

					<label for="price">Price</label>
					<sf:errors path="price" cssClass="help-block" element="em"></sf:errors>
					<sf:input class="form-input" path="price" type="number" placeholder="Price in &#163;" name="price"/>

					<label for="qnty">Quantity</label>
					<sf:errors path="quantity" cssClass="help-block" element="em"></sf:errors>
					<sf:input class="form-input" path="quantity" type="number" placeholder="0.0" name="qnty"/>
					
					<label for="country">Country</label>
					<sf:errors path="country" cssClass="help-block" element="em"></sf:errors>
					<sf:input class="form-input" path="country" type="text" placeholder="Country" name="country"/>

					<label for="regionId">Select Region</label>
					
					<div class="select-style">
					
					<sf:select path="regionId" 
							id="categoryId" 
							items="${regions}" 
							itemLabel="name" 
							itemValue="id">
					</sf:select>
					
					</div>
					
					<label for="supplierId">Select Supplier</label>
					
					<div class="select-style">
					
					<sf:select path="supplierId" 
							id="supplierId" 
							items="${suppliers}" 
							itemLabel="companyName" 
							itemValue="id">
					</sf:select>
					
					</div>
					
				</div>
			</div><!-- End of row -->

			<div class="row">
				<div class="col-md-6 text-center">
					<input class="btn register" type="submit" name="submit" value="Add Product"/>
				</div>
				<div class="col-md-6 text-center">
					<input class="btn cancel" type="reset" value="Clear"/>
				</div>
			</div><!-- End of row -->
			
			<!-- Hidden fields for product -->
			<sf:hidden path="id" />
			<sf:hidden path="code" />
			<sf:hidden path="active" />
			<sf:hidden path="purchases" />
			<sf:hidden path="views" />
		</sf:form>

	</div>
	<!-- End of row -->

</section>

<section>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
			
				<h3>Available Products</h3>
				
				<div class="container-fluid">
					<div class="table-responsive">
						
						<!-- Products table for Admin -->
						<table id="adminProductsTable"
							class="table table-striped table bordered">
								
								<thead>

									<tr>
										<th>Id</th>
										<th>Image</th>
										<th>Name</th>
										<th>Variety</th>
										<th>Country</th>
										<th>Price 1kg</th>
										<th>Qty</th>
										<th>Active</th>
										<th>Edit</th>

									</tr>

								</thead>

								<tfoot>

									<tr>
										<th>Id</th>
										<th>Image</th>
										<th>Name</th>
										<th>Variety</th>
										<th>Country</th>
										<th>Price 1kg</th>
										<th>Qty</th>
										<th>Active</th>
										<th>Edit</th>

									</tr>

								</tfoot>
						
						</table>
						
					</div>
				</div>
				
			</div>
		</div><!-- End of row -->
	</div>
</section>
