package SpringWebMVC.s2.controller;

import SpringWebMVC.s2.DAL.Alojamento;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller

public class PontoInteresse {

    @RequestMapping(value= "/pontointeresse")
    public ModelAndView test(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String idU = request.getParameter("idU");

        SpringWebMVC.s2.DAL.Utilizador UtilizadorInstance = SpringWebMVC.s2.BLL.Utilizador.readUtilizador(Integer.parseInt(idU));
        List<SpringWebMVC.s2.DAL.Ponto> pontoInstance = SpringWebMVC.s2.BLL.PontoInteresse.readAll();

        ModelAndView mview = new ModelAndView("pontointeresse");
        mview.addObject("utilizadorsession", UtilizadorInstance);
        mview.addObject("pontos", pontoInstance);



        return mview;

    }
}
