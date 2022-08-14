package tests;


import lombok.extern.log4j.Log4j2;
import models.Car;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.Test;

@Log4j2

public class SimpleTest {

    //   Logger logger = LoggerFactory.getLogger(SimpleTest.class);


    @Test
    public void Test2() {
        //  Car bmw = new Car("bmw", "7", 50000);
        // System.out.println(bmw.getMake());

        //


        //Car honda = new Car("Honda", "civic", 50000);
        // System.out.println(honda);

    }

    @Test
    public void Test3() throws Exception {
        // Car car = Car.builder()
        //    .make("adf").model("8").build();

        Car car = Car.builder().withModel("8").build();
        log.fatal("Fatal");
        log.error("Error");
        log.warn("Warm");
        log.info("Info");
        log.debug("Debug");
        log.trace("Trace");

        try {
            throw new StaleElementReferenceException("Unable to click element with locator//div.....");
            // Car.builder().build();
            //any action
        } catch (StaleElementReferenceException exception) {
            log.error(exception.getLocalizedMessage());
            throw new Exception("Was not lable to click ..... button");
        }

    }


}
