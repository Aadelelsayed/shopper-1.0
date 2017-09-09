'use strict';

angular.module('shopper')
    .controller('ProductController', ['$scope', 'productService', 'CartService', '$localStorage', 
        function($scope, productService, CartService, $localStorage){
            $scope.products = [];
            $scope.cart = {
                "id": $localStorage.cart_id,
                "products": []
            };
            $scope.loading = true;
            
            var getProducts = function(){
                productService.getAllProducts()
                    .then(function(res){
                        if($scope.cart.products != null && $scope.cart.products.length > 0){
                            res.data.forEach(function(product){
                              $scope.cart.products.forEach(function(item){
                                  if(item.id == product.id){
                                    product.isInCart = true;
                                  }
                              });
                            });
                        }

                        $scope.products = res.data;
                        $scope.loading = false;
                    })
            }

            $scope.addToCart = function(id){
                productService.addToCart($scope.cart.id, id)
                    .then(function(res){
                        $scope.products.forEach(function(item){
                            if(item.id == id){
                                $scope.cart.products.push(item);
                                item.isInCart = true;
                            }
                        })
                    });
            }

            $scope.cartTotal = function(){
                var total = 0;

                $scope.cart.products.forEach(function(item){
                    total += item.price;
                })

                return total;
            }

            $scope.removeFromCart = function(id){
                 $scope.cart.products.forEach(function(item, index){
                    if(item.id == id){
                        $scope.cart.products.splice(index, 1);
                    }
                });

                $scope.products.forEach(function(item){
                    if(item.id == id){
                        item.isInCart = false;
                    }
                });

                productService.removeFromCart($scope.cart.id, id)
                    .then(function(res){
                       
                    });
            }

            var createCart = function(){
                CartService.createCart()
                    .then(function(res){
                        $localStorage.cart_id = res.data.id;
                        $scope.cart.id = res.data.id;

                        getProducts();
                    });
            }

            if($scope.cart.id == null || $scope.cart.id == ''){
                createCart();
            } else {
                CartService.getCart($localStorage.cart_id)
                    .then(function(res){
                        $scope.cart = res.data;
                        getProducts();
                    }, function(err){
                        if(err){
                            createCart();
                        }
                    })
            }           
        }]);