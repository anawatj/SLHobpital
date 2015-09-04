/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

app.controller('projectFrmModalCtrl', function (
        $scope,
        $http,
        $q,
        $pageUtils,
        $modalInstance,
        params
        )
{
    $scope.items=params.items;
    $scope.projectItemId= params.projectItemId;
    $scope.productGroups = [];
    $scope.init=function()  
    {
        var promise = $scope.load();
        promise.then(function ()
        {
           // $scope.loading = false;
        });
        
    };
    $scope.load=function()
    {
        var id = 0;
        if (angular.isDefined($scope.id)) {
            id = $scope.id;
        }
        var deferred = $q.defer();
        var promise = $q.all(
                [
                    $http.get(url+"master/productGroup/getAll")
                ]).then(function(data)
                {
                    $scope.productGroups=data[0].data;
                             deferred.resolve(data);
                });
        return promise;
    };
    $scope.addItem =function()
    {
        var projectItemId = undefined;
        if($scope.projectItemId!=0)
        {
            projectItemId = $scope.projectItemId;
        }
        var item = {
            id:0,
            projectItemId:projectItemId,
            selected:false
        };
        $scope.items.push(item);
    };
    $scope.delItem=function()
    {
        for(var index=0;index<$scope.items.length;index++)
        {
            var item = $scope.items[index];
            if(item.selected)
            {
                $scope.items.splice(index,1);
                index--;
            }
        }
    };
    $scope.save=function()
    {
        $modalInstance.close($scope.items);
    };
    $scope.close=function()
    {
        $modalInstance.dismiss('cancel');
    };
});
