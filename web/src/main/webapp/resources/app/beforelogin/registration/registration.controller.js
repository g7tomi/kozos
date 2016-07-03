'use strict';
function RegistrationController(RegistrationFactory) {
      "ngInject"
    var vm = this;
        
    vm.registerUser = registerUser;
    
    function registerUser(user) {
        RegistrationFactory.registerUser(user);
    }
} 

export default RegistrationController;
