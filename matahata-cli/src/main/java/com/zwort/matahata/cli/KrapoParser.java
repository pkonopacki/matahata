package com.zwort.matahata.cli;

import java.util.List;

import com.zwort.matahata.cli.file.FileParser;
import com.zwort.matahata.cli.file.FileParserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.zwort.matahata.cli.model.Item;
import com.zwort.matahata.cli.validator.ArgListValidator;
import com.zwort.matahata.cli.validator.InputValidator;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.inject.Inject;


/**
 * Enterprise Application Client main class.
 *
 */
@Component
public class KrapoParser {

    private static final String CONFIG_PATH = "classpath*:applicationContext.xml";

    @Inject
    private ServiceInvoker serviceInvoker;

    public ServiceInvoker getServiceInvoker() {
        return serviceInvoker;
    }

    public static void main( String[] args ) {

       // KrapoParser krapoParser = new KrapoParser();
        final ApplicationContext ctx = new ClassPathXmlApplicationContext(CONFIG_PATH);
        final KrapoParser krapoParser = ctx.getBean(KrapoParser.class);

        String usage = ArgListValidator.validateArgList(args);

        if (!"".equals(usage)) {
            System.out.print(usage);
            System.exit(1);
        }

        FileParserFactory factory = new FileParserFactory();
        FileParser parser = factory.createFileParser(args[0]);
        List<Item> itemsList = parser.readItems(args[0]);

        //TODO: Better error handling - parse errors

        List<String> errorsList = InputValidator.validate(itemsList);

        if (!errorsList.isEmpty()) {
            System.out.println("Validation errors:");

            for (String errMsg : errorsList) {
                System.out.println(errMsg);
                System.exit(1);
            }
        }

        //for (Item ite : itemsList) {
        //	System.out.print(ite.getType());
        //}

        //ServiceInvoker serviceInvoker = (ServiceInvoker) ctx.getBean("serviceInvoker");

        try {
            krapoParser.getServiceInvoker().invokeService(itemsList);

        } catch (ServiceInvokerException e) {
            System.out.println( "Exception while invoking service");
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println( "Krapoparser finished successfuly :)");
        System.exit(0);

	}

}
//    	for(Item i : itemsList) {
//    		RequestBase req = null;
//    		
//    		try {
//        		req = factory.create(i, i.getType());
//        		
//        	} catch (TransformationException te) {
//        		System.err.println("Error during transformation" + te.getMessage());
//        		te.printStackTrace();
//        	}	
//    		
//        	if (req instanceof AddIncomeRequest) {
//        		AddIncomeRequest incomeRequest = (AddIncomeRequest) req;
//            	System.out.print("\nType AddIncomeRequest" + incomeRequest);
//        		
//        	} else if (req instanceof AddTransferRequest) {
//        		AddTransferRequest transferRequest = (AddTransferRequest) req;
//            	System.out.print("\nType AddTransferRequest" + transferRequest);
//        		
//        	} else if (req instanceof AddExpenseRequest) {
//        		AddExpenseRequest expenseRequest = (AddExpenseRequest) req;
//            	System.out.print("\nType AddExpenseRequest" + expenseRequest);
//        		
//        	} else {
//        		
//        	}
//        	SYSTEM.OUT.PRINT("\NTYPE " + I.GETTYPE());
//    		SYSTEM.OUT.PRINT("\NDATE " + I.GETDATE());
//    		SYSTEM.OUT.PRINT("\NDESC " + I.GETDESCRIPTION());
//    		SYSTEM.OUT.PRINT("\NSRCACCOUNT " + I.GETSRCACCOUNTNO());
//    		SYSTEM.OUT.PRINT("\NDESTACCOUNT " + I.GETDESTACCOUNTNO());
//    		SYSTEM.OUT.PRINT("\NAMOUNT " + I.GETAMOUNT());
//    		SYSTEM.OUT.PRINT("\NLOCATION " + I.GETLOCATION());
//    		SYSTEM.OUT.PRINT("\NREFUNDABLE " + I.GETREFUNDABLE());
//    		SYSTEM.OUT.PRINT("\NCLEARED " + I.GETCLEARED());
//    		SYSTEM.OUT.PRINT("\NDEBT " + I.GETDEBT());
//    		SYSTEM.OUT.PRINT("\NORIGINALAMOUNT " + I.GETORIGINALAMOUNT());
//    		SYSTEM.OUT.PRINT("\NORIGINALCURRENCY " + I.GETORIGINALCURRENCY());
//    		SYSTEM.OUT.PRINT("\N\N");
    	
//    	ClientProxyFactoryBean factory = new JaxWsProxyFactoryBean();
//    	
//    	factory.getInInterceptors().add(new LoggingInInterceptor());
//    	factory.getOutInterceptors().add(new LoggingOutInterceptor());
//    	factory.setServiceClass(ExpenseManagementPortType.class);
//    	factory.setAddress("http://localhost:8080/matahata-core-wtp-ws/ExpenseManagementHttpPort");
//    	
//    	ExpenseManagementPortType serviceClient = (ExpenseManagementPortType) factory.create();
//    	Client proxy = ClientProxy.getClient(serviceClient);
    	
//    	ExpenseManagementImplService service = new ExpenseManagementImplService();
//    	ExpenseManagement port = service.getExpenseManagementImplPort();
//    	
//    	FindExpenseResponse resp  = port.findAllExpenses();
//    	
//    	FindExpenseResponse resp = serviceClient.findAllExpenses();
//    	System.out.println(resp);
//    	