package util.logging;

import java.util.Date;

public class Movimiento {
   private Integer id=0;
   private Date fecha = new Date();
   private String tabla="";
   private Integer idAcceso=0;
   private String request="";
   private String ip="";
   private String comentarios="";
   
   public Integer getId() {
      return id;
   }

   public void setId(Integer id) {
      this.id = id;
   }

   public Date getFecha() {
      return fecha;
   }

   public void setFecha(Date fecha) {
      this.fecha = fecha;
   }

   public String getTabla() {
      return tabla;
   }

   public void setTabla(String tabla) {
      this.tabla = tabla;
   }

   public Integer getIdAcceso() {
      return idAcceso;
   }

   public void setIdAcceso(Integer idAcceso) {
      this.idAcceso = idAcceso;
   }

   public String getRequest() {
      return request;
   }

   public void setRequest(String request) {
      this.request = request;
   }

   public String getComentarios() {
      return comentarios;
   }

   public void setComentarios(String comentarios) {
      this.comentarios = comentarios;
   }

   public String getIp() {
      return ip;
   }

   public void setIp(String ip) {
      this.ip = ip;
   }

   @Override
   public String toString() {
      return "Movimiento{" + "fecha=" + fecha + ", tabla=" + tabla + ", idAcceso=" + idAcceso + ", request=" + request + ", ip=" + ip + ", comentarios=" + comentarios + '}';
   }

}
