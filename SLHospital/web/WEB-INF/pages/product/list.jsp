<%-- 
    Document   : list
    Created on : 24-Aug-2015, 08:32:28
    Author     : anawatj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute  name="body">
        <div class="col-xs-12" ng-controller="productListCtrl" ng-init="init()">
            <form id="frmProduct">
                <div class="row">
                    <div class="col-xs-3">
                        <label for="code">code</label>
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
                        <label for="supplier">Supplier</label>
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
                        <label for="active">Active</label>
                    </div>
                    <div class="col-xs-7">
                           <input type="checkbox" ng-model="model.active" ng-true-value="'Y'" ng-false-value="'N'" ng-checked="model.active == 'Y'"/>

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
                                    <th>Supplier</th>
                                    <th>UnitInStock</th>
                                    <th>UnitPrice</th>
                                    <th>Active</th>
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
                                        {{item.name}}
                                    </td>
                                    <td>
                                        {{item.supplier.name}}
                                    </td>
                                    <td>
                                        {{item.unitInStock}}
                                    </td>
                                    <td>
                                        {{item.unitPrice}}
                                    </td>
                                    <td>
                                        <label ng-if="item.active=='Y'">ใช้งาน</label>
                                        <label ng-if="item.actie=='N'">ไม่ใช้งาน</label>
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
