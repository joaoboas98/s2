package SpringWebMVC.s2.BLL;

import SpringWebMVC.s2.DAL.Alojamento;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ClassTrilho {
    private static final EntityManager em = entityManager.getEntityManager();

    public static List<SpringWebMVC.s2.DAL.ClassTrilho> readAll(){
        List<SpringWebMVC.s2.DAL.ClassTrilho> tri = new ArrayList<>();

        Query q1 = em.createNamedQuery("ClassTrilho.findAll");
        List<Object> lstObj = q1.getResultList();

        for(Object obj : lstObj){
            SpringWebMVC.s2.DAL.ClassTrilho gui = ((SpringWebMVC.s2.DAL.ClassTrilho)obj);
            tri.add(gui);
        }

        return tri;
    }
    public static void createClassificar(SpringWebMVC.s2.DAL.ClassTrilho  cla){


        em.getTransaction().begin();
        em.persist(cla);
        em.getTransaction().commit();
    }
}
