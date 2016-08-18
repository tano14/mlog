app.factory('Category', function CategoryFactory($resource){
	return $resource('http://localhost:8080/cat/:id', {id: "@_id"},{
    update: {
      method: 'PUT'
    }
  });
});