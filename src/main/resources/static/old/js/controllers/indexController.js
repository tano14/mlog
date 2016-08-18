app.controller('indexController', function($scope,Mlog) {
	console.log("pasa por el index controller");
	$scope.mlogs = Mlog.query();
});