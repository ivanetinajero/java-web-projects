// Funcion JavaScript (AJAX) para validar la CURP antes.
function validaCURP(curp) {
   /* la variable curptmp almacenara el valor tecleado en el text
    * con id curp <input type="text" id="curp" ...>
    */
   var curptmp = $("#curp").val();
   //alert("CURP A VALIDAR " + curptmp);
   // Hacemos una peticion AJAX
   $.ajax({
      url: "validaCurp", // URL del SERVLET para validar la CURP
      type: 'POST', // Enviaremos los datos por POST
      data: {
         paramCurp: curptmp   // paramCurp sera el parametro que tendra la curp en el SERVLET
      },
      success: function (result) { // result es la respuesta que nos manda el SERVLET 
         //alert("Respuesta del SERVLET: " + result);
         if (result == "existe") { // mandamos un mensaje de que ya existe
            alert("Esta curp ya existe. Por favor ingresa una diferente");
         } else { // no existe en la BD. Activamos el boton para que pueda hacer submit                              
            $("#btnGuardar").prop("disabled", false); // Activamos boton Submit
            $("#curp").prop("readonly", true); // ya no dejamos que edite esta CURP, porque ya es correcta (NO EXISTE EN LA BD)
         }
      }
   });
}
