package mk.finki.ukim.mk.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab.service.SongService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name="SongServlet",urlPatterns = "/listSongs")
public class SongListServlet extends HttpServlet {
    private final SpringTemplateEngine templateEngine;
    private final SongService songService;

    public SongListServlet(SpringTemplateEngine templateEngine, SongService songService) {
        this.templateEngine = templateEngine;
        this.songService = songService;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);
        String search = req.getParameter("search");

        if (search == null || search.isEmpty()) {
            context.setVariable("songsList", songService.listSongs());
        } else {
            context.setVariable("songsList", songService.searchByStr(search));
        }

        templateEngine.process("listSongs.html", context, resp.getWriter());
    }

}
