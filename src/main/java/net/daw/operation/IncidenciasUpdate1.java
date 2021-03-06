/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.daw.operation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.daw.bean.IncidenciasBean;
import net.daw.dao.IncidenciasDao;
import net.daw.helper.Contexto;
import net.daw.parameter.IncidenciasParam;

/**
 *
 * @author Enrique Gimeno
 */
public class IncidenciasUpdate1 implements Operation {
    @Override
    public Object execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Contexto oContexto = (Contexto) request.getAttribute("contexto");
        oContexto.setVista("jsp/incidencias/form.jsp");
        IncidenciasBean oIncidenciasBean;
        IncidenciasDao oIncidenciasDao;
        oIncidenciasBean = new IncidenciasBean();
        IncidenciasParam oClienteParam = new IncidenciasParam(request);
        oIncidenciasBean = oClienteParam.loadId(oIncidenciasBean);
        oIncidenciasDao = new IncidenciasDao(oContexto.getEnumTipoConexion());
        try {
            oIncidenciasBean = oIncidenciasDao.get(oIncidenciasBean);
        } catch (Exception e) {
            throw new ServletException("ClienteController: Update Error: Phase 1: " + e.getMessage());
        }
        oIncidenciasBean = oClienteParam.load(oIncidenciasBean);
        return oIncidenciasBean;
    }
}
