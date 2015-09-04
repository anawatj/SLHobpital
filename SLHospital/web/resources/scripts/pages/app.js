/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var url = "http://localhost:8080/SLHospital/";
var app = angular.module('example',['kendo.directives','ui.bootstrap','checklist-model','base64']);
app.directive('fileModel', ['$parse', function ($parse) {
    return {
        restrict: 'A',
        link: function (scope, element, attrs) {
            var model = $parse(attrs.fileModel);
            var modelSetter = model.assign;

            element.bind('change', function () {
                scope.$apply(function () {
                    modelSetter(scope, element[0].files[0]);
                });
            });
        }
    };
}]);

app.service('fileUpload', ['$http', function ($http) {
    this.uploadFileToUrl = function (file, uploadUrl) {
        var fd = new FormData();
        fd.append('file', file);
        $http.post(uploadUrl, fd, {
            transformRequest: angular.identity,
            headers: { 'Content-Type': undefined }
        })
        .success(function () {
        })
        .error(function () {
        });
    }
}]);


app.factory('$dialogUtils', function() {
    return {
        confirm: function(str, callback) {
            bootbox.confirm({
                message: str,
                buttons: {
                    "cancel": {
                        label: "ยกเลิก"
                    },
                    "confirm": {
                        label: "ตกลง",
                        className: "btn-primary"
                    }
                },
                callback: callback
            });
        },
        alert: function(str, callback) {
            bootbox.alert(str, callback);
        },
        dialog: function(str, buttons) {
        	bootbox.dialog({
        		  message: str,
        		  title: "Shawpat",
        		  buttons: buttons
        		});
        }
    };
});

app.factory('$pageUtils', function() {
    return {
        createParamStringFromObject: function(obj) {
        	var paramString = "";
        	for(var attr in obj) {
    			if(obj.hasOwnProperty(attr)) 
    			{
    				if(obj[attr] == "" || (typeof obj[attr] === "undefined"))
    				{
    					delete obj[attr];
    				}
    			}
    		}
        	if(!(typeof obj === "undefined")) {
    			paramString = $.param( obj );	
    		}
        	return paramString;
        },
    	washValues_new:function(obj) 
    	{
    		for(var attr in obj) {
    			if(obj.hasOwnProperty(attr)) 
    			{
    				if(attr==="@id" || attr==="@ref"){
    					delete obj[attr];
    				}
    				else if ($.isArray(obj[attr]) || typeof obj[attr] === "object") {
    					this.washValues(obj[attr]);
    				}
    				else if (obj[attr]) { // <== isDefined and not null
    					if(obj[attr].hasOwnProperty("@id")) {
    						delete obj[attr]["@id"];
    					}
    					if(obj[attr].hasOwnProperty("@ref")) {
    						delete obj[attr]["@ref"];
    					}
						if (obj[attr].hasOwnProperty("id")) {
							if (obj[attr].id == "") {
								obj[attr] = undefined;
							}
						}
					}
    				else if (obj[attr] == "")
    				{
    					obj[attr] = undefined;
    				}
    			}
    		}
    	},

    	washValues:function(obj) 
    	{
    		for(var attr in obj) {
    			if(obj.hasOwnProperty(attr)) 
    			{
					if (obj[attr]) { // <== isDefined and not null
						if (obj[attr].hasOwnProperty("id")) {
							if (obj[attr].id == "") {
								obj[attr] = undefined;
							}
						}
					}
    				else if (obj[attr] == "")
    				{
    					obj[attr] = undefined;
    				}
    				
    			}
    		}
    	},
    	
    	convertDateToShow: function(date) {
    		if(date){
                return date.substring(6, 8)+"/"+date.substring(4, 6)+"/"+date.substring(0, 4);   			
    		}else {
    			return date;
    		}
        },        
    	convertStrDateToShow: function(date) {
    		return date.substring(6, 8)+"/"+date.substring(4, 6)+"/"+date.substring(0, 4);   			
        },        
        convertDateISO: function(date) {
        	if(date){
        		return new Date(date).toISOString();
        	}
        	else{
        		return undefined;
        	}
        },
    	yyyymmddToDate: function(yyyymmdd) {
    		if(yyyymmdd && yyyymmdd.length == 8){
                return new Date(yyyymmdd.substring(0, 4)+"-"+yyyymmdd.substring(4, 6)+"-"+yyyymmdd.substring(6, 8));   			
    		}else {
    			return null;
    		}
        },
        getUrlVars : function()
        {
            var vars = [], hash;
            var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
            for(var i = 0; i < hashes.length; i++)
            {
                hash = hashes[i].split('=');
                vars.push(hash[0]);
                vars[hash[0]] = hash[1];
            }
            return vars;
        },
        getCurrentTime : function() 
        {
			var now = new Date();
			var hour = now.getHours();
			var minute = now.getMinutes();

			if (hour.toString().length == 1) {
				var hour = '0' + hour;
			}
			if (minute.toString().length == 1) {
				var minute = '0' + minute;
			}

			var dateTime = hour + ':' + minute
			return dateTime;
		}

    };
});


