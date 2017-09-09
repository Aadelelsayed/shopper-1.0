'use strict';

angular.module('shopper')
    .component('productComponent', {
        templateUrl: '/static/app/views/products/product.html',
        restrict: 'E',
        bindings: {
            item: '@'
        },
        controller: ['$scope', 'productService', function($scope, productService) {
            console.log(this);
            $scope.addToCart = function(productId){

            }
        }]
    });