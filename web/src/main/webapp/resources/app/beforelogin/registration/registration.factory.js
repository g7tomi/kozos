function RegistrationFactory( $http, $q, URL_CONFIG){
     "ngInject"
	
	var service = {
        registerUser: registerUser
	};
    return service;

    function registerUser(user) {
        var deferred = $q.defer();
		deferred.resolve(	
            $http.post(URL_CONFIG.url + '/register-user', text)
        );
		     
		return deferred.promise;
    }
}

export default RegistrationFactory;
