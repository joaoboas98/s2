package SpringWebMVC.s2.BLL;

import SpringWebMVC.s2.DAL.Trilho;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Fotos {

    private static final EntityManager em = entityManager.getEntityManager();
    public static List<SpringWebMVC.s2.DAL.FotoAlojamento> readAllFotoAlojamento(){
        List<SpringWebMVC.s2.DAL.FotoAlojamento> tri2 = new ArrayList<>();
        Query q1 = em.createNamedQuery("FotoAlojamento.findAll");
        List<Object> lstObj = q1.getResultList();

        for(Object obj : lstObj){
            SpringWebMVC.s2.DAL.FotoAlojamento gui = ((SpringWebMVC.s2.DAL.FotoAlojamento)obj);
            tri2.add(gui);
        }

        return tri2;
    }
    public static List<SpringWebMVC.s2.DAL.FotoTrilho> readAllFotoTrilho(){
        List<SpringWebMVC.s2.DAL.FotoTrilho> tri2 = new ArrayList<>();
        Query q1 = em.createNamedQuery("FotoTrilho.findAll");
        List<Object> lstObj = q1.getResultList();

        for(Object obj : lstObj){
            SpringWebMVC.s2.DAL.FotoTrilho gui = ((SpringWebMVC.s2.DAL.FotoTrilho)obj);
            tri2.add(gui);
        }

        return tri2;
    }

    public static List<SpringWebMVC.s2.DAL.FotoPonto> readAllFotoPonto(){
        List<SpringWebMVC.s2.DAL.FotoPonto> tri2 = new ArrayList<>();
        Query q1 = em.createNamedQuery("FotoPonto.findAll");
        List<Object> lstObj = q1.getResultList();

        for(Object obj : lstObj){
            SpringWebMVC.s2.DAL.FotoPonto gui = ((SpringWebMVC.s2.DAL.FotoPonto)obj);
            tri2.add(gui);
        }

        return tri2;
    }




}
