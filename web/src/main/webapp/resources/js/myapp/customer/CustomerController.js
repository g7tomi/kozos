'use strict';
function CustomerController(CustomerService) {
	var vm = this;
	vm.customer = {
		id: null
	};
	vm.customers = [];
	vm.messages;
	vm.email;

	function fetchAllUsers() {
		CustomerService.fetchAllUsers().then(function(data) {
			vm.customers = data;
			console.log('Customers: ', vm.customers);
		}, function(errResponse) {
			console.error('Error while fetching Customers');
		});
	};
	
	fetchAllUsers();
	
	function createUser(customer) {
		CustomerService.createUser(customer).then(
				function(data) {
					vm.messages = data.message;
					fetchAllUsers();
					console.log('response after adding:', data);
				}, function(errResponse) {
					console.error('Error while creating Customer.');
				});
	};
	
	function editUser(customer) {
		CustomerService.editUser(customer).then(
				function(data) {
					fetchAllUsers();
					console.log('response after editing: ', data);
				}, function(errResponse) {
					console.error('Error while editing Customer.');
				});
	};
	
	vm.deleteUser = function(customerId) {
		CustomerService.deleteUser(customerId).then(function(data) {
					vm.messages = data.message;
					console.log('response after adding:', data);
					fetchAllUsers();
				}, function(errResponse) {
					console.error('Error while creating Customer.');
				});
	};
	
	vm.getCustomerById = function getCustomer(customerId) {
		var customers = angular.copy(vm.customers.customer);
		angular.forEach(customers, function(value,key) {
			console.log(key + ': ' + value.name);
			if (value.id == customerId) {
				vm.customer = value;
				console.log('Selected customer loaded to vm.user:', vm.customer);
			}
		});
	};
	
	vm.submit = function submit() {
		if (vm.customer.id === null) {
			console.log('Saving new user', vm.customer);
			createUser(vm.customer);
		} else {
			console.log('User updated with id', vm.customer.id);
			editUser(vm.customer);
		}
		reset();
	};
	
	function reset() {
		vm.customer = {};
	}
	
};

CustomerController.$inject = ['CustomerService'];
