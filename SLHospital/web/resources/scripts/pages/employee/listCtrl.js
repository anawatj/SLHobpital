/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

app.controller('employeeListCtrl', function (
        $scope,
        $http,
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
    $scope.init = function ()
    {
        $scope.$parent.link = "สร้าง-Employee";
        $scope.$parent.urlLink = url + "employee/entry.html";
        $scope.$parent.pageName = "ค้นหา-Employee";
    };
    $scope.search = function ()
    {
        $http.post(url + "employee/search", $scope.model)
                .success(function (data)
                {

                    $scope.results = data.list;

                    $scope.totalItems = data.totalRecord;
                });
    };
    $scope.edit = function (id)
    {
        window.location = url + "employee/entry.html?id=" + id;
    };
    $scope.remove = function (id)
    {
        if (window.confirm("ยืนยันการลบข้อมูล"))
        {
            var data = {};
            data.id = id;
            $http.post(url + "employee/delete", data)
                    .success(function ()
                    {
                        window.location = url + "employee/list.html";
                    });
        }
    };
});
