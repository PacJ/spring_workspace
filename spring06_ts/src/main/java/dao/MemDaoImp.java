package dao;

import org.mybatis.spring.SqlSessionTemplate;

import model.MemDTO;

public class MemDaoImp implements MemDAO{

	private SqlSessionTemplate sqlSession;
	
	public MemDaoImp() {
	}

	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	@Override
	public void insertMethod(MemDTO dto) {
		sqlSession.insert("mem.ins", dto);
	}
}
