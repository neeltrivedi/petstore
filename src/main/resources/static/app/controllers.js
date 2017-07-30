(function () {
    'use strict';

    angular
        .module('restApp')
        .controller('PetController', PetController);

    PetController.$inject = ['$http','$scope','$location','$rootScope'];

    function PetController($http,$scope,$location,$rootScope,$cookies) {

    	if(sessionStorage.loggedIn != null){
    		$rootScope.permission = sessionStorage.loggedIn;
    	}

    	if(sessionStorage.role != null){
    		$rootScope.role = sessionStorage.role;
    	}
		
        var vm = this;

        vm.pets = [];
        vm.getAll = getAll;
        vm.getOne = getOne;
        vm.deletePet = deletePet;
        vm.addPet=addPet;
        
        init();

        function init(){
            getAll();
        }

        function getAll(){
            var url = "/api/pets";
            var petsPromise = $http.get(url);
            petsPromise.then(function(response){
                vm.pets = response.data;
                
            });
        }

        function getOne(id){
        	$scope.pet=null;
            var url = "/api/pets/" + id;
            var petsPromise = $http.get(url);
            petsPromise.then(function(response){
                vm.pets = response.data;
                $scope.pet=vm.pets;
            });
        }

        function deletePet(id){
           
            $http({  
                method: "DELETE",  
                url: "/api/pets/" + id,
                data: null,
                headers: {"Content-Type": "application/json" }  
            }).then(function(response){
                vm.pets = response.data;
                getAll();
            });  
        }
        
        function addPet(pet){
          $http({  
              method: "POST",  
              url: "/api/pets/",
              data: {
            		"name": pet.name,
            		"photoUrl": pet.photoUrl,
            		"status":pet.status
            	},
              headers: {"Content-Type": "application/json" }  
          }).then(function(response){
              vm.pets = response.data;
              alert("Pet Successfully Added");
              $location.path('/viewpets');
          });  
      }
        
    }
})();

restApp.controller('LoginController',['$scope','$location','$rootScope','$cookies',function($scope,$location,$rootScope,$cookies){

	$scope.submit = function(){
		if($scope.username == 'admin' && $scope.password == 'admin'){

			var loggedIn = $cookies.get('loggedIn');
			$cookies.put('loggedIn', 'yes');

			var role = $cookies.get('role');
			$cookies.put('role', 'admin');
			
			$rootScope.permission = $cookies.get('loggedIn');
			$rootScope.role = $cookies.get('role');
			
			sessionStorage.loggedIn = 'yes';
			sessionStorage.role = 'admin';
			$location.path('/viewpets');
		}
		else if($scope.username == 'user' && $scope.password == 'user'){
			
			var loggedIn = $cookies.get('loggedIn');
			$cookies.put('loggedIn', 'yes');
			
			var role = $cookies.get('role');
			$cookies.put('role', 'user');
			
			$rootScope.permission = $cookies.get('loggedIn');
			$rootScope.role = $cookies.get('role');
			
			sessionStorage.loggedIn = 'yes';
			sessionStorage.role = 'user';
			$location.path('/viewpets');
		}
		else{
			alert("Invalid credentials");
		}
	}
	
	$scope.logout = function(){

		sessionStorage.clear();
		$rootScope.permission= null;
		$rootScope.role= null;
		$cookies.remove("loggedIn");
		$cookies.remove("role");
		$location.path('/');
	}
		
}]);
