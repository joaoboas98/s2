package SpringWebMVC.s2.controller;

import SpringWebMVC.s2.BLL.Trilho;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@Controller
public class trilho {

    @RequestMapping(value= "/trilho")
    public ModelAndView test(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String idU = request.getParameter("idU");
        SpringWebMVC.s2.DAL.Utilizador UtilizadorInstance = SpringWebMVC.s2.BLL.Utilizador.readUtilizador(Integer.parseInt(idU));
        List<SpringWebMVC.s2.DAL.Trilho> trilhoInstance = SpringWebMVC.s2.BLL.Trilho.readAll();
        List<SpringWebMVC.s2.DAL.ClassTrilho> classtrilhoInstance = SpringWebMVC.s2.BLL.ClassTrilho.readAll();
        ModelAndView mview = new ModelAndView("trilho");
        mview.addObject("utilizadorsession", UtilizadorInstance);
        mview.addObject("trilhos", trilhoInstance);
        mview.addObject("classtrilho", classtrilhoInstance);
        return mview;

    }


}
