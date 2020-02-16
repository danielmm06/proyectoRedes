<%@page contentType="text/html" language="java" pageEncoding="UTF-8" import="java.util.*" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags/template" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<t:Estructura_Sistema>
    <jsp:attribute name="title">
        <c:out value="${title}" />
    </jsp:attribute>
    <jsp:attribute name="styles">
    </jsp:attribute>
    <jsp:attribute name="scripts">
        <script src="js/jquery-3.3.1.min.js" type="text/javascript"></script>
    </jsp:attribute>

    <jsp:body>
        <div class="card card-login mx-auto mt-5">
            <div class="card-header">Captura de datos</div>

            <div class="card-body">
                <form name="Registroform" id="Registroform" method="post" action="capturarDatos">

                    <div class="form-group">
                        <label for="lector">lector</label>
                        <input type="text" id="lector" name="lector" class="form-control" placeholder="lector" value="<c:out value="${lector}" />">
                    </div>

                    <div class="form-group">
                        <label for="codTerjeta">codTerjeta</label>
                        <input type="text" id="codTerjeta" name="codTerjeta" class="form-control" placeholder="codTerjeta" value="<c:out value="${codigo}" />">
                    </div>


                    <!--<input type="submit" id="botonRegistrar" name="botonRegistrar" class="btn btn-primary btn-lg btn-block" value="Registrarme" >-->

                </form>

            </div>
        </div>

        <script type="text/javascript">
            var lector = document.getElementById("lector").value;
            var codTerjeta = document.getElementById("codTerjeta").value;
            if ((lector != null) && (codTerjeta != null)) {
//                alert("hola");
                var form = document.getElementById("Registroform");
                form.submit();

            }
        </script>

    </jsp:body>
</t:Estructura_Sistema>