'use strict';
function MyAppConfig($stateProvider, $urlRouterProvider, $locationProvider,
		$httpProvider) {
	
	$urlRouterProvider.otherwise('/');
	$locationProvider.html5Mode(true);

	$stateProvider.state('home', {
		url : "/",
		templateUrl : "htmlcontent/home.html"
	})
	.state('login', {
		url : "/login",
		controller : 'CustomerController',
		controllerAs : 'vm',
		templateUrl : "htmlcontent/login.html"
			
	})
	.state('admin', {
		url : "/admin",
		controller : 'CustomerController',
		controllerAs : 'vm',
		templateUrl : "htmlcontent/admin.html"
	})
}
