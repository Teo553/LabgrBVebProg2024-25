package mk.finki.ukim.mk.lab.web.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mk.finki.ukim.mk.lab.model.Artist;
import mk.finki.ukim.mk.lab.model.Song;
import mk.finki.ukim.mk.lab.service.ArtistService;
import mk.finki.ukim.mk.lab.service.SongService;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(name="ArtistServlet",urlPatterns = "/artist")
public class ArtistServlet extends HttpServlet {
    private final SpringTemplateEngine templateEngine;
    private final ArtistService artistService;
    private final SongService songService;

    public ArtistServlet(SpringTemplateEngine templateEngine, ArtistService artistService, SongService songService) {
        this.templateEngine = templateEngine;
        this.artistService = artistService;
        this.songService = songService;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        IWebExchange webExchange = JakartaServletWebApplication
                .buildApplication(getServletContext())
                .buildExchange(req, resp);

        WebContext context = new WebContext(webExchange);
        String trackId = req.getParameter("trackId");
        context.setVariable("artistList",artistService.listArtist());
        context.setVariable("trackId",trackId);
        templateEngine.process("artistsList.html", context, resp.getWriter());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String trackId = req.getParameter("trackId");
        String artistId= req.getParameter("artistId");
        Artist artist=this.artistService.findById(artistId);
        Song song=this.songService.findByTrackId(trackId);
        this.songService.addArtistToSong(artist,song);
        resp.sendRedirect("/songDetails?trackId=" + trackId);
    }
}
