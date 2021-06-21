package SpringWebMVC.s2.controller;

import SpringWebMVC.s2.BLL.Fotos;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class Trilhoinfo {

    @RequestMapping(value= "/trilhoinfo")
    public ModelAndView test(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String id = request.getParameter("idTrilho");

        List<SpringWebMVC.s2.DAL.FotoTrilho> FotoTrilhoInstance = Fotos.readAllFotoTrilho();

        SpringWebMVC.s2.DAL.Trilho trilhoInstance = SpringWebMVC.s2.BLL.Trilho.readTrilho(Integer.parseInt(id));
        ModelAndView mview = new ModelAndView("trilhoinfo");
        mview.addObject("trilhosInf", trilhoInstance);
        mview.addObject("fotoTrilho", FotoTrilhoInstance);
        return mview;

    }
}
