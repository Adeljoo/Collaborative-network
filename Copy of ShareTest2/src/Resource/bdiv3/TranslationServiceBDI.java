package Resource.bdiv3;

/*import jadex.bdiv3.annotation.Goal;
import jadex.bdiv3.annotation.Goals;
import jadex.bdiv3.annotation.Plan;
import jadex.bdiv3.annotation.Publish;
import jadex.bdiv3.annotation.Trigger*/
import jadex.bridge.IExternalAccess;
//import jadex.bridge.IExternalAccess;
import jadex.bridge.IInternalAccess;
import jadex.bridge.service.annotation.Service;
import jadex.bridge.service.annotation.ServiceComponent;
import jadex.bridge.service.annotation.ServiceStart;
import jadex.bridge.service.component.IRequiredServicesFeature;
import jadex.bridge.service.types.clock.IClockService;
import jadex.commons.future.ExceptionDelegationResultListener;
import jadex.commons.future.Future;
import jadex.commons.future.IFuture;
/*import jadex.bridge.service.annotation.ServiceStart;
import jadex.bridge.service.component.IRequiredServicesFeature;
import jadex.commons.future.ExceptionDelegationResultListener;
import jadex.commons.future.Future;
import jadex.commons.future.IFuture;*/
import jadex.micro.annotation.Agent;
import jadex.micro.annotation.AgentCreated;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import TranslationGuiBDI;

/**
 *  The translation agent B5.
 *  
 *  BDI goal that is automatically published as service.
 */

@Service
/*@Goals(@Goal(clazz=TranslationGoal.class, 
	publish=@Publish(type=ITranslationService.class)))//, method="translateEnglishGerman")))
*/
public class TranslationServiceBDI extends BobServiceBDI implements ITranslationService
{
	
	protected static final List<UserProfile> checks;
	/** The clock service. */
	protected IClockService clock;
	
	protected ITranslationService check;
	
	/** The time format. */
	//protected static LocalDateTime format;
	/** The user interface. */
	protected TranslationGuiBDI gui;
	
	
protected UserProfile profile;

