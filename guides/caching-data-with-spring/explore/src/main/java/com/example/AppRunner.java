package com.example;

import com.example.caching.BookRepository;
import com.example.caching.MemberRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class AppRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(AppRunner.class);

    @Autowired
    private final MemberRepository memberRepository;

    public AppRunner(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info(".... Fetching members");
        logger.info("Memeber 1 -->" + memberRepository.getById(1));
        logger.info("Memeber 2-->" + memberRepository.getById(2));
        logger.info("Memeber 1-->" + memberRepository.changeLocation(1, "NY"));
        logger.info("Memeber 1 -->" + memberRepository.getById(1));
    }

}