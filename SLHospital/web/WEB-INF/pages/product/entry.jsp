<%-- 
    Document   : entry
    Created on : 24-Aug-2015, 08:32:12
    Author     : anawatj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute  name="body">
        <div class="col-xs-12" ng-controller="productEntryCtrl" ng-init="init()">
            <form id="frmProduct">
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
                    <div class="col-xs-7">
                        <input type="text" class="form-control" ng-model="model.name"/>
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
                    <div class="col-xs-3">
                        <label for="unitPrice">Unit Price</label>
                    </div>
                    <div  class="col-xs-7">
                        <input kendo-numeric-text-box ng-model="model.unitPrice"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label>Unit InStock</label>
                    </div>
                    <div class="col-xs-7">
                        <input kendo-numeric-text-box ng-model="model.unitInStock"/>

                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label>Unit On Order</label>
                    </div>
                    <div class="col-xs-7">
                        <input kendo-numeric-text-box ng-model="model.unitOnOrder"/>

                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label>Active</label>
                    </div>
                    <div class="col-xs-7">
                        <input type="checkbox" ng-model="model.active" ng-true-value="'Y'" ng-false-value="'N'" ng-checked="model.active == 'Y'"/>

                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <button class="btn btn-default" ng-click="save()">Save</button>
                        <button class="btn btn-default">Clear</button>
                    </div>
                </div>
            </form>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>
