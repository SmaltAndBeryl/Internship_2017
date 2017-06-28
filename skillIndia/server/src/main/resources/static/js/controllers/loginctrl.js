var app = angular.module('myAngularApp', []);
app.controller('loginCtrl',
				['$scope', '$http', 
				 	function($scope, $http){
					
							var formModel = {
												userName : $scope.userName,
												password : $scope.password
											};
					
							$scope.login = function(){
						
											console.log("click is working");
											//var parseJSON = JSON.parse(formModel);
											//console.log(formModel.data);
											$http.post('/loginUrl', formModel)
											.then(function(response)
													{
													console.log(response.status);
													},function()
													{
														
													});
													}
						}
				]);