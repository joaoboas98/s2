package SpringWebMVC.s2.controller;

import SpringWebMVC.s2.DAL.Utilizador;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Controller
public class utilizador {
    @RequestMapping(value= "/login")

    public ModelAndView test(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String pass = request.getParameter("Pass");
        String nome = request.getParameter("Uname");

        SpringWebMVC.s2.DAL.Utilizador modelInstance = SpringWebMVC.s2.BLL.Utilizador.UtilizadorLogin(nome,pass);

        ModelAndView mview = null;
        String msg = "";

        if (modelInstance == null) {
            msg = "Credenciais erradas!";
            mview = new ModelAndView("index");
            mview.addObject("msg", msg);
            System.out.println("null");

        } else if (modelInstance.getUtilizadorTipo().equals(BigDecimal.ONE)) {
            System.out.println("utilizador");
            if (modelInstance.getUtilizadorId() == null) {
                System.out.println("Novo Utilizador");
                mview = new ModelAndView("home");
                mview.addObject("utilizador", modelInstance);

                mview.addObject("msg", msg);
            }
        } else if (modelInstance.getUtilizadorTipo().equals(BigDecimal.ZERO)) {
            System.out.println("Admi");
            mview = new ModelAndView("home");
            mview.addObject("utilizador", modelInstance);
            mview.addObject("msg", msg);
        }

        return mview;


    }


}
