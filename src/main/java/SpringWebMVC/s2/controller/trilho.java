package SpringWebMVC.s2.controller;

import SpringWebMVC.s2.BLL.Trilho;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

        List<SpringWebMVC.s2.DAL.Trilho> trilhoInstance = SpringWebMVC.s2.BLL.Trilho.readAll();
        ModelAndView mview = new ModelAndView("trilho");
        mview.addObject("trilhos", trilhoInstance);
        return mview;

    }
}
