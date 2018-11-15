package Resource.bdiv3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
//import java.util.ArrayList;
import java.util.Date;
//import java.util.List;

import javax.swing.SwingUtilities;

//import ICheckService;
import jadex.bridge.IExternalAccess;
import jadex.bridge.IInternalAccess;
import jadex.bridge.service.annotation.ServiceComponent;
import jadex.bridge.service.annotation.ServiceShutdown;
import jadex.bridge.service.annotation.ServiceStart;
import jadex.bridge.service.component.IRequiredServicesFeature;
import jadex.bridge.service.types.clock.IClockService;
import jadex.commons.future.ExceptionDelegationResultListener;
import jadex.commons.future.Future;
import jadex.commons.future.IFuture;
//import jadex.commons.gui.future.SwingExceptionDelegationResultListener;

public class BobServiceBDI implements IlogSevice{

	private static final String UserProfile = null;

	/** The agent. */
	@ServiceComponent
	protected IInternalAccess agent;
	
	/** The clock service. */
	protected IClockService clock;
	
	//protected ICheckService check;
	
	/** The time format. */
	protected DateFormat format;
	
	/** The user interface. */
	protected BobGuiBDI gui;
	
	//-------- attributes --------
	
	/**
	 *  Init the service.
	 */
	@ServiceStart
	public IFuture<Void> startService()
	{
		final Future<Void> ret = new Future<Void>();
		this.format = new SimpleDateFormat("hh:mm:ss");
		final IExternalAccess exta = agent.getExternalAccess();
		IFuture<IClockService>	fut	= agent.getComponentFeature(IRequiredServicesFeature.class).getRequiredService("clockservice");
		fut.addResultListener(new ExceptionDelegationResultListener<IClockService, Void>(ret)
		{
			public void customResultAvailable(IClockService result)
			{
				BobServiceBDI.this.clock = result;
				BobServiceBDI.this.gui = createGui(exta);
				ret.setResult(null);
			}
		});
		return ret;
	
	}
	/*@ServiceStart
	public IFuture<Void> startService1()
	{
		final Future<Void> net = new Future<Void>();
		this.format = new SimpleDateFormat("hh:mm:ss");
		final IExternalAccess exta = agent.getExternalAccess();
		IFuture<ICheckService>	transser	= agent.getComponentFeature(IRequiredServicesFeature.class).getRequiredService("transser");
		transser.addResultListener(new ExceptionDelegationResultListener<ICheckService, Void>(net)
		{
			public void customResultAvailable(ICheckService result)
			{
				BobServiceBDI.this.check = result;
				BobServiceBDI.this.gui = createGui(exta);
				net.setResult(null);
			}
		});
		return net;
	
}*/
	
	/**
	 *  Init the service.
	 */
	@ServiceShutdown
	public void shutdownService()
	{
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run()
			{
				gui.dispose();
			}
		});
//		return IFuture.DONE;
	}
	
	/**
	 *  Receives a chat message.
	 *  @param sender The sender's name.
	 *  @param text The message text.
	 * @return 
	 */
	public  IFuture<String> message(final String sender, final String text, final String UserProfile)
	{
		//Object eword;
		gui.addMessage(agent.getComponentIdentifier().getLocalName()+" received at "
			+format.format(new Date(clock.getTime()))+" from: "+sender+" message: "+text+"type:"+UserProfile);
		//return null;
		return null;
		
	}
	

	/**
	 *  Create the gui.
	 */
	protected BobGuiBDI createGui(IExternalAccess agent)
	{
		return new BobGuiBDI(agent);
	}

	@Override
	public IFuture<Resource.bdiv3.UserProfile> getUserProfile() {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public IFuture<UserProfile> getUserProfile() {
		gui.addMessage(agent.getComponentIdentifier().getLocalName()+" received at "
				+format.format(new Date(clock.getTime()))+UserProfile);
			return null;		
	}*/


	
	
	
	
}
