app.controller('indexController', function($scope,Mlog) {
	$scope.mlogs = Mlog.query();
});