<form ng-submit="vm.registerUser(vm.user)" name="myForm">
    <input type="hidden" ng-model="vm.user.id" />
    <fieldset class="form-group">
        <div class="col-xs-4">
            <label for="formGroupExampleInput">Name</label> 
            <input type="text" class="form-control" ng-model="vm.user.name" id="uname" placeholder="Enter your name!">
        </div>
    </fieldset>
    <fieldset class="form-group">
        <div class="col-xs-4">
            <label for="formGroupExampleInput2">Age</label> 
            <input type="text" class="form-control" ng-model="vm.user.age" id="age" placeholder="Enter your age!">
        </div>
    </fieldset>
    <fieldset class="form-group">
        <div class="col-xs-4">
            <label for="formGroupExampleInput2">E-mail</label> <input type="email" class="form-control" ng-model="vm.user.email" id="email" placeholder="Enter your e-mail address!">
        </div>
    </fieldset>
    <div class="form-group">
        <div class="form-group col-md-7">
            <button class="btn btn-success custom-width" type="submit">Register</button>
            <button class="btn btn-warning btn-sm" ui-sref="login">Back</button>
        </div>
    </div>
</form>