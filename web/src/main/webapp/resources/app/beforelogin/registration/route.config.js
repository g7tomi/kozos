function RegistrationRouteConfig($stateProvider) {
    "ngInject";
    $stateProvider
            .state('registration',
					{
						url : '/registration',
						controller : 'RegistrationController',
						controllerAs : 'vm',
						templateUrl : 'resources/dist/beforelogin/registration/registration.tpl'
                    })

}
export default RegistrationRouteConfig;