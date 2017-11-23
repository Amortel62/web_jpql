package controleurs;


import entites.Projet;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrateur
 */
@Named
@RequestScoped
public class Controleur_Q08  {
   
    @PersistenceContext
    private EntityManager em;
    
     private String       codeproj;
     private Projet       projet;
    
    
    
    public void recherche(){
    
  
     String texteReqJPQL= 
                 "SELECT   pr  FROM Projet pr "
                 + "JOIN FETCH pr.lesAffectations "
                 + "JOIN FETCH pr.leClient "
                 + "where pr.codeproj = :codeproj";
     
      Query    req= em.createQuery(texteReqJPQL);
            
      req.setParameter("codeproj",codeproj);
      projet = (Projet) req.getSingleResult();
          
    }

    public String getCodeproj() {
        return codeproj;
    }

    public void setCodeproj(String codeproj) {
        this.codeproj = codeproj;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }
    
}
