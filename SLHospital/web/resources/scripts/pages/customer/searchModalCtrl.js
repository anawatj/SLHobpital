/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

app.controller('customerSerchModalCtrl', function (
        $scope,
        $http,
        $q,
        $pageUtils,
        $modalInstance,
        params
        )
{
    $scope.model =
            {
                code:params.code,
                flagPersonal: "N",
                flagCompany: "N",
                page: 1
            };
    $scope.results = [];
    $scope.pageSize = 10;
    $scope.maxSize = 10;
    $scope.totalItems = 0;
    $scope.provinces = [];

    $scope.init = function ()
    {
        var promise = $scope.load();
        promise.then(function ()
        {

        })
    };
    $scope.load = function ()
    {
        var deferred = $q.defer();
        var promise = $q.all(
                [
                    $http.get(url + "master/address/province/getAll")
                ]).then(function (data)
        {
            $scope.provinces = data[0].data;
            deferred.resolve(data);
        });
        return promise;
    };
    $scope.search = function ()
    {
        $pageUtils.washValues($scope.model);
        $http.post(url + "customer/search", $scope.model)
                .success(function (data)
                {
                    $scope.results = data.list;
                    $scope.totalItems = data.totalRecord;
                });
    };
    $scope.select = function (item)
    {
        $modalInstance.close(item);
    };
   
    $scope.clear = function ()
    {
        $scope.model = {page: 1};
    };
}
);

