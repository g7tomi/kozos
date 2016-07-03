function LoginRouteConfig($stateProvider, BASE_DIR) {
    "ngInject";
    $stateProvider
            .state('login',
					{
						url : '/login-page',
						controller : 'LoginController',
						controllerAs : 'vm',
						templateUrl :  BASE_DIR.path+'beforelogin/login/login.tpl'
                    })

}
export default LoginRouteConfig;