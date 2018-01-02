<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/template/" prefix="template"%>
<%@taglib tagdir="/WEB-INF/tags/bootstrap/" prefix="bs" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<template:index>
    <bs:modal title="" id="login" icon="user"> 
        <form method="POST" class="form" action="">
            <label>Username</label>
            <input type="text" id="username" name="username" required="required" class="form-control">
            <label>Password</label>
            <input type="password" id="password" name="password" required="required" class="form-control">
            <br>
            <input type="hidden" name="LOGIN" value="TRUE">
            <button type="submit" class="btn btn-success pull-right"><span class="fa fa-sign-in"> Login </span></button>
        </form>
    </bs:modal>
    <script>
        $('#login').modal();
    </script>
</template:index>