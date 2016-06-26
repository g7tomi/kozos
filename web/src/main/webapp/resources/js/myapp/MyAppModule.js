angular.module('myApp', ['ui.router','ui.bootstrap'])
	.config(MyAppConfig)
	.controller('CustomerController', CustomerController)
	.factory('CustomerService', CustomerService);