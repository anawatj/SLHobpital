<%-- 
    Document   : entry
    Created on : 28-Aug-2015, 16:52:10
    Author     : anawatj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute  name="body">
        <div class="col-xs-12" ng-controller="userEntryCtrl" ng-init="init()">
            <form>
                <div class="row">
                    <div class="col-xs-3">
                        <label for="code">Code</label>
                    </div>
                    <div class="col-xs-7">
                        <input type="text" class="form-control" ng-model="model.code"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label for="name">Name</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" class="form-control" ng-model="model.name"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label for="password">Password</label>
                    </div>
                    <div class="col-xs-7">
                        <input type="password" class="form-control" ng-model="model.password"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <table class="table table-bordered table-hover table-condensed grid">
                            <thead>
                                <tr>
                                    <th></th>
                                    <th>RoleCode</th>
                                    <th>RoleName</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr ng-repeat="item in model.roles">
                                    <td><input type="checkbox" ng-model="item.selected"/></td>
                                    <td>
                                   
                                            {{item.code}}
                                       
                                    </td>
                                    <td>
                                        {{item.name}}
                                    </td>
                                </tr>
                            </tbody>
                            <tfoot>
                                <tr>
                                    <td colspan="3">
                                        
                                        <button class="btn btn-default" ng-click="addRole()">Add</button>
                                        <button class="btn btn-default" ng-click="delRole()">Del</button>
                                    </td>
                                </tr>
                            </tfoot>
                        </table>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <button class="btn btn-default" ng-click="save()">Save</button>
                         <button class="btn btn-default" ng-click="clear()">Clear</button>
                    </div>
                </div>
            </form>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>