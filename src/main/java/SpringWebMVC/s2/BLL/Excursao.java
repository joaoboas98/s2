package SpringWebMVC.s2.BLL;

import SpringWebMVC.s2.DAL.Guia;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class Excursao {
    private static final EntityManager em = entityManager.getEntityManager();
    public static List<SpringWebMVC.s2.DAL.Excursao> readAll(){
        List<SpringWebMVC.s2.DAL.Excursao> tri = new ArrayList<>();

        Query q1 = em.createNamedQuery("Excursao.findAll");
        List<Object> lstObj = q1.getResultList();

        for(Object obj : lstObj){
            SpringWebMVC.s2.DAL.Excursao gui = ((SpringWebMVC.s2.DAL.Excursao)obj);
            tri.add(gui);
        }

        return tri;
    }
    public static void createClassificar(SpringWebMVC.s2.DAL.Excursao  cla){


        em.getTransaction().begin();
        em.persist(cla);
        em.getTransaction().commit();
    }
}
