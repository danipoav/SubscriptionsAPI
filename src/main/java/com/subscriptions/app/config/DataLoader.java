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
                                User admin = new User(null, "Admin", "admin@gmail.com", passwordEncoder.encode("Admin"),
                                                Rol.ADMIN);
                                User user = new User(null, "User", "user@gmail.com", passwordEncoder.encode("User"),
                                                Rol.USER);
                                userRepository.save(admin);
                                userRepository.save(user);

                                // Insertar 5 servicios
                                Service netflix = new Service(null, "Netflix",
                                                "Netflix is a subscription-based streaming service that allows users to watch TV shows, movies, documentaries, and original content across a wide variety of genres and languages. Founded in 1997 as a DVD rental service, it transitioned into streaming in 2007 and quickly became a leader in the entertainment industry.",
                                                "https://upload.wikimedia.org/wikipedia/commons/0/0c/Netflix_2015_N_logo.svg");
                                Service spotify = new Service(null, "Spotify",
                                                "Spotify is a digital music, podcast, and video streaming service that gives users access to millions of songs and audio content from artists all over the world. Launched in 2008, it has become one of the most popular music platforms globally. Spotify offers both a free, ad-supported version and a premium subscription that removes ads, allows offline listening, and provides higher audio quality.",
                                                "https://storage.googleapis.com/pr-newsroom-wp/1/2023/05/Spotify_Primary_Logo_RGB_Green.png");
                                Service youtube = new Service(null, "YouTube Premium",
                                                "YouTube Premium offers an enhanced viewing experience on YouTube and YouTube Music with no ads, offline playback, and background play. It provides access to original content and a seamless, uninterrupted streaming service.",
                                                "https://upload.wikimedia.org/wikipedia/commons/0/09/YouTube_full-color_icon_%282017%29.svg");

                                Service amazon = new Service(null, "Amazon Prime Video",
                                                "Amazon Prime Video is a subscription-based streaming service offering a vast library of movies, TV shows, and original content. Included with an Amazon Prime membership, it allows streaming on multiple devices with high-quality playback.",
                                                "https://upload.wikimedia.org/wikipedia/commons/f/f1/Prime_Video.png");

                                Service cloudZen = new Service(null, "CloudZen",
                                                "CloudZen is an all-in-one cloud storage and collaboration platform designed for professionals and teams. It offers encrypted storage, real-time sharing, and AI-assisted organization tools to boost productivity and data security.",
                                                "https://cdn-icons-png.flaticon.com/512/4150/4150897.png");

                                serviceRepository.save(netflix);
                                serviceRepository.save(spotify);
                                serviceRepository.save(youtube);
                                serviceRepository.save(amazon);
                                serviceRepository.save(cloudZen);

                                // Insertar 2 planes de cada servicio
                                Plan netflixMensual = new Plan(null, netflix, "Monthly", 15.99, "1 mes");
                                Plan netflixAnual = new Plan(null, netflix, "Annual", 149.99, "1 año");
                                Plan spotifyMensual = new Plan(null, spotify, "Monthly", 9.99, "1 mes");
                                Plan spotifyAnual = new Plan(null, spotify, "Annual", 99.99, "1 año");
                                Plan youtubeMensual = new Plan(null, youtube, "Monthly", 11.99, "1 mes");
                                Plan youtubeAnual = new Plan(null, youtube, "Annual", 119.99, "1 año");
                                Plan amazonMensual = new Plan(null, amazon, "Monthly", 12.99, "1 mes");
                                Plan amazonAnual = new Plan(null, amazon, "Annual", 129.99, "1 año");
                                Plan cloudZenMensual = new Plan(null, cloudZen, "Monthly", 6.99, "1 mes");
                                Plan cloudZenAnual = new Plan(null, cloudZen, "Annual", 69.99, "1 año");
                                planRepository.save(netflixMensual);
                                planRepository.save(netflixAnual);
                                planRepository.save(spotifyMensual);
                                planRepository.save(spotifyAnual);
                                planRepository.save(youtubeMensual);
                                planRepository.save(youtubeAnual);
                                planRepository.save(amazonMensual);
                                planRepository.save(amazonAnual);
                                planRepository.save(cloudZenMensual);
                                planRepository.save(cloudZenAnual);

                                // Insertar 2 subscripciones
                                Subscribe sub1 = new Subscribe(null, user, netflixMensual, LocalDate.now(),
                                                LocalDate.now().plusMonths(1));
                                Subscribe sub2 = new Subscribe(null, user, spotifyAnual, LocalDate.now(),
                                                LocalDate.now().plusYears(1));
                                subscribeRepository.save(sub1);
                                subscribeRepository.save(sub2);

                                // Insertar 2 pagos
                                Payment pago1 = new Payment(null, sub1, netflixMensual.getPrice(), LocalDate.now(),
                                                "Paid");
                                Payment pago2 = new Payment(null, sub2, spotifyAnual.getPrice(), LocalDate.now(),
                                                "Pending");
                                paymentRepository.save(pago1);
                                paymentRepository.save(pago2);

                                System.out.println("Usuarios inicializados");
                        } else {
                                System.out.println("Ya hay datos en la tabla Users");
                        }
                };
        }

}
