<%-- 
    Document   : entry
    Created on : 18-Aug-2015, 17:32:40
    Author     : anawatj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute  name="body">

        <div class="col-xs-12" ng-controller="employeeEntryCtrl" ng-init="init()">
            <progressbar value="100" ng-show="loading"></progressbar>
            <form id="frmEmployee">
                <div class="row">
                    <div class="col-xs-3">
                        <label for="employeeCode">รหัสพนักงาน</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" class="form-control" ng-model="model.code"/>
                    </div>
                    <div class="col-xs-3">
                        <label for="title">คำนำหน้าชื่อ</label>
                    </div>
                    <div class="col-xs-3">
                        <select class="form-control" ng-model="model.title.id">
                            <option value="0">กรุณาเลือก</option>
                            <option ng-repeat="item in titles" ng-selected="item.id == model.title.id" value="{{item.id}}">{{item.desc}}</option>
                        </select>
                    </div>
                </div>
                <div class="row">

                    <div class="col-xs-3">
                        <label for="firstName">ชื่อ</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" class="form-control" ng-model="model.firstName"/>
                    </div>
                    <div class="col-xs-3">
                        <label for="lastName">นามสกุล</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" class="form-control" ng-model="model.lastName"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        BirthDay 
                    </div>
                    <div class="col-xs-6">
                        <input kendo-date-picker k-format="'dd/MM/yyyy'" style="width:100%" k-ng-model="model.birthDate"/>
                    </div>
                    <div class="col-xs-3">
                        <label for="salary">เงินเดือน</label>
                    </div>

                    <div class="col-xs-3">
                        <input kendo-numeric-text-box style="width:100%" ng-model="model.salary" />
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label for="department">สาขา</label>
                    </div>
                    <div class="col-xs-3">
                        <select ng-model="model.branch.id" class="form-control">
                            <option value="0">กรุณาเลือก</option>
                            <option ng-repeat="item in branches" ng-selected="item.id == model.branch.id" value="{{item.id}}">{{item.desc}}</option>
                        </select>
                    </div>

                    <div class="col-xs-3">
                        <label for="department">ฝ่าย</label>
                    </div>
                    <div class="col-xs-3">
                        <select ng-model="model.department.id" class="form-control">
                            <option value="0">กรุณาเลือก</option>
                            <option ng-repeat="item in departments" ng-selected="item.id == model.department.id" value="{{item.id}}">{{item.desc}}</option>
                        </select>
                    </div>

                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label for="position">ตำแหน่ง</label>
                    </div>
                    <div class="col-xs-3">
                        <select class="form-control" ng-model="model.position.id">
                            <option value="0">กรุณาเลือก</option>
                            <option ng-repeat="item in positions" ng-selected="item.id == model.position.id" value="{{item.id}}">{{item.desc}}</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-2">
                        <label for="addressNo">ที่อยู่</label>
                    </div>
                    <div class="col-xs-2">
                        <input type="text" class="form-control" ng-model="model.address.addressNo"/>
                    </div>
                    <div class="col-xs-2">
                        <label for="moo">หมู่</label>
                    </div>
                    <div class="col-xs-2">
                        <input type="text" class="form-control" ng-model="model.address.moo"/>
                    </div>
                    <div class="col-xs-2">
                        <label for="soi">ซอย</label>
                    </div>
                    <div class="col-xs-2">
                        <input type="text" class="form-control" ng-model="model.address.soi"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label for="road">ถนน</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text"  class="form-control" ng-model="model.address.road"/>
                    </div>
                    <div class="col-xs-3">
                        <label for="district">ตำบล</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" class="form-control" ng-model="model.address.district"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label for="province">จังหวัด</label>
                    </div>
                    <div class="col-xs-3">
                        <select ng-model="model.address.province.id" class="form-control" ng-change="provinceChange(model.address.province.id)">
                            <option value="0">กรุณาเลือก</option>
                            <option ng-repeat="item in provinces" ng-selected="item.id == model.address.province.id" value="{{item.id}}">{{item.desc}}</option>
                        </select>
                    </div>
                    <div class="col-xs-3">
                        <label for="amphur">อำเภอ</label>
                    </div>
                    <div class="col-xs-3">
                        <select ng-model="model.address.amphur.id" class="form-control">
                            <option value="0">กรุณาเลือก</option>
                            <option ng-repeat="item in amphurs" ng-selected="item.id == model.address.amphur.id" value="{{item.id}}">{{item.desc}}</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label for="fatherName">ชื่อ-สกุล บิดา</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" class="form-control" ng-model="model.fatherName"/>
                    </div>
                    <div class="col-xs-3">
                        <label for="fatherOccupation">อาชีพ</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" class="form-control" ng-model="model.fatherOccupation"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label for="fatherCompany">บริษัท</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" class="form-control" ng-model="model.fatherCompany"/>
                    </div>
                    <div class="col-xs-3">
                        <label for="fatherTel">เบอร์โทร</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" class="form-control" ng-model="model.fatherTel"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label for="fatherAddress">ที่อยู่</label>
                    </div>

                    <div class="col-xs-7">
                        <textarea class="form-control" ng-model="model.fatherAddress"></textarea>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label for="motherName">ชื่อ-สกุล มารดา</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" class="form-control" ng-model="model.motherName"/>
                    </div>
                    <div class="col-xs-3">
                        <label for="motherOccupation">อาชีพ</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" class="form-control" ng-model="model.motherOccupation"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label for="motherCompany">บริษัท</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" class="form-control" ng-model="model.motherCompany"/>
                    </div>
                    <div class="col-xs-3">
                        <label for="motherTel">เบอร์โทร</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" class="form-control" ng-model="model.motherTel"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label for="motherAddress">ที่อยู่</label>
                    </div>

                    <div class="col-xs-7">
                        <textarea class="form-control" ng-model="model.motherAddress"></textarea>
                    </div>
                </div>

                <div class="row">
                    <div class="col-xs-3">
                        <label for="marital">
                            สถานภาพสมรส
                        </label>
                    </div>
                    <div class="col-xs-7">
                        <div class="radio-inline">

                            <input type="radio" name="marital" ng-model="model.marital" value="S" checked="checked"/><label>โสด</label>
                        </div>
                        <div class="radio-inline">
                            <input type="radio" name="marital" ng-model="model.marital" value="M"/><label>แต่งงาน</label>
                        </div>

                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label for="supouseName">ชื่อ-สกุล คู่สมรส</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" class="form-control" ng-model="model.supouseName"/>
                    </div>
                    <div class="col-xs-3">
                        <label for="supouseOccupation">อาชีพ</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" class="form-control" ng-model="model.supouseOccupation"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label for="suposeCompany">บริษัท</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" class="form-control" ng-model="model.suposeCompany"/>
                    </div>
                    <div class="col-xs-3">
                        <label for="suposeTel">เบอร์โทร</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" class="form-control" ng-model="model.suposeTel"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label for="motherAddress">ที่อยู่</label>
                    </div>

                    <div class="col-xs-7">
                        <textarea class="form-control" ng-model="model.suposeAddress"></textarea>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label for="contactName">ชื่อผู้ติดต่อ</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" class="form-control" ng-model="model.contactName"/>
                    </div>
                    <div class="col-xs-3">
                        <label for="contactTel">เบอร์โทร</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" class="form-control" ng-model="model.contactTel"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label for="contactRelation">ความสัมพันธ์</label>
                    </div>
                    <div class="col-xs-7">  
                        <input type="text" class="form-control" ng-model="model.contactRelation"/>

                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label for="conatctAddress">ที่อยู่</label>
                    </div>
                    <div class="col-xs-7">  
                        <textarea class="form-control" ng-model="model.conatctAddress"></textarea>

                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label for="hobby">งานอดิเรก</label>
                    </div>
                    <div class="col-xs-6">
                        <div class="checkbox-inline" ng-repeat="item in hobbies">
                              <input type="checkbox" checklist-model="model.hobbies" checklist-value="item" checklist-comparator="compareHobbies"/>{{item.desc}}
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-12">
                        <ul class="nav nav-tabs">
                            <li class="active"><a href="#education" data-toggle="tab">Education</a></li>
                            <li><a href="#experience" data-toggle="tab">Experience</a></li>
                            <li><a href="#sibling" data-toggle="tab">Sibling</a></li>
                            <li><a href="#children" data-toggle="tab">Children</a></li>
                            <li><a href="#training" data-toggle="tab">training</a></li>
                            <li><a href="#language" data-toggle="tab">LanguageSkill</a></li>
                            <li><a href="#reference" data-toggle="tab">Reference</a></li>
                        </ul>
                        <div class="tab-content">
                            <div id="education" class="tab-pane fade in active">

                                <jsp:include page="${context}/employee/tabEducation.html"></jsp:include>
                                </div>
                                <div id="experience" class="tab-pane fade">

                                <jsp:include page="${context}/employee/tabExperience.html"></jsp:include>
                                </div>
                                <div id="sibling" class="tab-pane fade">
                                <jsp:include page="${context}/employee/tabSibling.html"></jsp:include>
                                </div>
                                <div id="children" class="tab-pane fade">
                                <jsp:include page="${context}/employee/tabChildren.html"></jsp:include>
                                </div>
                                <div id="training" class="tab-pane fade">
                                <jsp:include page="${context}/employee/tabTraining.html"></jsp:include>
                                </div>
                                <div id="language" class="tab-pane fade">
                                <jsp:include page="${context}/employee/tabLanguageSkill.html"></jsp:include>

                                </div>
                                <div id="reference" class="tab-pane fade">
                                <jsp:include page="${context}/employee/tabReference.html"></jsp:include>
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
