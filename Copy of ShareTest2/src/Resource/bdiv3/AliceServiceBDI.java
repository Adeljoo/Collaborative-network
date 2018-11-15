package Resource.bdiv3;


import jadex.micro.annotation.Agent;

/*import jadex.micro.annotation.AgentBody;
import jadex.micro.annotation.AgentCreated;
import jadex.micro.annotation.Binding;
import jadex.micro.annotation.Implementation;
import jadex.micro.annotation.ProvidedService;
import jadex.micro.annotation.ProvidedServices;
import jadex.micro.annotation.RequiredService;
import jadex.micro.annotation.RequiredServices;

import jadex.bdiv3.annotation.Plan;
import jadex.bdiv3.annotation.Plans;
import jadex.bdiv3.annotation.Trigger;
//import jadex.bdiv3.examples.marsworld.producer.IProduceService;
import jadex.bdiv3.features.IBDIAgentFeature;
import jadex.bdiv3.runtime.IPlan;
import jadex.bridge.service.RequiredServiceInfo;*/
import jadex.bridge.service.annotation.Service;
import jadex.commons.future.Future;
import jadex.commons.future.IFuture;
//import jadex.commons.future.IResultListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.Map;

import jadex.bridge.IExternalAccess;
import jadex.bridge.IInternalAccess;
import jadex.bridge.service.annotation.ServiceComponent;
import jadex.bridge.service.annotation.ServiceStart;
import jadex.bridge.service.component.IRequiredServicesFeature;
import jadex.bridge.service.types.clock.IClockService;
import jadex.commons.future.ExceptionDelegationResultListener;
@Agent
@Service

public class AliceServiceBDI implements IlogSevice {
private static final String UserProfile = null;

/* Alice, make a proposal. 
 * send a certificate,
 * */
	@ServiceComponent
	protected IInternalAccess agent;
	
	/** The clock service. */
	protected IClockService clock;
	/** The check service. */
	protected ITranslationService check;
	/** The time format. */
	protected DateFormat format;
	
	/** The user interface. */
	protected AliceGuiBDI gui;
	@ServiceStart
	public IFuture<Void> startService()
	{
		
	
		final Future<Void> ret = new Future<Void>();
		final Future<Void> net = new Future<Void>();
		this.format = new SimpleDateFormat("hh:mm:ss");
		final IExternalAccess exta = agent.getExternalAccess();
		{
		IFuture<IClockService>	fut	= agent.getComponentFeature(IRequiredServicesFeature.class).getRequiredService("clockservice");
		
		fut.addResultListener(new ExceptionDelegationResultListener<IClockService, Void>(ret)
		{
			public void customResultAvailable(IClockService result)
			{
				AliceServiceBDI.this.clock = result;
				AliceServiceBDI.this.gui = createGui(exta);
				ret.setResult(null);
			}
			
		});
		
		/*IFuture<ITranslationService>	fut1	= agent.getComponentFeature(IRequiredServicesFeature.class).getRequiredService("transee");
		fut.addResultListener( null, new ExceptionDelegationResultListener<ITranslationService, Void>(net)
		{
			public void customResultAvailable(ITranslationService result)
			{
				AliceServiceBDI.this.check = result;
				AliceServiceBDI.this.gui = createGui(exta);
				ret.setResult(null);
			}
		});*/
		return ret;
		}
}
		
	
	
	/**
	 *  Receives a chat message.
	 *  @param sender The sender's name.
	 *  @param text The message text.
	 * @return 
	 */
	public IFuture<String> message(final String sender, final String text,final String UserProfile)
	{
	//	Object eword;
		gui.addMessage(agent.getComponentIdentifier().getLocalName()+" received at "
			+format.format(new Date(clock.getTime()))+" from: "+sender+" message: "+text+"type:"+UserProfile);
		return null;
	}

	/*public IFuture<String> translateEnglishGerman(final String sender, final String text,final String eword)
	{
	//	Object eword;
		gui.addMessage(agent.getComponentIdentifier().getLocalName()+" received at "
			+format.format(new Date(clock.getTime()))+" from: "+sender+" message: "+text+"tttt"+sender+"type:"+eword);
		return null;
	}
*/
	/**
	 *  Create the gui.
	 */
	protected AliceGuiBDI createGui(IExternalAccess agent)
	{
		return new AliceGuiBDI(agent);
	}

	public IFuture<UserProfile> getUserProfile() {
		String profile = null;
		gui.addMessage(agent.getComponentIdentifier().getLocalName()+" received at "
				+format.format(new Date(clock.getTime()))+profile);
			return null;		
	}


	
	
	
	
}
	

