package Resource.bdiv3;

import jadex.commons.future.IFuture;

/**
 *  Translation service interface.
 */
public interface ITranslationService extends IlogSevice
{
	/**
	 *  Translate an English word to German.
	 *  @param eword The english word.
	 *  @return The german translation.
	 */
	//public IFuture<String> translate(String eword);
	public IFuture<UserProfile> getUserProfile();
}
