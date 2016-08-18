app.controller('addMlogController', function($scope,Mlog,$location){
	
	$scope.title = "Escribiendo nuevo log";
	$scope.mlog=new Mlog();
	$scope.addMlog=function(mlog){
		mlog.$save().then(function(data){
			$location.path("#/");
		});
	};
	$scope.tinymceOptions={
			menubar: false,
			height : 400,
			plugins: 'link image media',
			toolbar: 'undo redo | bold italic | image media link | styleselect | alignleft aligncenter alignright'
	}
});