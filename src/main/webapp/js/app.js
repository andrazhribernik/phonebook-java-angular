
var app = angular.module('phonebookApp', ['ui.bootstrap', 'ngRoute', 'itemService']);

app.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/', {
    templateUrl: 'views/phonebook.html',
    controller: 'PhonebookCtrl',
  }).otherwise({
      redirectTo: '/'
  });
}]);
