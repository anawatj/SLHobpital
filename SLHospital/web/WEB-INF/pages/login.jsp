<%-- 
    Document   : login
    Created on : 24-Aug-2015, 14:13:06
    Author     : anawatj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<tiles:insertDefinition name="loginTemplate">
    <tiles:putAttribute name="body">
        <div class='col-xs-12' >
            <form id="frmLogin" action="<c:url value='j_spring_security_check' />" method="POST" >
                <div class='row'>
                    <div class='col-xs-3'>
                        <label for="username" style="font-weight:bolder">Username</label>
                    </div>
                    <div class='col-xs-7'>
                        <input type='text' class="form-control" name="username"/>
                    </div>
                </div>
                <div class='row'>
                       <div class='col-xs-3'>
                        <label for="username" style="font-weight:bolder">Password</label>
                    </div>
                    <div class='col-xs-7'>
                        <input type='password' class="form-control" name="password"/>
                    </div>
                </div>
                <div class='row'>
                    <div class='col-xs-12'>
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                        <input type="submit" name="submit" class="btn btn-default" value="Login"/>
                    </div>
                </div>
            </form>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>

