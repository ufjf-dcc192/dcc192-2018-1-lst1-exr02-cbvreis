package atividade02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "MapsServlet", urlPatterns = {"/maps.html"})
public class MapsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String menu = request.getParameter("menu");

        Map<String, String> paises = new HashMap<>();

        paises.put("Brasil", "Amarelo");
        paises.put("Argentina", "Azul");
        paises.put("França", "Azul");
        paises.put("Inglaterra", "Vermelho");
        paises.put("Estados Unidos", "Vermelho");
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MapsServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1> Atividade 03</h1>");

            if ("lista".equals(menu)) {

                out.println("<dl>");
                for (Map.Entry<String, String> pais : paises.entrySet()) {

                    out.println("<dt>" + pais.getKey() + "<dt>");
                    out.println("<dd>" + pais.getValue() + "</dd>");
                }
                out.println("</dl>");

                out.println("<br><br><hr>");
            } else if ("agrupa".equals(menu)) {
                Map<String, ArrayList<String>> mapCores = new HashMap<>();
                for (Map.Entry<String, String> pais : paises.entrySet()) {
                    if (!mapCores.containsKey(pais.getValue())) {
                        ArrayList<String> listPais = new ArrayList();
                        listPais.add(pais.getKey());
                        mapCores.put(pais.getValue(), listPais);
                    } else {
                        mapCores.get(pais.getValue()).add(pais.getKey());
                    }

                }
                for (Map.Entry<String, ArrayList<String>> cor : mapCores.entrySet()) {
                    out.println("<dt>" + cor.getKey() + "</dt>");
                    for (String paisao : cor.getValue()) {
                        out.println("<dd>" + paisao + "</dd>");
                    }
                }
            } else {

                out.println("<br><br><hr>");
                out.println("<h1> Não foi possível entender sua requisição</h1>");

            }

            out.println("</body>");
            out.println("</html>");
        }
    }

}