	static
	{  
		checks = new ArrayList<UserProfile>();
		//LocalDateTime simpDate = null;
		//SimpleDateFormat date = null;
		checks.add(new UserProfile("Alice", 1000,"A", "","", "Executable file"));
		checks.add(new UserProfile("Bob", 100, "AD", "","","PDF"));
	    checks.add(new UserProfile("Eve", 580, "ABC", "","","File"));
		checks.add(new UserProfile("Jim", 1000, "C", "","","PDF."));
		checks.add(new UserProfile("Maria", 44, "DS","","", "PDF."));
		
		checks.add(new UserProfile("Alice", 1000,"A", "","", "Executable file"));
		checks.add(new UserProfile("Bob", 100, "AD", "","","PDF"));
	    checks.add(new UserProfile("Eve", 580, "ABC", "","","File"));
		checks.add(new UserProfile("Jim", 1000, "C", "","","PDF."));
		checks.add(new UserProfile("Maria", 44, "DS","","", "PDF."));
		
		checks.add(new UserProfile("Alice", 1000,"A", "","", "Executable file"));
		checks.add(new UserProfile("Bob", 100, "AD", "","","PDF"));
	    checks.add(new UserProfile("Eve", 580, "ABC", "","","File"));
		checks.add(new UserProfile("Jim", 1000, "C", "","","PDF."));
		checks.add(new UserProfile("Maria", 44, "DS","","", "PDF."));
		
		checks.add(new UserProfile("Alice", 1000,"A", "","", "Executable file"));
		checks.add(new UserProfile("Bob", 100, "AD", "","","PDF"));
	    checks.add(new UserProfile("Eve", 580, "ABC", "","","File"));
		checks.add(new UserProfile("Jim", 1000, "C", "","","PDF."));
		checks.add(new UserProfile("Maria", 44, "DS","","", "PDF."));
		
		checks.add(new UserProfile("Alice", 1000,"A", "","", "Executable file"));
		checks.add(new UserProfile("Bob", 100, "AD", "","","PDF"));
	    checks.add(new UserProfile("Eve", 1000, "ABC", "","","File"));
		checks.add(new UserProfile("Jim", 1000, "C", "","","PDF."));
		checks.add(new UserProfile("Maria", 44, "DS","","", "PDF."));
		
		checks.add(new UserProfile("Alice", 1000,"A", "","", "Executable file"));
		checks.add(new UserProfile("Bob", 100, "AD", "","","PDF"));
	    checks.add(new UserProfile("Eve", 1000, "ABC", "","","File"));
		checks.add(new UserProfile("Jim", 1000, "C", "","","PDF."));
		checks.add(new UserProfile("Maria", 44, "DS","","", "PDF."));
		
		checks.add(new UserProfile("Alice", 1000,"A", "","", "Executable file"));
		checks.add(new UserProfile("Bob", 100, "AD", "","","PDF"));
	    checks.add(new UserProfile("Eve", 1000, "ABC", "","","File"));
		checks.add(new UserProfile("Jim", 1000, "C", "","","PDF."));
		checks.add(new UserProfile("Maria", 44, "DS","","", "PDF."));
		
		checks.add(new UserProfile("Alice", 1000,"A", "","", "Executable file"));
		checks.add(new UserProfile("Bob", 100, "AD", "","","PDF"));
	    checks.add(new UserProfile("Eve", 1000, "ABC", "","","File"));
		checks.add(new UserProfile("Jim", 1000, "C", "","","PDF."));
		checks.add(new UserProfile("Maria", 44, "DS","","", "PDF."));
		
		checks.add(new UserProfile("Alice", 1000,"A", "","", "Executable file"));
		checks.add(new UserProfile("Bob", 100, "AD", "","","PDF"));
	    checks.add(new UserProfile("Eve", 900, "ABC", "","","File"));
		checks.add(new UserProfile("Jim", 1000, "C", "","","PDF."));
		checks.add(new UserProfile("Maria", 44, "DS","","", "PDF."));
		
		checks.add(new UserProfile("Alice", 1000,"A", "","", "Executable file"));
		checks.add(new UserProfile("Bob", 100, "AD", "","","PDF"));
	    checks.add(new UserProfile("Eve", 900, "ABC", "","","File"));
		checks.add(new UserProfile("Jim", 1000, "C", "","","PDF."));
		checks.add(new UserProfile("Maria", 44, "DS","","", "PDF."));
		
		checks.add(new UserProfile("Alice", 1000,"A", "","", "Executable file"));
		checks.add(new UserProfile("Bob", 100, "AD", "","","PDF"));
	    checks.add(new UserProfile("Eve", 1000, "ABC", "","","File"));
		checks.add(new UserProfile("Jim", 1000, "C", "","","PDF."));
		checks.add(new UserProfile("Maria", 44, "DS","","", "PDF."));
		
		checks.add(new UserProfile("Alice", 1000,"A", "","", "Executable file"));
		checks.add(new UserProfile("Bob", 100, "AD", "","","PDF"));
	    checks.add(new UserProfile("Eve", 900, "ABC", "","","File"));
		checks.add(new UserProfile("Jim", 1000, "C", "","","PDF."));
		checks.add(new UserProfile("Maria", 44, "DS","","", "PDF."));
		
		checks.add(new UserProfile("Alice", 1000,"A", "","", "Executable file"));
		checks.add(new UserProfile("Bob", 100, "AD", "","","PDF"));
	    checks.add(new UserProfile("Eve", 1000, "ABC", "","","File"));
		checks.add(new UserProfile("Jim", 1000, "C", "","","PDF."));
		checks.add(new UserProfile("Maria", 44, "DS","","", "PDF."));
		
		checks.add(new UserProfile("Alice", 1000,"A", "","", "Executable file"));
		checks.add(new UserProfile("Bob", 100, "AD", "","","PDF"));
	    checks.add(new UserProfile("Eve", 1000, "ABC", "","","File"));
		checks.add(new UserProfile("Jim", 1000, "C", "","","PDF."));
		checks.add(new UserProfile("Maria", 44, "DS","","", "PDF."));
		
		checks.add(new UserProfile("Alice", 1000,"A", "","", "Executable file"));
		checks.add(new UserProfile("Bob", 100, "AD", "","","PDF"));
	    checks.add(new UserProfile("Eve", 1000, "ABC", "","","File"));
		checks.add(new UserProfile("Jim", 1000, "C", "","","PDF."));
		checks.add(new UserProfile("Maria", 44, "DS","","", "PDF."));
		
		checks.add(new UserProfile("Alice", 1000,"A", "","", "Executable file"));
		checks.add(new UserProfile("Bob", 100, "AD", "","","PDF"));
	    checks.add(new UserProfile("Eve", 980, "ABC", "","","File"));
		checks.add(new UserProfile("Jim", 1000, "C", "","","PDF."));
		checks.add(new UserProfile("Maria", 44, "DS","","", "PDF."));
		
		checks.add(new UserProfile("Alice", 1000,"A", "","", "Executable file"));
		checks.add(new UserProfile("Bob", 100, "AD", "","","PDF"));
	    checks.add(new UserProfile("Eve", 990, "ABC", "","","File"));
		checks.add(new UserProfile("Jim", 1000, "C", "","","PDF."));
		checks.add(new UserProfile("Maria", 44, "DS","","", "PDF."));
		
		checks.add(new UserProfile("Alice", 1000,"A", "","", "Executable file"));
		checks.add(new UserProfile("Bob", 100, "AD", "","","PDF"));
	    checks.add(new UserProfile("Eve", 1000, "ABC", "","","File"));
		checks.add(new UserProfile("Jim", 1000, "C", "","","PDF."));
		checks.add(new UserProfile("Maria", 44, "DS","","", "PDF."));
		
		checks.add(new UserProfile("Alice", 1000,"A", "","", "Executable file"));
		checks.add(new UserProfile("Bob", 100, "AD", "","","PDF"));
	    checks.add(new UserProfile("Eve", 1000, "ABC", "","","File"));
		checks.add(new UserProfile("Jim", 1000, "C", "","","PDF."));
		checks.add(new UserProfile("Maria", 44, "DS","","", "PDF."));
		
		checks.add(new UserProfile("Alice", 1000,"A", "","", "Executable file"));
		checks.add(new UserProfile("Bob", 100, "AD", "","","PDF"));
	    checks.add(new UserProfile("Eve", 1000, "ABC", "","","File"));
		checks.add(new UserProfile("Jim", 1000, "C", "","","PDF."));
		checks.add(new UserProfile("Maria", 44, "DS","","", "PDF."));
		
		checks.add(new UserProfile("Alice", 1000,"A", "","", "Executable file"));
		checks.add(new UserProfile("Bob", 100, "AD", "","","PDF"));
	    checks.add(new UserProfile("Eve", 1000, "ABC", "","","File"));
		checks.add(new UserProfile("Jim", 1000, "C", "","","PDF."));
		checks.add(new UserProfile("Maria", 44, "DS","","", "PDF."));
		
		checks.add(new UserProfile("Alice", 1000,"A", "","", "Executable file"));
		checks.add(new UserProfile("Bob", 100, "AD", "","","PDF"));
	    checks.add(new UserProfile("Eve", 1000, "ABC", "","","File"));
		checks.add(new UserProfile("Jim", 1000, "C", "","","PDF."));
		checks.add(new UserProfile("Maria", 44, "DS","","", "PDF."));
		
		checks.add(new UserProfile("Alice", 1000,"A", "","", "Executable file"));
		checks.add(new UserProfile("Bob", 100, "AD", "","","PDF"));
	    checks.add(new UserProfile("Eve", 1000, "ABC", "","","File"));
		checks.add(new UserProfile("Jim", 1000, "C", "","","PDF."));
		checks.add(new UserProfile("Maria", 44, "DS","","", "PDF."));
		
		checks.add(new UserProfile("Alice", 1000,"A", "","", "Executable file"));
		checks.add(new UserProfile("Bob", 100, "AD", "","","PDF"));
	    checks.add(new UserProfile("Eve", 1000, "ABC", "","","File"));
		checks.add(new UserProfile("Jim", 1000, "C", "","","PDF."));
		checks.add(new UserProfile("Maria", 44, "DS","","", "PDF."));
		
		checks.add(new UserProfile("Alice", 1000,"A", "","", "Executable file"));
		checks.add(new UserProfile("Bob", 100, "AD", "","","PDF"));
	    checks.add(new UserProfile("Eve", 1000, "ABC", "","","File"));
		checks.add(new UserProfile("Jim", 1000, "C", "","","PDF."));
		checks.add(new UserProfile("Maria", 44, "DS","","", "PDF."));
		
		checks.add(new UserProfile("Alice", 800,"A", "","", "Executable file"));
		checks.add(new UserProfile("Bob", 100, "AD", "","","PDF"));
	    checks.add(new UserProfile("Eve", 1000, "ABC", "","","File"));
		checks.add(new UserProfile("Jim", 1000, "C", "","","PDF."));
		checks.add(new UserProfile("Maria", 44, "DS","","", "PDF."));
		
	}
	
