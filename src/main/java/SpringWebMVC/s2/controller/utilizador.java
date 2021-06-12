package SpringWebMVC.s2.controller;

import SpringWebMVC.s2.DAL.Utilizador;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class utilizador {
    @RequestMapping(value={"/", "/login"})
    public ModelAndView test(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome= request.getParameter("Pass");
        String pass= request.getParameter("Uname");
        SpringWebMVC.s2.DAL.Utilizador modelInstance = SpringWebMVC.s2.BLL.Utilizador.UtilizadorLogin(nome,pass);
        ModelAndView mview = null;
        String msg = "";
        if(modelInstance == null) {
            msg = "Credenciais erradas!";
            mview = new ModelAndView("home");
            mview.addObject("msg", msg);
            System.out.println("null2");

        }


        return mview;

    }

}
