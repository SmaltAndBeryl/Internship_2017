'use strict';

var app = angular.module('myAngularApp', []);
app.controller('loginCtrl',
				['$scope', '$http', 
				 	function($scope, $http){							
					
							$scope.login = function(){
								console.log(angular.toJson($scope.user));
								var loginControllerURI = "/loginUrl";
								console.log(loginControllerURI);
										console.log("click is working");
											$http({
												url : loginControllerURI,
												method : "POST",
												data : angular.toJson($scope.user),
												headers : {
															'Content-type': ''
															}
												
												}).then(function(response)
													{
												     console.log(response);
													});
													}
						}
				]);