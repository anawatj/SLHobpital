<%-- 
    Document   : tabTraining
    Created on : 27-Aug-2015, 14:35:13
    Author     : anawatj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table class="table table-bordered table-hover table-condensed grid">
       <thead>
            <tr>
                <th></th>
                <th>company</th>
                <th>courseName</th>
                <th>startDate</th>
                <th>endDate</th>
              

            </tr>
        </thead>
        <tbody>
            <tr ng-repeat="item in model.trainings">
                <td><input type="checkbox" ng-model="item.selected"/></td>
                <td>
                     <input type="text" class="form-control" ng-model="item.company"/>
                </td>
                <td>
                    <input type="text" class="form-control" ng-model="item.courseName"/>
                </td>
                <td>
                    <input kendo-date-picker k-format="'dd/MM/yyyy'" k-ng-model="item.startDate"/>
                </td>
                <td>
                  <input kendo-date-picker k-format="'dd/MM/yyyy'" k-ng-model="item.endDate"/>
                </td>
           
            </tr>
        </tbody>
        <tfoot>
            <tr>
                <td colspan="5">
                    <button class="btn btn-default" ng-click="addTraining()">Add</button>
                    <button class="btn btn-default" ng-click="delTraining()">Del</button>
                </td>
            </tr>
        </tfoot>
</table>
