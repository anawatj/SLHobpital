<%-- 
    Document   : entry
    Created on : 26-Aug-2015, 16:48:40
    Author     : anawatj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute  name="body">
        <div class="col-xs-12" ng-controller="projectEntryCtrl" ng-init="init()">
            <form>
                <div class="row">
                    <div class="col-xs-3"><label for="code">Code</label></div>
                    <div class="col-xs-3"> <input type="text" class="form-control" ng-model="model.code"/></div>
                    <div class="col-xs-3"><label for="name">Name</label></div>
                    <div class="col-xs-3"><input type="text" class="form-control" ng-model="model.name"/></div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label class="type">Type</label>
                    </div>
                    <div class="col-xs-7">
                        <div class="radio">
                            <input type="radio" name="type" ng-model="model.type" checked="checked" value="A"/><label>Commercial</label>
                        </div>
                        <div class="radio">
                            <input type="radio" name="type" ng-model="model.type" value="B"/><label>Industrial</label>
                        </div>
                        
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <table class="table table-bordered table-hover table-condensed grid">
                            <thead>
                                <tr>
                                    <th></th>
                                    <th>ProductGroup</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr ng-repeat="item in model.items">
                                    <td>
                                        <input type="checkbox" ng-model="item.selected"/>
                                    </td>
                                    <td>
                                        <input type="text" class="form-control" ng-model="item.projectGroup"/>
                                    </td>
                                    <td>
                                        <button class="btn btn-default" ng-click="editFrm(item)">....</button>
                                    </td>
                                    
                                </tr>
                            </tbody>
                            <tfoot>
                                <tr>
                                    <td colspan="3">
                                        <button class="btn btn-default" ng-click="addItem()">Add</button>
                                        <button class="btn btn-default" ng-click="delItem()">Del</button>
                                    </td>
                                </tr>
                            </tfoot>
                        </table>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <button class="btn btn-default" ng-click="save()">Save</button>
                            <button class="btn btn-default" ng-click="clear()">Clear</button>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>