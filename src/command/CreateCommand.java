package command;

import javax.servlet.http.HttpServletRequest;

import domain.*;
import enums.*;
import service.MemberServiceImpl;

//enum 폴더에 domain 만든 후 

public class CreateCommand extends Command{
	public CreateCommand(HttpServletRequest request) {  
		setRequest(request); 
		setDomain(request.getServletPath().substring(1, request.getServletPath().indexOf(".")));
		setAction(request.getParameter("action"));
		setPage(request.getParameter("page"));
		excute();
	}
	
	@Override
	public void excute() {
		switch (Domain.valueOf(Receiver.cmd.domain.toUpperCase())) {
		case MEMBER:
			System.out.println("회원가입에 들어옴");
			MemberBean member = new MemberBean();
			member.setName(request.getParameter("new-user-name"));
			member.setUserid(request.getParameter("new-user-id"));
			member.setPassword(request.getParameter("new-user-password"));
			member.setSsn(request.getParameter("new-user-birth"));
			//MemberServiceImpl.getInstance().createMember(member);
			
			break;
		default:
			break;
		}
		super.excute();
	}
}
