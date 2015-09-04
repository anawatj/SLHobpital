/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
app.controller('reservationListCtrl', function (
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
    $scope.init = function ()
    {
        $scope.$parent.pageName="ค้นหา-Reservation";
        $scope.$parent.link="สร้าง-Reservation";
        $scope.$parent.urlLink=url+"reservation/entry.html";
    };
    $scope.search = function ()
    {
        $pageUtils.washValues($scope.model);
        $http.post(url + "reservation/search", $scope.model)
                .success(function (data)
                {
                    $scope.results = data.list;
                    $scope.totalItems = data.totalRecord;
                });
    };
    $scope.edit = function (id)
    {
        window.location = url + "reservation/entry.html?id=" + id;
    };
    $scope.remove = function (id)
    {
        if (window.confirm("ยืนยันการลบข้อมูล"))
        {
            var data = {};
            data.id = id;
            $http.post(url + "reservation/delete", data)
                    .success(function ()
                    {
                        window.location = url + "reservation/list.html";
                    });
        }
    };
    $scope.clear = function ()
    {
        $scope.model = {page: 1};
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
                        code: $scope.model.requestBy
                    }
                }
            }
        });

        modalInstance.result.then(function (selectedItem) {

            $scope.model.requestBy = selectedItem.code;

        });
    };
    $scope.findApproveBy = function ()
    {
        var modalInstance = $modal.open({
            animation: $scope.animationsEnabled,
            templateUrl: url + "employee/searchModal.html",
            controller: 'employeeSearchModalCtrl',
            size: 'lg',
            resolve: {
                params: function () {
                    return {
                        code: $scope.model.approveBy
                    }
                }
            }
        });

        modalInstance.result.then(function (selectedItem) {
           
            $scope.model.approveBy = selectedItem.code;
            //$scope.model.approveBy.birthDate = undefined;
        });
    };
});

