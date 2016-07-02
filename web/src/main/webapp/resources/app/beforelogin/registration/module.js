import RegistrationRouteConfig from './route.config';
import RegistrationController from './registration.controller';

export default angular.module('myapp.beforelogin.registration', [])
    .config(RegistrationRouteConfig)
    .controller('RegistrationController', RegistrationController)