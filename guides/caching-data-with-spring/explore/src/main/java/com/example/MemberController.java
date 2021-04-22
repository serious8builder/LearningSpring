package com.example;

import com.example.caching.Member;
import com.example.caching.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/member")
public class MemberController {
    @Autowired
    MemberRepository memberRepository;

    @GetMapping("/{id}")
    @Cacheable(value = "member")
    public Member getMember(@PathVariable Integer id) {
        Member member = memberRepository.getById(id);
        return member;
    }

    @PutMapping("/{id}")
    public Member modifyMember(@PathVariable Integer id, @RequestParam String loc) {
        Member member = memberRepository.getById(id);
        member.setLocation(loc);
        return member;
    }
}
