/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
app.controller('reservationEntryCtrl', function (
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
    $scope.model = {};
    $scope.rooms = [];
    $scope.motors = [];
    $scope.its = [];
    $scope.loading = true;
    $scope.init = function ()
    {
      
        
        $scope.urlParameter = $pageUtils.getUrlVars();
        $scope.id = $scope.urlParameter.id;
        if($scope.id==null || $scope.id==undefined)
        {
              $scope.$parent.pageName="สร้าง-reservation";
        }else
        {
            $scope.$parent.pageName="แก้ไข-reservation";
        }
        $scope.$parent.link="ค้นหา-reservation";
        $scope.$parent.urlLink=url+"reservation/list.html";
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
                    $http.get(url + "reservation/getByKey", {params: {key: id}}),
                    $http.get(url + "master/equipment/room/getAll"),
                    $http.get(url + "master/equipment/motor/getAll"),
                    $http.get(url + "master/equipment/it/getAll")
                ])
                .then(function (data)
                {
                    $scope.rooms = data[1].data;
                    $scope.motors = data[2].data;
                    $scope.its = data[3].data;
                    $scope.model = data[0].data;
                    $scope.model.id = id;
                    if ($scope.model.reservationDate != null && $scope.model.reservationDate != undefined)
                    {
                        $scope.model.reservationDate = new Date($scope.model.reservationDate);
                    }
                    if ($scope.model.approveDate != null && $scope.model.approveDate != undefined)
                    {
                        $scope.model.approveDate = new Date($scope.model.approveDate);
                    }
                    if ($scope.model.reservationBy == null || $scope.model.reservationBy == undefined)
                    {
                        $scope.model.reservationBy = {};
                    }

                    if ($scope.model.approveBy == null || $scope.model.approveBy == undefined)
                    {
                        $scope.model.approveBy = {};
                    }
                    if ($scope.model.attachment == null || $scope.model.attachment == undefined)
                    {
                        $scope.model.attachment = {};
                    }
                    if ($scope.model.rooms == null || $scope.model.rooms == undefined)
                    {
                        $scope.model.rooms = [];
                    }
                    if ($scope.model.motors == null || $scope.model.motors == undefined)
                    {
                        $scope.model.motors = [];
                    }
                    if ($scope.model.its == null || $scope.model.its == undefined)
                    {
                        $scope.model.its = [];
                    }
                    for (var index = 0; index < $scope.model.rooms.length; index++)
                    {
                        var item = $scope.model.rooms[index];
                        if (item.equipment == null || item.equipment == undefined)
                        {
                            item.equipment = {};
                        }
                        if (item.resvFromDate != null && item.resvFromDate != undefined)
                        {
                            item.resvFromDate = new Date(item.resvFromDate);
                        }
                        if (item.resvToDate != null && item.resvToDate != undefined)
                        {
                            item.resvToDate = new Date(item.resvToDate);
                        }
                    }
                    for (var index = 0; index < $scope.model.motors.length; index++)
                    {
                        var item = $scope.model.motors[index];
                        if (item.equipment == null || item.equipment == undefined)
                        {
                            item.equipment = {};
                        }
                        if (item.resvFromDate != null && item.resvFromDate != undefined)
                        {
                            item.resvFromDate = new Date(item.resvFromDate);
                        }
                        if (item.resvToDate != null && item.resvToDate != undefined)
                        {
                            item.resvToDate = new Date(item.resvToDate);
                        }
                    }
                    for (var index = 0; index < $scope.model.its.length; index++)
                    {
                        var item = $scope.model.its[index];
                        if (item.equipment == null || item.equipment == undefined)
                        {
                            item.equipment = {};
                        }
                        if (item.resvFromDate != null && item.resvFromDate != undefined)
                        {
                            item.resvFromDate = new Date(item.resvFromDate);
                        }
                        if (item.resvToDate != null && item.resvToDate != undefined)
                        {
                            item.resvToDate = new Date(item.resvToDate);
                        }
                    }
                    deferred.resolve(data);
                });
        return promise;
    };
    $scope.findReservationBy = function ()
    {
        var modalInstance = $modal.open({
            animation: $scope.animationsEnabled,
            templateUrl: url + "employee/searchModal.html",
            controller: 'employeeSearchModalCtrl',
            size: 'lg',
            resolve: {
                params: function () {
                    return {
                        code: $scope.model.reservationBy.code
                    }
                }
            }
        });

        modalInstance.result.then(function (selectedItem) {
            if ($scope.model.reservationBy == null || $scope.model.reservationBy == undefined)
            {
                $scope.model.reservationBy = {};
            }
            $scope.model.reservationBy = selectedItem;
            $scope.model.reservationBy.birthDate = undefined;
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
    $scope.findAttachment = function ()
    {
        var id = undefined;
        if ($scope.model.attachment.id != null && $scope.model.attachment.id != undefined)
        {
            id = $scope.model.attachment.id;
        }
        var modalInstance = $modal.open({
            animation: $scope.animationsEnabled,
            templateUrl: url + "attachment/entryModal.html",
            controller: 'attachmentEntryModalCtrl',
            size: 'lg',
            resolve: {
                params: function () {
                    return {
                        id: id
                    }
                }
            }
        });

        modalInstance.result.then(function (selectedItem) {
            if ($scope.model.attachment == null || $scope.model.attachment == undefined)
            {
                $scope.model.attachment = {};
            }
            $scope.model.attachment = selectedItem;
            //  $scope.model.approveBy.birthDate = undefined;
        });


    };
    $scope.addRoom = function ()
    {
        var item = {};
        item.id = 0;
        item.reservationId = $scope.id;
        item.selected = false;
        $scope.model.rooms.push(item);
    };
    $scope.delRoom = function ()
    {
        for (var index = 0; index < $scope.model.rooms.length; index++)
        {
            var room = $scope.model.rooms[index];
            if (room.selected == true)
            {
                $scope.model.rooms.splice(index, 1);
                index--;
            }
        }
    };
    $scope.addMotor = function ()
    {
        var item = {};
        item.id = 0;
        item.reservationId = $scope.id;
        item.selected = false;
        $scope.model.motors.push(item);
    };
    $scope.delMotor = function ()
    {
        for (var index = 0; index < $scope.model.motors.length; index++)
        {
            var motor = $scope.model.motors[index];
            if (motor.selected)
            {
                $scope.model.motors.splice(index, 1);
                index--;
            }
        }
    };
    $scope.addIt = function ()
    {
        var item = {};
        item.id = 0;
        item.reservationId = $scope.id;
        item.selected = false;
        $scope.model.its.push(item);
    };
    $scope.delIt = function ()
    {
        for (var index = 0; index < $scope.model.its.length; index++)
        {
            var it = $scope.model.its[index];
            if (it.selected)
            {
                $scope.model.its.splice(index, 1);
                index--;
            }
        }
    };
    $scope.save = function ()
    {
        $http.post(url + "/reservation/save", $scope.model)
                .success(function (data)
                {
                    window.location = url + "/reservation/entry.html?id=" + data.id;
                })
    };
    $scope.clear = function ()
    {
        $scope.init();
    };


});

