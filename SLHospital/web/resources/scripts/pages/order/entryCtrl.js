/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


app.controller('orderEntryCtrl', function (
        $scope,
        $http,
        $pageUtils,
        $dialogUtils,
        config,
        $modal,
        $q
        )
{
    $scope.urlParameter = "";
    $scope.id = 0;
    $scope.provinces = [];
    $scope.amphurs = [];
    $scope.shippers = [];

    $scope.model = {};
    $scope.loading = true;
    $scope.init = function ()
    {
        $scope.urlParameter = $pageUtils.getUrlVars();
        $scope.id = $scope.urlParameter.id;
        if($scope.id==null || $scope.id==undefined)
        {
            $scope.$parent.pageName="สร้าง-Order";
        }else
        {
            $scope.$parent.pageName="แก้ไข-Order";
        }
        $scope.$parent.link="ค้นหา-Order";
        $scope.$parent.urlLink=url+"order/list.html";
        var promise = $scope.load();
        promise.then(function ()
        {
            $scope.loading = false;
        });
    };
    $scope.load = function ()
    {
        var id = 0;
        if (angular.isDefined($scope.id)) {
            id = $scope.id;
        }
        var deferred = $q.defer();
        var promise = $q.all(
                [
                    $http.get(url + "master/address/province/getAll"),
                    $http.get(url + "master/shipper/getAll"),
                    $http.get(url + "order/getByKey", {params: {key: id}})
                ]
                ).then(function (data)
        {
            $scope.provinces = data[0].data;
            $scope.shippers = data[1].data;
            $scope.model = data[2].data;
            $scope.model.id = id;
            if ($scope.model.id > 0)
            {
                if ($scope.model.address != null && $scope.model.address != undefined)
                {
                    if ($scope.model.address.province == null || $scope.model.address.province == undefined)
                    {
                        $scope.model.address.province = {};
                    }
                    if ($scope.model.address.amphur == null || $scope.model.address.amphur == undefined)
                    {
                        $scope.model.address.amphur = {};
                    }
                    $scope.provinceChange($scope.model.address.province.id);

                }


            }
            if ($scope.model.orderDate != null && $scope.model.orderDate != undefined)
            {
                $scope.model.orderDate = new Date($scope.model.orderDate);
            }
            if ($scope.model.requireDate != null && $scope.model.requireDate != undefined)
            {
                $scope.model.requireDate = new Date($scope.model.requireDate);
            }
            if ($scope.model.shipperDate != null && $scope.model.shipperDate != undefined)
            {
                $scope.model.shipperDate = new Date($scope.model.shipperDate);
            }
            if ($scope.model.approveDate != null && $scope.model.approveDate != undefined)
            {
                $scope.model.approveDate = new Date($scope.model.approveDate);
            }
            if ($scope.model.shipper == null || $scope.model.shipper == undefined)
            {
                $scope.model.shipper = {}
            }
            if ($scope.model.customer == null || $scope.model.customer == undefined)
            {
                $scope.model.customer = {};
            }
            if ($scope.model.requestBy == null || $scope.model.requestBy == undefined)
            {
                $scope.model.requestBy = {};
            }
            if ($scope.model.approveBy == null || $scope.model.approveBy == undefined)
            {
                $scope.model.approveBy = {};
            }
            if ($scope.model.items == null || $scope.model.items == undefined)
            {
                $scope.model.items = [];
            }
            for (var index = 0; index < $scope.model.items.length; index++)
            {
                var item = $scope.model.items[index];
                if (item.product == null || item.product == undefined)
                {
                    item.product = {};
                }
            }

            deferred.resolve(data);
        });
        return promise;
    };
    $scope.provinceChange = function (key)
    {
        $http.get(url + "master/address/amphur/getAll", {params: {provinceId: key}})
                .success(function (data)
                {
                    $scope.amphurs = data;
                });
    };
    $scope.findCustomer = function () {
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
            if ($scope.model.customer == null || $scope.model.customer == undefined)
            {
                $scope.model.customer = {};
            }
            $scope.model.customer = selectedItem;
        });
    };
    $scope.findRequestBy = function ()
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
            if ($scope.model.requestBy == null || $scope.model.requestBy == undefined)
            {
                $scope.model.requestBy = {};
            }
            $scope.model.requestBy = selectedItem;
            $scope.model.requestBy.birthDate = undefined;
        });
    };
    $scope.findApproveBy = function () {
        var modalInstance = $modal.open({
            animation: $scope.animationsEnabled,
            templateUrl: url + "employee/searchModal.html",
            controller: 'employeeSearchModalCtrl',
            size: 'lg',
            resolve: {
                params: function () {
                    return {
                        code: $scope.model.approveBy.code
                    }
                }
            }
        });

        modalInstance.result.then(function (selectedItem) {
            if ($scope.model.approveBy == null || $scope.model.approveBy == undefined)
            {
                $scope.model.approveBy = {};
            }
            $scope.model.approveBy = selectedItem;
            $scope.model.approveBy.birthDate = undefined;
        });
    };
    $scope.findProduct = function (item)
    {
        var code = "";
        if (item.product != null && item.product != undefined)
        {
            code = item.product.code;
        }
        var modalInstance = $modal.open({
            animation: $scope.animationsEnabled,
            templateUrl: url + "product/searchModal.html",
            controller: 'productSearchModalCtrl',
            size: 'lg',
            resolve: {
                params: function () {
                    return {
                        code: code
                    }
                }
            }
        });

        modalInstance.result.then(function (selectedItem) {
            if (item.product == null || item.product == undefined)
            {
                item.product = {};
            }
            item.product = selectedItem;
        });
    };
    $scope.addItem = function ()
    {
        var item = {};
        item.id = 0;
        item.orderId = $scope.id;
        item.selected = false;
        $scope.model.items.push(item);
    };
    $scope.delItem = function ()
    {
        for (var index = 0; index < $scope.model.items.length; index++)
        {
            var item = $scope.model.items[index];
            if (item.selected)
            {
                $scope.model.items.splice(index, 1);
                index--;
            }
        }

    };
    $scope.save = function ()
    {
        $scope.model.status = "P";
        $http.post(url + "order/save", $scope.model)
                .success(function (data)
                {
                    window.location = url + 'order/entry.html?id=' + data.id;
                });
    };
    $scope.approve = function ()
    {
        $scope.model.status = "A";
        $http.post(url + "order/save", $scope.model)
                .success(function (data)
                {
                    window.location = url + 'order/entry.html?id=' + data.id;
                });
    }
    $scope.clear = function ()
    {
        $scope.init();

    };
});