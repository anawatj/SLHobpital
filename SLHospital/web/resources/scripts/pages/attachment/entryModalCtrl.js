/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
app.controller('attachmentEntryModalCtrl', function (
        $scope,
        $http,
        $q,
        $pageUtils,
        $modalInstance,
        params,
        $modal,
        $base64

        )
{
    $scope.id = params.id;
    $scope.model = {};
    $scope.attachmentTypes = [];
    $scope.init = function ()
    {
        var promise = $scope.load();
        promise.then(function ()
        {
        });
    };
    $scope.load = function ()
    {
        var id = 0;
        if (angular.isDefined($scope.id))
        {
            id = $scope.id;
        }
        var deferred = $q.defer();
        var promise = $q.all(
                [
                    $http.get(url + "attachment/getByKey", {params: {key: id}}),
                    $http.get(url + "master/attachmentType/getAll")
                ]).then(function (data)
        {
            $scope.attachmentTypes = data[1].data;
            $scope.model = data[0].data;
            $scope.model.id = id;
            if ($scope.model.attachDate != null && $scope.model.attachDate != undefined)
            {
                $scope.model.attachDate = new Date($scope.model.attachDate);
            }
            if ($scope.model.attachBy == null || $scope.model.attachBy == undefined)
            {
                $scope.model.attachBy = {};
            }
            if ($scope.model.items == null || $scope.model.items == undefined)
            {
                $scope.model.items = [];
            }
            for (var index = 0; index < $scope.model.items.length; index++)
            {
                var item = $scope.model.items[index];
                if (item.type == null || item.type == undefined)
                {
                    item.type = {};
                }
            }
            deferred.resolve(data);
        });
        return promise;

    };
    $scope.uploadedFile = function (element, index) {
        $scope.$apply(function ($scope) {
            var file = element.files[0];

            if (element.files && file) {
                var reader = new FileReader();

                reader.onload = function (readerEvt) {
                    var binaryString = readerEvt.target.result;
                    $scope.model.items[index].fileName=binaryString;
              
                };

                reader.readAsBinaryString(file);
            }
       
        });
    };
    $scope.findAttachBy = function ()
    {
        var modalInstance = $modal.open({
            animation: $scope.animationsEnabled,
            templateUrl: url + "employee/searchModal.html",
            controller: 'employeeSearchModalCtrl',
            size: 'lg',
            resolve: {
                params: function () {
                    return {
                        code: $scope.model.attachBy.code
                    }
                }
            }
        });

        modalInstance.result.then(function (selectedItem) {
            if ($scope.model.attachBy == null || $scope.model.attachBy == undefined)
            {
                $scope.model.attachBy = {};
            }
            $scope.model.attachBy = selectedItem;
            $scope.model.attachBy.birthDate = undefined;
        });
    };
    $scope.addItem = function ()
    {
        var id = $scope.id;
        if ($scope.id == 0)
        {
            id = undefined;
        }
        var item = {};
        item.id = 0;
        item.attachmentId = id;
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
        $http.post(url + "attachment/store", $scope.model)
                .success(function (data)
                {
                    $modalInstance.close(data);
                });
    };
    $scope.close = function ()
    {
        $modalInstance.dismiss('cancel');
    };

});

