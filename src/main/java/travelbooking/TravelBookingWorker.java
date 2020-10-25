package travelbooking;

import java.util.logging.Logger;
import org.camunda.bpm.client.ExternalTaskClient;

public class TravelBookingWorker
{
    private final static Logger LOGGER = Logger.getLogger(TravelBookingWorker.class.getName());

    public static void main(String[] args)
    {
        ExternalTaskClient client = ExternalTaskClient.create()
                .baseUrl("http://localhost:8080/engine-rest")
                .asyncResponseTimeout(10000) // long polling timeout
                .build();
        LOGGER.info("Not yet any travel requests");

        // subscribe to an external task topic as specified in the process
        client.subscribe("testy")
                .lockDuration(1000) // the default lock duration is 20 seconds, but you can override this
                .handler((externalTask, externalTaskService) -> {
                    // Put your business logic here
                    System.out.println("Every request received is approved for travel: ");
                    // Get a process variable
                    String countryColor = (String) externalTask.getVariable("countryColor");

                    LOGGER.info(countryColor);

                    // Complete the task
                    externalTaskService.complete(externalTask);
                })
                .open();
    }
}
