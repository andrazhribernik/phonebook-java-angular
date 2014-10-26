angular.module('phonebookApp').controller('AddItemCtrl', function ($scope, $modalInstance, item, modalType) {

  $scope.newItem = item;
  console.log(modalType);
  $scope.ok = function () {
    $modalInstance.close({
      item: $scope.newItem,
      modalType: modalType	
    });
  };

  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
});