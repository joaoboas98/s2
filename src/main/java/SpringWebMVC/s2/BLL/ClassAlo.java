package SpringWebMVC.s2.BLL;

import SpringWebMVC.s2.DAL.ClassTrilho;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ClassAlo {
    private static final EntityManager em = entityManager.getEntityManager();

    public static List<SpringWebMVC.s2.DAL.ClassAlo> readAll(){
        List<SpringWebMVC.s2.DAL.ClassAlo> tri = new ArrayList<>();

        Query q1 = em.createNamedQuery("ClassAlo.findAll");
        List<Object> lstObj = q1.getResultList();

        for(Object obj : lstObj){
            SpringWebMVC.s2.DAL.ClassAlo gui = ((SpringWebMVC.s2.DAL.ClassAlo)obj);
            tri.add(gui);
        }

        return tri;
    }
    public static void createClassificar(SpringWebMVC.s2.DAL.ClassAlo  cla){


        em.getTransaction().begin();
        em.persist(cla);
        em.getTransaction().commit();
    }


}