	/**
	 *  Get the user profile.
	 *  @return The user profile.
	 */
//	@ServiceStart
//	public IFuture<Void> startService1()
//	{
//		final Future<Void> net = new Future<Void>();
//		this.format = new SimpleDateFormat("hh:mm:ss");
//		final IExternalAccess exta = agent.getExternalAccess();
//		IFuture<ITranslationService>	transser	= agent.getComponentFeature(IRequiredServicesFeature.class).getRequiredService("transser");
//		transser.addResultListener(new ExceptionDelegationResultListener<ITranslationService, Void>(net)
//		{
//			public void customResultAvailable(ITranslationService result)
//			{
//				TranslationServiceBDI.this.check = result;
//				TranslationServiceBDI.this.gui = (TranslationGuiBDI) createGui(exta);
//				net.setResult(null);
//			}
//		});
//		
//		return net;
//	
//}
	
	
	public IFuture<UserProfile> getUserProfile()
	{
		if(profile==null)
			
		this.profile = (UserProfile)checks.get((int)(Math.random()*checks.size()));
//		gui.addMessage(agent.getComponentIdentifier().getLocalName()+" received at "
//				+format.format(new Date(clock.getTime()))+profile);
		
		return new Future<UserProfile>(profile);
	
	}
	
	/**
	 *  Create the gui.
	 */
	protected BobGuiBDI createGui(IExternalAccess agent)
	{
		return new TranslationGuiBDI(agent);
	} {

}

	
//	public IFuture<Resource.bdiv3.UserProfile> getUserProfile() {
//		if(profile==null)
//		// TODO Auto-generated method stub
//		this.profile = (UserProfile)checkes.get((int)(Math.random()*checkes.size()));
//		gui.addMessage(agent.getComponentIdentifier().getLocalName()+" received at "
//				+format.format(new Date(clock.getTime()))+profile);
//		return new Future<UserProfile>(profile);
//		
//	}
//	

	
	
	
}
