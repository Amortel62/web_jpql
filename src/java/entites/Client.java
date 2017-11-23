package entites;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Client implements Serializable {
    
    @Id
    private Long          numcli;
    private String        nomcli;
    private String        adrcli;


    @OneToMany(mappedBy = "leClient")
    private List<Projet>  lesProjets=new LinkedList<Projet>();

    
    public Float totalDesDevis(){
    
        Float total=0f;
        for(Projet p: lesProjets){
             
          total+=p.getMontantDevis();
        }
        
        return total;
             
    }
    
    public Client() { }

    public Client(Long numcli, String nomcli, String adrcli) {
        this.numcli = numcli;
        this.nomcli = nomcli;
        this.adrcli = adrcli;
    }

    public Long getNumcli() {
        return numcli;
    }
    public void setNumcli(Long numcli) {
        this.numcli = numcli;
    }
    public String getNomcli() {
        return nomcli;
    }
    public void setNomcli(String nomcli) {
        this.nomcli = nomcli;
    }
    public String getAdrcli() {
        return adrcli;
    }
    public void setAdrcli(String adrcli) {
        this.adrcli = adrcli;
    }

    public List<Projet> getLesProjets() {
        return lesProjets;
    }
    public void setLesProjets(List<Projet> lesProjets) {
        this.lesProjets = lesProjets;
    }

  
}