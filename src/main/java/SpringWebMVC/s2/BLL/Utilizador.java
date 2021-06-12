package SpringWebMVC.s2.BLL;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class Utilizador {

    private static final String PERSISTENCE_UNIT_NAME = "JPA";
    private static EntityManagerFactory factory;

    public static List<SpringWebMVC.s2.DAL.Utilizador> readAllUtilizador() {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        List<SpringWebMVC.s2.DAL.Utilizador> listaUtilizador= new ArrayList<>();

        Query q = em.createNamedQuery("Utilizador.findAll");
        q.getResultList().forEach(f -> {
            listaUtilizador.add((SpringWebMVC.s2.DAL.Utilizador) f);
        });
        return listaUtilizador;
    }

    public static SpringWebMVC.s2.DAL.Utilizador UtilizadorLogin(String username, String password) {
        SpringWebMVC.s2.DAL.Utilizador utilizador = new SpringWebMVC.s2.DAL.Utilizador();
        boolean exist = false;

        for (SpringWebMVC.s2.DAL.Utilizador u : Utilizador.readAllUtilizador()) {
            if (u.getUtilizadorNome().equals(username) && u.getUtilizadorPass().equals(password)) {
                utilizador = u;
                exist = true;
            }
        }
        if (exist) {
            return utilizador;
        } else {
            return null;
        }
    }
}

