package SpringWebMVC.s2.controller;

import SpringWebMVC.s2.BLL.Fotos;
import SpringWebMVC.s2.DAL.ClassAlo;
import SpringWebMVC.s2.DAL.ClassTrilho;
import SpringWebMVC.s2.DAL.FotoAlojamento;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Controller
public class AlojamentoInfo {
    @RequestMapping(value= "/alojamentoinfo")
    public ModelAndView test(HttpServletResponse response, HttpServletRequest request) throws IOException {
        String idA = request.getParameter("idAlojamento");
        String idU = request.getParameter("idU");

        SpringWebMVC.s2.DAL.Utilizador UtilizadorInstance = SpringWebMVC.s2.BLL.Utilizador.readUtilizador(Integer.parseInt(idU));
        List<ClassAlo> classaloInstance = SpringWebMVC.s2.BLL.ClassAlo.readAll();
        List<SpringWebMVC.s2.DAL.FotoAlojamento> FOTOInstance = SpringWebMVC.s2.BLL.Fotos.readAllFotoAlojamento();

        var idTb = new BigDecimal(idA);

        List listmap = new ArrayList();

        for(FotoAlojamento im : FOTOInstance){
            if(im.getAlojamentoid().getAlojamentoId().equals(idTb)) {
                byte[] imgData = im.getFotoalo(); // blob field
                String encode = Base64.getEncoder().encodeToString(imgData);
                listmap.add(encode);
                request.setAttribute("imgBase", listmap);
            }
        }
        SpringWebMVC.s2.DAL.Alojamento aloInstance = SpringWebMVC.s2.BLL.Alojamento.readAlojamento(Integer.parseInt(idA));
        ModelAndView mview = new ModelAndView("alojamentoinfo");
        mview.addObject("alojamentoInf", aloInstance);
        mview.addObject("fotoalojamentos", FOTOInstance);
        mview.addObject("utilizadorsession", UtilizadorInstance);
        mview.addObject("classalo", classaloInstance);

        return mview;

    }
}
