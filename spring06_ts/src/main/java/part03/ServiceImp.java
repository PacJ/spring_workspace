package part03;


import org.springframework.transaction.annotation.Transactional;

import dao.MemDAO;
import model.MemDTO;

public class ServiceImp implements Service{
	
	private MemDAO memDao;
	
	public ServiceImp() {
		
	}
	
	public void setMemDao(MemDAO memDao) {
		this.memDao = memDao;
	}

	@Transactional(rollbackFor = org.springframework.dao.DuplicateKeyException.class)
	@Override
	public void insertProcess() {
		memDao.insertMethod(new MemDTO(112, "용팔이", 50, "경기"));
		memDao.insertMethod(new MemDTO(112, "유다희", 20, "대전"));
	}//end insertProcess()

}//end class
