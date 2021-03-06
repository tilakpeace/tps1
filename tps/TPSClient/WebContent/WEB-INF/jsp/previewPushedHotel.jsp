<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Ganga
  Date: 9/25/2016
  Time: 11:26 AM
  To change this template use File | Settings | File Templates.
--%>
<!-- The Gallery as lightbox dialog, should be a child element of the document body -->
<div id="blueimp-gallery" class="blueimp-gallery">
    <div class="slides"></div>
    <h3 class="title"></h3>
    <a class="prev">‹</a>
    <a class="next">›</a>
    <a class="close">×</a>
    <a class="play-pause"></a>
    <ol class="indicator"></ol>
</div>

<div>
    <c:set
            value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/TPSResources/HotelImages/"
            var="url"></c:set>

    <c:set
            value="http://${pageContext.request.serverName}:${pageContext.request.serverPort}/TPSResources/RoomImages/"
            var="roomImageUrl"></c:set>
    <div class="col-lg-12">
        <c:set var="tempKeyName" value="hotel_name${hotelDetailMap.hotelDetailId}hotel_detail"/>
        <h1>${hotelDetailMap.hotelName}
            <c:if test="${tempContentData[tempKeyName] != hotelDetailMap.hotelName}"><span class="updated-info">${tempContentData[tempKeyName]}</span></c:if>
            </h1>

        <h2>${hotelDetailMap.streetAddress}</h2>
        <h3>${hotelDetailMap.hotelPhNo1},${hotelDetailMap.hotelPhNo2}<c:if test="${hotelDetailMap.hotelPhNo3!=null}">,</c:if> ${hotelDetailMap.hotelPhNo3}</h3>
        <div class="col-lg-6">
            <div class="ibox float-e-margins">
                <div class="ibox-title">
                    <h5>Description</h5>
                    <div class="ibox-tools">
                        <a class="collapse-link">
                            <i class="fa fa-chevron-up"></i>
                        </a>
                    </div>
                </div>
                <div class="ibox-content">
                    ${hotelDetailMap.description}
                </div>
                <div class="ibox-footer">

                </div>
            </div>
        </div>
        <c:set var="tempKeyName" value="description${hotelDetailMap.hotelDetailId}hotel_detail"/>
        <c:if test="${(tempContentData[tempKeyName]!=null) && (tempContentData[tempKeyName] != hotelDetailMap.description)}">
            <div class="col-lg-6">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>Description</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>

                        </div>
                    </div>
                    <div class="ibox-content updated-info">

                            ${tempContentData[tempKeyName]}
                    </div>
                    <div class="ibox-footer">

                    </div>
                </div>
            </div>
        </c:if>

    </div>
    <div class="lightBoxGallery">
        <c:forEach var="hotelImage" items="${hotelImageList}">
            <c:set var="tempKeyName" value="image_url${hotelImage.hotelImageId}hotel_image"/>
            <c:choose><c:when test="${hotelImage.imageUrl==null}"> <a href="${url}${tempContentData[tempKeyName]}" title="Image from Unsplash" data-gallery="">
                <img src="${url}${tempContentData[tempKeyName]}" width="100px" height="100px"
                     class="updated-info"></a></c:when>
                <c:otherwise> <a href="${url}${hotelImage.imageUrl}" title="Image from Unsplash" data-gallery="">
                    <img src="${url}${hotelImage.imageUrl}" width="100px" height="100px"></a></c:otherwise></c:choose>
            <%--<a href="${url}${hotelImage.imageUrl}" title="Image from Unsplash" data-gallery="">
                <img src="${url}${hotelImage.imageUrl}" width="100px" height="100px"
                     <c:if test="${hotelImage.imageUrl==null}">class="updated-info" </c:if> ></a>--%>
        </c:forEach>
    </div>

    <div class="ibox">
        <div class="ibox-title">
            <h5>Hotel Features</h5>
            <div class="ibox-tools">
                <a class="collapse-link">
                    <i class="fa fa-chevron-up"></i>
                </a>
            </div>
        </div>
        <div class="ibox-content">
            <ul class="unstyled">

                <p>Check In: ${hotelFeatureMap.checkInFrom}-${hotelFeatureMap.checkInTo}</p>
                <p>Check Out: ${hotelFeatureMap.checkOutFrom}-${hotelFeatureMap.checkOutTo}</p>

                <c:set var="parentId" value="0"/>
                <strong>Hotel Facility: </strong>
                <ul>
                    <c:forEach var="hotelActivity" items="${hotelActivityList}" varStatus="count">
                        <li>${hotelActivity.activityDesc}</li>
                        <%--<c:choose>
                            <c:when test="${hotelActivity.active=='Y'}">
                                <li>${hotelActivity.activityDesc}</li>
                            </c:when>
                        </c:choose>--%>

                    </c:forEach>
                </ul>

            </ul>

        </div>
    </div>


    <div class="ibox">
        <div class="ibox-title">
            <h5>Room Detail</h5>
            <div class="ibox-tools">
                <a class="collapse-link">
                    <i class="fa fa-chevron-up"></i>
                </a>
            </div>
        </div>
        <div class="ibox-content">
            <%--<c:out value="${roomAmentityList}"/>--%>
            <table class="table">
                <thead>
                <tr>
                    <th>Photo</th>
                    <th>Room Description</th>
                    <th>Allocate Number</th>
                    <th>Occupancy</th>
                    <th>Rate</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${roomDetailList}" var="roomDetail">

                    <%--<c:set var="totalAllocateRooms" value="${roomDetail.roomsProvided + totalAllocateRooms}"/>--%>
                    <tr>
                        <td>
                            <div class="carousel slide" id="carousel1">
                                <div class="carousel-inner">
                                    <c:set value="0" var="count"/>
                                    <c:forEach var="roomImage" items="${roomImageList}">

                                        <c:if test="${fn:contains(roomImage.roomDetailId,roomDetail.roomDetailId )}">
                                            <c:set value="${count+1}" var="count"/>
                                            <div class="item <c:if test='${count==1}'>active</c:if> ">
                                            <c:set var="tempKeyName" value="image_url${roomImage.roomImageId}room_image" scope="page"/>
                                            <c:choose><c:when test="${roomImage.imageUrl==null}">

                                                    <img alt="image" class="img-responsive updated-info" src="${roomImageUrl}${tempContentData[tempKeyName]}"
                                                         width="250px" height="250px">

                                            </c:when>
                                                <c:otherwise>
                                                        <img alt="image" class="img-responsive" src="${roomImageUrl}${roomImage.imageUrl}" width="250px" height="250px">
                                                </c:otherwise></c:choose>
                                            </div>
                                                </c:if>

                                    </c:forEach>
                                </div>
                                <a data-slide="prev" href="#carousel1" class="left carousel-control">
                                    <span class="icon-prev"></span>
                                </a>
                                <a data-slide="next" href="#carousel1" class="right carousel-control">
                                    <span class="icon-next"></span>
                                </a>
                            </div>
                        </td>
                        <td>
                            <c:set var="tempKeyName" value="custom_name${roomDetail.roomDetailId}room_detail"/>
                            <h3><c:choose>
                                <c:when test="${roomDetail.customName eq null}">${roomDetail.roomTypeDesc}</c:when>
                                <c:otherwise>${roomDetail.customName}</c:otherwise>
                            </c:choose>
                                <c:if test="${tempContentData[tempKeyName] != roomDetail.customName}">
                                <span class="updated-info">${tempContentData[tempKeyName]}</span></h3>
                                </c:if>

                            Facilities: <br>

                            <ul>
                                <c:forEach var="roomAmenity" items="${roomAmentityList}">
                                    <c:if test="${fn:contains(roomAmenity.roomDetailId,roomDetail.roomDetailId )}">
                                        <li>${roomAmenity.amenityDesc}</li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                            Size:${roomDetail.roomDimension}m<sup>2</sup><br>


                           <%-- <ul>

                                    &lt;%&ndash;<li>${roomAmenity.amenityDesc}</li>&ndash;%&gt;
                                    <c:if test="${fn:contains(offer.roomDetailId,roomDetail.roomDetailId )}">
                                        <li>${offer.offerName}</li>
                                    </c:if>
                                </c:forEach>
                            </ul>--%>


                        </td>
                        <td>${roomDetail.roomsProvided}</td>
                        <td>${roomDetail.noOfGuest}</td>
                        <td>${roomDetail.rate}
                            <span>Offers: </span>
                            <c:forEach var="offer" items="${offerList}">
                                <c:if test="${fn:contains(offer.roomDetailId,roomDetail.roomDetailId )}">
                                    <c:set var="tempKeyName" value="offer_name${offer.offerId}offer"/>
                                    <div class="row">
                                        <div class="col-lg-12">
                                                ${offer.offerName}
                                            <c:if test="${tempContentData[tempKeyName] != offer.offerName}"><span class="updated-info"> ${tempContentData[tempKeyName]}</span></c:if>
                                        </div>
                                        <div class="col-lg-12">
                                            <b>Booking Period: </b>
                                                ${offer.bookingFrom}-${offer.bookingTo}
                                        </div>
                                        <div class="col-lg-12">
                                            <b>Effective Period: </b>
                                                ${offer.effectiveFrom}-${offer.effectiveTo}
                                        </div>
                                    </div>
                                </c:if>
                            </c:forEach></td>
                    </tr>
                    <%--<tr><td colspan="4"> Offers: <br>
                        <div class="row">
                            <div class="col-lg-6">
                                Offer Name
                            </div>
                            <div class="col-lg-3">
                                Booking Period
                            </div>
                            <div class="col-lg-3">
                                Effective Period
                            </div>
                        </div>
                        <c:forEach var="offer" items="${offerList}">
                            <c:if test="${fn:contains(offer.roomDetailId,roomDetail.roomDetailId )}">
                                <c:set var="tempKeyName" value="offer_name${offer.offerId}offer"/>
                                <div class="row">
                                    <div class="col-lg-6">
                                            ${offer.offerName}
                                                <c:if test="${tempContentData[tempKeyName] != offer.offerName}"><span class="updated-info"> ${tempContentData[tempKeyName]}</span></c:if>
                                    </div>
                                    <div class="col-lg-3">
                                            ${offer.bookingFrom}-${offer.bookingTo}
                                    </div>
                                    <div class="col-lg-3">
                                            ${offer.effectiveFrom}-${offer.effectiveTo}
                                    </div>
                                </div>
                            </c:if>
                        </c:forEach></td></tr>--%>
                   <%-- <tr><td >

                        <div class="lightBoxGallery"><c:forEach var="roomImage" items="${roomImageList}">

                        <c:if test="${fn:contains(roomImage.roomDetailId,roomDetail.roomDetailId )}">
                            <c:set var="tempKeyName" value="image_url${roomImage.roomImageId}room_image"/>
                            <c:choose><c:when test="${roomImage.imageUrl==null}"> <a href="${roomImageUrl}${tempContentData[tempKeyName]}" title="Image from Unsplash" data-gallery="">
                                <img src="${roomImageUrl}${tempContentData[tempKeyName]}" width="100px" height="100px"
                                     class="updated-info"></a></c:when>
                                <c:otherwise> <a href="${roomImageUrl}${roomImage.imageUrl}" title="Image from Unsplash" data-gallery="">
                                    <img src="${roomImageUrl}${roomImage.imageUrl}" width="100px" height="100px"></a></c:otherwise></c:choose>


                        </c:if>
                    </c:forEach></div></td></tr>--%>
                </c:forEach>

                </tbody>

            </table>

                <%--<c:out value="${action}"/>--%>
                <form action="" id="accept" method="post" class="form-horizontal">
                    <input type="hidden" name="hotelDetailId" value="${hotelDetailMap.hotelDetailId}">

                    <c:if test="${action eq 'accept'}">
                        <button type="submit" class="btn btn-primary" formaction="${pageContext.request.contextPath}/hotelDetail/acceptHotel">Accept</button>
                    </c:if>
                    <c:if test="${action eq 'approved'}">
                        <div class="form-group"><label class="col-sm-2 control-label">Remarks</label>

                            <div class="col-sm-3"> <textarea name="remarks" class="form-control"></textarea> </div>
                        </div>
                        <div class="col-sm-4 col-sm-offset-2">
                            <button type="submit" class="btn btn-primary" formaction="${pageContext.request.contextPath}/hotelDetail/approveContent">Approved</button>
                            <button type="submit" class="btn btn-default" formaction="${pageContext.request.contextPath}/hotelDetail/rejectContent">Reject</button>
                        </div>
                    </c:if>
                    <c:if test="${(action eq '') && (sessionScope.get('roleId')==2)}">
                        <button type="submit" class="btn btn-primary" formaction="${pageContext.request.contextPath}/hotelDetail/pushUpdate">Push Update</button>
                    </c:if>
                    <%--<div class="form-group">
                        <div class="col-sm-4 col-sm-offset-2">
                            <button type="submit" class="btn btn-primary" formaction="${pageContext.request.contextPath}/hotelDetail/approveContent">Approved</button>
                            <button type="submit" class="btn btn-default" formaction="${pageContext.request.contextPath}/hotelDetail/rejectContent">Reject</button>
                        </div>
                    </div>
--%>
                    <%--<label class="col-sm-2 control-label">Accept <input type="checkbox" class="i-checks" id="checkbox-accept" name="active" checked value="Y"></label>--%>


                </form>

        </div>
    </div>
</div>

