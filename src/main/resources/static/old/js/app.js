var app = angular.module('app', ['ngRoute','ngResource']);
app.config(function($routeProvider){
    $routeProvider
	    .when('/', {
	        redirectTo: '/home'
	      })
        .when('/home',{
            templateUrl: '/views/index.html',
            controller: 'indexController'
        })
        .when('/mlog/add',{
            templateUrl: '/views/add.html',
            controller: 'mlogController'
        })
        .otherwise(
            { redirectTo: '/home'}
        );
});

