<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Bootstrap Dashboard" pageEncoding="UTF-8"%>
<%@taglib  tagdir="/WEB-INF/tags/bootstrap/" prefix="b" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@taglib tagdir="/WEB-INF/tags/ui/" prefix="ui" %>
<%@taglib tagdir="/WEB-INF/tags/template/" prefix="template" %>
<c:if test="${sessionScope.user.role.name() ne 'ADMIN'}">
    <c:redirect url="logout.html"></c:redirect>
</c:if>
<template:dashboard>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="left-side sidebar-offcanvas">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->
            <div class="user-panel">
            </div>
            <!-- /.search form -->
            <!-- sidebar menu: : style can be found in sidebar.less -->
            <ul class="sidebar-menu">
                 <li class="${requestScope['javax.servlet.forward.servlet_path'] eq '/r1.saa'? 'active':''}">
                    <a href="r1.saa">
                        <i class="fa fa-info"></i> <span>Requete 1</span>
                    </a>
                </li>
                <li class="${requestScope['javax.servlet.forward.servlet_path'] eq '/r2.saa'? 'active':''}">
                    <a href="r2.saa">
                        <i class="fa fa-info"></i> <span>Requete 2</span>
                    </a>
                </li>
                    <li class="${requestScope['javax.servlet.forward.servlet_path'] eq '/r3.saa'? 'active':''}">
                    <a href="r3.saa">
                        <i class="fa fa-info"></i> <span>Requete 3</span>
                    </a>
                </li>
                    <li class="${requestScope['javax.servlet.forward.servlet_path'] eq '/r4.saa'? 'active':''}">
                    <a href="r4.saa">
                        <i class="fa fa-info"></i> <span>Requete 4</span>
                    </a>
                </li>
                   <li class="${requestScope['javax.servlet.forward.servlet_path'] eq '/r5.saa'? 'active':''}">
                    <a href="r5.saa">
                        <i class="fa fa-info"></i> <span>Requete 5</span>
                    </a>
                </li>
                   <li class="${requestScope['javax.servlet.forward.servlet_path'] eq '/r6.saa'? 'active':''}">
                    <a href="r6.saa">
                        <i class="fa fa-info"></i> <span>Requete 6</span>
                    </a>
                </li>
                </ul>
            </section>
            <!-- /.sidebar -->
        </aside>
        <!-- Right side column. Contains the navbar and content of the page -->
        <aside class="right-side">
            <!-- Content Header (Page header) -->
            <section class="content-header">
            </section>
            <!-- Main content -->
            <section class="content">
            <core:if test="${requestScope.error ne null}">
                <b:alert type="danger">
                    <p>${requestScope.error}</p>
                    <br>
                </b:alert>
            </core:if>
            <core:if test="${requestScope.success  ne null}">
                <b:alert type="success">
                    <p>${requestScope.success}</p>
                    <br>
                </b:alert>
            </core:if>
            <core:if test="${requestScope.info ne null}">
                <b:alert type="info">
                    <p>${requestScope.info}</p>
                    <br>
                </b:alert>
            </core:if>
            <core:if test="${requestScope.warning  ne null}">
                <b:alert type="warning">
                    <p>${requestScope.warning}</p>
                    <br>
                </b:alert>
            </core:if>
            <div class="container-fluid">
                <div class="row">
                    <jsp:doBody/>
                </div>
            </div>
        </section><!-- /.content -->
    </aside><!-- /.right-side -->
</template:dashboard>