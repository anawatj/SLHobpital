<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<tiles:insertDefinition name="defaultTemplate">
    <tiles:putAttribute name="body">
        <div class="row">
            <div class="col-sm-6">
                <div class="col-sm-12">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-9">
                        <div class="panel-group" id="shawpatMenuLeft" role="tablist" aria-multiselectable="true">
                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="headingProjectMenu">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#shawpatMenuLeft" href="#projectMenu" aria-expanded="true" aria-controls="#projectMenu">
                                            1. Project
                                        </a>
                                    </h4>
                                </div>
                                <div id="projectMenu" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingProjectMenu">
                                    <div class="panel-body">
                                        <div class="panel-group" id="subProjectMenu" role="tablist" aria-multiselectable="true">
                                            <div class="panel panel-default">
                                                <div class="panel-heading" role="tab" id="subPlanAndDirectMenu">
                                                    <h4 class="panel-title">
                                                        <a data-toggle="collapse" data-parent="#subProjectMenu" href="#subPlanAndDirectLinkMenu" aria-expanded="true" aria-controls="#subPlanAndDirectLinkMenu">
                                                            1.1 Project
                                                        </a>
                                                    </h4>
                                                </div>
                                                <div id="subPlanAndDirectLinkMenu" class="panel-collapse collapse" role="tabpanel" aria-labelledby="subPlanAndDirectMenu">
                                                    <div class="panel-body">
                                                        <ul class="nav nav-pills nav-stacked">
                                                            <li role="presentation"><a href="${context}/project/entry.html">สร้าง</a></li>
                                                            <li role="presentation"><a href="${context}/project/list.html">ค้นหา</a></li>


                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="panel panel-default">
                                                <div class="panel-heading" role="tab" id="subActivityMenu">
                                                    <h4 class="panel-title">
                                                        <a data-toggle="collapse" data-parent="#subProjectMenu" href="#subActivityLinkMenu" aria-expanded="true" aria-controls="#subActivityLinkMenu">
                                                            1.2 Claim
                                                        </a>
                                                    </h4>
                                                </div>
                                                <div id="subActivityLinkMenu" class="panel-collapse collapse" role="tabpanel" aria-labelledby="subActivityMenu">
                                                    <div class="panel-body">
                                                        <ul class="nav nav-pills nav-stacked">                                             				
                                                            <li role="presentation"><a href="${context}/claim/upload.html">Upload</a></li>
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="headingServiceMenu">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#shawpatMenuLeft" href="#serviceMenu" aria-expanded="true" aria-controls="#serviceMenu">
                                            2. Product
                                        </a>
                                    </h4>
                                </div>
                                <div id="serviceMenu" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingServiceMenu">
                                    <div class="panel-body">
                                        <div class="panel-group" id="subServiceMenu" role="tablist" aria-multiselectable="true">
                                            <div class="panel panel-default">
                                                <div class="panel-heading" role="tab" id="subSaleMenu">
                                                    <h4 class="panel-title">
                                                        <a data-toggle="collapse" data-parent="#subServiceMenu" href="#subSaleLinkMenu" aria-expanded="true" aria-controls="#subSaleLinkMenu">
                                                            2.1 Order
                                                        </a>
                                                    </h4>
                                                </div>
                                                <div id="subSaleLinkMenu" class="panel-collapse collapse" role="tabpanel" aria-labelledby="subSaleMenu">
                                                    <div class="panel-body">
                                                        <ul class="nav nav-pills nav-stacked">                                             				
                                                            <li role="presentation"><a href="${context}/order/entry.html">สร้าง</a></li>
                                                            <li role="presentation"><a href="${context}/order/list.html">ค้นหา</a></li>                                             				
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="panel panel-default">
                                                <div class="panel-heading" role="tab" id="subRentMenu">
                                                    <h4 class="panel-title">
                                                        <a data-toggle="collapse" data-parent="#subServiceMenu"	href="#subRentLinkMenu" aria-expanded="true" aria-controls="#subRentLinkMenu">
                                                            2.2 Purchase
                                                        </a>
                                                    </h4>
                                                </div>
                                                <div id="subRentLinkMenu" class="panel-collapse collapse" role="tabpanel" aria-labelledby="subRentMenu">
                                                    <div class="panel-body">
                                                        <ul class="nav nav-pills nav-stacked">

                                                            <li role="presentation"><a href="${context}/purchase/entry.html">สร้าง</a></li>
                                                            <li role="presentation"><a href="${context}/purchase/list.html">ค้นหา</a></li>  
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="panel panel-default">
                                                <div class="panel-heading" role="tab" id="subRentMenu">
                                                    <h4 class="panel-title">
                                                        <a data-toggle="collapse" data-parent="#subServiceMenu"	href="#subProductMenu" aria-expanded="true" aria-controls="#subRentLinkMenu">
                                                            2.2 Product
                                                        </a>
                                                    </h4>
                                                </div>
                                                <div id="subProductMenu" class="panel-collapse collapse" role="tabpanel" aria-labelledby="subRentMenu">
                                                    <div class="panel-body">
                                                        <ul class="nav nav-pills nav-stacked">

                                                            <li role="presentation"><a href="${context}/product/entry.html">สร้าง</a></li>
                                                            <li role="presentation"><a href="${context}/product/list.html">ค้นหา</a></li>  
                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>                
                                        </div>
                                    </div>
                                </div>
                            </div>

                            <div class="panel-group" id="shawpatMenuLeft" role="tablist" aria-multiselectable="true">
                                <div class="panel panel-default">
                                    <div class="panel-heading" role="tab" id="headPeopleMenu">
                                        <h4 class="panel-title">
                                            <a data-toggle="collapse" data-parent="#shawpatMenuLeft" href="#accountingMenu" aria-expanded="true" aria-controls="#projectMenu">
                                                3.Accounting
                                            </a>
                                        </h4>

                                    </div>
                                    <div id="accountingMenu" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headPeopleMenu">
                                        <div class="panel-body">
                                            <div class="panel-group" id="subAccountingMenu" role="tablist" aria-multiselectable="true">
                                                <div class="panel panel-default">
                                                    <div class="panel-heading" role="tab" id="subAccountingMenu">
                                                        <h4 class="panel-title">
                                                            <a data-toggle="collapse" data-parent="#subAccountingMenu" href="#receiveMenu" aria-expanded="true" aria-controls="#subPlanAndDirectLinkMenu">
                                                                3.1 Receive
                                                            </a>
                                                        </h4>
                                                    </div>
                                                    <div id="receiveMenu" class="panel-collapse collapse" role="tabpanel" aria-labelledby="subPlanAndDirectMenu">
                                                        <div class="panel-body">
                                                            <ul class="nav nav-pills nav-stacked">
                                                                <li role="presentation"><a href="${context}/receive/entry.html">สร้าง</a></li>
                                                                <li role="presentation"><a href="${context}/receive/list.html">ค้นหา</a></li>


                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="panel panel-default">
                                                    <div class="panel-heading" role="tab" id="subAccountingMenu">
                                                        <h4 class="panel-title">
                                                            <a data-toggle="collapse" data-parent="#subAccountingMenu" href="#paymentMenu" aria-expanded="true" aria-controls="#subPlanAndDirectLinkMenu">
                                                                3.2 Payment
                                                            </a>
                                                        </h4>
                                                    </div>
                                                    <div id="paymentMenu" class="panel-collapse collapse" role="tabpanel" aria-labelledby="subPlanAndDirectMenu">
                                                        <div class="panel-body">
                                                            <ul class="nav nav-pills nav-stacked">
                                                                <li role="presentation"><a href="${context}/payment/edit.html">สร้าง</a></li>
                                                                <li role="presentation"><a href="${context}/payment/list.html">ค้นหา</a></li>


                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="panel panel-default">
                                                    <div class="panel-heading" role="tab" id="subPeopleMenu">
                                                        <h4 class="panel-title">
                                                            <a data-toggle="collapse" data-parent="#subAccountingMenu" href="#movementMenu" aria-expanded="true" aria-controls="#subPlanAndDirectLinkMenu">
                                                                3.3 Movement
                                                            </a>
                                                        </h4>
                                                    </div>
                                                    <div id="movementMenu" class="panel-collapse collapse" role="tabpanel" aria-labelledby="subPlanAndDirectMenu">
                                                        <div class="panel-body">
                                                            <ul class="nav nav-pills nav-stacked">
                                                                <li role="presentation"><a href="${context}/movement/edit.html">สร้าง</a></li>
                                                                <li role="presentation"><a href="${context}/movement/list.html">ค้นหา</a></li>


                                                            </ul>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
            <div class="col-sm-6">
                <div class="col-sm-12">
                    <div class="col-sm-2"></div>
                    <div class="col-sm-9">
                        <div class="panel-group" id="shawpatMenuLeft" role="tablist" aria-multiselectable="true">
                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="headPeopleMenu">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#shawpatMenuLeft" href="#peopleMenu" aria-expanded="true" aria-controls="#projectMenu">
                                            4.People
                                        </a>
                                    </h4>

                                </div>
                                <div id="peopleMenu" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headPeopleMenu">
                                    <div class="panel-body">
                                        <div class="panel-group" id="subPeopleMenu" role="tablist" aria-multiselectable="true">
                                            <div class="panel panel-default">
                                                <div class="panel-heading" role="tab" id="subPeopleMenu">
                                                    <h4 class="panel-title">
                                                        <a data-toggle="collapse" data-parent="#subPeopleMenu" href="#customerMenu" aria-expanded="true" aria-controls="#subPlanAndDirectLinkMenu">
                                                            4.1 Customer
                                                        </a>
                                                    </h4>
                                                </div>
                                                <div id="customerMenu" class="panel-collapse collapse" role="tabpanel" aria-labelledby="subPlanAndDirectMenu">
                                                    <div class="panel-body">
                                                        <ul class="nav nav-pills nav-stacked">
                                                            <li role="presentation"><a href="${context}/customer/entry.html">สร้าง</a></li>
                                                            <li role="presentation"><a href="${context}/customer/list.html">ค้นหา</a></li>


                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>

                                            <div class="panel panel-default">
                                                <div class="panel-heading" role="tab" id="subPeopleMenu">
                                                    <h4 class="panel-title">
                                                        <a data-toggle="collapse" data-parent="#subPeopleMenu" href="#supplierMenu" aria-expanded="true" aria-controls="#subPlanAndDirectLinkMenu">
                                                            4.2 Supplier
                                                        </a>
                                                    </h4>
                                                </div>
                                                <div id="supplierMenu" class="panel-collapse collapse" role="tabpanel" aria-labelledby="subPlanAndDirectMenu">
                                                    <div class="panel-body">
                                                        <ul class="nav nav-pills nav-stacked">
                                                            <li role="presentation"><a href="${context}/supplier/entry.html">สร้าง</a></li>
                                                            <li role="presentation"><a href="${context}/supplier/list.html">ค้นหา</a></li>


                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>


                                            <div class="panel panel-default">
                                                <div class="panel-heading" role="tab" id="subPeopleMenu">
                                                    <h4 class="panel-title">
                                                        <a data-toggle="collapse" data-parent="#subPeopleMenu" href="#employeeMenu" aria-expanded="true" aria-controls="#subPlanAndDirectLinkMenu">
                                                            4.3 Employee
                                                        </a>
                                                    </h4>
                                                </div>
                                                <div id="employeeMenu" class="panel-collapse collapse" role="tabpanel" aria-labelledby="subPlanAndDirectMenu">
                                                    <div class="panel-body">
                                                        <ul class="nav nav-pills nav-stacked">
                                                            <li role="presentation"><a href="${context}/employee/entry.html">สร้าง</a></li>
                                                            <li role="presentation"><a href="${context}/employee/list.html">ค้นหา</a></li>


                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="headUtilityMenu">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#shawpatMenuLeft" href="#utilityMenu" aria-expanded="true" aria-controls="#projectMenu">
                                            5.Utility
                                        </a>
                                    </h4>

                                </div>
                                <div id="utilityMenu" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headUtilityMenu">
                                    <div class="panel-body">
                                        <div class="panel-group" id="subUtilityMenu" role="tablist" aria-multiselectable="true">
                                            <div class="panel panel-default">
                                                <div class="panel-heading" role="tab" id="subUtilityMenu">
                                                    <h4 class="panel-title">
                                                        <a data-toggle="collapse" data-parent="#subUtilityMenu" href="#reservationMenu" aria-expanded="true" aria-controls="#subPlanAndDirectLinkMenu">
                                                            5.1 Reservation
                                                        </a>
                                                    </h4>
                                                </div>
                                                <div id="reservationMenu" class="panel-collapse collapse" role="tabpanel" aria-labelledby="subReservationMenu">
                                                    <div class="panel-body">
                                                        <ul class="nav nav-pills nav-stacked">
                                                            <li role="presentation"><a href="${context}/reservation/entry.html">สร้าง</a></li>
                                                            <li role="presentation"><a href="${context}/reservation/list.html">ค้นหา</a></li>


                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>


                                        </div>
                                    </div>

                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="headUserMenu">
                                    <h4 class="panel-title">
                                        <a data-toggle="collapse" data-parent="#shawpatMenuLeft" href="#subUserMenu" aria-expanded="true" aria-controls="#projectMenu">
                                            6.User
                                        </a>
                                    </h4>

                                </div>
                                <div id="subUserMenu" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headUserMenu">
                                    <div class="panel-body">
                                        <div class="panel-group" id="subUserMenu" role="tablist" aria-multiselectable="true">
                                            <div class="panel panel-default">
                                                <div class="panel-heading" role="tab" id="subUserMenu">
                                                    <h4 class="panel-title">
                                                        <a data-toggle="collapse" data-parent="#subUserMenu" href="#userMenu" aria-expanded="true" aria-controls="#subPlanAndDirectLinkMenu">
                                                            6.1 User
                                                        </a>
                                                    </h4>
                                                </div>
                                                <div id="userMenu" class="panel-collapse collapse" role="tabpanel" aria-labelledby="subUserMenu">
                                                    <div class="panel-body">
                                                        <ul class="nav nav-pills nav-stacked">
                                                            <li role="presentation"><a href="${context}/user/entry.html">สร้าง</a></li>
                                                            <li role="presentation"><a href="${context}/user/list.html">ค้นหา</a></li>


                                                        </ul>
                                                    </div>
                                                </div>
                                            </div>


                                        </div>
                                    </div>

                                </div>
                            </div>
                        </div>


                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-6">&nbsp;</div>
        </div>
    </tiles:putAttribute>
</tiles:insertDefinition>
