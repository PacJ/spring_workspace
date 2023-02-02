package members.service;

import members.dto.AuthInfo;
import members.dto.ChangePwdCommand;
import members.dto.MembersDTO;

public interface MembersService {
	
	public AuthInfo addMemberProcess(MembersDTO dto);
	public AuthInfo loginProcess(MembersDTO dto);
	
	public MembersDTO updateMemberProcess(String memberEmail);
	public AuthInfo updateMemberProcess(MembersDTO dto);
	public void updatePassProcess(String memberEmail, ChangePwdCommand changePwd);

}
