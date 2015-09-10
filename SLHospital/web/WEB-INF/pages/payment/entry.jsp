<%-- 
    Document   : entry
    Created on : Sep 10, 2015, 3:42:28 PM
    Author     : Tao
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute  name="body">
        <div class="col-xs-12" >
            <form>
                <div class="row">
                    <div class="col-xs-3">
                        <label for="code">Code</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" class="form-control"/>
                    </div>
                    <div class="col-xs-3">
                        <label for="description">Desc</label>
                    </div>
                    <div class="col-xs-3">
                        <input type="text" class="form-control"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label>Payment Date</label>
                    </div>
                    <div class="col-xs-3">
                        <input kendo-date-picker k-format="'dd/MM/yyyy'"/>
                    </div>
                    <div class="col-xs-3">
                        <label>Payment By</label>
                    </div>
                    <div class="col-xs-3">
                        <div class="input-group">
                            <input type="text" class="form-control"/>
                            <span class="input-group-btn">
                                <button class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button>
                            </span>
                            <label></label>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-3">
                        <label>Approve Date</label>
                    </div>
                    <div class="col-xs-3">
                        <input kendo-date-picker k-format="'dd/MM/yyyy'"/>
                    </div>
                    <div class="col-xs-3">
                        <label>Approve By</label>
                    </div>
                    <div class="col-xs-3">
                        <div class="input-group">
                            <input class="form-control" type="text"/>
                            <span class="input-group-btn">
                                <button class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
                            </span>
                            <label></label>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>
