package SpringWebMVC.s2.BLL;

import SpringWebMVC.s2.DAL.Trilho;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class Grupo {

    private static final EntityManager em = entityManager.getEntityManager();

    public static List<SpringWebMVC.s2.DAL.Grupo> readAll(){
        List<SpringWebMVC.s2.DAL.Grupo> tri = new ArrayList<>();

        Query q1 = em.createNamedQuery("Grupo.findAll");
        List<Object> lstObj = q1.getResultList();

        for(Object obj : lstObj){
            SpringWebMVC.s2.DAL.Grupo gui = ((SpringWebMVC.s2.DAL.Grupo)obj);
            tri.add(gui);
        }

        return tri;
    }
}
