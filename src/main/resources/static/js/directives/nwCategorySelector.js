app.directive("nwCategorySelector", function(Category){
	return {
		restrict: 'E',
		templateUrl: '/views/categorySelector.html',
		link: function(scope){
			scope.categories = Category.query();
		}
	}
});