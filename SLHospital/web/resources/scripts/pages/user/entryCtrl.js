/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
app.controller('userEntryCtrl', function (
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
    $scope.loading = true;
    $scope.init = function ()
    {
        
        $scope.urlParameter = $pageUtils.getUrlVars();
        $scope.id = $scope.urlParameter.id;
        if($scope.id==null || $scope.id==undefined)
        {
            $scope.$parent.pageName="สร้าง-User";
            
        }else
        {
            $scope.$parent.pageName="แก้ไข-User";
        }
        $scope.$parent.link="ค้นหา-User";
        $scope.$parent.urlLink=url+"user/list.html";
        var promise = $scope.load();
        promise.then(function()
        {
           $scope.loading=false; 
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
                    $http.get(url + "user/getByKey", {params: {key: id}})
                ]
                ).then(function (data)
        {
                $scope.model=data[0].data;
                $scope.model.id=id;
                if($scope.model.roles==null || $scope.model.roles==undefined)
                {
                    $scope.model.roles=[];
                }
                  deferred.resolve(data);
        });
        return promise;
    };
    $scope.addRole=function()
    {
          var modalInstance = $modal.open({
            animation: $scope.animationsEnabled,
            templateUrl: url + "role/searchMultiModal.html",
            controller: 'roleSearchMultiModalCtrl',
            size: 'lg',
            resolve: {
                params: function () {
                    return {
                        
                    }
                }
            }
        });

        modalInstance.result.then(function (items) {
            for(var index=0;index<items.length;index++)
            {
                var item= items[index];
                var hasRole = $scope.findRole(item);
                if(hasRole === false)
                {
                    item.selected=false;
                    $scope.model.roles.push(item);
                }
            }
        });
    };
    $scope.findRole=function(item)
    {
      for(var index=0;index<$scope.model.roles.length;index++)
      {
          var role = $scope.model.roles[index];
          if(role.id===item.id)
          {
              return true;
          }
      }
      return false;
    };
    $scope.delRole=function()
    {
        for(var index=0;index<$scope.model.roles.length;index++)
        {
            var item  =$scope.model.roles[index];
            if(item.selected)
            {
                $scope.model.roles.splice(index,1);
                index--;
            }
        }
    };
    $scope.save=function()
    {
        $http.post(url+"user/save",$scope.model)
                .success(function(data)
        {
           window.location=url+"user/entry.html?id="+data.id; 
        });
    };
    $scope.clear=function()
    {
        $scope.init();
    }
});

