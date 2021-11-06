(function ($localStorage) {
    'use strict';

    angular
        .module('admin', ['ngRoute', 'ngStorage', 'ngCookies'])
        .config(config);

    function config($routeProvider, $httpProvider) {
        $routeProvider
            .when('/admin/product/list', {
                templateUrl: 'admin/product/list/list.html',
                controller: 'productAdminListController',
            })
            .when('/admin/product/edit/:productId', {
                templateUrl: 'admin/product/edit/edit.html',
                controller: 'productAdminEditController',
            })
            .when('/admin/product/edit', {
                templateUrl: 'admin/product/edit/edit.html',
                controller: 'productAdminEditController',
            })
            .otherwise({
                redirectTo: '/admin/product/list'
            });
    }
})(angular.window);
angular.module('app').controller('adminController', function
    ($scope, $http, $localStorage, $location, $routeParams) {
});
