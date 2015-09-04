<%-- 
    Document   : frmModal
    Created on : 26-Aug-2015, 16:49:05
    Author     : anawatj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="modal-header" style="background-color:#848484;color:white">
    <label>Frm</label>
</div>
<div class="modal-body col-xs-12 form-horizontal form-group-sm table-bordered" style="color:#848484;">
    <div  class="col-xs-12" ng-init="init()">
        <form>
            <div class="row">
                <div class="col-xs-12">
                    <table class="table table-bordered table-hover table-condensed grid">
                        <thead>
                            <tr>
                                <th></th>
                                <th>ProductGroup</th>

                            </tr>
                        </thead>
                        <tbody>
                            <tr ng-repeat="item in items">
                                <td><input type="checkbox" ng-model="item.selected"/></td>
                                <td>
                                    <select class="form-control" ng-model="item.productGroup.id">
                                        <option value="0"></option>
                                        <option ng-repeat="sitem in productGroups" ng-selected="sitem.id == item.productGroup.id" value="{{sitem.id}}">{{sitem.desc}}</option>
                                    </select>
                                </td>

                            </tr>
                        </tbody>
                        <tfoot>
                            <tr>
                                <td colspan="2">
                                    <button class="btn btn-default" ng-click="addItem()">Add</button>
                                    <button class="btn btn-default" ng-click="delItem()">Del</button>
                                </td>
                            </tr>
                        </tfoot>
                    </table>
                </div>

                <div class="row">
                    <div class="col-xs-12">
                        <button class="btn btn-default" ng-click="save()">Save</button>
                        <button class="btn btn-default" ng-click="close()">Close</button>
                    </div>
                </div>
        </form>
    </div>
</div>

</div>
<div class="modal-footer"></div>