package entites;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;

@Entity
public class Salarie implements Serializable {

    @Id
    private Long      numsal;

    private String   nomsal;
    private String   sexe;
    private Float     salaire;

    @ManyToOne
    @JoinColumn(name="CODEFONCT")
    
    private Fonction laFonction;

    @OneToMany(mappedBy = "leSalarie")
    private List<Affectation>  lesAffectations=new LinkedList<Affectation>();

    public Salarie() {}

    public Salarie(Long numsal, String nomsal, String sexe,Float salaire, Fonction laFonction) {
        this.numsal    =  numsal;
        this.nomsal    =  nomsal;
        this.salaire  = salaire;
        this.sexe       =  sexe;
        this.laFonction=laFonction;
        this.laFonction.getLesSalaries().add(this);
    }

    @Override
    public String toString() {
        return numsal+" "+nomsal+" "+sexe+" "+salaire;
    }
    
    //    //<editor-fold defaultstate="collapsed" desc="Calls Back">
//   
//    
//    @PreUpdate
//    public void  avantMAJ(){
//        System.out.println("avant MAJ Salarie");
//    }
//    
//    @PostUpdate
//    public void  apresMAJ(){
//        System.out.println("après MAJ Salarie");
//    }
//    
//    @PreRemove
//    public void  avantSUPP(){
//        System.out.println("avant Suppression Salarie");
//    }
//    
//    @PostRemove
//    public void  apresSUPP(){
//        System.out.println("après Suppression Salarie");
//    }
//    
//    @PrePersist
//    public void  avantPersist(){
//        System.out.println("avant Ajout Salarie");
//    }
//    
//    @PostPersist
//    public void  apresPersist(){
//        System.out.println("après Ajout Salarie");
//    }
//    
    @PostLoad
    public void aprèsChargement(){
        System.out.println("Chargement Salarie");
    }
//    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="get set">
    
    public Fonction getLaFonction() {
        return laFonction;
    }
    public void setLaFonction(Fonction laFonction) {
        this.laFonction = laFonction;
    }
    public String getNomsal() {
        return nomsal;
    }
    public void setNomsal(String nomsal) {
        this.nomsal = nomsal;
    }
    public Long getNumsal() {
        return numsal;
    }
    public void setNumsal(Long numsal) {
        this.numsal = numsal;
    }
    public Float getSalaire() {
        return salaire;
    }
    public void setSalaire(Float salaire) {
        this.salaire = salaire;
    }
    public String getSexe() {
        return sexe;
    }
    public void setSexe(String sexe) {
        this.sexe = sexe;
    }
    
    public List<Affectation> getLesAffectations() {
        return lesAffectations;
    }
    public void setLesAffectations(List<Affectation> lesAffectations) {
        this.lesAffectations = lesAffectations;
    }
    //</editor-fold>
}
