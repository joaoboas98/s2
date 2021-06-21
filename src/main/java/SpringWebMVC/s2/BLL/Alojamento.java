package SpringWebMVC.s2.BLL;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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

}
