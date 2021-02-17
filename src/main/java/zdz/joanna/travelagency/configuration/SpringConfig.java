package zdz.joanna.travelagency.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SpringConfig {

    @Bean
    public ModelMapper mapper() {
        return new ModelMapper();
    }
    
//    @Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/travelagency").allowedOrigins("http://localhost:8080");
//			}
//		};
//	}
}
