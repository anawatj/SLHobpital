/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

app.controller('purchaseEntryCtrl', function (
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

    $scope.departments = [];
    $scope.branches = [];
    $scope.services = [];
    $scope.model = {};
    $scope.loading = true;
    $scope.init = function ()
    {
        $scope.urlParameter = $pageUtils.getUrlVars();
        $scope.id = $scope.urlParameter.id;
        if($scope.id==null || $scope.id==undefined)
        {
            $scope.$parent.pageName="สร้าง-Purchase";
        }else
        {
            $scope.$parent.pageName="แก้ไข-Purchase";
        }
        $scope.$parent.link="ค้นหา-Purchase";
        $scope.$parent.urlLink=url+"purchase/list.html";
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
        var promise = $q.all
                (
                        [
                            $http.get(url + "master/department/getAll"),
                            $http.get(url + "master/branch/getAll"),
                            $http.get(url + "master/service/getAll"),
                            $http.get(url + "purchase/getByKey", {params: {key: id}})
                        ]
                        ).then(function (data)
        {
                $scope.departments=data[0].data;
                $scope.branches=data[1].data;
                $scope.services=data[2].data;
                $scope.model=data[3].data;
                $scope.model.id = id;
                if($scope.model.purchaseBy==null || $scope.model.purchaseBy==undefined)
                {
                    $scope.model.purchaseBy={};
                }
                if($scope.model.approveBy==null || $scope.model.approveBy==undefined )
                {
                    $scope.model.approveBy={};
                }
                if($scope.model.supplier==null || $scope.model.supplier==undefined)
                {
                    $scope.model.supplier={};
                }
                if($scope.model.department==null || $scope.model.department==undefined)
                {
                    $scope.model.department={};
                }
                if($scope.model.branch==null || $scope.model.branch==undefined)
                {
                    $scope.model.branch={};
                }
                if($scope.model.purchaseDate!=null && $scope.model.purchaseDate!=undefined)
                {
                    $scope.model.purchaseDate = new Date($scope.model.purchaseDate);
                }
                if($scope.model.approveDate!=null && $scope.model.approveDate!=undefined)
                {
                    $scope.model.approveDate = new Date($scope.model.approveDate);
                }
                if($scope.model.products==null || $scope.model.products==undefined)
                {
                    $scope.model.products=[];
                    
                }
                if($scope.model.services==null || $scope.model.services==undefined)
                {
                    $scope.model.services=[];
                }
                for(var index=0;index<$scope.model.products.length;index++)
                {
                    var product = $scope.model.products[index];
                    if(product.product==null || product.product==undefined)
                    {
                        product.product={};
                    }
                    
                }
                for(var index=0;index<$scope.model.services.length;index++)
                {
                    var service = $scope.model.services[index];
                    if(service.service==null || service.service==undefined)
                    {
                        service.service={};
                    }
                }
                 deferred.resolve(data);
                
        });
        return promise;
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
                        code: $scope.model.purchaseBy.code
                    }
                }
            }
        });

        modalInstance.result.then(function (selectedItem) {
            if ($scope.model.purchaseBy == null || $scope.model.purchaseBy == undefined)
            {
                $scope.model.purchaseBy = {};
            }
            $scope.model.purchaseBy = selectedItem;
            $scope.model.purchaseBy.birthDate=undefined;
        });
    };
    $scope.findApproveBy=function()
    {
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
            $scope.model.approveBy.birthDate=undefined;
        });
    };
    $scope.findSupplier=function()
    {
         var modalInstance = $modal.open({
            animation: $scope.animationsEnabled,
            templateUrl: url + "supplier/searchModal.html",
            controller: 'supplierSearchModalCtrl',
            size: 'lg',
            resolve: {
                params: function () {
                    return {
                        code: $scope.model.supplier.code
                    }
                }
            }
        });

        modalInstance.result.then(function (selectedItem) {
            if ($scope.model.supplier == null || $scope.model.supplier == undefined)
            {
                $scope.model.supplier = {};
            }
            $scope.model.supplier = selectedItem;
        });
    };
    $scope.findProduct=function(item)
    {
        var code ="";
        if(item.product!=null&&item.product!=undefined)
        {
            code= item.product.code;
        }
              var modalInstance = $modal.open({
            animation: $scope.animationsEnabled,
            templateUrl: url + "product/searchModal.html",
            controller: 'productSearchModalCtrl',
            size: 'lg',
            resolve: {
                params: function () {
                    return {
                        code:code
                    }
                }
            }
        });

        modalInstance.result.then(function (selectedItem) {
           if(item.product==null||item.product==undefined)
           {
               item.product={};
           }
           item.product=selectedItem;
        });
    };
    $scope.addProduct=function()
    {
        var item={};
        item.id=0;
        item.purchaseId=$scope.id;
        item.selected=false;
        $scope.model.products.push(item);
    };
    $scope.delProduct=function()
    {
        for(var index=0;index<$scope.model.products.length;index++)
        {
            var item = $scope.model.products[index];
            if(item.selected)
            {
                $scope.model.products.splice(index,1);
                index--;
            }
        }
    };
    $scope.addService=function()
    {
            var item={};
        item.id=0;
        item.purchaseId=$scope.id;
        item.selected=false;
        $scope.model.services.push(item);
    };
    $scope.delService=function()
    {
          for(var index=0;index<$scope.model.services.length;index++)
        {
            var item = $scope.model.services[index];
            if(item.selected)
            {
                $scope.model.services.splice(index,1);
                index--;
            }
        }
        
    };
    $scope.save=function()
    {
        $scope.model.status="P";
        $http.post(url+"purchase/save",$scope.model)
                .success(function(data)
        {
           window.location=url+"purchase/entry.html?id="+data.id; 
        });
    };
    $scope.approve=function()
    {
        $scope.model.status="A";
            $http.post(url+"purchase/save",$scope.model)
                .success(function(data)
        {
           window.location=url+"purchase/entry.html?id="+data.id; 
        });
        
    };
    $scope.clear=function()
    {
        if($scope.id==null||$scope.id==undefined)
        {
            window.location=url+"purchase/entry.html";
        }else
        {
            window.location=url+"purchase/entry.html?id="+$scope.id;
        }
    }
});
