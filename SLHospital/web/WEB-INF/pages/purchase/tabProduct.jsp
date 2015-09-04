<%-- 
    Document   : tabProduct
    Created on : 28-Aug-2015, 10:50:47
    Author     : anawatj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table class="table table-bordered table-hover table-condensed grid">
       <thead>
            <tr>
                <th></th>
                <th>Product</th>
                <th>Quantity</th>
                <th>Unit Price</th>
                <th>Vat</th>
                <th>Include</th>
            </tr>
        </thead>
        <tbody>
            <tr ng-repeat="item in model.products">
                <td>
                    <input type="checkbox" ng-model="item.selected"/>
                    
                </td>
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
                    <input kendo-numeric-text-box ng-model="item.vat"/>
                </td>
                <td>
                    <input type="checkbox" ng-model="item.flagVat" ng-true-value="'I'" ng-false-value="'E'" ng-checked="item.flagVat=='I'"/>
                </td>
            </tr>
        </tbody>
        <tfoot>
            <tr>
                <td colspan="6">
                    <button class="btn btn-default" ng-click="addProduct()">Add</button>
                    <button class="btn btn-default" ng-click="delProduct()">Del</button>
                </td>
            </tr>
        </tfoot>
</table>
