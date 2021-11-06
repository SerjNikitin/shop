(function ($localStorage) {
    'use strict';

    angular
        .module('app', ['ngRoute', 'ngStorage', 'ngCookies'])
        .config(config);

    function config($routeProvider, $httpProvider) {
        $routeProvider
            .when('/product/list', {
                templateUrl: 'product/list/list.html',
                controller: 'productListController',
            })
            .when('/product/info/:productId', {
                templateUrl: 'product/info/info.html',
                controller: 'productInfoController',
            })
            .when('/admin', {
                templateUrl: 'admin/admin.html',
                controller: 'adminController',
            })
            .otherwise({
                redirectTo: '/product/list'
            });
    }
})(angular.window);