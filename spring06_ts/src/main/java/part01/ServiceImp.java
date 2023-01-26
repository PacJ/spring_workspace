package part01;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import dao.MemDAO;
import model.MemDTO;

public class ServiceImp implements Service{
	
	private MemDAO memDao;
	private TransactionTemplate transactionTemplate;
	
	public ServiceImp() {
		
	}
	
	public void setMemDao(MemDAO memDao) {
		this.memDao = memDao;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}
	
	@Override
	public void insertProcess() {
		String result = transactionTemplate.execute(new TransactionCallback<String>() {
			@Override
			public String doInTransaction(TransactionStatus status) {
				try {
					memDao.insertMethod(new MemDTO(104, "용팔이", 50, "경기"));
					memDao.insertMethod(new MemDTO(104, "유다희", 20, "대전"));
					return "OK";
				} catch (Exception e) {
					status.setRollbackOnly();
					return e.toString();
				}
			}
		});
		
		System.out.println("result: " + result);
	}//end insertProcess()

}//end class
