<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE html>
<html lang="en">
<head>

    <!-- start: Meta -->
    <meta charset="utf-8">
    <title>Country</title>
    <meta name="description" content="IGC Travel Portal System">
    <meta name="author" content="IGC Travel Portal System">
    <meta name="keyword" content="IGC Travel Portal System">
    <!-- end: Meta -->

    <!-- start: Mobile Specific -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- end: Mobile Specific -->

    <!-- 	base url -->

    <base href="${pageContext.request.contextPath}/country/"/>

    <!--  End	base url -->


    <!-- start: CSS -->


    <!-- ******script included********* -->
    <%@include file="/WEB-INF/includes/styling.jsp" %>

    <!-- ******  end of script included********* -->

    <!-- end: CSS -->


    <!-- start: Favicon -->
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/img/favicon.ico">
    <!-- end: Favicon -->


</head>

<body>

<!-- delete confirm model -->

<div class="modal fade" id="myModal_del" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="delete" method="post">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span
                            aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">Delete Country</h4>
                </div>
                <div class="modal-body">

                    Are you sure you want to delete this Country? This action cannot be undone!
                    <input id="deleteId" type="text" style="display: none" value="" name="id">

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default btn-sm" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary btn-sm">Delete</button>
                </div>

            </form>

        </div>
    </div>
</div>

<!-- End   delete confirm model -->

<!-- start: Header -->

<!--     ***** header******  -->

<%@include file="/WEB-INF/includes/header.jsp" %>

<!--     ***** end  header******  -->

<!-- end: Header -->

<div class="container-fluid-full">
    <div class="row-fluid">

        <!-- start: Main Menu -->

        <!--     ***** navigator******  -->

        <%@include file="/WEB-INF/includes/navigator.jsp" %>

        <!--     ***** end  navigator******  -->

        <!-- end: Main Menu -->

        <noscript>
            <div class="alert alert-block span10">
                <h4 class="alert-heading">Warning!</h4>
                <p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a>
                    enabled to use this site.</p>
            </div>
        </noscript>

        <!-- start: Content -->
        <div id="content" class="span10">


            <ul class="breadcrumb">
                <li>
                    <i class="icon-home"></i>
                    <a href="index.html">Home</a>
                    <i class="icon-angle-right"></i>
                </li>
                <li><a href="#">Messages</a></li>
            </ul>


            <%-- 			${dbResponse} --%>
            <!-- 			 success alert -->
            <c:if test="${dbResponse!=null}">
                <div class="alert alert-success">
                    <button type="button" class="close" data-dismiss="alert">�</button>
                    <strong>Well Done!</strong> ${dbResponse.msg }
                </div>
            </c:if>

            <!-- 		 end	 success alert -->

            <!-- 				error alert -->

            <!-- <div class="alert alert-error">
                <button type="button" class="close" data-dismiss="alert">�</button>
                <strong>Oh snap!</strong> Change a few things up and try submitting
                again.
            </div> -->

            <!-- 				end error alert -->


            <!-- 			Add  or Edit form -->

            <c:if test="${mode=='edit' || mode=='add'  }">

                <div class="row-fluid sortable">
                    <div class="box span12" id="box">
                        <div class="box-header" data-original-title>
                            <h2><i class="halflings-icon white edit"></i><span class="break"></span><c:if
                                    test="${mode=='add'}">Add</c:if><c:if test="${mode=='edit'}">Edit</c:if> Country
                            </h2>
                            <div class="box-icon">
                                <a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
                                <a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
                                <a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
                            </div>
                        </div>
                        <div class="box-content">
                            <form id="form1" class="form-horizontal" method="post" action="${mode}">
                                <fieldset>
                                    <div class="control-group">
                                        <label class="control-label" for="focusedInput">Country</label>
                                        <div class="controls"><input type="hidden" name="countryId"
                                                                     value="${countryMap.countryId}">
                                            <input class="input-xlarge focused" id="focusedInput" name="countryName"
                                                   type="text" value="${countryMap.countryName}">
                                        </div>
                                    </div>

                                    <c:if test="${mode!='detail'}">
                                        <div class="form-actions">
                                            <button type="submit" class="btn btn-primary">Save changes</button>
                                            <button class="btn" id="cancel">Cancel</button>
                                        </div>

                                    </c:if>


                                </fieldset>
                            </form>

                        </div>
                    </div><!--/span-->

                </div>
                <!--/row-->

            </c:if>
            <!-- 			End Add  or Edit form -->


            <!-- 			add button -->

            <div class="test">
                <a href="add" title="Add Country" data-rel="tooltip" class="btn btn-warning">Add Country</a>
            </div>
            <!-- 			end add button -->


            <!-- 			table  -->

            <div class="row-fluid sortable">
                <div class="box span12">
                    <div class="box-header" data-original-title>
                        <h2><i class="halflings-icon white user"></i><span class="break"></span>Country List</h2>
                        <div class="box-icon">
                            <a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
                            <a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
                            <a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
                        </div>
                    </div>
                    <div class="box-content">
                        <table class="table table-striped table-bordered bootstrap-datatable datatable">
                            <thead>
                            <tr>
                                <th>S.N</th>
                                <th>Country</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <%int count = 0; %>
                            <c:forEach items="${countryList}" var="data">
                                <%count++; %>
                                <tr>
                                    <td><%=count%>.</td>
                                    <td>${data.countryName}</td>

                                    <td class="center">

                                        <a class="btn btn-info" href="edit/${data.countryId}" title="Edit"
                                           data-rel="tooltip">
                                            <i class="halflings-icon white edit"></i>
                                        </a>

                                        <a class="open btn btn-danger" title="Delete" data-toggle="modal"
                                           data-target="#myModal_del"
                                           data-id="${data.countryId}" data-rel="tooltip">
                                            <i class="halflings-icon white trash"></i>
                                        </a>
                                    </td>
                                </tr>


                            </c:forEach>


                            </tbody>
                        </table>
                    </div>
                </div><!--/span-->

            </div><!--/row-->

            <!-- 			end table -->


        </div><!--/.fluid-container-->

        <!-- end: Content -->
    </div><!--/#content.span10-->
