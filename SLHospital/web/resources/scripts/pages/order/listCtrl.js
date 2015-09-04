/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

app.controller('orderListCtrl', function (
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
    $scope.shippers = [];
    $scope.init = function ()
    {
        $scope.$parent.pageName="ค้นหา-Order";
        $scope.$parent.link="สร้าง-Order";
        $scope.$parent.urlLink=url+"order/entry.html";
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
                    $http.get(url + "master/shipper/getAll")
                ]
                ).then(function (data)
        {
            $scope.shippers = data[0].data;
            deferred.resolve(data);
        });
        return promise;
    };
    $scope.search = function ()
    {
        $pageUtils.washValues($scope.model);
        $http.post(url + "order/search", $scope.model)
                .success(function (data)
                {
                    $scope.results = data.list;
                    $scope.totalItems = data.totalRecord;
                });
    };
    $scope.edit = function (id)
    {
        window.location = url + "order/entry.html?id=" + id;
    };
    $scope.remove = function (id)
    {
        if (window.confirm("ยืนยันการลบข้อมูล"))
        {
            var data = {};
            data.id = id;
            $http.post(url + "order/delete", data)
                    .success(function ()
                    {
                        window.location = url + "order/list.html";
                    });
        }
    };
    $scope.clear = function ()
    {
        $scope.model = {page: 1};
    };
    $scope.findEmployee=function()
    {
         var modalInstance = $modal.open({
            animation: $scope.animationsEnabled,
            templateUrl: url + "employee/searchModal.html",
            controller: 'employeeSearchModalCtrl',
            size: 'lg',
            resolve: {
                params: function () {
                    return {
                        code: $scope.model.requestBy.code
                    }
                }
            }
        });

        modalInstance.result.then(function (selectedItem) {
         
            $scope.model.employee = selectedItem.code;
        
        });
    };
    $scope.findCustomer=function()
    {
        var modalInstance = $modal.open({
            animation: $scope.animationsEnabled,
            templateUrl: url + "customer/searchModal.html",
            controller: 'customerSerchModalCtrl',
            size: 'lg',
            resolve: {
                params: function () {
                    return {
                        code: $scope.model.customer.code
                    }
                }
            }
        });

        modalInstance.result.then(function (selectedItem) {
            $scope.model.customer =selectedItem.code;
        });
    };
});
