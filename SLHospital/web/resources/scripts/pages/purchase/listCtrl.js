/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

app.controller('purchaseListCtrl', function (
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
                page: 1
            };
    $scope.results = [];
    $scope.pageSize = 10;
    $scope.maxSize = 10;
    $scope.totalItems = 0;
    $scope.departments = [];
    $scope.branches = [];
    $scope.statuses=[];
    $scope.init = function ()
    {
        $scope.$parent.pageName="ค้นหา-Purchase";
        $scope.$parent.link="สร้าง-Purchase";
        $scope.$parent.urlLink=url+"purchase/entry.html";
        var promise = $scope.load();
        promise.then(function ()
        {
            $scope.loading = false;
        });
    };
    $scope.load = function ()
    {
        var deferred = $q.defer();
        var promise = $q.all(
                [
                    $http.get(url + "master/department/getAll"),
                    $http.get(url + "master/branch/getAll"),
                    $http.get(url + "master/purchaseStatus/getAll")
                ]).then(function (data)
        {
            $scope.departments = data[0].data;
            $scope.branches = data[1].data;
            $scope.statuses=data[2].data;
             deferred.resolve(data);
        });
        return promise;
    };
    $scope.search = function ()
    {
        $pageUtils.washValues($scope.model);
        $http.post(url + "purchase/search", $scope.model)
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
    $scope.findPurchaseBy=function()
    {
         var modalInstance = $modal.open({
            animation: $scope.animationsEnabled,
            templateUrl: url + "employee/searchModal.html",
            controller: 'employeeSearchModalCtrl',
            size: 'lg',
            resolve: {
                params: function () {
                    return {
                        code: $scope.model.purchaseBy
                    }
                }
            }
        });

        modalInstance.result.then(function (selectedItem) {
           
            $scope.model.purchaseBy = selectedItem.code;
        });
    };
    $scope.edit = function (id)
    {
        window.location = url + "purchase/entry.html?id=" + id;
    };
    $scope.remove = function (id)
    {
        if (window.confirm("ยืนยันการลบข้อมูล"))
        {
            var data = {};
            data.id = id;
            $http.post(url + "purchase/delete", data)
                    .success(function ()
                    {
                        window.location = url + "purchase/list.html";
                    });
        }
    };
    $scope.clear = function ()
    {
        $scope.model = { page: 1};
    };
});
