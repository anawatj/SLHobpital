<%-- 
    Document   : templateLogin
    Created on : 24-Aug-2015, 14:07:23
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
        <title>HHH Hospital</title>
        <link  rel="stylesheet" href="${context}/webjars/bootstrap/3.3.5/css/bootstrap.min.css"/>
        <link href="http://cdn.kendostatic.com/2014.2.716/styles/kendo.common-bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="http://cdn.kendostatic.com/2014.2.716/styles/kendo.bootstrap.min.css" rel="stylesheet" type="text/css" />

        <script type="text/javascript" src="${context}/webjars/jquery/2.1.4/jquery.min.js"></script>
        <script src="${context}/webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
        <script type="text/javascript" src="${context}/webjars/angularjs/1.4.1/angular.min.js"></script>
        <script src="http://cdn.kendostatic.com/2014.2.716/js/kendo.ui.core.min.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/lib/ui-bootstrap-tpls-0.13.3.min.js"></script>
        <script type="text/javascript" src="${context}/resources/scripts/pages/app.js"></script>
    </head>
    <body style="background-image:url('${context}/resources/images/bg_img.jpg');background-size:cover;color:black;font-weight:bolder" ng-app="example">
        <div class='col-xs-12'>
            <div class='row'>
                <div class='col-xs-4'>
                    <img src="${context}/resources/images/logo.gif"/>
                </div>
                <div class='col-xs-8' style="color:black">
                    <label style="font-size:40px;font-weight:bolder">HHH Hospital System</label>
                </div>
            </div>
            <div class="row">
                &nbsp;
            </div>
           
                <div class='row'  >
                    <div class="col-xs-4">&nbsp;</div>
                    <div class='col-xs-4' style="background-color:white">
                        <fieldset style="height:200px">
                            <legend style="font-size:40px;font-weight:bolder;color:black;">Login</legend>


                            <tiles:insertAttribute name="body"></tiles:insertAttribute>
                        </fieldset>
                    </div>
                    <div class="col-xs-4">&nbsp;</div>
                </div>
     
            <div class="row" style="text-align:center ">
                <div class="col-xs-12">
                    Copy right by HHH hospital
                </div>
            </div>
        </div>
    </body>
</html>
