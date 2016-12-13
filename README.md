### Overview

The redundancy checker is a class that will report any implemented steps that are not referenced via a feature file. This is userful for identifying redundant code that may no longer be called; for example the scenario may have changed or been removed.

#This solution will only work for Cucumber 1.1.8 and before. The functionality on which it is based has been removed from subsequent versions of Cucumber. We may look to support more current versions in the future.#

The redundancy checker class is RedundancyCheck.java. It can be copied into your Cucumber JVM project and run as a main class. It runs a Cucumber JUnit test which is configured at the bottom of the class. The glue and feature attributes should be amended to appropriate values for your project.

```
@RunWith(Cucumber.class)
@CucumberOptions(
  glue = "uk.co.hmtt.cucumber.redundancy.steps", 
  features = {"classpath:features"}, 
  dotcucumber = "." + REPORT, format = "usage", 
  monochrome = true, 
  dryRun = true)
    public class Runner {}
```

#### Sonar Report

https://sonarqube.com/dashboard/index?id=uk.co.hmtt%3Acucumber-redundancy-check
