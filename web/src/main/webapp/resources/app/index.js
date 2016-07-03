import MainRouteConfig from './main-route.config';
import MainRun from './main.run';
import BeforeLoginModule from './beforelogin/beforelogin.module';
import Common from './common_modules/module';
import Admin from './admin/module';


angular.module('myapp', ['ui.router','ui.bootstrap','ngAnimate', 'toastr', Common.name, BeforeLoginModule.name, Admin.name])
    .config(MainRouteConfig)
    .run(MainRun)
