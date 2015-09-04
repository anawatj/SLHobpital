/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
app.controller('customerEntryCtrl', function (
        $scope,
        $http,
        $pageUtils,
        $dialogUtils,
        config,
        $modal,
        $q
        )
{
    $scope.loading = true;
    $scope.model = {};
    $scope.provinces = [];
    $scope.amphurs = [];
    $scope.urlParameter = "";
    $scope.id = 0;
    $scope.init = function ()
    {
       
        $scope.urlParameter = $pageUtils.getUrlVars();
        $scope.id = $scope.urlParameter.id;
         if($scope.id==null||$scope.id==undefined)
         {
             $scope.$parent.pageName="สร้าง-Customer";
         }else
         {
             $scope.$parent.pageName="แก้ไข-Customer";
         }
         $scope.$parent.link="ค้นหา-Customer";
         $scope.$parent.urlLink=url+"customer/list.html";
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
                    $http.get(url + "customer/getByKey", {params: {key: id}})
                ]
                ).then(function (data)
        {
            $scope.provinces = data[0].data;
            $scope.model = data[1].data;
            $scope.model.id = id;
            if ($scope.model.id == 0)
            {
                $scope.model.customerType = "P";
            }
            if ($scope.model.id != 0)
            {
                if ($scope.model.address != null && $scope.model.address != undefined)
                {
                    if ($scope.model.address.province == null || $scope.model.address.province == undefined)
                    {
                        $scope.model.address.province = {id: 0};
                    }
                    if ($scope.model.address.amphur == null || $scope.model.address.amphur == undefined)
                    {
                        $scope.model.address.amphur = {id: 0};
                    }
                    $scope.provinceChange($scope.model.address.province.id);
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
    $scope.save = function ()
    {
        $http.post(url + "customer/save", $scope.model)
                .success(function (data)
                {
                    window.location = url + "customer/entry.html?id=" + data.id;
                });
    };
}
);

