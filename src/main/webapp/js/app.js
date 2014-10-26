
var app = angular.module('phonebookApp', ['ngRoute']);

app.config([
    '$routeProvider', function($routeProvider) {
      $routeProvider.when('/', {
        templateUrl: 'views/phonebook.html',
        controller: 'PhonebookCtrl',
      }).otherwise({
          redirectTo: '/'
      });
    }]);
