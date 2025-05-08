package se.mete.javawebdemo.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConcolRunner implements CommandLineRunner {

    @Autowired
    POPSingerRepository popsingerRepository;

    @Override
    public void run(String... args) throws Exception {
        if (popsingerRepository.count() == 0) {
            popSinger pop = new popSinger();
            pop.setAge(30);
            pop.setName("V");
            popsingerRepository.save(pop);

            pop = new popSinger();
            pop.setAge(31);
            pop.setName("RM");
            popsingerRepository.save(pop);
        }
    }
}
