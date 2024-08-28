package jp.co.internous.team2406.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.team2406.model.domain.MstUser;
import jp.co.internous.team2406.model.mapper.MstUserMapper;
import jp.co.internous.team2406.model.session.LoginSession;

/**
 * マイページに関する処理を行うコントローラー
 * @author インターノウス
 *
 */
@Controller
@RequestMapping("/team2406/mypage")
public class MyPageController {
	
	@Autowired
	private MstUserMapper userMapper;
	@Autowired
	private LoginSession loginSession;
	   
	
	
	/**
	 * マイページ画面を初期表示する。
	 * @param m 画面表示用オブジェクト
	 * @return マイページ画面
	 */
	@RequestMapping("/")
	public String index(Model m) {
		
		String userName = loginSession.getUserName();
		String password = loginSession.getPassword();
		
		MstUser user = userMapper.findByUserNameAndPassword(userName, password);
		
		m.addAttribute("user", user);
		m.addAttribute("loginSession",loginSession);
		
		return "my_page";
	}
}
