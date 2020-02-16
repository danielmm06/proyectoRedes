<%@page contentType="text/html" language="java" pageEncoding="UTF-8" import="java.util.*" %>

<%@ taglib prefix="t" tagdir="/WEB-INF/tags/template" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<t:Estructura_Sistema>
    <jsp:attribute name="title">
        <c:out value="${title}" />
    </jsp:attribute>
    <jsp:attribute name="styles">
        <!-- Styles -->
        <!-- /Styles -->
    </jsp:attribute>
    <jsp:attribute name="scripts">
        <!-- Scripts -->
        <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
        <!--<script type="text/javascript" src="views/js/formulario.js"></script>-->
        <!-- /Scripts -->
    </jsp:attribute>

    <jsp:body>
        <div class="container-fluid">
            <div class="card mb-3">

                <div class="card-header">                    
                    <h2 align="center"><i class="fa fa-file-alt" aria-hidden="true"></i> Prueba Redes</h2>
                </div>
                <div class="card-body  mx-auto mt-2">  

                    <c:forEach  items="${personas}" var="estra">
                        <c:out value="${estra.cedula}"/><br>
                    </c:forEach>
                        <br>
                        <br>
                        <a href="http://localhost:8080/redes/capturarDatos?lector=6&cod=e5 0b 5e e2">prueba</a>
                        
                        

                </div>




            </div>
        </div>
        <!-- /Content -->
    </jsp:body>
</t:Estructura_Sistema>