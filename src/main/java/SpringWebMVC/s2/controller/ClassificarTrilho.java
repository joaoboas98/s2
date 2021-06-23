package SpringWebMVC.s2.controller;

import SpringWebMVC.s2.DAL.Trilho;
import SpringWebMVC.s2.DAL.Utilizador;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Controller
public class ClassificarTrilho {
    @RequestMapping(value= "/classificartrilho")
    public ModelAndView test(HttpServletResponse response, HttpServletRequest request) throws IOException {

    String estrelas = request.getParameter("Classifacao");
    BigInteger estrelabig=new BigInteger(estrelas);
    String Descricao = request.getParameter("Descricao");
    String idU = request.getParameter("idU");
    String idT = request.getParameter("idTrilho");
    String msg = "";
    ModelAndView mview = null;
    var idTb = new BigDecimal(idT);
    var idUb = new BigDecimal(idU);
    SpringWebMVC.s2.DAL.Utilizador UtilizadorInstance = SpringWebMVC.s2.BLL.Utilizador.readUtilizador(Integer.parseInt(idU));
    SpringWebMVC.s2.DAL.ClassTrilho cla = new SpringWebMVC.s2.DAL.ClassTrilho();
        List<Trilho> trilhoInstance = SpringWebMVC.s2.BLL.Trilho.readAll();
        cla.setTrilhoId(new Trilho(idTb));
        cla.setUtilizadorId(new Utilizador(idUb));
        cla.setClassTrilhoValor(estrelabig);
        cla.setClassTrilhoComentario(Descricao);

            SpringWebMVC.s2.BLL.ClassTrilho.createClassificar(cla);


    msg = "Avaliação criada";
    mview = new ModelAndView("trilho");
            mview.addObject("msg", msg);
        mview.addObject("utilizadorsession", UtilizadorInstance);
        mview.addObject("trilhos", trilhoInstance);
                 return mview;
}
}
