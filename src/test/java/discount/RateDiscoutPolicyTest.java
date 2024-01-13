package discount;

import member.Grade;
import member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RateDiscoutPolicyTest {
    RateDiscoutPolicy discoutPolicy = new RateDiscoutPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용되어야 한다")
    void vip_o() {
        Member member = new Member(1L, "memberVIP", Grade.VIP);
        int discount = discoutPolicy.discount(member, 10000);
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP가 아닌경우")
    void vip_x() {
        Member member = new Member(2L, "memberBasic", Grade.BASIC);
        int discount = discoutPolicy.discount(member, 10000);
        assertThat(discount).isEqualTo(1000);
    }

}