package SpringWebMVC.s2.controller;

import SpringWebMVC.s2.DAL.Utilizador;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class home {

    @RequestMapping(value={"/", "/index"})
    public ModelAndView test(HttpServletResponse response) throws IOException {
        List<Utilizador> UtilizadorList = SpringWebMVC.s2.BLL.Utilizador.readAllUtilizador();
        ModelAndView mview = null;
        mview = new ModelAndView("index");
        mview.addObject("utilizador", UtilizadorList);
        return mview;
    }


}
