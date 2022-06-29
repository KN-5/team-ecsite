package jp.co.internous.cony.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import jp.co.internous.cony.model.domain.dto.PurchaseHistoryDto;

@Mapper
public interface TblPurchaseHistoryMapper {
	int insert(@Param("destinationId") int destinationId, @Param("userId") int userId);
	
	//購入履歴情報の登録
	List<PurchaseHistoryDto> findByUserId(@Param("userId") int userId);
	
	//ユーザーIDで論理削除
	@Update("UPDATE tbl_purchase_history SET status = 0, updated_at = now() WHERE user_id = #{userId}")
		int logicalDeleteByUserId(@Param("userId") int userId);
	
}
