function RegistrationFactory($http, URL_CONFIG, toastr){
     "ngInject"
	
	var service = {
        registerUser: registerUser
	};
    return service;

    function registerUser(user) {
         
        $http.post(URL_CONFIG.url + '/register-user', user).then(success, error);
        
        function success(data) {
            console.log("success");
            toastr.success('Success', 'Successful registration');
        }
        
        function error(data) {
            console.log("success");
            toastr.error('Error', 'Something happened during the registration');
        }
    }
}

export default RegistrationFactory;
