package hello.core.member;

public class MemberServiceImpl implements MemberService{

    /* 추상화와 구현체 둘다 의존하는중 !!DIP 위반!!
    private final MemberRepository memberRepository = new MemoryMemberRepository();*/

    private final MemberRepository memberRepository;

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

    // 테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}