'use strict';

angular.module('shopper')
    .service('productService' , ['$http', 'config', function($http, config){
        var productService = {};

        productService.getAllProducts = function(){
            return $http.get(config.apiUrl + '/product');
        }

        productService.addToCart = function(cart_id, product_id){
            var data = {
                'cart_id': cart_id,
                'product_id': product_id
            };

            return $http.post(config.apiUrl + '/cart/addProduct', data);
        }

        productService.removeFromCart = function(cart_id, product_id){
            var data = {
                'cart_id': cart_id,
                'product_id': product_id
            };

            return $http.post(config.apiUrl + '/cart/removeProduct', data);        
        }

        return productService;
    }]);