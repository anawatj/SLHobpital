<%-- 
    Document   : template
    Created on : 18-Aug-2015, 16:32:40
    Author     : anawatj
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<c:set var="context" value="${pageContext.request.servletContext.contextPath}" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saintluis Hospital</title>
        <link  rel="stylesheet" href="${context}/webjars/bootstrap/3.3.5/css/bootstrap.min.css"/>
        <link href="http://cdn.kendostatic.com/2014.2.716/styles/kendo.common-bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="http://cdn.kendostatic.com/2014.2.716/styles/kendo.bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="${context}/resources/style/sl-styles.css" rel="stylesheet" type="text/css"/>
        <script type="text/javascript" src="${context}/webjars/jquery/2.1.4/jquery.min.js"></script>
        <script src="${context}/webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${context}/webjars/angularjs/1.4.1/angular.min.js"></script>
        <script src="http://cdn.kendostatic.com/2014.2.716/js/kendo.ui.core.min.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/lib/ui-bootstrap-tpls-0.13.3.min.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/lib/checklist-model.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/lib/angular-base64.min.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/pages/app.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/pages/pageCtrl.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/pages/employee/entryCtrl.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/pages/employee/listCtrl.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/pages/claim/uploadCtrl.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/pages/supplier/entryCtrl.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/pages/supplier/listCtrl.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/pages/supplier/searchModalCtrl.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/pages/customer/entryCtrl.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/pages/customer/listCtrl.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/pages/product/entryCtrl.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/pages/product/listCtrl.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/pages/project/entryCtrl.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/pages/project/listCtrl.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/pages/project/frmModalCtrl.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/pages/employee/searchModalCtrl.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/pages/purchase/entryCtrl.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/pages/purchase/listCtrl.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/pages/product/searchModalCtrl.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/pages/user/entryCtrl.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/pages/user/listCtrl.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/pages/role/searchMultiModalCtrl.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/pages/order/listCtrl.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/pages/order/entryCtrl.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/pages/customer/searchModalCtrl.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/pages/reservation/entryCtrl.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/pages/reservation/listCtrl.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/pages/attachment/entryModalCtrl.js"></script>
        <style>
            .dropdown:hover>.dropdown-menu
            {
                display: block;
                float: right;

            }
            table.grid
            {

            }
            table.grid th 
            {
                background-color:#848484;
                color:white
            }



        </style>

    </head>
    <body ng-app="example" >
        <div class="col-xs-12" ng-controller="pageCtrl">
            <div class="row" class="col-xs-12" style="background-color:#848484;color:white">

                <div class="col-xs-4">
                    <img src="${context}/resources/images/logo.gif"/>
                </div>
                <div class="col-xs-8">


                    <h1>Saintluis Hospital System</h1>
                </div>
            </div>



            <div class='row'>
                <div class='col-xs-4'>
                    <label >  <a href="${context}/index.html" >Home</a> > {{pageName}}</label>
                     | <label ><a href="{{urlLink}}">{{link}}</a></label>
                </div>
                <div class='col-xs-4'>
                    &nbsp;
                </div>

                <div class='col-xs-4' style="text-align: right">
                    
                          <a href="${context}/user/changePassword.html?id={{profile.id}}" id="lbtnUser"><span class="glyphicon glyphicon-user"></span> {{profile.code}}</a>
                    <a href="${context}/logout" id="lbtnLogout"><span class="glyphicon glyphicon-log-out"></span> Logout</a>
                   
                </div>
            </div>

            <div class="row" >
                <div class="col-xs-12" >
                    <div class="content"   >
                        <fieldset style="border:1px solid #848484">
                            <tiles:insertAttribute name="body"></tiles:insertAttribute>
                        </fieldset>

                    </div>
                </div>
            </div>
            <DIV class="row">
                &nbsp;
            </DIV>
            <div class="row" style="background-color:#848484;color:white;text-align:center ">
                <div class="col-xs-12">
                    Copy right by Saintluis hospital
                </div>
            </div>
        </div>

    </body>
</html>
