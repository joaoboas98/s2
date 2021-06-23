package SpringWebMVC.s2.BLL;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.math.BigDecimal;

public class Ponto {
    private static final EntityManager em = entityManager.getEntityManager();
    public static SpringWebMVC.s2.DAL.Ponto readPonto (int idponto){

        Query q = em.createNamedQuery("Ponto.findByPontoId");
        q.setParameter("pontoId", BigDecimal.valueOf(idponto));
        SpringWebMVC.s2.DAL.Ponto f = null;
        Object res = q.getSingleResult();

        if(res != null) f = (SpringWebMVC.s2.DAL.Ponto) res;

        return f;
    }
}
