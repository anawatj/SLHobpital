<%-- 
    Document   : tabLanguageSkill
    Created on : 27-Aug-2015, 14:38:23
    Author     : anawatj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<table class="table table-bordered table-hover table-condensed grid">
       <thead>
            <tr>
                <th></th>
                <th>Language</th>
                <th>Speaking</th>
                <th>Listening</th>
                <th>Reading</th>
                <th>Writing</th>

            </tr>
        </thead>
        <tbody>
            <tr ng-repeat="item in model.languages">
                <td><input type="checkbox" ng-model="item.selected"/></td>
                <td>
                    <select class="form-control" ng-model="item.language.id">
                        <option value="0"></option>
                        <option ng-repeat="sitem in languages" ng-selected="sitem.id==item.language.id" value="{{sitem.id}}">{{sitem.desc}}</option>
                    </select>
                </td>
                <td>
                    <select ng-model="item.speaking" class="form-control">
                        <option value="V">VeryGood</option>
                        <option value="G">Good</option>
                        <option value="F">Fair</option>
                        <option value="N">None</option>
                    </select>
                </td>
                <td>
                      <select ng-model="item.listing" class="form-control">
                        <option value="V">VeryGood</option>
                        <option value="G">Good</option>
                        <option value="F">Fair</option>
                        <option value="N">None</option>
                    </select>
                </td>
                <td>
                        <select ng-model="item.reading" class="form-control">
                        <option value="V">VeryGood</option>
                        <option value="G">Good</option>
                        <option value="F">Fair</option>
                        <option value="N">None</option>
                    </select>
                </td>
             <td>
                        <select ng-model="item.writing" class="form-control">
                        <option value="V">VeryGood</option>
                        <option value="G">Good</option>
                        <option value="F">Fair</option>
                        <option value="N">None</option>
                    </select>
                </td>
            </tr>
        </tbody>
        <tfoot>
            <tr>
                <td colspan="6">
                    <button class="btn btn-default" ng-click="addLanguage()">Add</button>
                    <button class="btn btn-default" ng-click="delLanguage()">Del</button>
                </td>
            </tr>
        </tfoot>
</table>