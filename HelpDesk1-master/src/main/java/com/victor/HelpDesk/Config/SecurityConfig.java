package com.victor.HelpDesk.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.victor.HelpDesk.Security.JWTAuthenticationFilter;
import com.victor.HelpDesk.Security.JWTAuthorizationFilter;
import com.victor.HelpDesk.Security.JWTUtil;


//@EnableWebSecurity: Indica que esta classe será usada para configurar a segurança web.
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true): Habilita a segurança global a nível de método com pré-autorização.
@EnableGlobalMethodSecurity(prePostEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter
// {: Define a classe SecurityConfig que estende WebSecurityConfigurerAdapter.
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    //private static final String[] PUBLIC_MATCHERS = { "/h2-console/**", "/login" };:
    // Define uma matriz de URLs públicas que não requerem autenticação.
    private static final String[] PUBLIC_MATCHERS = { "/h2-console/**", "/login" };

    //@Autowired private Environment env;: Injeta o ambiente do Spring.
    @Autowired
    private Environment env;

    //@Autowired private JWTUtil jwtUtil;: Injeta o utilitário JWT.
    @Autowired
    private JWTUtil jwtUtil;

   // @Autowired private UserDetailsService userDetailsService;: Injeta o serviço UserDetailsService.
    @Autowired
    private UserDetailsService userDetailsService;


    //@Override protected void configure(HttpSecurity http) throws Exception { ... }: Sobrescreve o método
    // configure de WebSecurityConfigurerAdapter para configurar as regras de segurança HTTP.
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
            http.headers().frameOptions().disable();
        }

        http.cors().and().csrf().disable();
        http.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtUtil));
        http.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtUtil, userDetailsService));
        http.authorizeRequests().antMatchers(PUBLIC_MATCHERS).permitAll().anyRequest().authenticated();

        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    //@Override protected void configure(AuthenticationManagerBuilder auth) throws Exception { ... }: Sobrescreve o
    // método configure de WebSecurityConfigurerAdapter para configurar o gerenciador de autenticação.

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
    //@Bean CorsConfigurationSource corsConfigurationSource() { ... }: Define um bean para configurar a origem da configuração CORS.
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration().applyPermitDefaultValues();
        configuration.setAllowedMethods(Arrays.asList("POST", "GET", "PUT", "DELETE", "OPTIONS"));
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    //@Bean public BCryptPasswordEncoder bCryptPasswordEncoder() { ... }: Define um bean para o codificador de senhas BCrypt.

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}