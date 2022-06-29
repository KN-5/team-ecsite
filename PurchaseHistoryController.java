package jp.co.internous.cony.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import jp.co.internous.cony.model.domain.dto.PurchaseHistoryDto;
import jp.co.internous.cony.model.mapper.TblPurchaseHistoryMapper;
import jp.co.internous.cony.model.session.LoginSession;

//購入履歴用のコントローラー
@Controller
@RequestMapping("/cony/history")
public class PurchaseHistoryController {
	
	@Autowired
	private LoginSession loginSession;
	
	@Autowired
	private TblPurchaseHistoryMapper purchaseHistoryMapper;
	
	//購入履歴画面の表示
	@RequestMapping("/")
	public String index(Model m) {
		int userId = loginSession.getUserId();
		List<PurchaseHistoryDto> historyList = purchaseHistoryMapper.findByUserId(userId);
		m.addAttribute("historyList", historyList);
		m.addAttribute("loginSession", loginSession);
		return "purchase_history";
	}
	
	//購入履歴の論理削除
	@RequestMapping("/delete")
	@ResponseBody
	public boolean delete() {
		int userId = loginSession.getUserId();
		int result = purchaseHistoryMapper.logicalDeleteByUserId(userId);
		return result > 0;
	}
	
}
