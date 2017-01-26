/**
 * Esta clase representa nuestro usuario en la session activa
 */
package net.itinajero.dto;

public class Usuario {

   private int id;
   private String nombre;
   private String username;
   private String[] roles;

   public Usuario(int id) {
      this.id = id;
   }

     
   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getNombre() {
      return nombre;
   }

   public void setNombre(String nombre) {
      this.nombre = nombre;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String[] getRoles() {
      return roles;
   }

   public void setRoles(String[] roles) {
      this.roles = roles;
   }

   /**
    * Metodo que nos dice si este usuario tiene perfil de Editor. 
    * @return
    */
   public boolean isEditor() {
      for (String r : roles) {
         if (r.equals("editor")) {
            return true;
         }
      }
      return false;
   }
   
   // Si necesitamos comparar si tiene otro rol ...
   
   public boolean isGerente() {      
      for (String r : roles) {
         if (r.equals("gerente")) {
            return true;
         }
      }
      return false;
   }   
   

   @Override
   public String toString() {
      return "Usuario{" + "id=" + id + ", nombre=" + nombre + ", username=" + username + ", roles=" + roles + '}';
   }
   
}
