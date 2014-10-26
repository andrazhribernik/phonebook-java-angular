angular.module('phonebookApp').controller('AddItemCtrl', function ($scope, $modalInstance, item) {

  $scope.newItem = item;
  console.log(item);
  $scope.ok = function () {
    $modalInstance.close($scope.newItem);
  };

  $scope.cancel = function () {
    $modalInstance.dismiss('cancel');
  };
});