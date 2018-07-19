package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Carrier {
	public static void forward(HttpServletRequest request, HttpServletResponse response)  {
		try {
			System.out.println("뷰 : "+Receiver.cmd.getView());
			request.getRequestDispatcher(Receiver.cmd.getView()).forward(request, response);
		} catch (Exception e) {e.printStackTrace();}
		
		//receiver센트리의 명령(cmd) 
		//System.out.println() 도 패턴걸린것 . Sentry.cmd.getView()유사한 모양이지 
		//view= "/WEB-INF/view/member/"+page+".jsp"
		//캐리어는 명령보내는 일만 하는 클래스.
		
	}
	public static void redirect(HttpServletRequest request,HttpServletResponse response,String url) {
		try {
			response.sendRedirect(request.getContextPath()+url);
		} catch (Exception e) {e.printStackTrace();}
	}
}
