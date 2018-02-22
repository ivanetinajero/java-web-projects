<!-- https://www.jstree.com/ -->

<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>jsTree test</title>
  <link rel="stylesheet" href="dist/themes/default/style.min.css" />
  
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  
  <script src="dist/jstree.min.js"></script>
   
  <script>
  $(function () {
     /*
     var arrayCollection = [
        {"id": "animal", "parent": "#", "text": "Animals"},
        {"id": "device", "parent": "#", "text": "Devices"},
        {"id": "dog", "parent": "animal", "text": "Dogs"},
        {"id": "lion", "parent": "animal", "text": "Lions"},
        {"id": "mobile", "parent": "device", "text": "Mobile Phones"},
        {"id": "lappy", "parent": "device", "text": "Laptops"},
        {"id": "daburman", "parent": "dog", "text": "Dabur Man", "icon": "/"},
        {"id": "Dalmation", "parent": "dog", "text": "Dalmatian", "icon": "/"},
        {"id": "african", "parent": "lion", "text": "African Lion", "icon": "/"},
        {"id": "indian", "parent": "lion", "text": "Indian Lion", "icon": "/"},
        {"id": "apple", "parent": "mobile", "text": "Apple IPhone 6", "icon": "/"},
        {"id": "samsung", "parent": "mobile", "text": "Samsung Note II", "icon": "/"},
        {"id": "lenevo", "parent": "lappy", "text": "Lenevo", "icon": "/"},
        {"id": "hp", "parent": "lappy", "text": "HP", "icon": "/"}
     ];
     */
     
     var arrayCollection = [
        {"id": "1", "parent": "#", "text": "Activos"},
        {"id": "2", "parent": "1", "text": "Muebles"},       
        {"id": "3", "parent": "1", "text": "Vehiculos", "icon": "dist/images/car.png"},
        {"id": "4", "parent": "2", "text": "Escritorios", "icon": "dist/images/folder.png",
           state:{
            disabled  : true,
           }
        },
        {"id": "5", "parent": "2", "text": "Impresoras", "icon": "/"},
        {"id": "6", "parent": "3", "text": "Camiones", "icon": "/"},
        {"id": "7", "parent": "3", "text": "Motocicletas", "icon": "/"}
     ];
     
    // Create an instance when the DOM is ready
    $('#jstree').jstree({
       'core': {
          'data': arrayCollection,
          'check_callback' : true
       },    
       'plugins' : [ "dnd" ]
    });
    
    // Bind to events triggered on the tree
    $('#jstree').on("move_node.jstree", function (e, data) {
      console.log("id " + data.node.id);
      console.log("Parent " + data.parent);
      console.log("Old Parent " + data.old_parent);
      
      $.ajax({
         type: 'post',
         url: "move",
         data: {
           id: data.node.id,
           newParent: data.parent,              
         },
         success: function (result) {
           alert(result);
           result = true;
         },
         error: function () {
         }           
      });
      
    });    
    
    // Bind to events triggered on the tree
    $('#jstree').on("changed.jstree", function (e, data) {
      console.log("Id: " + data.node.id);
      console.log("Parent " + data.node.parent);
    });
    
  });
  </script>
  
  
</head>
<body>
  <div id="jstree"></div>

  
</body>
</html>