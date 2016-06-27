'use strict';

function CustomerService($http, $q) {
	return {
		fetchAllUsers: function() {
			return $http.get('admin/getCustomers').then(function(response) {
				return response.data;
			}, function(errResponse) {
				console.error('Error while fetching users');
				return $q.reject(errResponse);
			});
		},
		createUser: function(customer) {
			var request = {
				customer: customer
			};
			console.info('service request', angular.toJson(request));
			return $http({
                url: 'admin/addCustomer',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                },
                dataType: "json",
                method: "POST",
                data: JSON.stringify(request)
			})
			.then(function(response) {
				return response.data;
			}, function(errResponse) {
				console.error('Error while creating user');
				return $q.reject(errResponse);
			});
		},
		
		deleteUser: function(customerId) {
			
			var request = {
					id: customerId
			};
	
			return $http({
                url: 'admin/deleteCustomer',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                },
                dataType: "json",
                method: "POST",
                data: JSON.stringify(request)
			})
			.then(function(response) {
				return response.data;
			}, function(errResponse) {
				console.error('Error while creating user');
				return $q.reject(errResponse);
			});
		},
		
		editUser: function(customer) {
			var request = {
				customer: customer
			};
			
			return $http({
                url: 'admin/editCustomer',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                },
                dataType: "json",
                method: "POST",
                data: JSON.stringify(request)
			})
			.then(function(response) {
				return response.data;
			}, function(errResponse) {
				console.error('Error while creating user');
				return $q.reject(errResponse);
			});
		},
		
		sendEmailToCustomer: function(request) {
			console.info('service request', angular.toJson(request));
			return $http({
                url: 'admin/sendEmail',
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/json',
                },
                dataType: "json",
                method: "POST",
                data: JSON.stringify(request)
			})
			
		}
	}
};