<%-- 
    Document   : tabChildren
    Created on : 27-Aug-2015, 14:32:42
    Author     : anawatj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table class="table table-bordered table-hover table-condensed grid">
       <thead>
            <tr>
                <th></th>
                <th>Title</th>
                <th>FirstName</th>
                <th>LastName</th>
                <th>Company</th>
                <th>Position</th>
                <th>Age</th>

            </tr>
        </thead>
        <tbody>
            <tr ng-repeat="item in model.children">
                <td><input type="checkbox" ng-model="item.selected"/></td>
                <td>
                    <select class="form-control" ng-model="item.title.id">
                        <option value="0"></option>
                        <option ng-repeat="sitem in titles" ng-selected="sitem.id==item.title.id" value="{{sitem.id}}">{{sitem.desc}}</option>
                    </select>
                </td>
                <td>
                    <input type="text" class="form-control" ng-model="item.firstName"/>
                </td>
                <td>
                    <input type="text" class="form-control" ng-model="item.lastName"/>
                </td>
                <td>
                    <input type="text" class="form-control" ng-model="item.company"/>
                </td>
                <td>
                    <input type="text" class="form-control" ng-model="item.position"/>
                </td>
                <td>
                    <input kendo-numeric-text-box ng-model="item.age"/>
                </td>
            </tr>
        </tbody>
        <tfoot>
            <tr>
                <td colspan="7">
                    <button class="btn btn-default" ng-click="addChild()">Add</button>
                    <button class="btn btn-default" ng-click="delChild()">Del</button>
                </td>
            </tr>
        </tfoot>
</table>
