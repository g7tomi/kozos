import MainRouteConfig from './main-route.config';
import MainRun from './main.run';
import BeforeLoginModule from './beforelogin/beforelogin.module';


angular.module('myapp', ['ui.router','ui.bootstrap', BeforeLoginModule.name])
.config(MainRouteConfig)
.run(MainRun)
.constant('URL_CONFIG', {
        'url': 'http://localhost:8080/web/',
    })