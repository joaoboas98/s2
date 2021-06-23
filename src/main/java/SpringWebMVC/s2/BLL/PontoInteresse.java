package SpringWebMVC.s2.BLL;

import SpringWebMVC.s2.DAL.Ponto;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PontoInteresse {
    private static final EntityManager em = entityManager.getEntityManager();

    public static List<Ponto> readAll(){
        List<SpringWebMVC.s2.DAL.Ponto> tri = new ArrayList<>();

        Query q1 = em.createNamedQuery("Ponto.findAll");
        List<Object> lstObj = q1.getResultList();

        for(Object obj : lstObj){
            SpringWebMVC.s2.DAL.Ponto gui = ((SpringWebMVC.s2.DAL.Ponto)obj);
            tri.add(gui);
        }

        return tri;
    }

    public static SpringWebMVC.s2.DAL.Ponto readPonto (int idponto){

        Query q = em.createNamedQuery("Ponto.findByPontoId");
        q.setParameter("pontoId", BigDecimal.valueOf(idponto));
        SpringWebMVC.s2.DAL.Ponto f = null;
        Object res = q.getSingleResult();

        if(res != null) f = (SpringWebMVC.s2.DAL.Ponto) res;

        return f;
    }

}
