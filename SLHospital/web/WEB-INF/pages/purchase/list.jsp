<%-- 
    Document   : list
    Created on : 28-Aug-2015, 10:28:04
    Author     : anawatj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute  name="body">
        <div class="col-xs-12" ng-controller="purchaseListCtrl" ng-init="init()">

            <form>
                <div class="row">
                    <div class="col-xs-3">
                        <label for="code">Code</label>
                    </div>
                    <div class="col-xs-3">  
                        <input type="text" class="form-control" ng-model="model.code"/>
                    </div>
                    <div class="col-xs-3">
                        <label for="name">Name</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" class="form-control" ng-model="model.name"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label>Purchase Date</label>
                    </div>
                    <div class="col-xs-7">
                        <div class="input-group">
                            <input kendo-date-picker k-format="'dd/MM/yyyy'" k-ng-model="model.purchaseDateStart"/>
                            <label>ถึง</label>
                            <input kendo-date-picker k-format="'dd/MM/yyyy'" k-ng-model="model.purchaseDateEnd"/>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label for="purchaseBy">PurchaseBy</label>
                    </div>
                    <div class="col-xs-7">
                         <div class="input-group">
                            <input type="text" class="form-control" ng-model="model.purchaseBy"/>
                            <span class="input-group-btn">
                                <button class="btn btn-default" ng-click="findPurchaseBy()"><span class="glyphicon glyphicon-search"></span></button>
                            </span>
                            
                        </div>
                    </div>
                       <div class="col-xs-3">
                        <label for="purchaseBy">Supplier</label>
                    </div>
                    <div class="col-xs-7">
                         <div class="input-group">
                            <input type="text" class="form-control" ng-model="model.supplier"/>
                            <span class="input-group-btn">
                                <button class="btn btn-default" ng-click="findSupplier()"><span class="glyphicon glyphicon-search"></span></button>
                            </span>
                            
                        </div>
                    </div>
                </div>
           
                <div class="row">
                         <div class="col-xs-3">
                        <label for="department">Department</label>
                    </div>
                    <div class="col-xs-3">
                        <select ng-model="model.department" class="form-control">
                            <option value="0"></option>
                            <option ng-repeat="item in departments"  value="{{item.id}}">{{item.desc}}</option>
                        </select>
                    </div>

                    <div class="col-xs-3">
                        <label for="department">Branch</label>
                    </div>
                    <div class="col-xs-3">
                        <select ng-model="model.branch" class="form-control">
                            <option value="0"></option>
                            <option ng-repeat="item in branches"  value="{{item.id}}">{{item.desc}}</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label>Status</label>
                    </div>
                    <div class="col-xs-3">
                        <select class="form-control" ng-model="model.status">
                            <option value=""></option>
                            <option ng-repeat="item in statuses" value="{{item.code}}">{{item.desc}}</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <button class="btn btn-default" ng-click="search()">ค้นหา</button>
                        <button class="btn btn-default" ng-click="clear()">เคลียร์หน้าจอ</button>
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
                                    <th>Supplier</th>
                                    <th>PurchaseBy</th>
                                    <th>PurchaseDate</th>
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
                                        {{item.supplier.name}}
                                    </td>
                                    <td>
                                        {{item.purchaseBy.firstName}} {{item.purchaseBy.lastName}}
                                    </td>
                                    <td>
                                        {{item.purchaseDate | date:'dd/MM/yyyy'}}
                                    </td>
                                    <td>
                                        <label ng-if="item.active=='P'">Process</label>
                                        <label ng-if="item.actie=='A'">Approve</label>
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
