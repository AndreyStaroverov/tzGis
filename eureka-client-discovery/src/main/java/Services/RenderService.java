package Services;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Service
public class RenderService {
    public Mono<byte[]> render(int width, int height, double minLat, double minLon, double maxLat, double maxLon) {
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = image.createGraphics();

        int x1 = (int) (width * (minLon / 180.0 + 1.0) / 2.0);
        int y1 = (int) (height * (maxLat / 90.0 + 1.0) / 2.0);
        int x2 = (int) (width * (maxLon / 180.0 + 1.0) / 2.0);
        int y2 = (int) (height * (minLat / 90.0 + 1.0) / 2.0);

        graphics.setColor(Color.BLUE);
        graphics.fillRect(x1, y1, x2 - x1, y2 - y1);
        graphics.dispose();

        return imageToBytes(image);
    }

    private Mono<byte[]> imageToBytes(BufferedImage image) {
        return Mono.fromCallable(() -> {
            try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
                ImageIO.write(image, "png", outputStream);
                return outputStream.toByteArray();
            } catch (IOException e) {
                throw new RuntimeException("Error converting image to bytes", e);
            }
        });
    }
}
