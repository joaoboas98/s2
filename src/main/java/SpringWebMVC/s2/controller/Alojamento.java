package SpringWebMVC.s2.controller;

import SpringWebMVC.s2.DAL.Trilho;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@Controller
public class Alojamento {

    @RequestMapping(value= "/alojamento")
    public ModelAndView test(HttpServletResponse response, HttpServletRequest request) throws IOException {

        List<SpringWebMVC.s2.DAL.Alojamento> AlojamentoInstance = SpringWebMVC.s2.BLL.Alojamento.readAll();
        ModelAndView mview = new ModelAndView("alojamento");
        mview.addObject("alojamentos", AlojamentoInstance);
        return mview;

    }
}
