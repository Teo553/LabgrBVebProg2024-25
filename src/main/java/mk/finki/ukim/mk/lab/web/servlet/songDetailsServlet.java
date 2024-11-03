package mk.finki.ukim.mk.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.service.ArtistService;
import mk.finki.ukim.mk.lab.service.SongService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name = "songDetailsServlet",urlPatterns = "/songDetails")
public class songDetailsServlet extends HttpServlet {
    private final SpringTemplateEngine templateEngine;
    private final ArtistService artistService;
    private final SongService songService;

    public songDetailsServlet(SpringTemplateEngine templateEngine, ArtistService artistService, SongService songService) {
        this.templateEngine = templateEngine;
        this.artistService = artistService;
        this.songService = songService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String trackId =req.getParameter("trackId");
        Song song=songService.findByTrackId(trackId);

        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);
        context.setVariable("song", song);
        templateEngine.process("songDetails.html", context, resp.getWriter());
    }
}
