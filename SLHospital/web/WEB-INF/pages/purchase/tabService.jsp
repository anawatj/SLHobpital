<%-- 
    Document   : tabService
    Created on : 28-Aug-2015, 10:50:58
    Author     : anawatj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table class="table table-bordered table-hover table-condensed grid">
       <thead>
            <tr>
                <th></th>
                <th>Service</th>
                <th>Quantity</th>
                <th>Unit Price</th>
                <th>Vat</th>
                <th>Include</th>
            </tr>
        </thead>
        <tbody>
            <tr ng-repeat="item in model.services">
                <td>
                    <input type="checkbox" ng-model="item.selected"/>
                    
                </td>
                <td>
                    <select ng-model="item.service.id" class="form-control">
                        <option value="0"></option>
                        <option ng-repeat="sitem in services" ng-selected="sitem.id==item.service.id" value="{{sitem.id}}">{{sitem.desc}}</option>
                    </select>
                </td>
                <td>
                    <input kendo-numeric-text-box ng-model="item.quantity"/>
                </td>
                <td>
                    <input kendo-numeric-text-box ng-model="item.unitPrice"/>
                </td>
                <td>
                    <input kendo-numeric-text-box ng-model="item.vat"/>
                </td>
                <td>
                    <input type="checkbox" ng-model="item.flagVat" ng-true-value="'I'" ng-false-value="'E'" ng-checked="item.flagVat=='I'"/>
                </td>
            </tr>
        </tbody>
        <tfoot>
            <tr>
                <td colspan="6">
                    <button class="btn btn-default" ng-click="addService()">Add</button>
                    <button class="btn btn-default" ng-click="delService()">Del</button>
                </td>
            </tr>
        </tfoot>
</table>