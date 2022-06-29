package jp.co.internous.cony.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jp.co.internous.cony.model.domain.MstDestination;
import jp.co.internous.cony.model.mapper.MstDestinationMapper;
import jp.co.internous.cony.model.mapper.TblCartMapper;
import jp.co.internous.cony.model.mapper.TblPurchaseHistoryMapper;
import jp.co.internous.cony.model.session.LoginSession;

//決済処理用のコントローラー
@Controller
@RequestMapping("/cony/settlement")
public class SettlementController {
	
	@Autowired
	private LoginSession loginSession;
	
	private Gson gson = new Gson();
	
	@Autowired
	private TblCartMapper cartMapper;
	
	@Autowired
	private MstDestinationMapper destinationMapper;
	
	@Autowired
	private TblPurchaseHistoryMapper purchaseHistoryMapper;
	
	//決済画面にて、ユーザー情報と宛先情報を表示
	@RequestMapping("/")
	public String index(Model m) {
		int userId = loginSession.getUserId();
		List<MstDestination> destinationList = destinationMapper.findByUserId(userId);
		m.addAttribute("destinationList", destinationList);
		m.addAttribute("loginSession", loginSession);
		return "settlement";
	}
	
	//決済処理の実行
	@ResponseBody
	@SuppressWarnings("unchecked")
	@RequestMapping("/complete")
	public boolean complete (@RequestBody String destinationId) {
		Map<String, String> map = gson.fromJson(destinationId, Map.class);
		int id = Integer.parseInt(map.get("destinationId"));
		int userId = loginSession.getUserId();
		int insertCount = purchaseHistoryMapper.insert(id, userId);
		
		int deleteCount = 0;
		if(insertCount > 0) {
			deleteCount = cartMapper.deleteByUserId(userId);
		}
		return deleteCount == insertCount;
	}
	
}
