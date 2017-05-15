function MyCtrl($scope, limitToFilter) {
  $scope.ideas = [
    ['ideas1', 1],
    ['ideas2', 8],
    ['ideas3', 5]
  ];
  
  $scope.limitedIdeas = limitToFilter($scope.ideas, 3);
}

