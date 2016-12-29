package net.itinajero.dto;
   
public class Contact {
   private int id;
   private String name;
   private String email;
   private String source;
   private String code;
   private String codeMD5;
   private int active = 0;
   private String dateReg;
   private String dateAct;

   public Contact(int id) {
      this.id = id;
   }

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getSource() {
      return source;
   }

   public void setSource(String source) {
      this.source = source;
   }

   public String getCode() {
      return code;
   }

   public void setCode(String code) {
      this.code = code;
   }

   public String getCodeMD5() {
      return codeMD5;
   }

   public void setCodeMD5(String codeMD5) {
      this.codeMD5 = codeMD5;
   }

   public int getActive() {
      return active;
   }

   public void setActive(int active) {
      this.active = active;
   }

   public String getDateReg() {
      return dateReg;
   }

   public void setDateReg(String dateReg) {
      this.dateReg = dateReg;
   }

   public String getDateAct() {
      return dateAct;
   }

   public void setDateAct(String dateAct) {
      this.dateAct = dateAct;
   }

   @Override
   public String toString() {
      return "Contact{" + "id=" + id + ", name=" + name + ", email=" + email + ", source=" + source + ", code=" + code + ", codeMD5=" + codeMD5 + ", active=" + active + ", dateReg=" + dateReg + ", dateAct=" + dateAct + '}';
   }

}
