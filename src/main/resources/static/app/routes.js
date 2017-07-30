//routes
restApp.config(function ( $routeProvider ){

    $routeProvider
    .when('/',{
    	templateUrl: 'pages/login.html',
    	controller: 'LoginController'
    })
    

    .when('/addpet',{
    	resolve:{
    		"check": function($location,$cookies){
    			if(!$cookies.get('loggedIn')){
    				$location.path('/');
    			}
    		}
    	},    
        templateUrl: 'pages/addpet.html',
        controller: 'PetController as vm'
        
    })
    
    .when('/viewpets',{
    	resolve:{
    		"check": function($location,$cookies){
    			if(!$cookies.get('loggedIn')){
    				$location.path('/');
    			}
    		}
    	}, 
        templateUrl: 'pages/viewpets.html',
        controller: 'PetController as vm'
    })
    
    .when('/searchpet',{
    	resolve:{
    		"check": function($location,$cookies){
    			if(!$cookies.get('loggedIn')){
    				$location.path('/');
    			}
    		}
    	}, 
        templateUrl: 'pages/searchpet.html',
        controller: 'PetController as vm'
    })
    .otherwise({redirectTo:'/'})
    
});