package entites;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class Affectation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date        dateaff;

    private boolean    pilote;

    @ManyToOne
    private Projet     leProjet;

    @ManyToOne
    private Salarie    leSalarie;

    public Affectation() {}

    public Affectation(Projet leProjet, Salarie leSalarie, Date dateaff, boolean pilote ) {

        this.dateaff = dateaff;
        this.pilote   = pilote;

        this.leProjet=leProjet;
        this.leProjet.getLesAffectations().add(this);

        this.leSalarie = leSalarie;
        this.leSalarie.getLesAffectations().add(this);
    }

    public Date getDateaff() {
        return dateaff;
    }
    public void setDateaff(Date dateaff) {
        this.dateaff = dateaff;
    }

     public boolean isPilote() {
        return pilote;
    }
    public void setPilote(boolean pilote) {
        this.pilote = pilote;
    }

    public Projet getLeProjet() {
        return leProjet;
    }
    public void setLeProjet(Projet leProjet) {
        this.leProjet = leProjet;
    }

    public Salarie getLeSalarie() {
        return leSalarie;
    }
    public void setLeSalarie(Salarie leSalarie) {
        this.leSalarie = leSalarie;
    }

}
