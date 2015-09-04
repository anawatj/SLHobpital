/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

app.controller('employeeSearchModalCtrl', function (
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
                code: params.code,
                page: 1
            };
    $scope.results = [];
    $scope.pageSize = 10;
    $scope.maxSize = 10;
    $scope.totalItems = 0;
    ///  $scope.selectedItem={};
    $scope.search = function ()
    {
        $pageUtils.washValues($scope.model);
        $http.post(url + "employee/search", $scope.model)
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
    $scope.close = function ()
    {
        $modalInstance.dismiss('cancel');
    };
}
);
