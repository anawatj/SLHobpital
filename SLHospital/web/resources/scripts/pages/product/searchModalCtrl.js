/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


app.controller('productSearchModalCtrl', function (
        $scope,
        $http,
        $q,
        $pageUtils,
        $modalInstance,
        params,
        $modal

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
        $http.post(url + "product/search", $scope.model)
                .success(function (data)
                {
                    $scope.results = data.list;
                    $scope.totalItems = data.totalRecord;
                });
    };
    $scope.findSupplier = function ()
    {
        var modalInstance = $modal.open({
            animation: $scope.animationsEnabled,
            templateUrl: url + "supplier/searchModal.html",
            controller: 'supplierSearchModalCtrl',
            size: 'lg',
            resolve: {
                params: function () {
                    return {
                        code: $scope.model.supplier
                    }
                }
            }
        });

        modalInstance.result.then(function (selectedItem) {
            if ($scope.model.supplier == null || $scope.model.supplier == undefined)
            {
                $scope.model.supplier = {};
            }
            $scope.model.supplier = selectedItem.code;
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