angular.module('admin').controller('productAdminListController', function ($scope, $http, $localStorage, $location, $routeParams) {
    const contextPath = 'http://localhost:8080/api/v1'

    $scope.loadProducts = function (pageNumber) {
        console.log("call")
        $http({
            url: "/api/v1/product",
            method: "GET"
        }).then(function (response) {
            $scope.products = response.data;
            console.log($scope.products)
        });
    };

    $scope.editProduct = function(productId) {
        $location.path('/admin/product/edit/' + productId);
    }
    $scope.createProduct = function() {
        $location.path('/admin/product/create/');
    }

    $scope.saveProduct = function () {
        $http.post(contextPath + "/product", $scope.newProduct)
            .then(function successCallback(response) {
                console.log(response);
                $scope.loadProducts(1);

            }, function errorCallback(response) {
                console.log(response)

            });
    };

    $scope.loadProducts(1)
});