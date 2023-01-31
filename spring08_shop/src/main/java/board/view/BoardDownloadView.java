package board.view;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;

import board.dao.BoardDAO;

//다운로드 창을 띄우기 위한 뷰 페이지
public class BoardDownloadView extends AbstractView{
	private BoardDAO boardDao;
	
	public BoardDownloadView() {
		
	}
	
	public void setBoardDao(BoardDAO boardDao) {
		this.boardDao = boardDao;
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
	}
}
