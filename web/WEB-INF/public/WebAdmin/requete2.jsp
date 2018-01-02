<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/template/" prefix="template" %>
<%@taglib tagdir="/WEB-INF/tags/bootstrap/" prefix="bs" %>
<template:admin>
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="box box-info">
            <div class="box-header with-border">
                <h3 class="box-title">Le rendement de chaque employées par années </h3>
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
                                        <td>Nom de l'employée</td>
                                        <td>Ventes</td>
                                        <td>Année</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${employee}" var="value" >
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
                                    <div id="chartContainer" style="height: 500px; width: 900px;"></div>

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



    <script>

        var dynamic = [];
        var dynamic1 = [];
        window.onload = function () {

        <c:forEach var="employe"  items="${requestScope['employee']}" >
            dynamic.push({label: "${employe.get(0)}", y:${employe.get(1)}});
            dynamic1.push({label: "${employe.get(0)}", y:${employe.get(2)}});
        </c:forEach>

            var chart = new CanvasJS.Chart("chartContainer", {
                animationEnabled: true,
                title: {
                    text: ""
                },
                axisY: {
                    title: "Nombre des ventes",
                    titleFontColor: "#4F81BC",
                    lineColor: "#4F81BC",
                    labelFontColor: "#4F81BC",
                    tickColor: "#4F81BC"
                },
                axisY2: {
                    title: "Année",
                    titleFontColor: "#C0504E",
                    lineColor: "#C0504E",
                    labelFontColor: "#C0504E",
                    tickColor: "#C0504E"
                },
                toolTip: {
                    shared: true
                },
                legend: {
                    cursor: "pointer",
                    itemclick: toggleDataSeries
                },
                data: [{
                        type: "column",
                        name: "Nombres des ventes",
                        legendText: "Nombres des ventes",
                        showInLegend: true,
                        dataPoints: dynamic
                    },
                    {
                        type: "column",
                        name: "Année",
                        legendText: "Année",
                        axisYType: "secondary",
                        showInLegend: true,
                        dataPoints: dynamic1
                    }]
            });
            chart.render();
            }
            function toggleDataSeries(e) {
                if (typeof (e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
                    e.dataSeries.visible = false;
                } else {
                    e.dataSeries.visible = true;
                }
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