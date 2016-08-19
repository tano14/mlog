app.controller('addMlogController', function($scope,Mlog,$location){
	
	$scope.title = "Escribiendo nuevo log";
	$scope.mlog=new Mlog();
	$scope.mlog.categories=[];
	$scope.addMlog=function(mlog){
		mlog.$save().then(function(data){
			$location.path("#/");
		});
	};
	$scope.addCategory=function(){
		$scope.mlog.categories.push($("#category").val());
		$("#category").val('');
	};
	
	$scope.removeCategory=function(category){
		var index = $scope.mlog.categories.indexOf(category);
		$scope.mlog.categories.splice(index,1);
	};
	
	$scope.tinymceOptions={
			menubar: false,
			height : 400,
			plugins: 'link image media',
			toolbar: 'undo redo | bold italic | image media link | styleselect | alignleft aligncenter alignright'
	}
});