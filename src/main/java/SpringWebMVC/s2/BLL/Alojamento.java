package SpringWebMVC.s2.BLL;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class Alojamento {
    private static final String PERSISTENCE_UNIT_NAME = "JPA";
    private static EntityManagerFactory factory;
    private static EntityManager em = null;

    public static List<Alojamento> readAll(){
        List<Alojamento> alo = new ArrayList<>();

        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        if (em == null) em = factory.createEntityManager();

        Query q1 = em.createNamedQuery("Alojamento.findAll");
        List<Object> lstObj = q1.getResultList();

        for(Object obj : lstObj){
            Alojamento gui = ((Alojamento)obj);
            alo.add(gui);
        }

        return alo;
    }

}
