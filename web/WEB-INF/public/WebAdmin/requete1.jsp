<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/template/" prefix="template" %>
<%@taglib tagdir="/WEB-INF/tags/bootstrap/" prefix="bs" %>
<template:admin>
    <div class="col-md-12 col-sm-12 col-xs-12">
        <div class="box box-info">
            <div class="box-header with-border">
                <h3 class="box-title">Tendance des ventes pendant les années </h3>
            </div><!-- /.box-header -->
            <div  class="box-body">
                <div class="row">
                    <div class="col-xs-6">
                        <div id="canvas-holder">
                            <table class="table table-hover table-condensed  table-responsive table-bordered table-striped">
                                <thead>
                                    <tr>
                                        <td></td>
                                        <td>Ventes</td>
                                        <td>Année</td>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${ventes}" var="value" >
                                        <tr> 

                                            <td><span class="fa fa-bars"></span></td>
                                            <td><c:out value="${value.get(0)}" /></td>
                                            <td><c:out value="${value.get(1)}" /></td>

                                        </tr>
                                    </c:forEach>
                                </tbody>

                           </table>
                        </div>
                        <div class="row"><br>
                    <div class="col-xs-12">
                        <div id="canvas-holder">
                            <div id="chartContainer" style="height: 500px; width: 900px;"></div></div>
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

        <c:forEach var="vente"  items="${requestScope['ventes']}" >
        dynamic.push({y: ${vente.get(0)}, label:"${vente.get(1)}"})
        </c:forEach>
var chart = new CanvasJS.Chart("chartContainer", {
	animationEnabled: true,
	theme: "light2", 
	title:{
		text: ""
	},
	axisY: {
		title: "nombre des ventes"
	},
	data: [{        
		type: "column",  
		showInLegend: true, 
		legendMarkerColor: "grey",
		legendText: "Année",
		dataPoints: dynamic
	}]
});
chart.render();

}

    </script>
    
   
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>

</template:admin>

