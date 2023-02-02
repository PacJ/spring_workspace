package members.dao;

import org.apache.ibatis.session.SqlSession;

import members.dto.MembersDTO;

public class MembersDaoImp implements MembersDAO{

	private SqlSession sqlSession;
	
	public MembersDaoImp() {

	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int insertMember(MembersDTO dto) {
		return sqlSession.insert("members.insertMember", dto);
	}

	@Override
	public MembersDTO selectByEmail(String memberEmail) {
		return sqlSession.selectOne("members.selectByEmail", memberEmail);
	}

	@Override
	public void updateMember(MembersDTO dto) {
		sqlSession.update("members.updateMember", dto);
	}

	@Override
	public void updateByPass(MembersDTO dto) {
		sqlSession.update("members.updateByPass", dto);
	}
}
