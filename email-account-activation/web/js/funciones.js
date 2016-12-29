$(document).ready(function () {
   $("#submit").click(function () {
      var tmpName = $("#name").val();
      var tmpEmail = $("#email").val();            
      var tmpSource = $("#source").val();            
      if (tmpName === '' || tmpEmail === ''){
         alert("Please Fill All Fields");
      } else {
      // AJAX Code To Submit Form.
         $.ajax({
            type: "POST",
            url: "registration",
            data: {
               paramEmail: tmpEmail,
               paramName: tmpName,
               paramSource: tmpSource
            },
            cache: false,
            success: function (result) {
               alert(result);
            }
         });
      }
      return false;
   });
});