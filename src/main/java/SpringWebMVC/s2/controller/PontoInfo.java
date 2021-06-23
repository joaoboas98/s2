package SpringWebMVC.s2.controller;

import SpringWebMVC.s2.BLL.Fotos;
import SpringWebMVC.s2.DAL.ClassTrilho;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class PontoInfo {

    @RequestMapping(value= "/pontoinfo")
    public ModelAndView test(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String id = request.getParameter("idponto");
        String idU = request.getParameter("idU");

        SpringWebMVC.s2.DAL.Utilizador UtilizadorInstance = SpringWebMVC.s2.BLL.Utilizador.readUtilizador(Integer.parseInt(idU));

        List<SpringWebMVC.s2.DAL.FotoPonto> FotoPontoInstance = Fotos.readAllFotoPonto();

        SpringWebMVC.s2.DAL.Ponto pontoInstance = SpringWebMVC.s2.BLL.Ponto.readPonto(Integer.parseInt(id));
        ModelAndView mview = new ModelAndView("Pontoinfo");
        mview.addObject("pontoInf", pontoInstance);
        mview.addObject("fotoponto", FotoPontoInstance);
        mview.addObject("utilizadorsession", UtilizadorInstance);


        return mview;

    }
}
