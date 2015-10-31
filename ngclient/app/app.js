'use strict';
// Declare app level module which depends on views, and components
angular
		.module('myApp', [ 'myApp.version', 'ngResource' ])
		.factory('CityListServer', [ '$resource', function($resource) {
			return $resource('cities', {}, {
				query : {// result is array
					method : 'GET',
					isArray : true,
					transformResponse : function(data) {
						return angular.fromJson(data);
					}
				}
			});
		} ])
		.factory('WeatherServer', [ '$resource', function($resource) {
			return $resource('current/:cityId', {}, {
				get : {
					method : 'GET',
					params : {
						cityId : '@cityId'
					},
					isArray : false
				}
			});
		} ])
		.factory(
				'WeatherService',
				[
						'$log',
						'CityListServer',
						'WeatherServer',
						function($log, CityListServer, WeatherServer) {

							return {
								getCityList : function() {
									// query city list
									var cities = CityListServer.query();
									cities.$promise
											.then(
													function(data) {
														// This is where things
														// that happen upon
														// success go
														$log
																.debug("-> got city list successfully: "
																		+ angular
																				.toJson(data));
													},
													function(data) {
														// This is where things
														// that happen upon
														// error go
														$log
																.debug("-> failed to get city list");
													});
									return cities;
								},
								getCurrentWeather : function(cityId) {
									var currentWeather = WeatherServer.get({
										cityId : cityId
									});

									currentWeather.$promise
											.then(
													function(data) {
														console
																.log("-> got current weather successfully: "
																		+ angular
																				.toJson(data));
													},
													function(data) {
														$log
																.debug("-> failed to get current weather for city "
																		+ cityId);
													});

									return currentWeather;
								}
							};
						} ])
				.controller('myAppCtrl', ['$scope', 'WeatherService', function($scope, WeatherService) {

					$scope.cities = WeatherService.getCityList();
					
					$scope.getCurrentWeather = function(selectedCity){
						$scope.currentWeather = WeatherService.getCurrentWeather(selectedCity.id);
					}
					
				} ]);
