package Resource.bdiv3;




import jadex.bdiv3.annotation.Body;
import jadex.bdiv3.annotation.Goal;
import jadex.bdiv3.annotation.Goals;
import jadex.bdiv3.annotation.Plan;
import jadex.bdiv3.annotation.Plans;
import jadex.bdiv3.annotation.ServicePlan;
import jadex.bdiv3.annotation.Trigger;
import jadex.bdiv3.features.IBDIAgentFeature;
import jadex.bridge.IComponentStep;
import jadex.bridge.IExternalAccess;
import jadex.bridge.IInternalAccess;
import jadex.bridge.component.IExecutionFeature;
import jadex.bridge.service.RequiredServiceInfo;
import jadex.bridge.service.annotation.Service;
import jadex.bridge.service.component.IRequiredServicesFeature;
import jadex.bridge.service.types.clock.IClockService;
import jadex.commons.future.DefaultResultListener;
import jadex.commons.future.IFuture;
import jadex.commons.future.IIntermediateFuture;
import jadex.commons.future.IIntermediateResultListener;
import jadex.commons.gui.PropertiesPanel;
import jadex.commons.gui.SGUI;
import jadex.micro.annotation.Agent;
import jadex.micro.annotation.AgentBody;
import jadex.micro.annotation.AgentKilled;
import jadex.micro.annotation.Binding;
import jadex.micro.annotation.Implementation;
import jadex.micro.annotation.ProvidedService;
import jadex.micro.annotation.ProvidedServices;
import jadex.micro.annotation.RequiredService;
import jadex.micro.annotation.RequiredServices;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

/**
 *  Agent that presents a gui and sends translation requests
 *  via goal delegation to the translation agent.
 */
/*@Agent
@Service
@ProvidedServices(@ProvidedService(type=ITranslationService.class, 
implementation=@Implementation(value=TranslationServiceBDI.class)))
@RequiredServices({
@RequiredService(name="clockservice", type=IClockService.class, 
	binding=@Binding(scope=Binding.SCOPE_PLATFORM)),
@RequiredService(name="chatservices", type=ITranslationService.class, multiple=true,
	binding=@Binding(dynamic=true, scope=Binding.SCOPE_GLOBAL)),
@RequiredService(name="transser", type=ITranslationService.class, multiple=true,
binding=@Binding(dynamic=true,scope=Binding.SCOPE_PLATFORM))
})

@Goals(@Goal(clazz=TranslationGoal.class))
@Plans(@Plan(trigger=@Trigger(goals=TranslationGoal.class), body=@Body(service=@ServicePlan(name="transser"))))*/


public class TranslationGuiBDI extends BobGuiBDI
{
	
	//-------- methods ---------

	/**
	 *  The plan body.
	 */
	
		
	
	public TranslationGuiBDI(final IExternalAccess agent)
    {
        super(agent);
        JButton Checks = new JButton("Checks");
        JPanel p = new JPanel();//new BorderLayout());
        p.add(Checks);//, BorderLayout.CENTER);
        getContentPane().add(p, BorderLayout.NORTH);
        Checks.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                agent.scheduleStep(new IComponentStep<Void>()
                {
                    public IFuture<Void> execute(IInternalAccess ia)
                    {
                        IFuture<Collection<ITranslationService>>    transser    = ia.getComponentFeature(IRequiredServicesFeature.class).getRequiredServices("transser");
                        transser.addResultListener(new DefaultResultListener<Collection<ITranslationService>>()
                        {
                            public void resultAvailable(Collection<ITranslationService> result)
                            {
                                for(Iterator<ITranslationService> it=result.iterator(); it.hasNext(); )
                                {
                                    ITranslationService cs = it.next();
                                    cs.getUserProfile().addResultListener(new DefaultResultListener<UserProfile>()
                                    {
                                        public void resultAvailable(UserProfile result)
                                        {
                                            addMessage(result.toString());
                                        }
                                    });
                                }
                            }
                        });
                        return IFuture.DONE;
                    }
                });
            }
        });
	}
}


				
			
