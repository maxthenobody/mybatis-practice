package com.kh.practice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.practice.model.service.MemberService;
import com.kh.practice.model.service.MemberServiceImpl;
import com.kh.practice.model.vo.Member;

/**
 * Servlet implementation class InsertMemberServlet
 */
@WebServlet("/member/insertMember")
public class InsertMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = new MemberServiceImpl();
		int userNo = 0;
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		Member m = new Member(userNo, userId, userPwd, userName, email);
		
		int result = service.inserMember(m);
		System.out.println(result);
		
		if (result > 0) {
			request.getSession().setAttribute("msg", "회원 등록 성공.");
			response.sendRedirect(request.getContextPath() + "/");
		} else {
			request.getSession().setAttribute("msg", "회원 등록 실패.");
		}
	}

}
