package Controllers;

import Services.RenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.swing.text.AbstractDocument;

@RestController
@Validated
public class RenderController {

    private RenderService renderService;

    public RenderController(@Autowired RenderService renderService) {
        this.renderService = renderService;
    }

    @GetMapping("/render")
    @ResponseBody
    public Mono<byte[]> getParams(@RequestParam int width,
                                  @RequestParam int height,
                                  @RequestParam double minLat,
                                  @RequestParam double minLon,
                                  @RequestParam double maxLat,
                                  @RequestParam double maxLon) {
        return renderService.render(width, height, minLat, minLon, maxLat, maxLon);
    }
}
