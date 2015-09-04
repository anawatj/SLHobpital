<%-- 
    Document   : tabEducation
    Created on : 27-Aug-2015, 11:43:54
    Author     : anawatj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
        <table class="table table-bordered table-hover table-condensed grid">
                                    <thead>
                                        <tr>
                                            <th></th>
                                            <th>EducationLevel</th>
                                            <th>University</th>
                                            <th>Major</th>
                                            <th>Gpa</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr ng-repeat="item in model.educations">
                                            <td>
                                                <input type="checkbox" ng-model="item.selected"/>
                                            </td>
                                            <td>
                                                <select class="form-control" ng-model="item.educationLevel.id">
                                                    <option value="0" >Please Select</option>
                                                    <option  ng-repeat="sitem in educationLevels" ng-selected="sitem.id==item.educationLevel.id" value="{{sitem.id}}">
                                                        {{sitem.desc}}
                                                    </option>
                                                </select>
                                            </td>
                                            <td>
                                                <input type="text" ng-model="item.university" class="form-control"/>
                                            </td>
                                            <td>
                                                <input type="text" ng-model="item.major" class="form-control"/>
                                                
                                            </td>
                                            <td>
                                                <input kendo-numeric-text-box ng-model="item.gpa" style="width:100%"/>
                                            </td>
                                        </tr>
                                    </tbody>
                                    <tfoot>
                                        <tr>
                                            <td colspan="5">
                                                <button class="btn btn-default" ng-click="addEducation()">Add</button>
                                                <button class="btn btn-default" ng-click="delEducation()">Del</button>
                                            </td>
                                        </tr>
                                    </tfoot>
                                </table>
