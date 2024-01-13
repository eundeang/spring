package order;

import discount.DiscountPolicy;
import discount.FIxDiscountPolicy;
import member.Member;
import member.MemberRepository;
import member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository ;
    //DIP 위반
    //private final DiscountPolicy discountPolicy = new FIxDiscountPolicy();
    // 해결 1 추상화에 의존 (인터페이스에 의존) -null point exeption 발생
    private final DiscountPolicy discountPolicy ;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);
        return new Order(memberId, itemName,itemPrice,discountPrice);
    }
}
