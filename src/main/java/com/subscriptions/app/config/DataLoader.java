package com.subscriptions.app.config;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.subscriptions.app.model.Payment;
import com.subscriptions.app.model.Plan;
import com.subscriptions.app.model.Rol;
import com.subscriptions.app.model.Service;
import com.subscriptions.app.model.Subscribe;
import com.subscriptions.app.model.User;
import com.subscriptions.app.repository.PaymentRepository;
import com.subscriptions.app.repository.PlanRepository;
import com.subscriptions.app.repository.ServiceRepository;
import com.subscriptions.app.repository.SubscribeRepository;
import com.subscriptions.app.repository.UserRepository;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(
            UserRepository userRepository,
            ServiceRepository serviceRepository,
            PlanRepository planRepository,
            SubscribeRepository subscribeRepository,
            PaymentRepository paymentRepository) {
        return args -> {
            if (serviceRepository.count() == 0) {

                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

                // Insertar 2 usuarios
                User admin = new User(null, "Admin", "admin@gmail.com", passwordEncoder.encode("Admin"), Rol.ADMIN);
                User user = new User(null, "User", "user@gmail.com", passwordEncoder.encode("User"), Rol.USER);
                userRepository.save(admin);
                userRepository.save(user);

                // Insertar 2 servicios
                Service netflix = new Service(null, "Netflix",
                        "Netflix is a subscription-based streaming service that allows users to watch TV shows, movies, documentaries, and original content across a wide variety of genres and languages. Founded in 1997 as a DVD rental service, it transitioned into streaming in 2007 and quickly became a leader in the entertainment industry.",
                        "https://upload.wikimedia.org/wikipedia/commons/0/0c/Netflix_2015_N_logo.svg");
                Service spotify = new Service(null, "Spotify",
                        "Spotify is a digital music, podcast, and video streaming service that gives users access to millions of songs and audio content from artists all over the world. Launched in 2008, it has become one of the most popular music platforms globally. Spotify offers both a free, ad-supported version and a premium subscription that removes ads, allows offline listening, and provides higher audio quality.",
                        "https://storage.googleapis.com/pr-newsroom-wp/1/2023/05/Spotify_Primary_Logo_RGB_Green.png");
                serviceRepository.save(netflix);
                serviceRepository.save(spotify);

                // Insertar 2 planes de cada servicio
                Plan netflixMensual = new Plan(null, netflix, "Mensual", 15.99, "1 mes");
                Plan netflixAnual = new Plan(null, netflix, "Anual", 149.99, "1 año");
                Plan spotifyMensual = new Plan(null, spotify, "Mensual", 9.99, "1 mes");
                Plan spotifyAnual = new Plan(null, spotify, "Anual", 99.99, "1 año");
                planRepository.save(netflixMensual);
                planRepository.save(netflixAnual);
                planRepository.save(spotifyMensual);
                planRepository.save(spotifyAnual);

                // Insertar 2 subscripciones
                Subscribe sub1 = new Subscribe(null, user, netflixMensual, LocalDate.now(),
                        LocalDate.now().plusMonths(1));
                Subscribe sub2 = new Subscribe(null, user, spotifyAnual, LocalDate.now(), LocalDate.now().plusYears(1));
                subscribeRepository.save(sub1);
                subscribeRepository.save(sub2);

                // Insertar 2 pagos
                Payment pago1 = new Payment(null, sub1, netflixMensual.getPrice(), LocalDate.now(), "Pagado");
                Payment pago2 = new Payment(null, sub2, spotifyAnual.getPrice(), LocalDate.now(), "Pendiente");
                paymentRepository.save(pago1);
                paymentRepository.save(pago2);

                System.out.println("Usuarios inicializados");
            } else {
                System.out.println("Ya hay datos en la tabla Users");
            }
        };
    }

}
