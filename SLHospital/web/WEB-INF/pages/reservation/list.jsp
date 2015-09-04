<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute  name="body">
        <div class="col-xs-12" ng-controller="reservationListCtrl" ng-init="init()">
            <form>
                <div class="row">
                    <div class="col-xs-3">
                        <label>Code</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" class="form-control" ng-model="model.code"/>
                    </div>
                    <div class="col-xs-3">
                        <label>Desc</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" class="form-control" ng-model="model.description"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label>Request By</label>
                    </div>
                    <div class="col-xs-3">
                        <div class="input-group">
                            <input type="text" class="form-control" ng-model="model.requestBy"/>
                            <span class="input-group-btn">
                                <button class="btn btn-default" ng-click="findRequestBy()"><span class="glyphicon glyphicon-search"></span></button>
                            </span>
                        </div>
                    </div>
                    <div class="col-xs-3">
                        <label>Request Date</label>
                    </div>
                    <div class="col-xs-3">
                        <div class="input-group">
                            <input kendo-date-picker k-format="'dd/MM/yyyy'" k-ng-model="model.reservationDateFrom"/>
                            <input kendo-date-picker k-format="'dd/MM/yyyy'" k-ng-model="model.reservationDateTo"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <button class="btn btn-default" ng-click="search()">Search</button>
                        <button class="btn btn-default" ng-click="clear()">Clear</button>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <table class="table table-bordered table-hover table-condensed grid">
                            <thead>
                                <tr>
                                    <th></th>
                                    <th></th>
                                    <th>Code</th>
                                    <th>Description</th>
                                    <th>RequestBy</th>
                                    <th>RequestDate</th>
                                    <th>ApproveBy</th>
                                    <th>ApproveDate</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr ng-repeat="item in results">
                                    <td>
                                        <button class="btn btn-default" ng-click="edit(item.id)">Edit</button>
                                    </td>
                                    <td>
                                        <button class="btn btn-default" ng-click="remove(item.id)">Delete</button>
                                    </td>
                                    <td>
                                        {{item.code}}
                                    </td>
                                    <td>
                                        {{item.description}}
                                    </td>
                                    <td>
                                        {{item.reservationBy.firstName}} {{item.reservationBy.lastName}}
                                    </td>
                                    <td>
                                        {{item.reservationDate | date:'dd/MM/yyyy'}}
                                    </td>
                                    <td>
                                        {{item.approveBy.firstName}} {{item.approveBy.lastName}}
                                    </td>
                                    <td>
                                        {{item.approveDate | date:'dd/MM/yyyy'}}
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </form>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>