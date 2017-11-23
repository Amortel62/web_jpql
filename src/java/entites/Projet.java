
package entites;
import java.io.Serializable;
import java.util.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import utilitaires.UtilDate;

@Entity
public class Projet implements Serializable  {

    @Id
    private String    codeproj;

    private String    descproj;
    @Temporal(javax.persistence.TemporalType.DATE)  private Date      datedep;
    @Temporal(javax.persistence.TemporalType.DATE)  private Date      datefinp;
    private Float     montantDevis;

    @ManyToOne
    private Client leClient;

    @OneToMany(mappedBy = "leProjet")
    private List<Affectation> lesAffectations= new LinkedList<Affectation>();

    public Projet() {}
    public Projet(String codeproj, String descproj, Date datedebp, Date datefinp, Float montantDevis,
                          Client leClient) {
        this.codeproj = codeproj;
        this.descproj = descproj;
        this.datedep = datedebp;
        this.datefinp = datefinp;
        this.montantDevis = montantDevis;
        this.leClient = leClient;
        this.leClient.getLesProjets().add(this);
    }

    @Override
    public String toString() {
        return codeproj+" "+descproj+" "+UtilDate.format(datedep) +" "+UtilDate.format(datefinp) ;
    }

    //<editor-fold defaultstate="collapsed" desc="get & sets">
    
    public String getCodeproj() {
        return codeproj;
    }
    public void setCodeproj(String codeproj) {
        this.codeproj = codeproj;
    }
    
    public Date getDatedebp() {
        return datedep;
    }
    public void setDatedebp(Date datedep) {
        this.datedep = datedep;
    }
    
    public Date getDatefinp() {
        return datefinp;
    }
    public void setDatefinp(Date datefinp) {
        this.datefinp = datefinp;
    }
    
    public String getDescproj() {
        return descproj;
    }
    public void setDescproj(String descproj) {
        this.descproj = descproj;
    }
    
    public Float getMontantDevis() {
        return montantDevis;
    }
    public void setMontantDevis(Float montantDevis) {
        this.montantDevis = montantDevis;
    }
    
    public Client getLeClient() {
        return leClient;
    }
    public void setLeClient(Client leClient) {
        this.leClient = leClient;
    }
    
    public List<Affectation> getLesAffectations() {
        return lesAffectations;
    }
    public void setLesAffectations(List<Affectation> lesAffectations) {
        this.lesAffectations = lesAffectations;
    }
    
    //</editor-fold>

}
