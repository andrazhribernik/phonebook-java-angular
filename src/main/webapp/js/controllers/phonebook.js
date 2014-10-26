angular.module('phonebookApp').controller('PhonebookCtrl', [
  '$scope', 'Items', '$modal', function($scope, Items, $modal) {
	  
	  $scope.getItems = function(){
		$scope.items = Items.query();
	  };
	  
	  $scope.addItem = function(item) {
	    Items.save(item, function() {
	      $scope.success = true;
	      $scope.message = "Item has been added successfully.";
	      $scope.getItems();
		});
	  };
	  
	  $scope.removeItem = function(item) {
		 
	    Items.delete(item, function() {
	      $scope.success = true;
	      $scope.message = "Item has been deleted.";
		  $scope.getItems();	
	    });
	  };
	  
	  var editItem = function(item) {
	    item.$update(function() {
	      $scope.success = true;
		  $scope.message = "Item has been updated.";
	      $scope.getItems();  
	    });
	  }
	  
	  $scope.edit = function(item) {
		$scope.newItem = angular.copy(item);
	    open('edit');
	  };
	  
	  $scope.add = function(item) {
		$scope.newItem = new Items();
	    open('add');
	  };
	  
	  var open = function (type) {

	    var modalInstance = $modal.open({
	      templateUrl: 'views/addItem.html',
	      controller: 'AddItemCtrl',
	      resolve: {
	        item: function () {
	          return $scope.newItem;
	        },
	        modalType: function() {
	          return type;	
	        }
	      }
	    });
	    
	    
	    modalInstance.result.then(function (response) {
	      if (response.modalType == 'add') {	
	    	$scope.addItem(response.item)
	      }
	      else if (response.modalType == 'edit') {
	    	editItem(response.item);
	      }
	    }, function () {
	      console.log('Modal dismissed at: ' + new Date());
	      $scope.success = false;
	    });
	    
	  };
	  
	  $scope.getItems();
	  $scope.newItem = new Items();
  }
 ]);