<%-- 
    Document   : entryModal
    Created on : Sep 1, 2015, 6:07:57 PM
    Author     : Tao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal-header" style="background-color:#848484;color:white">
    <label>Save Attachment</label>
</div>
<div class="modal-body col-xs-12 form-horizontal form-group-sm table-bordered" style="color:#848484;" ng-init="init()">
    <form>
        <div class="row">
            <div class="col-xs-3">
                <label>Code</label>
            </div>
            <div class="col-xs-3">
                <input type="text" class="form-control" ng-model="model.code"/>
            </div>
            <div class="col-xs-3">
                <label>Description</label>
            </div>
            <div class="col-xs-3">
                <input type="text" class="form-control" ng-model="model.description"/>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-3">
                <label>AttachBy</label>
            </div>
            <div class="col-xs-3">
                <div class="input-group">
                    <input type="text" class="form-control" ng-model="model.attachBy.code"/>
                    <span class="input-group-btn">
                        <button class="btn btn-default" ng-click="findAttachBy()"><span class="glyphicon glyphicon-search"></span></button>
                    </span>
                </div>
            </div>
            <div class="col-xs-3">
                <label>Attach Date</label>
            </div>
            <div class="col-xs-3">
                <input kendo-date-picker k-format="'dd/MM/yyyy'" k-ng-model="model.attachDate"/>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12">
                <table class="table table-bordered table-hover table-condensed grid">
                    <thead>
                        <tr>
                            <th></th>
                            <th>Name</th>
                            <th>Type</th>
                            <th>File</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr ng-repeat="item in model.items">
                            <td>
                                <input type="checkbox" ng-model="item.selected"/>
                            </td>
                            <td>
                                <input type="text" class="form-control" ng-model="item.name"/>
                            </td>
                            <td>
                                <select class="form-control" ng-model="item.type.id">
                                    <option value="0"></option>
                                    <option ng-repeat="sitem in attachmentTypes" ng-selected="sitem.id==item.type.id" value="{{sitem.id}}">{{sitem.desc}}</option>
                                </select>
                            </td>
                            <td>
                                <input type="file"  class="form-control"  onchange="angular.element(this).scope().uploadedFile(this,angular.element(this).scope().$index)" ng-model="item.fileName" />
                                
                            </td>
                        </tr>
                    </tbody>
                    <tfoot>
                        <tr>
                            <td colspan="4">
                                <button class="btn btn-default" ng-click="addItem()">Add</button>
                                <button class="btn btn-default" ng-click="delItem()">Del</button>
                            </td>
                        </tr>
                    </tfoot>
                </table>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-12">
                <button class="btn btn-default" ng-click="save()">Save</button>
                <button class="btn btn-default" ng-click="close()">Close</button>
            </div>
        </div>
    </form>
</div>
<div class="modal-footer"></div>