</div><!--/fluid-row-->

<div class="modal hide fade" id="myModal">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">�</button>
        <h3>Settings</h3>
    </div>
    <div class="modal-body">
        <p>Here settings can be configured...</p>
    </div>
    <div class="modal-footer">
        <a href="#" class="btn" data-dismiss="modal">Close</a>
        <a href="#" class="btn btn-primary">Save changes</a>
    </div>
</div>

<div class="clearfix"></div>

<footer>

    <p>
        <span style="text-align:left;float:left">&copy; 2013 <a
                href="http://themifycloud.com/downloads/janux-free-responsive-admin-dashboard-template/"
                alt="Bootstrap_Metro_Dashboard">JANUX Responsive Dashboard</a></span>

    </p>

</footer>

<!-- start: JavaScript-->

<!-- ******script included********* -->
<%@include file="/WEB-INF/includes/script.jsp" %>

<!-- ******  end of script included********* -->

<!-- end: JavaScript-->


<script type="text/javascript">

    //
    <!-- 	pass deleteing  id to delete confirm model  -->

    $(document).on("click", ".open", function () {
        var id = $(this).data('id');
        $(".modal-body #deleteId").val(id);

    });

    //
    <!-- End	pass deleteing  id to delete confirm model 	 -->

    // clicking cancel button to close add/edit/detail form
    $(document).on("click", "#cancel", function () {
        $('#form1').submit(function () {
            return false;
        });

        $("#box").hide();

    });
    // end  clicking cancel button to close add/edit/detail form

</script>

<!-- enable  script for detail view to disable textEditor -->

<c:if test="${mode=='detail'}">
    <script type="text/javascript">
        $("#form1 :input").attr("disabled", true);

        $(document).ready(function () {
            $("#textEditor").setReadOnly(isReadOnly);
        });
    </script>
</c:if>

<!-- enable  script for detail view to disable textEditor -->


</body>
</html>
