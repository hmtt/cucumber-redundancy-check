package uk.co.hmtt.cucumber.redundancy;

import com.google.gson.Gson;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;



import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.Arrays.asList;
import static org.apache.commons.io.FileUtils.readFileToString;


public class RedundancyCheck {

    private static Logger logger = LoggerFactory.getLogger(RedundancyCheck.class);

    private static final String REPORT = "/target/";

    public static void main(String... args) throws IOException {
        final List<Definition> stepDefinitions = asList(new Gson().fromJson(loadReport(), Definition[].class));
        printRedundantSteps(stepDefinitions);
    }

    private static String loadReport() throws IOException {
        final Result result = new JUnitCore().run(Runner.class);
        if (result.wasSuccessful()) {
            return readFileToString(new File(System.getProperty("user.dir") + REPORT + "stepdefs.json"), "UTF-8");
        } else {
            throw new RuntimeException("Could not load Cucumber step definition file as generation was not successful");
        }
    }

    private static void printRedundantSteps(List<Definition> stepDefinitions) {
        stepDefinitions.
                stream().
                filter(p -> p.steps.length == 0).
                map(p -> p.source).
                forEach(source -> logger.info(source));
    }

    private static class Definition {
        private Steps[] steps;
        private String source;
        public void setSteps(Steps[] steps) {
            this.steps = steps;
        }
        public void setSource(String source) {
            this.source = source;
        }
    }

    private static class Steps {
        private String name;
        public void setName(String name) {
            this.name = name;
        }
    }

    @RunWith(Cucumber.class)
    @CucumberOptions(glue = "uk.co.hmtt.cucumber.redundancy.steps", features = {"classpath:features"}, dotcucumber = "." + REPORT, format = "usage", monochrome = true, dryRun = true)
    public class Runner {
    }

}
