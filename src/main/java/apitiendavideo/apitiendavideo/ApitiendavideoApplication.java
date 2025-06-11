package apitiendavideo.apitiendavideo;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//import apitiendavideo.apitiendavideo.seguridad.FiltroSeguridad;

@SpringBootApplication
@EnableTransactionManagement
public class ApitiendavideoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApitiendavideoApplication.class, args);
	}

	// @EnableWebSecurity
	// @Configuration
	// public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	// @Override
	// protected void configure(HttpSecurity http) throws Exception {
	// http.cors().and().csrf().disable().authorizeRequests()
	// //csrf().disable()
	// //.addFilterAfter(new FiltroSeguridad(),
	// UsernamePasswordAuthenticationFilter.class)
	// .antMatchers(HttpMethod.OPTIONS ).permitAll() //"/usuarios/login",
	// "/empresas/listar", "/titulos/listar", "/paises/listar",
	// "/alquileres/listar", "/empresas/modificar"
	// .antMatchers("/**").permitAll()
	// .anyRequest().authenticated()
	// .and().httpBasic();
	// }

	// @Bean
	// public CorsConfigurationSource corsConfigurationSource() {
	// CorsConfiguration configuration = new CorsConfiguration();
	// configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200")); //
	// or add * to allow all origins
	// configuration.setAllowCredentials(true);
	// configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "PATCH",
	// "DELETE", "OPTIONS")); // to
	// // set
	// // allowed
	// // http
	// // methods
	// configuration.setAllowedHeaders(Arrays.asList("Authorization",
	// "Cache-Control", "Content-Type"));
	// configuration.setExposedHeaders(Arrays.asList("custom-header1",
	// "custom-header2"));
	// UrlBasedCorsConfigurationSource source = new
	// UrlBasedCorsConfigurationSource();
	// source.registerCorsConfiguration("/**", configuration);
	// return source;
	// }

	// }

	@Configuration
	public class CorsConfig implements WebMvcConfigurer {

		@Bean
		public CorsFilter corsFilter() {
			CorsConfiguration config = new CorsConfiguration();
			config.setAllowCredentials(true); // Permitir credenciales (cookies o headers)
			config.addAllowedOriginPattern("*"); // Permitir todas las solicitudes de origen
			config.addAllowedHeader("*"); // Permitir todos los headers
			config.addAllowedMethod("*"); // Permitir todos los métodos (GET, POST, PUT, DELETE, etc.)

			UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
			source.registerCorsConfiguration("/**", config); // Aplicar a todas las rutas

			return new CorsFilter(source);
		}

		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry.addMapping("/**")
					.allowedOrigins("https://tiendavideo-o8ux.onrender.com")
					.allowedMethods("*")
					.allowedHeaders("*");
		}
	}

}