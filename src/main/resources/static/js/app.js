var app = angular.module('app', ['ngRoute','ngResource','ui.tinymce','angular.filter']);
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
            controller: 'addMlogController'
        })
        .when('/mlog/:id',{
        	templateUrl: '/views/post.html',
        	controller: 'showMlogController'
        })
        .when('/mlog/:id/edit',{
        	templateUrl: '/views/add.html',
        	controller: 'editMlogController'
        })
        .otherwise(
            { redirectTo: '/home'}
        );
});

app.filter('cut', function () {
    return function (value, max) {
        if (!value) return '';

        max = parseInt(max, 10);
        if (!max) return value;
        if (value.length <= max) return value;

        value = value.substr(0, max);
        var lastspace = value.lastIndexOf(' ');
        if (lastspace != -1) {
          //Also remove . and , so its gives a cleaner result.
          if (value.charAt(lastspace-1) == '.' || value.charAt(lastspace-1) == ',') {
            lastspace = lastspace - 1;
          }
          value = value.substr(0, lastspace);
        }
        

        return value + '...';
    };
});

app.filter('htmlToPlaintext', function() {
    return function(text) {
        text = text ? String(text).replace(/(<([^>]+)>)/ig, '') : '';
        return text ? String(text).replace(/&nbsp;/ig, '') : '';
      };
    });