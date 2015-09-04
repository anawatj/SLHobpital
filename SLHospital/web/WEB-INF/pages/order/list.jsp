<%-- 
    Document   : list
    Created on : 28-Aug-2015, 16:51:27
    Author     : anawatj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute  name="body">
        <div class="col-xs-12" ng-controller="orderListCtrl" ng-init="init()">
            <form>
                <div class="row">

                    <div class="col-xs-3">
                        <label>Code</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" class="form-control" ng-model="model.code"/>
                    </div>
                    <div clas="col-xs-3">
                        <label>Name</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" class="form-control" ng-model="model.name"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label for="orderDate">OrderDate</label>
                    </div>
                    <div class="col-xs-9">
                        <div class="input-group">
                            <input kendo-date-picker k-ng-model="model.orderDateStart" k-format="'dd/MM/yyyy'"/>
                            <input kendo-date-picker k-ng-model="model.orderDateEnd" k-format="'dd/MM/yyyy'"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label for="orderDate">RequireDate</label>
                    </div>
                    <div class="col-xs-9">
                        <div class="input-group">
                            <input kendo-date-picker k-ng-model="model.requireDateStart" k-format="'dd/MM/yyyy'"/>
                            <input kendo-date-picker k-ng-model="model.requireDateEnd" k-format="'dd/MM/yyyy'"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label>OrderBy</label>
                    </div>
                    <div class="col-xs-9">
                        <div class="input-group">
                            <input type="text" class="form-control" ng-model="model.employee"/>
                            <span class="input-group-btn">
                                <button class="btn btn-default" ng-click="findEmployee()"><span class="glyphicon glyphicon-search"></span></button>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label>Customer</label>
                    </div>
                    <div class="col-xs-9">
                        <div class="input-group">
                            <input type="text" class="form-control" ng-model="model.customer"/>
                            <span class="input-group-btn">
                                <button class="btn btn-default" ng-click="findCustomer()"><span class="glyphicon glyphicon-search"></span></button>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label>Shipper</label>
                    </div>
                    <div class="col-xs-3">
                        <select class="form-control">
                            <option value="0"></option>
                            <option ng-repeat="item in shippers" value="{{item.id}}">{{item.desc}}</option>
                        </select>
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
                                    <th>Name</th>
                                    <th>RequestBy</th>
                                    <th>Customer</th>
                                    <th>OrderDate</th>
                                    <th>Status</th>
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
                                        {{item.requestBy.name}}
                                    </td>
                                    <td>
                                        {{item.customer.name}}
                                    </td>
                                    <td>
                                        {{item.orderDate | date:'dd/MM/yyyy'}}
                                    </td>
                                    <td>
                                        <label ng-if="item.status=='P'">Process</label>
                                        <label ng-if="item.status=='A'">Approve</label>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                        <pagination ng-model="model.page" ng-change="search()" total-items="totalItems" num-pages="numPages"
                                    items-per-page="pageSize" max-size="maxSize" class="pagination-xs" boundary-links="true" rotate="false"></pagination>
                    </div>
                </div>
            </form>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>