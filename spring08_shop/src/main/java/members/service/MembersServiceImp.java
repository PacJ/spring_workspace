package members.service;

import common.exception.WrongEmailPasswordException;
import members.dao.MembersDAO;
import members.dto.AuthInfo;
import members.dto.ChangePwdCommand;
import members.dto.MembersDTO;

public class MembersServiceImp implements MembersService{
	private MembersDAO membersDao;
	
	public MembersServiceImp() {

	}

	public void setMembersDao(MembersDAO membersDao) {
		this.membersDao = membersDao;
	}

	@Override
	public AuthInfo addMemberProcess(MembersDTO dto) {
		membersDao.insertMember(dto);
		return new AuthInfo(dto.getMemberEmail(), dto.getMemberName(), dto.getMemberPass());
	}

	@Override
	public AuthInfo loginProcess(MembersDTO dto) {
		MembersDTO member = membersDao.selectByEmail(dto.getMemberEmail());
		if(member == null) {
//			System.out.println("이메일 주소와 일치하는 아이디를 찾지 못하였습니다.");
			throw new WrongEmailPasswordException();
		}
		
		if(!member.matchPassword(dto.getMemberPass())) {
//			System.out.println("비밀번호가 틀렸습니다.");
			throw new WrongEmailPasswordException();
		}
		
		return new AuthInfo(member.getMemberEmail(), member.getMemberName(), member.getMemberPass());
	}

	@Override
	public MembersDTO updateMemberProcess(String memberEmail) {
		return membersDao.selectByEmail(memberEmail);
	}

	@Override
	public AuthInfo updateMemberProcess(MembersDTO dto) {
		membersDao.updateMember(dto);
		MembersDTO member = membersDao.selectByEmail(dto.getMemberEmail());
		return new AuthInfo(member.getMemberEmail(), member.getMemberName(), member.getMemberPass());
	}

	@Override
	public void updatePassProcess(String memberEmail, ChangePwdCommand changePwd) {
		MembersDTO member = membersDao.selectByEmail(memberEmail);
		if(member == null) {
			throw new WrongEmailPasswordException();
		}
		member.changePassword(changePwd.getCurrentPassword(), changePwd.getNewPassword());
		membersDao.updateByPass(member);
	}
}
