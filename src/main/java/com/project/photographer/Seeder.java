//package com.project.photographer;
//
//import com.github.javafaker.Book;
//import com.github.javafaker.Faker;
//import com.github.javafaker.Yoda;
//import com.github.javafaker.service.FakeValuesService;
//import com.github.javafaker.service.RandomService;
//import com.project.photographer.models.Pic;
//import com.project.photographer.repositories.PicRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Locale;
//
//@Component
//public class Seeder implements CommandLineRunner {
//
//    @Autowired
//    PicRepo picRepo;
//
//
//    @Override
//    public void run(String... args) throws Exception {
//        Faker faker = new Faker();
//        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("it-IT"), new RandomService());
//        List<Pic> pics = new ArrayList<>(10);
//        for (int i = 0; i <100 ; i++){
//            Yoda yoda = faker.yoda();
//            Pic pic = new Pic();
//            pic.setDescription(faker.lorem());
//
//        }
//
//    }
//}
