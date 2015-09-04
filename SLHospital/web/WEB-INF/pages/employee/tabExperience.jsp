<%-- 
    Document   : tabExperience
    Created on : 27-Aug-2015, 11:05:07
    Author     : anawatj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <table class="table table-bordered table-hover table-condensed grid">
        <thead>
            <tr>
                <th></th>
                <th>Company</th>
                <th>Position</th>
                <th>Responsibility</th>
                <th>HiredDate</th>
                <th>ResignDate</th>
                <th>Salary</th>
                <th>Reason Of Resign</th>
            </tr>
        </thead>

        <tbody>
            <tr ng-repeat="item in model.experiences">
                <td>

                    <input type="checkbox" ng-model="item.selected"/>
                </td>

                <td>
                    <input type="text" class="form-control" ng-model="item.company"/>
                </td>
                <td>
                    <input type="text" class="form-control" ng-model="item.position"/>
                </td>
                <td>
                    <textarea class="form-control" ng-model="item.reponsiability"></textarea>
                </td>

                <td>
                    <input kendo-date-picker k-format="'dd/MM/yyyy'" k-ng-model="item.hiredDate"  />
                </td>
                <td>
                    <input kendo-date-picker k-format="'dd/MM/yyyy'" k-ng-model="item.resignedDate"  />
                </td>
                <td>
                    <input kendo-numeric-text-box ng-model="item.salary"/>
                </td>
                <td>
                    <textarea class="form-control" ng-model="item.reasonOfResign"></textarea>
                </td>
            </tr>
        </tbody>
        <tfoot>
            <tr>
                <td colspan="8">
                    <button class="btn btn-default" ng-click="addExperience()">Add</button>
                    <button class="btn btn-default" ng-click="delExperience()">Del</button>
                </td>
            </tr>
        </tfoot>
    </table>
