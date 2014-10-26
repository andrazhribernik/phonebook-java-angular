angular.module('itemService', ['ngResource']).
    factory('Items', function($resource){
  return $resource('rest/items/:id', { id: '@id' }, {
	  update: {
	    method: 'PUT' 
	  }
    });
});