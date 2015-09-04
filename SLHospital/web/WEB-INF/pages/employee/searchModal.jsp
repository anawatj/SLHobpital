<%-- 
    Document   : searchModal
    Created on : 28-Aug-2015, 10:28:28
    Author     : anawatj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal-header" style="background-color:#848484;color:white">
    <label>Search Employee</label>
</div>
<div class="modal-body col-xs-12 form-horizontal form-group-sm table-bordered" style="color:#848484;">
    <div class="col-xs-12" ng-init="init()">
        <form id="frmEmployee">
            <div class="row">
                <div class="col-xs-3">
                    <label for="code">Code</label>
                </div>
                <div class="col-xs-3">
                    <input type="text" ng-model="model.code" class="form-control"/>
                </div>
                <div class="col-xs-3">
                    <label for="firstName">FirstName</label>
                </div>
                <div class="col-xs-3">
                    <input type="text" ng-model="model.firstName" class="form-control"/>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-3">
                    <label for="LastName">LastName</label>
                </div>
                <div class="col-xs-3">
                    <input type="text" ng-model="model.lastName" class="form-control"/>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <button  ng-click="search()" class="btn btn-default">Search</button>
                    <button ng-click="clear()" class="btn btn-default">Clear</button>
                    <button  ng-click="close()" class="btn btn-default">Close</button>
                </div>

            </div>
            <div class="row">
                <div class="col-xs-12">
                    <table class="table table-bordered table-hover table-condensed grid">
                        <thead>
                            <tr>
                             
                                <th></th>
                                <th>Code</th>
                                <th>Title</th>
                                <th>FirstName</th>
                                <th>LastName</th>
                                <th>BirthDate</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr ng-repeat="item in results">
                               
                                <td><button class="btn btn-default" ng-click="select(item)">Select</button></td>
                                <td>{{item.code}}</td>
                                <td>{{item.title.desc}}</td>
                                <td>{{item.firstName}}</td>
                                <td>{{item.lastName}}</td>
                                <td>{{item.birthDate}}</td>
                            </tr>
                        </tbody>
                    </table>
                    <pagination ng-model="model.page" ng-change="search()" total-items="totalItems" num-pages="numPages"
                                items-per-page="pageSize" max-size="maxSize" class="pagination-xs" boundary-links="true" rotate="false"></pagination>
                </div>
            </div>

        </form>
    </div>
</div>
<div class="modal-footer"></div>
