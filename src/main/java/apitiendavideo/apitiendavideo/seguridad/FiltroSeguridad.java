// package apitiendavideo.apitiendavideo.seguridad;

// import java.io.IOException;
// import java.util.List;
// import java.util.stream.Collectors;

// import javax.servlet.FilterChain;
// import javax.servlet.ServletException;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.web.filter.OncePerRequestFilter;

// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.ExpiredJwtException;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.MalformedJwtException;
// import io.jsonwebtoken.UnsupportedJwtException;

// public class FiltroSeguridad extends OncePerRequestFilter {

//     public static String SECRETO = "0123456789";
//     private final String HEADER = "Authorization";
//     private final String PREFIX = "Bearer ";
//     private final String AUTHORITIES = "authorities";

//     @Override
//     protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//             throws ServletException, IOException {
//         try {
//             if (verificarJWTToken(request)) {
//                 Claims claims = validarToken(request);
//                 if (claims.get(AUTHORITIES) != null) {
//                     configurarAutenticacion(claims);

//                 } else {
//                     SecurityContextHolder.clearContext();
//                 }
//             } else {
//                 SecurityContextHolder.clearContext();
//             }
//             filterChain.doFilter(request, response);
//         } catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
//             response.setStatus(HttpServletResponse.SC_FORBIDDEN);
//             ((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
//         }
//     }

//     private void configurarAutenticacion(Claims claims) {
//         @SuppressWarnings("unchecked")
//         List<String> authorities = (List) claims.get(AUTHORITIES);

//         UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
//             claims.getSubject(), null,
//             authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
//         SecurityContextHolder.getContext().setAuthentication(auth);
//     }

//     private Claims validarToken(HttpServletRequest request) {
//         String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
//         return Jwts.parser().setSigningKey(SECRETO.getBytes()).parseClaimsJws(jwtToken).getBody();
//     }

//     private boolean verificarJWTToken(HttpServletRequest request) {
//         String authenticationHeader = request.getHeader(HEADER);
//         if (authenticationHeader == null || !authenticationHeader.startsWith(PREFIX))
//             return false;
//         else
//             return true;

//     }

// }
