<%-- 
    Document   : entry
    Created on : Sep 1, 2015, 6:20:46 PM
    Author     : Tao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute  name="body">
        <div class="col-xs-12" ng-controller="reservationEntryCtrl" ng-init="init()">
            <form>
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
                        <label for="reservationBy">Reservation By</label>
                    </div>
                    <div class="col-xs-3">
                        <div class="input-group">
                            <input type="text" class="form-control" ng-model="model.reservationBy.code"/>
                            <span class="input-group-btn">
                                <button class="btn btn-default" ng-click="findReservationBy()"><span class="glyphicon glyphicon-search"></span></button>
                            </span>
                            <label>{{model.reservationBy.firstName}} {{model.reservationBy.lastName}}</label>
                        </div>
                    </div>
                    <div class="col-xs-3">
                        <label>Reservation Date</label>
                    </div>
                    <div class="col-xs-3">
                        <input kendo-date-picker k-format="'dd/MM/yyyy'" k-ng-model="model.reservationDate"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label for="reservationBy">Apprvoe By</label>
                    </div>
                    <div class="col-xs-3">
                        <div class="input-group">
                            <input type="text" class="form-control" ng-model="model.approveBy.code"/>
                            <span class="input-group-btn">
                                <button class="btn btn-default" ng-click="findApproveBy()"><span class="glyphicon glyphicon-search"></span></button>
                            </span>
                            <label>{{model.approveBy.firstName}} {{model.approveBy.lastName}}</label>
                        </div>
                    </div>
                    <div class="col-xs-3">
                        <label>Approve Date</label>
                    </div>
                    <div class="col-xs-3">
                        <input kendo-date-picker k-format="'dd/MM/yyyy'" k-ng-model="model.approveDate"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        Attachment
                    </div>
                    <div class="col-xs-9">
                        <div class="input-group">
                            <input type="text" class="form-control" ng-model="model.attachment.code"/>
                            <span class="input-group-btn">
                                <button class="btn btn-default" ng-click="findAttachment()">....</button>
                            </span>
                            <label>{{model.attachment.description}}</label>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#room" data-toggle="tab">Room</a></li>
                            <li><a href="#motor" data-toggle="tab">Motor</a></li>
                            <li><a href="#it" data-toggle="tab">IT</a></li>

                        </ul>
                        <div class="tab-content">
                            <div id="room" class="tab-pane fade in active">
                                <jsp:include page="${context}/reservation/tabRoomItem.html"></jsp:include>

                                </div>
                                <div id="motor" class="tab-pane fade">
                                <jsp:include page="${context}/reservation/tabMotorItem.html"></jsp:include>

                                </div>
                                <div id="it" class="tab-pane fade">
                                <jsp:include page="${context}/reservation/tabItItem.html"></jsp:include>

                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <button class="btn btn-default" ng-click="save()">Save</button>
                            <button class="btn btn-default" ng-click="clear()">Clear</button>
                        </div>
                    </div>
                </form>
            </div>
    </tiles:putAttribute>
</tiles:insertDefinition>
