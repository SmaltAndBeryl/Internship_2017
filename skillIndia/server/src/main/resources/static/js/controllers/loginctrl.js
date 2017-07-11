'use strict';

var app = angular.module('myAngularApp', []);
app.controller('loginCtrl',
				['$scope', '$http','$window', 
				 	function($scope, $http, $window){							
					
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
															'Content-type': 'application/json'
															}
												
												}).then(function(response)
													{
												     console.log(response.data);
												     var db=response.data;
												     if(db==1)
												     $window.alert('User is authenticated');
												     else
												    	 $window.alert('Unauthorised user'); 
													});
													}
						}
				]);