<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/template/" prefix="template" %>
<%@taglib tagdir="/WEB-INF/tags/bootstrap/" prefix="bs" %>
<template:admin>
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="box box-info">
            <div class="box-header with-border">
                <h3 class="box-title">La ville qui a le plus grands nombre des ventes</h3>
            </div><!-- /.box-header -->
            <div  class="box-body">
                <div class="row">
                    <div class="col-xs-6">
                        <div id="canvas-holder">
                            <table class="table table-hover table-condensed  table-responsive table-bordered table-striped">
                                <thead>
                                    <tr>
                                        <td></td>
                                        <td>Ville</td>
                                        <td>Nombre des commandes</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${ville}" var="value" step="1"> 
                                        <tr> 

                                            <td><span class="fa fa-bars"></span></td>
                                            <td>${value.get(0)}</td>
                                            <td>${value.get(1)}</td>

                                        </tr>
                                    </c:forEach>
                                </tbody>
                                
                            </table>
                        </div>
                        <div class="row"><br>
                    <div class="col-xs-12">
                        <div id="canvas-holder">
                            </div>
                    </div>
                </div>
                    </div><!-- /.col -->
                </div><!-- /.row -->
                <!-- ./box-body -->
                
            </div>
        </div>
    </div>
    <script type="text/javascript" src="<c:url value="/assets/js/Chart.js"/>"></script>


</template:admin>

