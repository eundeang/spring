package member;

public class MemberServiceImpl implements MemberService{
    /**
     * 이 클래스에는 MemberRepository에 대한 코드는 없음
     * 오로지 MemberRepository라는 인터페이스 밖에 없음
     * 추상화에만 의존 ( DIP 지킴 )
     */
    private final MemberRepository memberRepository;

    /**
     * 생성자를 통해서 MemberRepository 구현체에 뭐가 들어갈지 확인
     */
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
