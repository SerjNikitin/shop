angular.module('app').controller('productAdminEditController', function ($scope, $http, $localStorage, $location, $routeParams) {
    const contextPath = 'http://localhost:8080/api/v1'

    $scope.saveProduct = function () {
        console.log($scope.newProduct)
        $http.post(contextPath + "/product", $scope.newProduct)
            .then(function successCallback(response) {
                $scope.product = response.data;
            }, function errorCallback(response) {
                console.log(response)
            });
    };

    $scope.loadProduct = function (productId) {
        $http({
            url: "/api/v1/product/" + productId,
            method: "GET"
        }).then(function (response) {
            $scope.product = response.data;
            console.log($scope.product)
        });
    };

    if ($routeParams.productId) {
        $scope.loadProduct($routeParams.productId)
    }
});