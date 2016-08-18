app.controller('showMlogController',function($scope, Mlog, $routeParams,$location,$sce){
	Mlog.get({id:$routeParams.id}).$promise.then(function(data){
		$scope.mlog=data;
		$scope.mlog.content=$sce.trustAsHtml(data.content);
		console.log($scope.mlog.content);
	});
	$scope.removeMlog=function(){
		Mlog.remove({id:$routeParams.id}).$promise.then(function(){
			$location.path('#/');
		});
	};
});
