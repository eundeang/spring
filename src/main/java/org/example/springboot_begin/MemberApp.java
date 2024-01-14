package org.example.springboot_begin;

import member.Grade;
import member.Member;
import member.MemberService;
import member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService =  appConfig.memberService();
        /**
         * 스프링 컨테이너 관리 객체
         */
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        /**
         * getBean의 파라미터의 name은 자동으로 메서드명으로 등록됨, Class<T> requiredType은 타입 이름을 적는다.
         */
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
