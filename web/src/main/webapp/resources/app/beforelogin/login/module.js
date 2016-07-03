import LoginRouteConfig from './route.config';
import LoginController from './login.controller';

export default angular.module('myapp.beforelogin.login', [])
        .config(LoginRouteConfig)
        .controller('LoginController', LoginController)
