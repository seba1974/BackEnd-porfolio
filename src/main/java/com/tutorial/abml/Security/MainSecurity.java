
package com.tutorial.abml.Security;

import com.tutorial.abml.Security.jwt.JwtEntryPoint;
import com.tutorial.abml.Security.jwt.JwtTokenFilter;
import com.tutorial.abml.Security.service.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class MainSecurity extends WebSecurityConfigurerAdapter{
    
    @Autowired
    UserDetailServiceImpl userDetailService;
    
    @Autowired
    JwtEntryPoint jwtEntryPoint;
    
    @Bean
    public JwtTokenFilter jwtTokenFilter(){
        return new JwtTokenFilter();
    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
            .authorizeRequests()
            .antMatchers("/auth/**").permitAll()
                
            .antMatchers("/perfil/lista").permitAll() // reemplazar ** por lista en todos
            .antMatchers("/perfil/detail/**").permitAll()
            
            .antMatchers("/redessociales/lista").permitAll()
            .antMatchers("/redessociales/detail/**").permitAll()
                
            .antMatchers("/experiencialaboral/lista").permitAll()
            .antMatchers("/experiencialaboral/detail/**").permitAll()
            
            .antMatchers("/educacion/lista").permitAll()
            .antMatchers("/educacion/detail/**").permitAll()            
            
            .antMatchers("/idiomas/lista").permitAll()
            .antMatchers("/idiomas/detail/**").permitAll()
                        
            .antMatchers("/cursos/lista").permitAll()
            .antMatchers("/cursos/detail/**").permitAll()
            
            .antMatchers("/acercade/lista").permitAll()
            .antMatchers("/acercade/detail/**").permitAll()
            
            .antMatchers("/proyectos/lista").permitAll()
            .antMatchers("/proyectos/detail/**").permitAll()
            
            .antMatchers("/skills_hard/lista").permitAll()
            .antMatchers("/skills_hard/detail/**").permitAll()
            
            .antMatchers("/skills_soft/lista").permitAll()
            .antMatchers("/skills_soft/detail/**").permitAll()
            
            .anyRequest().authenticated()
            .and()
            .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
            .and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        
        }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager(); //To change body of generated methods, choose Tools | Templates.
    }
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }
}
