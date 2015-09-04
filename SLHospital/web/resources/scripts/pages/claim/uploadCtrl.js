/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
app.controller('claimUploadCtrl', function (
        $scope,
        $http,
        $pageUtils,
        $dialogUtils,
        config,
        $modal,
        $q
        )
{
    $scope.uploadedFile = function (element) {
        $scope.$apply(function ($scope) {
            $scope.files = element.files;
        });
    };
    $scope.save = function ()
    {
        var formData = new FormData();
        if ($scope.files) {
            formData.append('file', $scope.files[0]);
        } else {
            formData.append('file', undefined);
        }
        $http.post(url + 'claim/uploadFile', formData, {
					transformRequest : angular.identity,
					headers : {
						'Content-Type' : undefined
					}
				}).success(function(data) {
					alert(data);
				});
    };
}
);

