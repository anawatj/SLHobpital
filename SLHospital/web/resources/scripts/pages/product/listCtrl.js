/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

app.controller('productListCtrl', function (
        $scope,
        $http,
        $pageUtils,
        $dialogUtils,
        config,
        $modal,
        $q
        )
{
    $scope.model =
            {
                active:"N",
                page: 1
            };
    $scope.results = [];
    $scope.pageSize = 10;
    $scope.maxSize = 10;
    $scope.totalItems = 0;
    $scope.init=function()
    {
        $scope.$parent.pageName="ค้นหา-Product";
        $scope.$parent.link="สร้าง-Product";
        $scope.$parent.urlLink=url+"product/entry.html";
    };
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
    $scope.edit = function (id)
    {
        window.location = url + "product/entry.html?id=" + id;
    };
    $scope.remove = function (id)
    {
        if (window.confirm("ยืนยันการลบข้อมูล"))
        {
            var data = {};
            data.id = id;
            $http.post(url + "product/delete", data)
                    .success(function ()
                    {
                        window.location = url + "product/list.html";
                    });
        }
    };
    $scope.clear=function()
    {
        $scope.model={active:"N", page:1};
    };
   
}
);
