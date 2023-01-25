package dao;

import org.mybatis.spring.SqlSessionTemplate;

import model.MemDTO;

public class MemDaoImp implements MemDAO{
	private SqlSessionTemplate sqlSession;
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	public MemDaoImp() {
		
	}
	

	@Override
	public java.util.List<MemDTO> List() {
		return sqlSession.selectList("mem.all");
	}

	@Override
	public void insertMethod(MemDTO dto) {
		sqlSession.insert("mem.ins", dto);
	}

	@Override
	public MemDTO updateMethod(int num) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateMethod(MemDTO dto) {
		sqlSession.update("mem.upt", dto);
	}

	@Override
	public void deleteMethod(int num) {
		sqlSession.delete("mem.del", num);
		
	}

	@Override
	public MemDTO one(int num) {
		return sqlSession.selectOne("mem.one", num);
	}

	@Override
	public int countMethod() {
		// TODO Auto-generated method stub
		return 0;
	}
}
