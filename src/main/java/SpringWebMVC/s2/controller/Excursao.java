package SpringWebMVC.s2.controller;

import SpringWebMVC.s2.BLL.Fotos;
import SpringWebMVC.s2.DAL.FotoTrilho;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class Excursao {
    @RequestMapping(value= "/excursao")
    public ModelAndView test(HttpServletResponse response, HttpServletRequest request) throws IOException {
        //String id = request.getParameter("idTrilho");
        String idU = request.getParameter("idU");
        SpringWebMVC.s2.DAL.Utilizador UtilizadorInstance = SpringWebMVC.s2.BLL.Utilizador.readUtilizador(Integer.parseInt(idU));
        List<SpringWebMVC.s2.DAL.Trilho> trilhoInstance = SpringWebMVC.s2.BLL.Trilho.readAll();
        ModelAndView mview = new ModelAndView("excursao");
        mview.addObject("trilhos", trilhoInstance);

        mview.addObject("utilizadorsession", UtilizadorInstance);
        return mview;

    }

}
