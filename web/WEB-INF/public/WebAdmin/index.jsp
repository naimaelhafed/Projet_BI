<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/template/" prefix="template" %>
<%@taglib tagdir="/WEB-INF/tags/bootstrap/" prefix="bs" %>
<template:admin>
    <div class="col-md-12">
        <div class="col-md-3 col-sm-6 col-xs-12">
            <div class="info-box">
                <span class="info-box-icon bg-aqua"><i class="fa fa-cube"></i></span>
                <div class="info-box-content">
                    <span class="info-box-text">Business Intelligence</span>
                </div><!-- /.info-box-content -->
            </div><!-- /.info-box -->
        </div><!-- /.col -->
    </div>

    <div class="col-md-12">
        <div class="box box-info">
            <div class="box-header with-border">
                <h3 class="box-title">Description</h3>
                <div class="box-tools pull-right">
                    <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                    <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>

                </div>
            </div><!-- /.box-header -->
            <div  class="box-body">
                <h3 style="align-content: center">Master Data Science- FSSM</h3>
                <h4>* Projet: Conception et implémentation d’un datawarehouse sur la base de données
                    “Northwind” (ORACLE/ JAVA) </h4>
                <h5 class="box-title">* Binome : EL-HAFED NAIMA et YOUSSEF MEHDI OUKAJA</h5><!-- /.row -->
            </div>
            <div style="display: none;" class="box-footer">
            </div>
        </div>
    </div>


    <script type="text/javascript" src="<c:url value="/assets/js/Chart.js"/>"></script>
    <script src="//unpkg.com/3d-force-graph-vr"></script>
    <script>

        var myGraph = ForceGraphVR();
        myGraph(<myDOMElement>)
.graphData(<myData>);


</script> 


    <script src="/assets/d3/d3.js"></script>



</template:admin>

