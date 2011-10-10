package com.williamvanderhoef.foursquare.responses;

import com.williamvanderhoef.foursquare.model.Tip;
import com.williamvanderhoef.foursquare.model.subtypes.Items;

/**
 * 
 * @author <a href="mailto://william.vanderhoef@gmail.com">William Vanderhoef</a>
 *
 */
public class UserTipsResponse
{
	private Items<Tip> tips;

	/**
	 * @return the tips
	 */
	public Items<Tip> getTips() {
		return tips;
	}

	/**
	 * @param tips the tips to set
	 */
	public void setTips(Items<Tip> tips) {
		this.tips = tips;
	}


	

	
}
