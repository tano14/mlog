app.controller('editMlogController',function($scope,$routeParams,Mlog,$location){
	$scope.title = "Editando un log";
	$scope.mlog=Mlog.get({id:$routeParams.id});
	
	$scope.addMlog=function(mlog){
		mlog.$update().then(function (data){
		    $location.path("#/mlog/" + data.id);
		});
	};
	
	$scope.tinymceOptions={
			menubar: false,
			height : 400,
			plugins: 'link image media',
			toolbar: 'undo redo | bold italic | image media link | styleselect | alignleft aligncenter alignright'
	}
});