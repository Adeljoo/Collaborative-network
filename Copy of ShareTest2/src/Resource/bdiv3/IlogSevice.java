package Resource.bdiv3;

import jadex.commons.future.IFuture;

//import jadex.commons.future.IFuture;

public interface IlogSevice {
	
	/**
	 *  Receives a chat message.
	 *  @param sender The sender's name.
	 *  @param text The message text.
	 */
	
//	public IFuture<String> message(String type);
	
	
	public IFuture<String> message(String sender, String text, String userProfile);
	
	public IFuture<UserProfile> getUserProfile();
}
