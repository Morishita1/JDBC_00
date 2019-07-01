package com.biz.jdbc.exec;

import java.util.Scanner;

import com.biz.jdbc.model.ScoreVO;
import com.biz.jdbc.model.StudentVO;
import com.biz.jdbc.service.ScoreService;
import com.biz.jdbc.service.ScoreServiceImp_01;
import com.biz.jdbc.service.StdService;
import com.biz.jdbc.service.StdServiceImp_01;

public class ScExec_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScoreService ss=new ScoreServiceImp_01();
		StdService st=new StdServiceImp_01();
		Scanner scan=new Scanner(System.in);
		
		while(true) {
			ScoreVO vo=new ScoreVO();
			StudentVO stvo=new StudentVO();
			System.out.print("학번(종료: -E)>>");
			String stno=scan.nextLine();
			if(stno.equals("-E")) break;
			if(st.findByNum(stno)==null) {
				System.out.println("학생정보가 없습니다 입력하세요");
			} else {
				System.out.println(stno+"번 학생정보가 있습니다");
				
				continue;
			}
			System.out.print("이름>>");
			String stname=scan.nextLine();
			System.out.print("학년>>");
			String stgr=scan.nextLine();
			int intgr=Integer.valueOf(stgr);
			System.out.print("학과>>");
			String stdn=scan.nextLine();
			
			System.out.println("학생 성적을 입력하세요");
			System.out.print("번호>>");
			long loNum=Long.valueOf(scan.nextLine());
			System.out.print("날짜>>");
			String straddr=scan.nextLine();
			System.out.print("학번>>");
			String strno=scan.nextLine();
			System.out.print("과목>>");
			String strsub=scan.nextLine();
			System.out.print("점수>>");
			String strsco=scan.nextLine();
			int intsco=Integer.valueOf(strsco);
			
			stvo.setSt_no(stno);
			stvo.setSt_name(stname);
			stvo.setSt_grade(intgr);
			stvo.setSt_dept_name(stdn);
			st.insert(stvo);
			vo.setSc_seq(loNum);
			vo.setSc_date(straddr);
			vo.setSc_st_no(strno);
			vo.setSc_subject(strsub);
			vo.setSc_score(intsco);
			ss.insert(vo);
		}
		

	}

}
