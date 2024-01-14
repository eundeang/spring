package org.example.springboot_begin;

import discount.DiscountPolicy;
import discount.FIxDiscountPolicy;
import discount.RateDiscoutPolicy;
import member.MemberService;
import member.MemberServiceImpl;
import member.MemoryMemberRepository;
import order.OrderService;
import order.OrderServiceImpl;

public class AppConfig {
    /**
     *  private final MemberService memberService = new MemberServiceImpl(); 로 직접 지정해줬는데
     *  이러한 방식은 인터페이스와 구현체로 분리 하였지만 다형성을 지킬 수 없는 상황이다.
     *  구현 객체를 변경 하기 위해서는 클라이언트 코드 (호출부)를 수정해야 하기 떄문이다.
     *  따서 OCP 원칙 위반인 코드를
     *  다음과 같이 수정해보고 자 한다. (객체를 생성하고 연관관계를 맺어주는 별도의 조립과정, 생성자가 필요하다)
     *  - 구체적인 MemoryMemberRepository를 생성자를 통해 넣어준다. (생성자 주입)
     */
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    private static MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    /**
     * OrderServiceImpld은 사용하는 필드가 두개
     */
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    private DiscountPolicy discountPolicy() {
        return new RateDiscoutPolicy();
    }
}
