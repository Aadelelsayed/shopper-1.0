'use strict';

var app = angular.module('shopper', ['ngRoute', 'ngStorage']);

app.constant('config', {
    apiUrl: 'http://localhost:8080'
});

app.config(function ($routeProvider, $locationProvider) {
    $routeProvider
      .when('/', {
        templateUrl: '/static/app/views/products/index.html',
        controller: 'ProductController'
      })
      .otherwise({
        redirectTo: '/'
      });

    $locationProvider.html5Mode(true);
  });