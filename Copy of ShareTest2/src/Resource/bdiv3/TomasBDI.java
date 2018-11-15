package Resource.bdiv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

//import ICheckService;
import jadex.bdiv3.annotation.Belief;
import jadex.bdiv3.annotation.Goal;
import jadex.bdiv3.annotation.GoalTargetCondition;
import jadex.bdiv3.annotation.Goals;
import jadex.bdiv3.annotation.Plan;
import jadex.bdiv3.annotation.PlanBody;
import jadex.bdiv3.annotation.PlanPrecondition;
import jadex.bdiv3.annotation.Publish;
import jadex.bdiv3.annotation.ServiceTrigger;
import jadex.bdiv3.annotation.Trigger;
import jadex.bdiv3.features.IBDIAgentFeature;
import jadex.bdiv3.runtime.impl.PlanFailureException;
import jadex.bridge.IComponentStep;
import jadex.bridge.IInternalAccess;
import jadex.bridge.service.component.IRequiredServicesFeature;
import jadex.bridge.service.types.clock.IClockService;
import jadex.commons.future.DefaultResultListener;
import jadex.commons.future.IFuture;
import jadex.commons.future.IIntermediateFuture;
import jadex.commons.future.IIntermediateResultListener;
import jadex.micro.annotation.Agent;
import jadex.micro.annotation.AgentBody;
import jadex.micro.annotation.AgentCreated;
import jadex.micro.annotation.Binding;
import jadex.micro.annotation.Description;
import jadex.micro.annotation.Implementation;
import jadex.micro.annotation.ProvidedService;
import jadex.micro.annotation.ProvidedServices;
import jadex.micro.annotation.RequiredService;
import jadex.micro.annotation.RequiredServices;

@Description("This agent provides a basic log and communication service.")
@Agent
@ProvidedServices(@ProvidedService(type=IlogSevice.class, 
	implementation=@Implementation(value=AliceServiceBDI.class)))
@RequiredServices({
	@RequiredService(name="clockservice", type=IClockService.class, 
		binding=@Binding(scope=Binding.SCOPE_PLATFORM)),
	@RequiredService(name="chatservices", type=IlogSevice.class, multiple=true,
		binding=@Binding(dynamic=true, scope=Binding.SCOPE_GLOBAL)),
	@RequiredService(name="transser", type=ITranslationService.class, multiple=true,
	binding=@Binding(dynamic=true,scope=Binding.SCOPE_PLATFORM))
})
//@Goals(@Goal(clazz=UserProfile.class,publish=@Publish(type=ITranslationService.class)))

public class TomasBDI{
	@Agent
	protected IInternalAccess agent;
	/** The sample. */
	/*protected Map<String, String> wordtable;
     @Belief
     protected Object Domain;
     //define rules 
      //define norm
	//-------- methods --------
	//protected Object eword;

	@AgentCreated
	public void init()
	{
//		System.out.println("Created: "+this);
		this.wordtable = new HashMap<String, String>();
		this.wordtable.put("Alice", "1000");
		this.wordtable.put("Bob", "1000");
		this.wordtable.put("P2", "200");
		this.wordtable.put("P1", "50");
		this.wordtable.put("Eve", "1000");
	}
	
	*/
/*	@AgentBody
	public void executeBody()
	{
		
		
		IFuture<Collection<IlogSevice>>	chatservices= agent.getComponentFeature(IRequiredServicesFeature.class).getRequiredServices("chatservices");
		chatservices.addResultListener(new DefaultResultListener<Collection<IlogSevice>>()
		{
			public void resultAvailable(Collection<IlogSevice> result)
			{
				for(Iterator<IlogSevice> it=result.iterator(); it.hasNext(); )
				{ 
					IlogSevice cs = it.next();
					cs.message(agent.getComponentIdentifier().getName(), "Consider Bob's application for collaboration","");
				}
			}
		});*/
		/*IFuture<Collection<ITranslationService>>	transser= agent.getComponentFeature(IRequiredServicesFeature.class).getRequiredServices("transser");
		transser.addResultListener(new DefaultResultListener<Collection<ITranslationService>>()
		{
			@Override
	        public void resultAvailable(Collection<ITranslationService> arg0) {
				for(Iterator<ITranslationService> it=arg0.iterator(); it.hasNext(); )
				{
					ITranslationService cs = it.next();
					cs.translateEnglishGerman(agent.getComponentIdentifier().getName());
				}

	        }
			
		});*/
	}
	/*@Plan(trigger=@Trigger(goals=UserProfile.class))
	public String chckPlan(String eword)
	{ 
		if (wordtable.get(eword) == target) {
			System.out.println("No cheating");
		}
		else{
			System.out.println("cheating happend");
		}
		
		return wordtable.get(eword);
			  
	}
*/

	/*@Override
	public void message(String sender, String text, String sample) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public IFuture<String> message(String eword) {
		// TODO Auto-generated method stub
		return null;
	}*/


		

