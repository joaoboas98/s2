package SpringWebMVC.s2.BLL;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.hibernate.jpa.AvailableSettings.PERSISTENCE_UNIT_NAME;

public class Alojamento {
    private static final EntityManager em = entityManager.getEntityManager();

    public static List<SpringWebMVC.s2.DAL.Alojamento> readAll(){
        List<SpringWebMVC.s2.DAL.Alojamento> tri = new ArrayList<>();

        Query q1 = em.createNamedQuery("Alojamento.findAll");
        List<Object> lstObj = q1.getResultList();

        for(Object obj : lstObj){
            SpringWebMVC.s2.DAL.Alojamento gui = ((SpringWebMVC.s2.DAL.Alojamento)obj);
            tri.add(gui);
        }

        return tri;
    }
    public static SpringWebMVC.s2.DAL.Utilizador readAlojamento(int idalojamento){

        Query q = em.createNamedQuery("Utilizador.findByUtilizadorId");
        q.setParameter("utilizadorId", BigDecimal.valueOf(idalojamento));
        SpringWebMVC.s2.DAL.Utilizador f = null;
        Object res = q.getSingleResult();

        if(res != null) f = (SpringWebMVC.s2.DAL.Utilizador) res;

        return f;
    }

}
