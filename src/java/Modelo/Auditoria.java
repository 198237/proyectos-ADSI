
package Modelo;


public class Auditoria {
     private int idAuditoria;
    private String usuarioAuditoria;
    private String fechaAuditoria;
    private String descripcionAuditoria;
    public Auditoria() {
    }

    public Auditoria(int idAuditoria, String usuarioAuditoria, String fechaAuditoria, String descripcionAuditoria) {
        this.idAuditoria = idAuditoria;
        this.usuarioAuditoria = usuarioAuditoria;
        this.fechaAuditoria = fechaAuditoria;
        this.descripcionAuditoria = descripcionAuditoria;
    }

   
   
   

    public int getIdAuditoria() {
        return idAuditoria;
    }

    public void setIdAuditoria(int idAuditoria) {
        this.idAuditoria = idAuditoria;
    }

    public String getUsuarioAuditoria() {
        return usuarioAuditoria;
    }

    public void setUsuarioAuditoria(String usuarioAuditoria) {
        this.usuarioAuditoria = usuarioAuditoria;
    }

    public String getFechaAuditoria() {
        return fechaAuditoria;
    }

    public void setFechaAuditoria(String fechaAuditoria) {
        this.fechaAuditoria = fechaAuditoria;
    }

    public String getDescripcionAuditoria() {
        return descripcionAuditoria;
    }

    public void setDescripcionAuditoria(String descripcionAuditoria) {
        this.descripcionAuditoria = descripcionAuditoria;
    }
    
    
    
    
}
