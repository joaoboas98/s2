package SpringWebMVC.s2.controller;

import SpringWebMVC.s2.DAL.FotoAlojamento;
import SpringWebMVC.s2.DAL.Trilho;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
@Controller
public class Alojamento {

    @RequestMapping(value= "/alojamento")
    public ModelAndView test(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String idU = request.getParameter("idU");
        SpringWebMVC.s2.DAL.Utilizador UtilizadorInstance = SpringWebMVC.s2.BLL.Utilizador.readUtilizador(Integer.parseInt(idU));
        List<SpringWebMVC.s2.DAL.Alojamento> AlojamentoInstance = SpringWebMVC.s2.BLL.Alojamento.readAll();


        ModelAndView mview = new ModelAndView("alojamento");
        mview.addObject("utilizadorsession", UtilizadorInstance);
        mview.addObject("alojamentos", AlojamentoInstance);

        return mview;

    }
}
