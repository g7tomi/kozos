import Login from './login/module';
import Registration from './registration/module';

export default angular.module('myapp.beforelogin', [Login.name,Registration.name])

