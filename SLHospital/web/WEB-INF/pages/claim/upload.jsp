<%-- 
    Document   : upload
    Created on : 20-Aug-2015, 15:26:50
    Author     : anawatj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute  name="body">
        <div class="col-xs-12" ng-controller="claimUploadCtrl">
            <form id="frmClaimUpload">
                <div class="row">
                    <div class="col-xs-3">
                        <label for="file">File</label>
                    </div>
                    <div class="col-xs-6">
                        <input type="file" class="form-control" onchange="angular.element(this).scope().uploadedFile(this)"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <button class="btn btn-default" ng-click="save()">Upload</button>
                    </div>
                </div>
            </form>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>

