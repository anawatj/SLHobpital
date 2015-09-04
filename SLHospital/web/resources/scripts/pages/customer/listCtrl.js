/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

app.controller('customerListCtrl', function (
        $scope,
        $http,
        $q,
        $pageUtils
        )
{
    $scope.model =
            {
                flagPersonal:"N",
                flagCompany:"N",
                page: 1
            };
    $scope.results = [];
    $scope.pageSize = 10;
    $scope.maxSize = 10;
    $scope.totalItems = 0;
    $scope.provinces=[];
    
    $scope.init=function()
    {
        $scope.$parent.link="สร้าง-Customer";
        $scope.$parent.urlLink=url+"customer/entry.html";
        $scope.$parent.pageName="ค้นหา-Customer";
        var promise = $scope.load();
        promise.then(function()
        {
            
        })
    };
    $scope.load=function()
    {
         var deferred = $q.defer();
         var promise = $q.all(
                 [
                    $http.get(url+"master/address/province/getAll")
                 ]).then(function(data)
                 {
                     $scope.provinces=data[0].data;
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
    $scope.edit = function (id)
    {
        window.location = url + "customer/entry.html?id=" + id;
    };
    $scope.remove = function (id)
    {
        if (window.confirm("ยืนยันการลบข้อมูล"))
        {
            var data = {};
            data.id = id;
            $http.post(url + "customer/delete", data)
                    .success(function ()
                    {
                        window.location = url + "customer/list.html";
                    });
        }
    };
    $scope.clear=function()
    {
        $scope.model={ page:1};
    };
}
);
