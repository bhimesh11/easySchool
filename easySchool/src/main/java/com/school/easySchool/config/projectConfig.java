package com.school.easySchool.config;


import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.jaas.memory.InMemoryConfiguration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class projectConfig {

    @Bean
    SecurityFilterChain DefaSecurityFilterChain(HttpSecurity security) throws Exception {
//        security.authorizeHttpRequests(request -> request.anyRequest().permitAll()).
//                formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());

        security.csrf(csrf -> csrf.ignoringRequestMatchers("/saveMsg"))
                .authorizeHttpRequests(request -> request.requestMatchers("/dashboard").authenticated()
                        .requestMatchers("/home").permitAll()
                        .requestMatchers("/contact").permitAll()
                        .requestMatchers("/saveMsg").permitAll()
                        .requestMatchers("/holidays", "/holidays/**").authenticated()
                        .requestMatchers("/courses").authenticated()
                        .requestMatchers("/about").permitAll()
                        .requestMatchers("/login").permitAll()
                        .requestMatchers("/logout").permitAll()
                        .requestMatchers("/assets/**").permitAll()
                        .requestMatchers(PathRequest.toH2Console()).permitAll())
                .formLogin(loginConfig -> loginConfig.loginPage("/login")
                        .defaultSuccessUrl("/dashboard")
                        .failureUrl("/login?error=true").permitAll())
                .logout(logoutConfig -> logoutConfig.logoutSuccessUrl("/login?logout=true")
                        .invalidateHttpSession(true)
                        .permitAll())
                .httpBasic(Customizer.withDefaults());
        security.headers(headers -> headers.frameOptions(frameOptionsConfig -> frameOptionsConfig.disable()));

        return security.build();

    }


    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder().
                username("bhimesh")
                .password("Easy@7044")
                .roles("USER").build();

        UserDetails admin = User.withDefaultPasswordEncoder().
                username("dihith")
                .password("Easy@7044")
                .roles("ADMIN").build();
        return new InMemoryUserDetailsManager(user, admin);
    }


//    @Bean
//    SecurityFilterChain DefauSecurityFilterChain(HttpSecurity security) throws  Exception
//    {
//        security.authorizeHttpRequests(request -> request.anyRequest().denyAll()).
//                formLogin(Customizer.withDefaults())
//                .httpBasic(Customizer.withDefaults());
//
//        return security.build();
//    }
}
