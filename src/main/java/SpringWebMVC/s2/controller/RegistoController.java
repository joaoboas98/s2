package SpringWebMVC.s2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

@Controller
public class RegistoController {
    @RequestMapping(value = "/registar")

    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
             {
        BigDecimal tipo = BigDecimal.ONE;
        String nome = request.getParameter("Uname");
        String morada = request.getParameter("morada");
        int idadeP = Integer.parseInt(request.getParameter("idade"));
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
                 String msg = "";
                 ModelAndView mview = null;

            SpringWebMVC.s2.DAL.Utilizador utilizador = new SpringWebMVC.s2.DAL.Utilizador();
            utilizador.setUtilizadorNome(nome);
            utilizador.setUtilizadorIdade(BigInteger.valueOf(idadeP));
            utilizador.setUtilizadorPass(password1);
            utilizador.setUtilizadorMorada(morada);
            utilizador.setUtilizadorTipo(tipo);


            Boolean modelInstance = SpringWebMVC.s2.BLL.Utilizador.createUtilizador(utilizador);


            msg = "Utilizador registado!";
            mview = new ModelAndView("index");
            mview.addObject("msg", msg);

                 return mview;
    }
}

