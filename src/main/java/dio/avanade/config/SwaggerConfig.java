package dio.avanade.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("Dio Java BootCamp").version("1.0"))
                .servers(List.of(
                        new Server().url("https://web-production-79fb.up.railway.app").description("Servidor Railway")
                ));
    }
}
