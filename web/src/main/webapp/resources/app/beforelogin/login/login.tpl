<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">
			<div class="login-panel panel panel-primary">
				<div class="panel-heading">
					<h3 class="panel-title">Please login</h3>
				</div>
				<div class="panel-body">
					<form name="loginform" role="form" action="/web/login"
						method="POST">
						<fieldset>
							<div class="form-group">
								<input class="form-control" type="text" name="username"
									id="username" required 
									placeholder="username"> 
							</div>
							<div class="form-group">
								<input class="form-control" type="password" name="password"
									required class="form-control"
									id="password" placeholder="password"> 
							</div>
							<button class="btn btn-primary" type="submit">Login</button>
							<button class="btn btn-primary" ui-sref="registration">Registration</button>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>