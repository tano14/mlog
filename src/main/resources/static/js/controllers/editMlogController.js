app.controller('editMlogController',function($scope,$routeParams,Mlog,$location){
	$scope.title = "Editando un log";
	$scope.mlog=Mlog.get({id:$routeParams.id});
	
	$scope.addMlog=function(mlog){
		mlog.$update().then(function (data){
		    $location.path("#/mlog/" + data.id);
		});
	};
	
	$scope.addCategory=function(){
		if($scope.mlog.categories == null){
			$scope.mlog.categories=[];
			
		}
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