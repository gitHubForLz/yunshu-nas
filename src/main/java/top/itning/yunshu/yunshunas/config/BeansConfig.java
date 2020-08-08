package top.itning.yunshu.yunshunas.config;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
import top.itning.yunshu.yunshunas.config.properties.NasProperties;
import top.itning.yunshu.yunshunas.video.Video2M3u8Helper;

import javax.servlet.MultipartConfigElement;

/**
 * @author itning
 * @date 2019/7/14 15:35
 */
@Configuration
public class BeansConfig {
    private final NasProperties nasProperties;

    public BeansConfig(NasProperties nasProperties) {
        this.nasProperties = nasProperties;
    }

    @Bean
    public Video2M3u8Helper video2M3u8Helper() {
        return new Video2M3u8Helper(nasProperties.getFfmpegBinDir());
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation(System.getProperty("java.io.tmpdir"));
        return factory.createMultipartConfig();
    }
}
