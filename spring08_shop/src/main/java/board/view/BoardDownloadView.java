package board.view;

import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import board.dao.BoardDAO;
import common.file.FileUpload;

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
		int num = Integer.parseInt(request.getParameter("num"));
		String saveDirectory = FileUpload.urlPath(request);
		
		String upload = boardDao.getFile(num);
		String fileName = upload.substring(upload.indexOf("_") + 1);
		
		//파일명이 한글일때 인코딩 작업을 한다.
		String str = URLEncoder.encode(fileName, "UTF-8");
		
		//원본파일명에서 공백이 있을 때, +표시가 되므로 공맥을 모조리 replace. "%20" 은 UTF-8에서 공백.
		str = str.replaceAll("\\+", "%20");
		
		//컨텐츠 타입
		response.setContentType("application/octet-stream");
		
		//다운로드 창에 보여줄 파일명을 저장한다.
		response.setHeader("Content-Disposition", "attachment;filename=" + str + ";");
	
		//서버에 저장된 파일을 읽어와 클라이언트에 출력해 준다.
		FileCopyUtils.copy(new FileInputStream(new File(saveDirectory, upload)), response.getOutputStream());
	}
}
