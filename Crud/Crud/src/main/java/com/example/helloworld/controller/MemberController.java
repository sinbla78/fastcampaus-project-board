package com.example.helloworld.controller;

import com.example.helloworld.dto.MemberFormDTO;
import com.example.helloworld.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/")
    public String Home() {
        return "home";
    }

    @GetMapping("/members/new")
    public String createMemberForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String createMember(MemberFormDTO memberFormDTO) {
        Long memberId = memberService.join(memberFormDTO);
        return "home";
    }
}