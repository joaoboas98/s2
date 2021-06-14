package SpringWebMVC.s2.BLL;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class Trilho {
    private static final String PERSISTENCE_UNIT_NAME = "JPA";
    private static EntityManagerFactory factory;
    private static EntityManager em = null;

    public static List<SpringWebMVC.s2.DAL.Trilho> readAll(){
        List<SpringWebMVC.s2.DAL.Trilho> tri = new ArrayList<>();

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Trilho.findAll");
        List<Object> lstObj = q1.getResultList();

        for(Object obj : lstObj){
            SpringWebMVC.s2.DAL.Trilho gui = ((SpringWebMVC.s2.DAL.Trilho)obj);
            tri.add(gui);
        }

        return tri;
    }
}
