<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute  name="body">
        <div class="col-xs-12" ng-controller="supplierEntryCtrl" ng-init="init()">
             <progressbar value="100" ng-show="loading"></progressbar>
            <form id="frmSupplier">
                <fieldset>
                    <legend>Main</legend>
                    <div class="row">
                        <div class="col-xs-3">
                            <label for="code">Code</label>
                        </div>
                        <div class="col-xs-3">
                            <input type="text" class="form-control" ng-model="model.code"/>
                        </div>
                        <div class="col-xs-3">
                            <label for="name">
                                Name
                            </label>
                        </div>
                        <div class="col-xs-3">
                            <input type="text" class="form-control" ng-model="model.name"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-3">
                            <label for="company">
                                Company
                            </label>
                        </div>
                        <div class="col-xs-3">
                            <input type="text" class="form-control" ng-model="model.compny"/>
                        </div>
                    </div>
                </fieldset>
                <fieldset>
                    <legend>Contact</legend>
                    <div class="row">
                        <div class="col-xs-3">
                            <label for="contactName">contactName</label>
                        </div>
                        <div class="col-xs-3">
                            <input type="text" class="form-control" ng-model="model.contact.contactName"/>
                        </div>
                        <div class="col-xs-3">
                            <label for="tel">Tel</label>
                        </div>
                        <div class="col-xs-3">
                            <input type="text" class="form-control" ng-model="model.contact.tel"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-3">
                            <label for="mobile">Mobile</label>
                        </div>
                        <div class="col-xs-3">
                            <input type="text" class="form-control" ng-model="model.contact.mobile"/>
                        </div>
                        <div class="col-xs-3">
                            <label for="fax">Fax</label>
                        </div>
                        <div class="col-xs-3">
                            <input type="text" class="form-control" ng-model="model.contact.fax"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-3">
                            <label for="HombPage">HomePage</label>
                        </div>
                        <div class="col-xs-3">
                            <input type="text" class="form-control" ng-model="model.contact.homePage"/>
                        </div>
                        <div class="col-xs-3">
                            <label for="email">Email</label>
                        </div>
                        <div class="col-xs-3">
                            <input type="text" class="form-control" ng-model="model.contact.email"/>
                        </div>
                    </div>
                </fieldset>
                <fieldset>
                    <legend>Address</legend>
                            <div class="row">
                        <div class="col-xs-3">
                            <label for="Address">Address</label>
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
                            <label for="Address">soi</label>
                        </div>
                        <div class="col-xs-3">
                            <input type="text" class="form-control" ng-model="model.address.soi"/>
                        </div>
                        <div class="col-xs-3">
                            <label for="moo">road</label>
                        </div>
                        <div class="col-xs-3">
                            <input type="text" class="form-control" ng-model="model.address.road"/>
                        </div>
                    </div>
                             <div class="row">
                        <div class="col-xs-3">
                            <label for="Province">Province</label>
                        </div>
                        <div class="col-xs-3">
                            <select class="form-control" ng-model="model.address.province.id" ng-change="provinceChange(model.address.province.id)">
                                <option value="0" >Please Select</option>
                                <option ng-repeat="item in provinces" ng-selected="item.id==model.address.province.id" value="{{item.id}}">{{item.desc}}</option>
                            </select>
                        </div>
                        <div class="col-xs-3">
                            <label for="moo">Moo</label>
                        </div>
                        <div class="col-xs-3">
                            <select class="form-control" ng-model="model.address.amphur.id">
                                <option value="0" >Please Select</option>
                                <option ng-repeat="item in amphurs" ng-selected="item.id==model.address.amphur.id" value="{{item.id}}">{{item.desc}}</option>
                            </select>
                        </div>
                    </div>
                </fieldset>
                <div class="row">
                    <div class="col-xs-12">
                        <button class="btn btn-default" ng-click="save()">Save</button>
                    </div>
                </div>
            </form>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>
