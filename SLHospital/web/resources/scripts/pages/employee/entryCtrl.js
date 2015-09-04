/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

app.controller('employeeEntryCtrl', function (
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
    $scope.languages = [];
    $scope.departments = [];
    $scope.branches = [];
    $scope.provinces = [];
    $scope.amphurs = [];
    $scope.model = {};
    $scope.loading = true;
    $scope.init = function ()
    {
        $scope.urlParameter = $pageUtils.getUrlVars();
        $scope.id = $scope.urlParameter.id;
        if($scope.id==null||$scope.id==undefined)
        {
            $scope.$parent.pageName="สร้าง-Employee";
        }else
        {
            $scope.$parent.pageName="แก้ไข-Employee";
        }
        $scope.$parent.link="ค้นหา-Employee";
        $scope.$parent.urlLink=url+"employee/list.html";
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
                    $http.get(url + "master/title/getAll"),
                    $http.get(url + "master/position/getAll"),
                    $http.get(url + "master/educationLevel/getAll"),
                    $http.get(url + "employee/getByKey", {params: {key: id}}),
                    $http.get(url + "master/hobby/getAll"),
                    $http.get(url + "master/department/getAll"),
                    $http.get(url + "master/branch/getAll"),
                    $http.get(url + "master/language/getAll"),
                    $http.get(url + "master/address/province/getAll")
                ]).then(function (data)
        {
            $scope.titles = data[0].data;
            $scope.positions = data[1].data;
            $scope.educationLevels = data[2].data;
            $scope.departments = data[5].data;
            $scope.branches = data[6].data;
            $scope.languages = data[7].data;
            $scope.provinces = data[8].data;
            $scope.model = data[3].data;
            $scope.model.id = id;
            if ($scope.model.birthDate != null && $scope.model.birthDate != undefined)
            {
                $scope.model.birthDate = new Date($scope.model.birthDate);
            }
            if ($scope.model.educations == null || $scope.model.educations == undefined)
            {
                $scope.model.educations = [];
            }
            if ($scope.model.hobbies == null || $scope.model.hobbies == undefined)
            {
                $scope.model.hobbies = [];
            }
            if ($scope.model.siblings == null || $scope.model.siblings == undefined)
            {
                $scope.model.siblings = [];
            }
            if ($scope.model.children == null || $scope.model.children == undefined)
            {
                $scope.model.children = [];
            }
            if ($scope.model.trainings == null || $scope.model.trainings == undefined)
            {
                $scope.model.trainings = [];
            }
            if ($scope.model.languages == null || $scope.model.languages == undefined)
            {
                $scope.model.languages = [];
            }
            if ($scope.model.references == null || $scope.model.references == undefined)
            {
                $scope.model.references = [];
            }
            if ($scope.model.address != null && $scope.model.address != undefined)
            {
                if ($scope.model.province != null && $scope.model.province != undefined)
                {
                    $scope.provinceChange($scope.model.province.id);
                }
            }
           $scope.hobbies = data[4].data;

           /* for (var index = 0; index < hobbies.length; index++)
            {
                var hasHobby = $scope.findHobby($scope.model.hobbies, hobbies[index]);
                if (hasHobby != null)
                {
                    //alert("found");
                    var modIndex = $scope.model.hobbies.indexOf(hasHobby);
                    $scope.model.hobbies[modIndex].selected = true;
                } else
                {
                    // alert("notfound");
                    hobbies[index].selected = false;
                   
                        $scope.model.hobbies.push(hobbies[index]);
                   
                }
            }*/

            for (var index = 0; index < $scope.model.experiences.length; index++)
            {
                var experience = $scope.model.experiences[index];
                experience.hiredDate = new Date(experience.hiredDate);
                experience.resignedDate = new Date(experience.resignedDate);
            }
            for (var index = 0; index < $scope.model.trainings.length; index++)
            {
                var training = $scope.model.trainings[index];
                training.startDate = new Date(training.startDate);
                training.endDate = new Date(training.endDate);
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
    $scope.compareHobbies = function(obj1, obj2){
        return obj1.id === obj2.id;
    };
    $scope.addEducation = function ()
    {
        var education = {};
        education.employeeId = $scope.id;
        education.id = 0;
        education.selected = false;
        $scope.model.educations.push(education);
    };
    $scope.delEducation = function ()
    {
        for (var index = 0; index < $scope.model.educations.length; index++)
        {
            var education = $scope.model.educations[index];
            if (education.selected)
            {
                $scope.model.educations.splice(index, 1);
                index--;
            }
        }
    };
    $scope.addExperience = function ()
    {
        var experience = {};
        experience.id = 0;
        experience.employeeId = $scope.id;
        experience.selected = false;
        $scope.model.experiences.push(experience);
    };
    $scope.delExperience = function () {
        for (var index = 0; index < $scope.model.experiences.length; index++)
        {
            var experience = $scope.model.experiences[index];
            if (experience.selected)
            {
                $scope.model.experiences.splice(index, 1);
                index--;
            }
        }
    };
    $scope.addSibling = function ()
    {
        var item = {};
        item.id = 0;
        item.employeeId = $scope.id;
        item.selected = false;
        $scope.model.siblings.push(item);
    };
    $scope.delSibling = function ()
    {
        for (var index = 0; index < $scope.model.siblings.length; index++)
        {
            var item = $scope.model.siblings[index];
            if (item.selected)
            {
                $scope.model.siblings.splice(index, 1);
                index--;
            }
        }
    };
    $scope.addChild = function ()
    {
        var item = {};
        item.id = 0;
        item.employeeId = $scope.id;
        item.selected = false;
        $scope.model.children.push(item);
    };
    $scope.delChild = function ()
    {
        for (var index = 0; index < $scope.model.children.length; index++)
        {
            var item = $scope.model.children[index];
            if (item.selected)
            {
                $scope.model.children.splice(index, 1);
                index--;
            }
        }
    };
    $scope.addTraining = function ()
    {
        var item = {};
        item.id = 0;
        item.employeeId = $scope.id;
        item.selected = false;
        $scope.model.trainings.push(item);
    };
    $scope.delTraining = function ()
    {
        for (var index = 0; index < $scope.model.trainings.length; index++)
        {
            var item = $scope.model.trainings[index];
            if (item.selected)
            {
                $scope.model.trainings.splice(index, 1);
                index--;
            }
        }
    };
    $scope.addLanguage = function ()
    {
        var item = {};
        item.id = 0;
        item.employeeId = $scope.id;
        item.selected = false;
        item.reading = "N";
        item.writing = "N";
        item.listing = "N";
        item.speaking = "N";
        $scope.model.languages.push(item);

    };
    $scope.delLanguage = function ()
    {
        for (var index = 0; index < $scope.model.languages.length; index++)
        {
            var item = $scope.model.languages[index];
            if (item.selected)
            {
                $scope.model.languages.splice(index, 1);
                index--;
            }
        }
    };
    $scope.addReference = function ()
    {
        var item = {};
        item.id = 0;
        item.employeeId = $scope.id;
        item.selected = false;
        $scope.model.references.push(item);
    };
    $scope.delReference = function ()
    {
        for (var index = 0; index < $scope.model.references.length; index++)
        {
            var item = $scope.model.references[index];
            if (item.selected)
            {
                $scope.model.references.splice(index, 1);
                index--;
            }
        }
    };
    $scope.save = function ()
    {
        alert($scope.model.hobbies.length);
        $http.post(url + "employee/save", $scope.model)
                .success(function (data)
                {
                    window.location = url + "employee/entry.html?id=" + data.id;
                });
    };
    $scope.clear = function ()
    {
        $scope.init();
    };
});
