$(document).ready(function(){var e=document.getElementById("info").innerHTML,r=e.substring(1,e.length-1).split(", ");$("#Categoria").val("1"),$("#TipoDocumento").val(r[1]),$("#ExpPais").val(r[2]).change(),setTimeout(function(){$("#ExpDepartamento").val(r[3]).change(),setTimeout(function(){$("#ExpCiudad").val(r[4]),$("#ResPais").val(r[5]).change(),setTimeout(function(){$("#ResDepartamento").val(r[6]).change(),setTimeout(function(){$("#ResCiudad").val(r[7]),$("#OfiPais").val(r[8]).change(),setTimeout(function(){$("#OfiDepartamento").val(r[9]).change(),setTimeout(function(){$("#OfiCiudad").val(r[10]),$("#NacPais").val(r[14]).change(),setTimeout(function(){$("#NacDepartamento").val(r[15]).change(),setTimeout(function(){$("#NacCiudad").val(r[16]),$("#EmpPais").val(r[21]).change(),setTimeout(function(){$("#EmpDepartamento").val(r[22]).change(),setTimeout(function(){$("#EmpCiudad").val(r[23])},500)},500)},500)},500)},500)},500)},500)},500)},500)},500),$("#ano").val(r[11]),$("#mes").val(r[12]),$("#dia").val(r[13]),$("#Sexo").val(r[17]),$("#Estado").val(r[18]),$("#Estrato").val(r[19]),$("#TipoEmpresa").val(r[20]);var a=!0;$("#Conocimiento option").each(function(){$(this).val()==r[24]&&(a=!1)}),a?null==r[24]?($("#Conocimiento").val("").change(),$("#Otrosok").val("")):($("#Conocimiento").val("Otros").change(),$("#Otrosok").val(r[24])):$("#Conocimiento").val(r[24]).change(),$(".tabla").focusout(),$("#EspComprende").val(r[26]),$("#EspHabla").val(r[27]),$("#EspEscribe").val(r[28]),$("#IngComprende").val(r[30]),$("#IngHabla").val(r[31]),$("#IngEscribe").val(r[32]),$("#FranComprende").val(r[34]),$("#FranHabla").val(r[35]),$("#FranEscribe").val(r[36]);var t=37;"finIdiomas"!=r[t]?($("#otroIdioma").val(r[t]).blur(),t++,$("#otroComprende").val(r[t]),t++,$("#otroHabla").val(r[t]),t++,$("#otroEscribe").val(r[t]),t+=2):t++,$("#Egresado").val(r[t]),"null"!=r[t+1]&&($("#notas").val(r[t+1]),$("#notasevaluador").removeAttr("hidden")),$("#OfiDireccion").blur(),$("#Empresa").blur()}),$("#otroIdioma").on("blur",function(e){""!=$("#otroIdioma").val()?($("#otroComprende").attr("required","required"),$("#otroHabla").attr("required","required"),$("#otroEscribe").attr("required","required")):($("#otroComprende").removeAttr("required"),$("#otroHabla").removeAttr("required"),$("#otroEscribe").removeAttr("required"))}),$("#OfiDireccion").on("blur",function(e){""!=$("#OfiDireccion").val()?($("#OfiDireccion").prop("required",!0),$("#OfiTelefono").prop("required",!0),$("#Celular").prop("required",!0),$("#OfiPais").prop("required",!0),$("#OfiDepartamento").prop("required",!0),$("#OfiCiudad").prop("required",!0)):($("#OfiDireccion").removeAttr("required"),$("#OfiTelefono").removeAttr("required"),$("#Celular").removeAttr("required"),$("#OfiPais").removeAttr("required"),$("#OfiDepartamento").removeAttr("required"),$("#OfiCiudad").removeAttr("required"))}),$("#Empresa").on("blur",function(e){""!=$("#Empresa").val()?($("#TipoEmpresa").prop("required",!0),$("#Cargo").prop("required",!0),$("#EmpDireccion").prop("required",!0),$("#EmpTelefono").prop("required",!0),$("#EmpPais").prop("required",!0),$("#EmpDepartamento").prop("required",!0),$("#EmpCiudad").prop("required",!0)):($("#TipoEmpresa").removeAttr("required"),$("#Cargo").removeAttr("required"),$("#EmpDireccion").removeAttr("required"),$("#EmpTelefono").removeAttr("required"),$("#EmpPais").removeAttr("required"),$("#EmpDepartamento").removeAttr("required"),$("#EmpCiudad").removeAttr("required"))}),$(".tabla").on("blur",function(e){if(""!=$(e.target).val())for(var r=2;r<=4;r++)$("#"+e.target.id.slice(0,-1)+r).attr("required","required");else for(r=2;r<=4;r++)$("#"+e.target.id.slice(0,-1)+r).removeAttr("required")}),$(".numeros").on("keypress",function(e){/[0-9]/.test(String.fromCharCode(e.keyCode))||e.preventDefault()}),$(".letras").on("keypress",function(e){/[a-zA-Z\s]/.test(String.fromCharCode(e.keyCode))||e.preventDefault()}),$(".lenum").on("keypress",function(e){/[a-zA-Z0-9\s#\-]/.test(String.fromCharCode(e.keyCode))||e.preventDefault()}),$(".fechas").on("keypress",function(e){/[0-9\-]/.test(String.fromCharCode(e.keyCode))||e.preventDefault()}),$(".fechas").on("blur",function(e){if(""!=$(e.target).val()){/^[0-9]{4}\-[0-9]{1,2}\-[0-9]{1,2}$/.test($(e.target).val())||(alert("La fecha debe tener el formato YYYY-MM-DD"),$(e.target).val(""),$(e.target).focus())}}),$(".correo").on("blur",function(e){if(""!=$(e.target).val()){/^[a-z\.]*\@[a-z]*\.[a-z\.]*$/.test($(e.target).val())||(alert("El correo debe tener el formato micorreo@unejemplo.es o mi.correo@un.ejemplo.es"),$(e.target).val(""),$(e.target).focus())}}),$("#Conocimiento").on("change",function(e){"Otros"==$("#Conocimiento").val()?$("#Otrosok").show():$("#Otrosok").hide()}),$(".pais").on("change",function(e){AJAX(""!=$(e.target).val()?$(e.target).val():"0",e.target.id.replace("Pais","Departamento"),"FormularioDept",!0)}),$(".departamento").on("change",function(e){AJAX(""!=$(e.target).val()?$(e.target).val():"0",e.target.id.replace("Departamento","Ciudad"),"FormularioCiudad",!0)});var suma=parseInt($("#Prestamo").val())+parseInt($("#AuxEmp").val())+parseInt($("#Recursos").val())+parseInt($("#Beca").val());$(".recursos").on("focus",function(e){suma-=parseInt($(e.target).val())}),$(".recursos").on("blur",function(e){$(e.target).val()<0||""==$(e.target).val()?$(e.target).val("0"):$(e.target).val()>100&&$(e.target).val("100"),suma+=parseInt($(e.target).val())}),$(document).on("submit",function(e){100!=suma&&(e.preventDefault(),e.stopPropagation(),alert("La suma de los recursos no da el 100%"))});