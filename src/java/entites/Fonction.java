package entites;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Fonction implements Serializable  {

    @Id
    private String codefonct;

    private String libfonct;

    @OneToMany(mappedBy = "laFonction", cascade= CascadeType.MERGE)

    private List<Salarie>  lesSalaries=new LinkedList<Salarie>();

    public Fonction() {}
    
    public Fonction(String codefonct, String libfonct) {
        this.codefonct = codefonct;
        this.libfonct = libfonct;
    }

    public Float sommeSalaires(){
        Float somme=0f;
        for(Salarie s:this.lesSalaries) {
            somme+=s.getSalaire();
        }
        return somme;
    }

     @Override
    public String toString() {
        return(codefonct+" "+libfonct);
    }
    
    //    //<editor-fold defaultstate="collapsed" desc="Calls Back">
//   
//    
//    @PreUpdate
//    public void  avantMAJ(){
//        System.out.println("avant MAJ Fonction");
//    }
//    
//    @PostUpdate
//    public void  apresMAJ(){
//        System.out.println("après MAJ Fonction");
//    }
//    
//    
//    @PrePersist
//    public void  avantPersist(){
//        System.out.println("avant Ajout Fonction");
//    }
//    
//    @PostPersist
//    public void  apresPersist(){
//        System.out.println("après Ajout Fonction");
//    }
// 
//    @PostLoad
//    public void aprèsChargement(){
//        System.out.println("Après Chargement Fonction");
//    }
//    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="get set">
    
    public String getCodefonct() {
        return codefonct;
    }
    public void setCodefonct(String codefonct) {
        this.codefonct = codefonct;
    }
    public String getLibfonct() {
        return libfonct;
    }
    public void setLibfonct(String libfonct) {
        this.libfonct = libfonct;
    }
    public List<Salarie> getLesSalaries() {
        return lesSalaries;
    }
    public void setLesSalaries(List<Salarie> lesSalaries) {
        this.lesSalaries = lesSalaries;
    }
    //</editor-fold>
}
