angular.module('phonebookApp').controller('PhonebookCtrl', [
  '$scope', 'Items', '$modal', function($scope, Items, $modal) {
	  
	  $scope.getItems = function(){
		$scope.items = Items.query();
	  };
	  
	  $scope.addItem = function(item) {
	    Items.save($scope.newItem, function() {
	      $scope.newItem = new Items();
	      $scope.success = true;
	      $scope.getItems();
		});
	  }
	  
	  $scope.open = function () {

	    var modalInstance = $modal.open({
	      templateUrl: 'views/addItem.html',
	      controller: 'AddItemCtrl',
	      resolve: {
	        item: function () {
	          return $scope.newItem;
	        }
	      }
	    });
	    
	    modalInstance.result.then(function (item) {
	      $scope.addItem(item)
	      console.log(item);
	    }, function () {
	      console.log('Modal dismissed at: ' + new Date());
	      $scope.success = false;
	    });
	    
	  };
	  
	  $scope.getItems();
	  $scope.newItem = new Items();
  }
 ]);