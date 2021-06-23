package SpringWebMVC.s2.controller;

import SpringWebMVC.s2.DAL.Utilizador;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;

@Controller
public class CriarGrupo {
    @RequestMapping(value = "/criargrupo")
    public ModelAndView test(HttpServletResponse response, HttpServletRequest request) throws IOException, ParseException {
        String msg = "";
        ModelAndView mview = null;
        String idU = request.getParameter("idU");
        String nome = request.getParameter("nome");
        String numero = request.getParameter("numero");
        BigInteger num=new BigInteger(numero);
        var idUb = new BigDecimal(idU);

        SpringWebMVC.s2.DAL.Grupo cla = new SpringWebMVC.s2.DAL.Grupo();
        SpringWebMVC.s2.DAL.Utilizador UtilizadorInstance = SpringWebMVC.s2.BLL.Utilizador.readUtilizador(Integer.parseInt(idU));

        cla.setUtilizadorId(new Utilizador(idUb));
        cla.setGrupoNome(nome);
        cla.setGrupoNumero(num);
        SpringWebMVC.s2.BLL.Grupo.createClassificar(cla);


        msg = "Grupo criado";
        mview = new ModelAndView("grupos");
        mview.addObject("msg", msg);
        mview.addObject("utilizadorsession", UtilizadorInstance);

        return mview;


    }
}