<%-- 
    Document   : entry
    Created on : 28-Aug-2015, 16:51:16
    Author     : anawatj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute  name="body">
        <div class="col-xs-12" ng-controller="orderEntryCtrl" ng-init="init()">
            <form>
                <fieldset>
                    <legend>Order</legend>

                    <div class="row">
                        <div class="col-xs-3">

                            <label for="code">Code</label>
                        </div>
                        <div class="col-xs-3">
                            <input type="text" class="form-control" ng-model="model.code"/>
                        </div>
                        <div class="col-xs-3">
                            <label for="description">Description</label>
                        </div>
                        <div class="col-xs-3">
                            <input type="text" class="form-control" ng-model="model.description"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-3">
                            <label for="orderDate">Order Date</label>
                        </div>
                        <div class="col-xs-3">
                            <input kendo-date-picker k-format="'dd/MM/yyyy'" k-ng-model="model.orderDate"/>
                        </div>
                        <div class="col-xs-3">
                            <label for="requireDate">requireDate</label>
                        </div>
                        <div class="col-xs-3">
                            <input kendo-date-picker  k-format="'dd/MM/yyyy'" k-ng-model="model.requireDate"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-3">
                            <label for="shipperDate">ShipperDate</label>
                        </div>
                        <div class="col-xs-3">
                            <input kendo-date-picker  k-format="'dd/MM/yyyy'" k-ng-model="model.shipperDate"/>
                        </div>
                        <div class="col-xs-3">
                            <label for="customer">Customer</label>
                        </div>
                        <div class="col-xs-3">
                            <div class="input-group">
                                <input type="text" class="form-control" ng-model="model.customer.code"/>
                                <span class="input-group-btn">
                                    <button class="btn btn-default" ng-click="findCustomer()"><span class="glyphicon glyphicon-search"></span></button>
                                </span>
                                <label>{{model.customer.name}}</label>
                            </div>

                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-3">
                            <label for="requestBy">Request By</label>
                        </div>
                        <div class="col-xs-3">
                            <div class="input-group">
                                <input type="text" class="form-control" ng-model="model.requestBy.code"/>
                                <span class="input-group-btn">
                                    <button class="btn btn-default" ng-click="findRequestBy()"><span class="glyphicon glyphicon-search"></span></button>
                                </span>
                                <label>{{model.requestBy.name}}</label>
                            </div>
                        </div>
                        <div class="col-xs-3">
                            <label for="shipper">
                                Shipper
                            </label>

                        </div>
                        <div class="col-xs-3">
                            <select class="form-control" ng-model="model.shipper.id">
                                <option value="0"></option>
                                <option ng-repeat="item in shippers" ng-selected="item.id == model.shipper.id" value="{{item.id}}">{{item.desc}}</option>
                            </select>
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
                            <label for="approveDate">Approve Date</label>
                        </div>
                        <div class="col-xs-3">
                            <input kendo-date-picker  k-format="'dd/MM/yyyy'" k-ng-model="model.approveDate"/>
                        </div>
                    </div>


                </fieldset>
                <fieldset>
                    <legend>Address</legend>
                    <div class="row">
                        <div class="col-xs-3">
                            <label for="shipName">ShipName</label>
                        </div>
                        <div class="col-xs-3">
                            <input type="text" class="form-control" ng-model="model.shippName"/>
                        </div>
                        <div class="col-xs-3">
                            <label for="freight">Freight</label>
                        </div>
                        <div class="col-xs-3">
                            <input kendo-numeric-text-box ng-model="model.freight"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-3">
                            <label for="addressNo">Address No</label>
                        </div>  
                        <div class="col-xs-3">
                            <input type="text" class="form-control" ng-model="model.address.addressNo"/>
                        </div>
                        <div class="col-xs-3">
                            <label for="moo">Moo</label>
                        </div>
                        <div class="col-xs-3">
                            <input type="text" class="form-control" ng-model="model.address.moo"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-3">
                            <label for="soi">Soi</label>
                        </div>
                        <div class="col-xs-3">
                            <input type="text" class="form-control" ng-model="model.address.soi"/>
                        </div>
                        <div class="col-xs-3">
                            <label for="road">Road</label>
                        </div>
                        <div class="col-xs-3">
                            <input type="text" class="form-control" ng-model="model.address.road"/>

                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-3">
                            <label for="district">District</label>
                        </div>
                        <div class="col-xs-3">
                            <input type="text" class="form-control" ng-model="model.address.district"/>
                        </div>
                        <div class="col-xs-3">
                            <label for="province">Province</label>
                        </div>
                        <div class="col-xs-3">
                            <select class="form-control" ng-model="model.address.province.id" ng-change="provinceChange(model.address.province.id)">
                                <option value="0"></option>
                                <option ng-repeat="item in provinces" ng-selected="item.id == model.address.province.id" value="{{item.id}}">{{item.desc}}</option>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-3">
                            <label for="amphur">Amphur</label>
                        </div>
                        <div class="col-xs-3">
                            <select class="form-control" ng-model="model.address.amphur.id">
                                <option value="0" ></option>
                                <option ng-repeat="item in amphurs" ng-selected="item.id == model.address.amphur.id" value="{{item.id}}">{{item.desc}}</option>
                            </select>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <table class="table table-bordered table-hover table-condensed grid">
                                <thead>
                                    <tr>
                                        <th></th>
                                        <th>Product</th>
                                        <th>Quantity</th>
                                        <th>Unit Price</th>
                                        <th>Discount</th>
                                        <th>Total</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr ng-repeat="item in model.items">
                                        <td><input type="checkbox" ng-model="item.selected"/></td>
                                        <td>
                                            <div class="input-group">
                                                <input type="text" class="form-control" ng-model="item.product.code"/>
                                                <span class="input-group-btn">
                                                    <button class="btn btn-default" ng-click="findProduct(item)"><span class="glyphicon glyphicon-search"></span></button>
                                                </span>
                                                <label>{{item.product.name}}</label>
                                            </div>
                                        </td>
                                        <td>
                                            <input kendo-numeric-text-box ng-model="item.quantity"/>
                                        </td>
                                        <td>
                                            <input kendo-numeric-text-box ng-model="item.unitPrice"/>
                                        </td>
                                        <td>
                                            <input kendo-numeric-text-box ng-model="item.discount"/>
                                        </td>
                                        <td>
                                            <input kendo-numeric-text-box ng-model="item.total"/>
                                        </td>
                                    </tr>
                                </tbody>
                                <tfoot>
                                    <tr>
                                        <td colspan="6">
                                            <button class="btn btn-default" ng-click="addItem()">Add</button>
                                            <button class="btn btn-default" ng-click="delItem()">Del</button>
                                        </td>
                                    </tr>
                                </tfoot>
                            </table>
                        </div>
                    </div>
                </fieldset>
                <div class="row">
                    <div class="col-xs-3">
                        <button class="btn btn-default" ng-click="save()">
                            Save
                        </button>
                        <button class="btn btn-default" ng-click="approve()">
                            Approve
                        </button>
                        <button class="btn btn-default" ng-click="clear()">
                            Clear
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>
