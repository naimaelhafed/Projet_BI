<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/template/" prefix="template" %>
<%@taglib tagdir="/WEB-INF/tags/bootstrap/" prefix="bs" %>
<template:admin>
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="box box-info">
            <div class="box-header with-border">
                <h3 class="box-title">le produit le plus vendu</h3>
            </div><!-- /.box-header -->
            <div  class="box-body">
                <div class="row">
                    <div class="col-xs-6">
                        <div id="canvas-holder">
                            <table class="table table-hover table-condensed  table-responsive table-bordered table-striped">
                                <thead>
                                    <tr>
                                        <td></td>
                                        <td>Nom de produit</td>
                                        <td>Nombre des commandes pour ce produit</td>
                                </tr>
                                </thead>
                                <tbody>
                                   <c:forEach items="${product}" var="value">
                                        <tr> 
                                            
                                            <td><span class="fa fa-bars"></span></td>
                                            <td><c:out value="${value.get(0)}" /></td>
                                            <td><c:out value="${value.get(1)}" /></td>
                                           
                                        </tr> 
                                   </c:forEach>
                                </tbody>
                               
                            </table>
                        </div>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- ./box-body -->
            <div style="display: none;" class="box-footer">
            </div><!-- /.box-footer -->
        </div><!-- /.box -->
    </div>
</template:admin>