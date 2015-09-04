<%-- 
    Document   : entry
    Created on : 28-Aug-2015, 10:28:15
    Author     : anawatj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute  name="body">
        <div class="col-xs-12" ng-controller="purchaseEntryCtrl" ng-init="init()">
            <form id="frmPurchase">
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
                        <input type="text" class="form-control" ng-model="model.description"/>
                    </div>
                </div>  
                <div class="row">
                    <div class="col-xs-3">
                        <label for="purchaseBy">PurchaseBy</label>
                    </div>
                    <div class="col-xs-3">
                        <div class="input-group">
                            <input type="text" class="form-control" ng-model="model.purchaseBy.code"/>
                            <span class="input-group-btn">
                                <button class="btn btn-default" ng-click="findPurchaseBy()"><span class="glyphicon glyphicon-search"></span></button>
                            </span>
                            <label>{{model.purchaseBy.name}}</label>
                        </div>
                    </div>
                    <div class="col-xs-3">
                        <label for="purchaseDate">Purchase Date</label>
                    </div>
                    <div class="col-xs-3">
                        <input kendo-date-picker k-format="'dd/MM/yyyy'" k-ng-model="model.purchaseDate"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label for="approveBy">Approve By</label>
                    </div>
                    <div class="col-xs-3">
                        <div class="input-group">
                            <input type="text" class="form-control" ng-model="model.approveBy.code"/>
                            <span class="input-group-btn">
                                <button class="btn btn-default" ng-click="findApproveBy()"><span class="glyphicon glyphicon-search"></span></button>
                            </span>
                            <label>{{model.approveBy.name}}</label>
                        </div>
                    </div>
                    <div class="col-xs-3">
                        <label for="approveDate">ApproveDate</label>
                    </div>
                    <div class="col-xs-3">
                        <input kendo-date-picker k-format="'dd/MM/yyyy'" k-ng-model="model.approveDate"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label for="department">Department</label>
                    </div>
                    <div class="col-xs-3">
                        <select ng-model="model.department.id" class="form-control">
                            <option value="0"></option>
                            <option ng-repeat="item in departments" ng-selected="item.id == model.department.id" value="{{item.id}}">{{item.desc}}</option>
                        </select>
                    </div>

                    <div class="col-xs-3">
                        <label for="department">Branch</label>
                    </div>
                    <div class="col-xs-3">
                        <select ng-model="model.branch.id" class="form-control">
                            <option value="0"></option>
                            <option ng-repeat="item in branches" ng-selected="item.id == model.branch.id" value="{{item.id}}">{{item.desc}}</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label for="supplier">Supplier</label>
                    </div>
                    <div class="col-xs-7">
                        <div class="input-group">
                            <input type="text" class="form-control" ng-model="model.supplier.code"/>
                            <span class="input-group-btn">
                                <button class="btn btn-default" ng-click="findSupplier()"><span class="glyphicon glyphicon-search"></span></button>
                            </span>
                            <label>{{model.supplier.name}}</label>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#product" data-toggle="tab">Product</a></li>
                            <li><a href="#service" data-toggle="tab">Service</a></li>
                        
                        </ul>
                        <div class="tab-content">
                                <div id="product" class="tab-pane fade in active">

                                <jsp:include page="${context}/purchase/tabProduct.html"></jsp:include>
                                </div>
                                <div id="service" class="tab-pane fade">

                                <jsp:include page="${context}/purchase/tabService.html"></jsp:include>
                                </div>
                        </div>
                    </div>
                </div>
               <div class="row">
                   <div class="col-xs-12">
                       <button class="btn btn-default" ng-click="save()">Save</button>
                       <button class="btn btn-default" ng-click="approve()">Approve</button>
                       <button class="btn btn-default" ng-click="clear()">Clear</button> 
                   </div>
               </div>
            </form>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>

