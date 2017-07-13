'use strict';

var newApp = angular.module('hello', []);
newApp.controller('loginCtrl',
				['$scope', '$http','$window', 
				 	function($scope, $http,){							
					
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
//												     console.log(response.data);
//												    if(response.data.userStatus="draft")
//														window.location = "http://localhost:8080/populateData";
//												    else
//												    	window.location = "http://localhost:8080/popup";
////												     if(db==1)
//												     $window.alert('User is authenticated');
//												     else
												    // $window.location.href = next.redirectTo;
//												    	 $window.alert('Unauthorised user'); 
													});
													}
							
							
						}
						
				]);




newApp.controller('signupCtrl',
				['$scope', '$http','$window', 
				 	function($scope, $http){							
					
					$scope.signup = function(){
						console.log(angular.toJson($scope.user));
						var signupControllerURI = "/signup";
						console.log(signupControllerURI);
						
								console.log("click is working");
									$http({
										url : signupControllerURI,
										method : "POST",
										data : angular.toJson($scope.newUser),
										headers : {
													'Content-type': 'application/json'
													}
										
										}).then(function(signUpResponse)
											{
										   console.log(signUpResponse.organizationName);
//										    if(userId==null) 
//											window.location = "http://localhost:8080/loginPage";
//										    else{
//										    	if($scope.newUser.userRole=="TP")
//													window.location = "http://localhost:8080/popup";
//										    	else
//													window.location = "http://localhost:8080/popup";

										    
											});
											}
				}
				]);