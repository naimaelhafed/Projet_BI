<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/template/" prefix="template" %>
<%@taglib tagdir="/WEB-INF/tags/bootstrap/" prefix="bs" %>
<template:admin>
    <div class="center-block">
        <div class="center-block">
            <div class="info-box">
                <span class="info-box-icon bg-aqua"><i class="fa fa-cube"></i></span>
                <div class="info-box-content">
                    <span class="info-box-text">Projet BI</span>
                    <span class="info-box-number">${state.products}</span>
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
                <div class="row">
                    <div class="col-xs-6">
                        <div id="canvas-holder">
			<canvas id="chart-area" width="300" height="300"/>
		</div>
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- ./box-body -->
            <div style="display: none;" class="box-footer">
            </div><!-- /.box-footer -->
        </div><!-- /.box -->
    </div>
</template:admin>