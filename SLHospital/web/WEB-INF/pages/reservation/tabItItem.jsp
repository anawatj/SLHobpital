<%-- 
    Document   : tabItItem
    Created on : Sep 1, 2015, 6:31:39 PM
    Author     : Tao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table class="table table-bordered table-hover table-condensed grid">
    <thead>
        <tr>
            <th></th>
            <th>Equipment</th>
            <th>FromDate</th>
            <th>FromTime</th>
            <th>ToDate</th>
            <th>ToTime</th>
            <th>Serial No</th>
        </tr>
    </thead>
    <tbody>
        <tr ng-repeat="item in model.its">
            <td>
                
                <input type="checkbox" ng-model="item.selected"/>
            </td>
            <td>
                <select class="form-control" ng-model="item.equipment.id">
                    <option value="0"></option>
                    <option ng-repeat="sitem in its" ng-selected="sitem.id==item.equipment.id" value="{{sitem.id}}">{{sitem.desc}}</option>
                </select>
            </td>
            <td>
                <input kendo-date-picker  k-format="'dd/MM/yyyy'" k-ng-model="item.resvFromDate"/>
            </td>
            <td>
                <input kendo-time-picker ng-model="item.resvFromTime" k-format="'HH:mm'" />
            </td>
            <td>
                <input kendo-date-picker k-format="'dd/MM/yyyy'" k-ng-model="item.resvToDate"/>
            </td>
            <td>
                <input kendo-time-picker ng-model="item.resvToTime" k-format="'HH:mm'" />
            </td>
            <td>
                <input class="form-control" ng-model="item.serialNo"/>
            </td>
        </tr>
        
    </tbody>
    <tfoot>
        <tr>
            <td colspan="7">
                <button class="btn btn-default" ng-click="addIt()">Add</button>
                <button class="btn btn-default" ng-click="delIt()">Del</button>
            </td>
        </tr>
    </tfoot>
</table>