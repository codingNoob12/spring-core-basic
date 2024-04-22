package hello.core.discount;

import static org.assertj.core.api.Assertions.assertThat;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

    @DisplayName("VIP는 10% 할인이 적용되어야 한다.")
    @Test
    void vip_o() {
        // Given
        Member member = new Member(1L, "memberVIP", Grade.VIP);

        // When
        int discount = rateDiscountPolicy.discount(member, 10000);

        // Then
        assertThat(discount).isEqualTo(1000);
    }

    @DisplayName("VIP가 아니면 할인이 적용되지 않아야 한다")
    @Test
    void vip_x() {
        // Given
        Member member = new Member(1L, "memberBASIC", Grade.BASIC);

        // When
        int discount = rateDiscountPolicy.discount(member, 10000);

        // Then
        assertThat(discount).isEqualTo(0);
    }
}