<%-- 
    Document   : list
    Created on : 21-Aug-2015, 14:07:29
    Author     : anawatj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute  name="body">
        <div class="col-xs-12" ng-controller="supplierListCtrl" ng-init="init()">
            <form id="frmSupplier">
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
                        <label for="company">Company</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" class="form-control" ng-model="model.company"/>
                    </div>
                    <div class="col-xs-3">
                        <label for="contactName">ContactName</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" class="form-control" ng-model="model.contactName"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3"> 
                        <label for="province">Province</label>
                    </div>
                    <div class="col-xs-3">
                        <select class="form-control" ng-model="model.province">
                            <option value="0">Please Select</option>
                            <option ng-repeat="item in provinces" value="{{item.id}}">{{item.desc}}</option>
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
                                    <th>Company</th>
                                    <th>ContactName</th>
                                    <th>Province</th>
                                    <th>Amphur</th>
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
                                        {{item.compny}}
                                    </td>
                                    <td>
                                        {{item.contact.contactName}}
                                    </td>
                                    <td>
                                        {{item.address.province.desc}}
                                    </td>
                                    <td>
                                        {{item.address.amphur.desc}}
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

