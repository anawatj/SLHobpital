/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

app.controller('projectEntryCtrl', function (
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
    $scope.positions = [];
    $scope.titles = [];
    $scope.educationLevels = [];
    $scope.model = {};
    $scope.loading = true;
    $scope.init = function ()
    {
       
        $scope.urlParameter = $pageUtils.getUrlVars();
        $scope.id = $scope.urlParameter.id;
        if($scope.id==null || $scope.id==undefined)
        {
            $scope.$parent.pageName="สร้าง-Project";
        }else
        {
            $scope.$parent.pageName="แก้ไข-Project";
        }
        $scope.$parent.link="ค้นหา-Project";
        $scope.$parent.urlLink=url+"project/list.html";
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
                    $http.get(url + "project/getByKey", {params: {key: id}})


                ]).then(function (data)
        {
            $scope.model = data[0].data;
            $scope.model.id = id;
            if ($scope.model.id == 0)
            {
                $scope.model.type = "A";
            }
            if ($scope.model.id != 0)
            {
                for (var index = 0; index < $scope.model.items.length; index++)
                {
                    var item = $scope.model.items[index];
                    for (var sindex = 0; sindex < item.frms.length; sindex++)
                    {
                        var sitem = item.frms[sindex];
                        if (sitem.productGroup == null || sitem.productGroup == undefined)
                        {
                            sitem.productGroup = {};
                        }
                    }
                }
            }
            deferred.resolve(data);
        });
        return promise;
    };
    $scope.addItem=function()
    {
        var item = {};
        item.id=0;
        item.projectId = $scope.id;
        item.selected=false;
        item.frms=[];
        $scope.model.items.push(item);
    };
    $scope.delItem=function()
    {
        for(var index=0;index<$scope.model.items.length;index++)
        {
            var item = $scope.model.items[index];
            if(item.selected)
            {
                $scope.model.items.splice(index,1);
                index--;
                
            }
        }
    };
    $scope.editFrm=function(item)
    {
           var modalInstance = $modal.open({
            animation: $scope.animationsEnabled,
            templateUrl: url + "project/frmModal.html",
            controller: 'projectFrmModalCtrl',
            size: 'lg',
            resolve: {
                params: function () {
                    return {
                        projectItemId:item.id,
                        items:item.frms
                    }
                }
            }
        });

        modalInstance.result.then(function (items) {
            if(item.frms==undefined)
            {
                item.frms=[];
            }
            item.frms=items;
        });
    };
    $scope.save=function()
    {
        $http.post(url+"project/save",$scope.model)
                .success(function(data)
        {
           window.location=url+"project/entry.html?id="+data.id;
           
        });
    };
    $scope.clear=function()
    {
        $scope.init();
    };
});
