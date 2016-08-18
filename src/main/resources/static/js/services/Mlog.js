app.factory('Mlog', function MlogFactory($resource){
  return $resource('http://localhost:8080/api/mlog/:id', {id: "@_id"},{
    update: {
      method: 'PUT'
    }
  });
});