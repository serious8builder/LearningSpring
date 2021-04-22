package com.example.caching;

import com.example.AppRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SimpleMemberRepository implements MemberRepository {
    private static final Logger logger = LoggerFactory.getLogger(SimpleBookRepository.class);


    private List<Member> members = new ArrayList<>();
    private Map<Integer, Member> memberMap = new HashMap<>();

    @Override
    //@Cacheable("member")
    public Member getById(Integer id) {
        logger.info("Method called: getById");
        //simulateSlowService();
        Member member = memberMap.get(id);
        return member;
    }

    public SimpleMemberRepository() {
        members.add(new Member(1, "RK", "SW"));
        members.add(new Member(2, "MJ", "GN"));

        for (Member member: members) {
            memberMap.put(member.getId(), member);
        }
    }

    @Override
    public Member changeLocation(Integer id, String location) {
        Member member = memberMap.get(id);
        member.setLocation(location);
        return member;
    }

    private void simulateSlowService() {
        try {
            long time = 3000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }
}
