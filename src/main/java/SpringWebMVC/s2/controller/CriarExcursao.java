package SpringWebMVC.s2.controller;

import SpringWebMVC.s2.DAL.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Controller
public class CriarExcursao {
    @RequestMapping(value= "/criarexcursao")
    public ModelAndView test(HttpServletResponse response, HttpServletRequest request) throws IOException, ParseException {

        String idU = request.getParameter("idU");
        String idT = request.getParameter("trilhos");
        String idG = request.getParameter("grupo");
        String idGuia = request.getParameter("guia");
        String datainicio = request.getParameter("datainicio");
        String datafim = request.getParameter("datafim");
        String msg = "";
        ModelAndView mview = null;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);


        Date date = formatter.parse(datainicio);
        Date date1 = formatter.parse(datafim);

        var idUb = new BigDecimal(idU);
        var idTb = new BigDecimal(idT);
        var idGb = new BigDecimal(idG);
        var idGuiaB = new BigDecimal(idGuia);
        SpringWebMVC.s2.DAL.Utilizador UtilizadorInstance = SpringWebMVC.s2.BLL.Utilizador.readUtilizador(Integer.parseInt(idU));
        SpringWebMVC.s2.DAL.Excursao cla = new SpringWebMVC.s2.DAL.Excursao();
        List<SpringWebMVC.s2.DAL.Excursao> excursaoInstance = SpringWebMVC.s2.BLL.Excursao.readAll();

        cla.setTrilhoId(new Trilho(idTb));
        cla.setGuiaId(new Guia(idGuiaB));
        cla.setUtilizadorId(new Utilizador(idUb));
        cla.setGrupoId(new Grupo(idGb));
        cla.setDataInicio(date);
        cla.setDataFim(date1);

        SpringWebMVC.s2.BLL.Excursao.createClassificar(cla);


        msg = "Excursao criada";
        mview = new ModelAndView("excursao");
        mview.addObject("msg", msg);
        mview.addObject("utilizadorsession", UtilizadorInstance);
        mview.addObject("excursoes", excursaoInstance);
        return mview;
    }
}
