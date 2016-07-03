import MainRouteConfig from './main-route.config';
import MainRun from './main.run';
import BeforeLoginModule from './beforelogin/beforelogin.module';
import Common from './common_modules/module';


angular.module('myapp', ['ui.router','ui.bootstrap', Common.name, BeforeLoginModule.name])
    .config(MainRouteConfig)
    .run(MainRun)