app.constant('config', {
	paginationSize: 5,
	pageSize: 10 
});

app.run(function($rootScope, $dialogUtils, $pageUtils) {
// $rootScope.dialogUtils = $dialogUtils;
//	$rootScope.pageUtils = $pageUtils;
});


//app.factory('progressbarInterceptor', ['$q', function($q) {  
//    var progressbarShow = {
//		'request': function(config) {
//        	if (config.url.endsWith("/getById") ||
//            	config.url.endsWith("/getByBpId") ||
//        		config.url.endsWith("/save") ||
//        		config.url.endsWith("/post") ||
//        		config.url.endsWith("/delete") ||
//        		config.url.endsWith("/cancel") ||
//        		config.url.endsWith("/search")) 
//        	{
//        		$('#pleaseWaitDialog').modal('show');
//        	}            		
//        	return config;
//		},
//        'requestError': function(rejection) {
//			$('#pleaseWaitDialog').modal('hide');
//            return $q.reject(rejection);
//        },
//        'response': function(response) {
//
//        	if (response.config.url.endsWith("/save") ||
//        			response.config.url.endsWith("/delete") ||
//        			response.config.url.endsWith("/post") ||
//        			response.config.url.endsWith("/cancel") 
//        			) {
//        		var deferred = new $.Deferred();  		
//        		bootbox.alert("process data successfully.", function() {
//            		$('#pleaseWaitDialog').modal('hide');
//        			deferred.resolve(response);
//        			});        		
//            	return deferred.promise();;
//        	}  
//        	if (response.config.url.endsWith("/getById") ||
//        		response.config.url.endsWith("/getByBpId") ||
//        		response.config.url.endsWith("/search")) 
//            	{
//            		$('#pleaseWaitDialog').modal('hide');
//                	return $q.when(response);       		
//            	}            		
//        	else {
//            	return $q.when(response);       		
//        	}
//        },
//        'responseError': function(rejection) {
//        	$('#pleaseWaitDialog').modal('hide');
//        	$('#AlertModal .modal-title').html("<H3> Oops! </H3>");
//        	var errorCode = rejection.data.errorCode===undefined?"ERR-0000":rejection.data.errorCode;
//        	var errorMessage = rejection.data.errorMessage===undefined?"พบข้อผิดพลาด โปรดติดต่อผู้ดูแลระบบ":rejection.data.errorMessage;
//        	var rejectContent = "<h4>"+errorCode+": &nbsp;"+errorMessage+"</h4>";
//        	$('#AlertModal .modal-body').html(rejectContent);
//        	$('#AlertModal').modal('show');
//        	return $q.reject(rejection);
//        }
//    };
//    return progressbarShow;
//}]);
//
//app.factory('logoutInterceptor', ['$q', function($q) {  
//	return {
//        'response': function (response) {
//        	// If keyword 'Logon' found, reload the page.
//        	if (angular.isString(response.data) && response.data.indexOf('Login') != -1) {
//                window.location.reload()
//        	}
//            //Will only be called for HTTP up to 300
//            //console.log(response);
//            return response;
//        },
////        'responseError': function (rejection) {
////            if(rejection.status === 401) {
////                location.reload();
////            }
////            return $q.reject(rejection);
////        }
//    };
//}]);
//
//app.config(['$httpProvider','$locationProvider', function($httpProvider,$locationProvider) {  
//	$locationProvider.html5Mode({
//		  enabled: true,
//		  requireBase: false
//		});
//	$httpProvider.interceptors.push('progressbarInterceptor');
//    $httpProvider.interceptors.push('logoutInterceptor');
//}]);



