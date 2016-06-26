'use strict';
function MyAppConfig($stateProvider, $urlRouterProvider, $locationProvider,
		$httpProvider) {
	
	$urlRouterProvider.otherwise('/login-page');
	$httpProvider.defaults.headers.common["X-Requested-With"] = 'XMLHttpRequest';
	$locationProvider.html5Mode(true);

	$stateProvider.state('login', {
		url : "/login-page",
		templateUrl : "htmlcontent/login.html"
	})
	.state('admin', {
		url : "/admin",
		controller : 'CustomerController',
		controllerAs : 'vm',
		templateUrl : "htmlcontent/admin.html"
			
	})
}
