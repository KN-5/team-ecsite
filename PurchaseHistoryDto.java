package jp.co.internous.cony.model.domain.dto;

public class PurchaseHistoryDto {
	
	private String purchasedAt;
	private String productName;
	private int price;
	private int productCount;
	private String familyName;
	private String firstName;
	private String address;
	
	//購入日時の取得・変更
	public String getPurchasedAt() {
		return purchasedAt;
	}
	
	public void setPurchasedAt(String purchasedAt) {
		this.purchasedAt = purchasedAt;
	}
	
	//商品名の取得・変更
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	//価格の取得・変更
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	//個数の取得・変更
	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	//宛先の苗字の取得・変更
	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	//宛先の名前の取得・変更
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	//住所の取得・変更
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
