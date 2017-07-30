//restApp.controller('PetController',['$http','$scope','$resource','$location','flash', function($http,$scope,  $resource, $location, flash){
//	
//	function PetController($http) {
//      var vm = this;
//
//      vm.pets = [];
//      vm.getAll = getAll;
//      vm.getOne = getOne;
//      vm.deletePet = deletePet;
//
//      init();
//
//      function init(){
//          getAll();
//      }
//
//      function getAll(){
//          var url = "/api/pets";
//          var petsPromise = $http.get(url);
//          petsPromise.then(function(response){
//              vm.pets = response.data;
//              
//          });
//      }
//
//      function getOne(id){
//          var url = "/api/pets/" + id;
//          var petsPromise = $http.get(url);
//          petsPromise.then(function(response){
//              vm.pets = response.data;
//          });
//      }
//
//      function deletePet(id){
//      	
////          var url = "/api/pets/" + pet.id;
////          $http.delete(url,{'Content-Type': 'application/json'}).then(function(response){
////              vm.pets = response.data;
////              
////          });
//          
//          $http({  
//              method: "DELETE",  
//              url: "/api/pets/" + id,
//              data: null,
//              headers: {"Content-Type": "application/json" }  
//          }).then(function(response){
//              vm.pets = response.data;
//              getAll();
//          });  
//      }
//		
//		
//	}
//	
//    
//}]);
//
