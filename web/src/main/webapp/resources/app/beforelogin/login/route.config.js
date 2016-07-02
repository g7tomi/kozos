function LoginRouteConfig($stateProvider) {
    "ngInject";
    $stateProvider
            .state('login',
					{
						url : '/login-page',
						controller : 'LoginController',
						controllerAs : 'vm',
						templateUrl : 'resources/dist/beforelogin/login/login.tpl'
                    })

}
export default LoginRouteConfig;