package application_interface.main_package;

public class Auction {
	private Item item;
	private String seller;
	private Bidder bidder;
	
	public Item getItem() {
		return item;
	}
	
	public void setItem(Item item) {
		this.item = item;
	}
	
	public String getSeller() {
		return seller;
	}
	
	public void setSeller(String seller) {
		this.seller = seller;
	}
	
	public Bidder getBidder() {
		return bidder;
	}
	
	public void setBidder(Bidder bidder) {
		this.bidder = bidder;
	}
}
