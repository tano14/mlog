app.controller('mlogController', function($scope,Mlog){
	
	$scope.title = "Escribiendo nuevo log";
	$scope.mlog=new Mlog();
	$scope.addMlog=function(mlog){
		mlog.$save().then(function(data){
			console.log("guardado");
		});
	};
	
});