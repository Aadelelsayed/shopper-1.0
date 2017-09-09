'use strict';

angular.module('shopper')
    .service('CartService', ['$http', 'config', function($http, config){
        var CartService = {};

        CartService.createCart = function() {
            return $http.post(config.apiUrl + '/cart/create?session_id=' + randomString(20));   
        }

        CartService.getCart = function(id){
            return $http.get(config.apiUrl + '/cart/get?id=' + id);
        }
        
        var randomString = function(length) {
            var text = "";
            var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            for(var i = 0; i < length; i++) {
                text += possible.charAt(Math.floor(Math.random() * possible.length));
            }
            return text;
        }

        return CartService;
    }]);