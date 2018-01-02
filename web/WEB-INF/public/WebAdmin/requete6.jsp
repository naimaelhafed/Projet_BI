<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/template/" prefix="template" %>
<%@taglib tagdir="/WEB-INF/tags/bootstrap/" prefix="bs" %>
<template:admin>
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="box box-info">
            <div class="box-header with-border">
                <h3 class="box-title">Client performance de l'expedition</h3>
                    <form method="POST" action="" class="row">
                <c:forEach var="item" items="${year}">
                    <button type="submit" class="btn  btn-primary" value="${item}" name="annee"><span>${item}</span></button>
                </c:forEach>
                 
                </form>
            </div><!-- /.box-header -->
            <div  class="box-body">
                <div class="row">
                    <div class="col-xs-6">
                        <div id="canvas-holder">
                            <table class="table table-hover table-condensed  table-responsive table-bordered table-striped">
                                <thead>
                                    <tr>
                                        <td></td>
                                        <td>Nom </td>
                                        <td>Nombre des commandes</td>
                                        <td>Année</td>
                                </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${SHIPPER}" var="value">
                                        <tr> 
                                            <td><span class="fa fa-bars"></span></td>
                                            <td><c:out value="${value.get(0)}" /></td>
                                            <td><c:out value="${value.get(1)}" /></td>
                                            <td><c:out value="${value.get(2)}" /></td>
                                        </tr>
                                        </c:forEach>
                                </tbody>
                                      </table>
                        </div>
                        <div class="row"><br>
                            <div class="col-xs-12">
                                <div id="canvas-holder">
                                    <div id="chart" style="height: 500px; width: 900px;"></div>
                                </div>
                            </div>
                        </div><!-- /.col -->
                    </div><!-- /.row -->
                    <!-- ./box-body -->

                </div>
            </div>
        </div>
        <script type="text/javascript" src="<c:url value="/assets/js/Chart.js"/>"></script>

        <script>

            var dynamic = [];
            window.onload = function () {

            <c:forEach var="liste"  items="${requestScope['SHIPPER']}" >
                dynamic.push({y: ${liste.get(1)}, name: "${liste.get(0)}"});
            </c:forEach>

                var chart = new CanvasJS.Chart("chart", {
                    exportEnabled: true,
                    animationEnabled: true,
                    title: {
                        text: ""
                    },
                    legend: {
                        cursor: "pointer",
                        itemclick: explodePie
                    },
                    data: [{
                            type: "pie",
                            showInLegend: true,
                            toolTipContent: "{name}: <strong>{y}</strong>",
                            indexLabel: "{name} - {y}",
                            dataPoints: dynamic
                        }]
                });
                chart.render();
            }

            function explodePie(e) {
                if (typeof (e.dataSeries.dataPoints[e.dataPointIndex].exploded) === "undefined" || !e.dataSeries.dataPoints[e.dataPointIndex].exploded) {
                    e.dataSeries.dataPoints[e.dataPointIndex].exploded = true;
                } else {
                    e.dataSeries.dataPoints[e.dataPointIndex].exploded = false;
                }
                e.chart.render();

            }



        </script> 

        <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
    </template:admin>