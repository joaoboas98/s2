package SpringWebMVC.s2.controller;

import SpringWebMVC.s2.DAL.Alojamento;
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
public class ClassificarAlojamento {
    @RequestMapping(value= "/classificarAlojamento")
    public ModelAndView test(HttpServletResponse response, HttpServletRequest request) throws IOException {

        String estrelas = request.getParameter("Classifacao");
        BigInteger estrelabig=new BigInteger(estrelas);
        String Descricao = request.getParameter("Descricao");
        String idU = request.getParameter("idU");
        String idA = request.getParameter("idAlojamento");
        String msg = "";
        ModelAndView mview = null;
        var idTb = new BigDecimal(idA);
        var idUb = new BigDecimal(idU);
        SpringWebMVC.s2.DAL.Utilizador UtilizadorInstance = SpringWebMVC.s2.BLL.Utilizador.readUtilizador(Integer.parseInt(idU));
        SpringWebMVC.s2.DAL.ClassAlo cla = new SpringWebMVC.s2.DAL.ClassAlo();
        List<SpringWebMVC.s2.DAL.Alojamento> alhoInstance = SpringWebMVC.s2.BLL.Alojamento.readAll();
        cla.setAlojamentoId(new Alojamento(idTb));
        cla.setUtilizadorId(new Utilizador(idUb));
        cla.setClassAloValor(estrelabig);
        cla.setClassAloComentario(Descricao);

        SpringWebMVC.s2.BLL.ClassAlo.createClassificar(cla);


        msg = "Avaliação criada";
        mview = new ModelAndView("alojamento");
        mview.addObject("msg", msg);
        mview.addObject("utilizadorsession", UtilizadorInstance);
        mview.addObject("alojamentos", alhoInstance);
        return mview;
    }
}
