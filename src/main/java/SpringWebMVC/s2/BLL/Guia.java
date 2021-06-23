package SpringWebMVC.s2.BLL;

import SpringWebMVC.s2.DAL.Trilho;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class Guia {

    private static final EntityManager em = entityManager.getEntityManager();

    public static List<SpringWebMVC.s2.DAL.Guia> readAll(){
        List<SpringWebMVC.s2.DAL.Guia> tri = new ArrayList<>();

        Query q1 = em.createNamedQuery("Guia.findAll");
        List<Object> lstObj = q1.getResultList();

        for(Object obj : lstObj){
            SpringWebMVC.s2.DAL.Guia gui = ((SpringWebMVC.s2.DAL.Guia)obj);
            tri.add(gui);
        }

        return tri;
    }
}
