<%-- 
    Document   : searchMultiModal
    Created on : 28-Aug-2015, 16:51:53
    Author     : anawatj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal-header" style="background-color:#848484;color:white">
        <label>Search Supplier</label>
    </div>
<div class="modal-body col-xs-12 form-horizontal form-group-sm table-bordered" style="color:#848484;">
        <form id="frmSearchSupplier" class="form-horizontal form-group-sm">
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
                <div  class="col-xs-3">
                    <input type="text" class="form-control" ng-model="model.name"/>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <button class="btn btn-default" ng-click="search()">Search</button>
                    <button class="btn btn-default" ng-click="clear()">Clear</button>
                    <button class="btn btn-default" ng-click="close()">Close</button>
                    <button class="btn btn-default" ng-click="save()">Save</button>
                </div>

            </div>
            <div class="row">
                    <div class="col-xs-12">
                        <table class="table table-bordered table-hover table-condensed grid">
                            <thead>
                                <tr>
                                  
                                    <th></th>
                                    <th>Code</th>
                                    <th>Name</th>
                              
                                </tr>
                            </thead>
                            <tbody>
                                <tr ng-repeat="item in results">
                                   
                                    <td>
                                        <input type="checkbox" ng-model="item.selected"/>
                                    </td>
                                    <td>
                                        {{item.code}}
                                    </td>
                                    <td>
                                        {{item.name}}
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
    <div class="modal-footer"></div>


