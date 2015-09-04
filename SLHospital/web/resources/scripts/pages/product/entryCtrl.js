/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

app.controller('productEntryCtrl', function (
        $scope,
        $http,
        $pageUtils,
        $dialogUtils,
        config,
        $modal,
        $q
        )
{
    $scope.model = {};
    $scope.urlParameter = "";
    $scope.id = 0;
    $scope.init = function ()
    {
        $scope.urlParameter = $pageUtils.getUrlVars();
        $scope.id = $scope.urlParameter.id;
        if($scope.id==null || $scope.id==undefined)
        {
            $scope.$parent.pageName="สร้าง-Product";
           
        }else
        {
            $scope.$parent.pageName="แก้ไข-Product";
        }
        $scope.$parent.link="ค้นหา-Product";
        $scope.$parent.urlLink=url+"product/list.html";
        var promise = $scope.load();
        promise.then(function ()
        {

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
                    $http.get(url + "product/getByKey", {params: {key: id}})
                ]).then(function (data)
        {
            $scope.model = data[0].data;
            $scope.model.id = id;
            if ($scope.id == 0)
            {
                $scope.model.supplier = {};
                $scope.model.active = "N";
            } else
            {
                if ($scope.model.supplier == null)
                {
                    $scope.model.supplier = {};
                }
            }
            deferred.resolve(data);
        });
        return promise;
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
    $scope.save=function()
    {
      $http.post(url+"product/save",$scope.model)
              .success(function(data)
      {
          window.location=url+"product/entry.html?id="+data.id;
      });
    };
}
);
