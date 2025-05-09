package com.udacity.webcrawler.main;

import com.google.inject.Guice;
import com.udacity.webcrawler.WebCrawler;
import com.udacity.webcrawler.WebCrawlerModule;
import com.udacity.webcrawler.json.ConfigurationLoader;
import com.udacity.webcrawler.json.CrawlResult;
import com.udacity.webcrawler.json.CrawlResultWriter;
import com.udacity.webcrawler.json.CrawlerConfiguration;
import com.udacity.webcrawler.profiler.Profiler;
import com.udacity.webcrawler.profiler.ProfilerModule;

import javax.inject.Inject;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Path;
import java.util.Objects;

public final class WebCrawlerMain {

  private final CrawlerConfiguration config;

  private WebCrawlerMain(CrawlerConfiguration config) {
    this.config = Objects.requireNonNull(config);
  }

  @Inject
  private WebCrawler crawler;

  @Inject
  private Profiler profiler;

  private void run() throws Exception {
    Guice.createInjector(new WebCrawlerModule(config), new ProfilerModule()).injectMembers(this);

    CrawlResult result = crawler.crawl(config.getStartPages());
    CrawlResultWriter resultWriter = new CrawlResultWriter(result);
    // TODO: Write the crawl results to a JSON file (or System.out if the file name is empty)
    if(!config.getResultPath().isEmpty()) {
      Path pathWriterJSON = Path.of(config.getResultPath());
      resultWriter.write(pathWriterJSON);
    } else {
      Writer Stdwriter = new OutputStreamWriter(System.out);
      resultWriter.write(Stdwriter);
      Stdwriter.flush();
    }
    // TODO: Write the profile data to a text file (or System.out if the file name is empty)
    if(!config.getProfileOutputPath().isEmpty()) {
      Path pathWriterProfile = Path.of(config.getProfileOutputPath());
      profiler.writeData(pathWriterProfile);
    } else {
      // else for both is same
      Writer Stdwriter = new OutputStreamWriter(System.out);
      profiler.writeData(Stdwriter);
      Stdwriter.flush();
    }
  }

  public static void main(String[] args) throws Exception {
    if (args.length != 1) {
      System.out.println("Usage: WebCrawlerMain [starting-url]");
      return;
    }
//    ⚠️Important Note⚠️:
//    Getting NullPointerException because of FileNotFoundException if run using the given command,
//    ❌ java -classpath target/udacity-webcrawler-1.0.jar com.udacity.webcrawler.main.WebCrawlerMain src/main/config/sample_config_sequential.json
//
//    Need to run this command instead with the correct path to the config file,
//    ✅ java -classpath target/udacity-webcrawler-1.0.jar com.udacity.webcrawler.main.WebCrawlerMain src/main/java/com/udacity/webcrawler/main/config/sample_config_sequential.json
    CrawlerConfiguration config = new ConfigurationLoader(Path.of(args[0])).load();
    new WebCrawlerMain(config).run();
    System.out.println("If the WebCrawlerMain finished successfully,");
    System.out.println("Open profile data in the file: " + "starter/webcrawler/profileData.txt");
    System.out.println("Open crawl result in the file: " + "starter/webcrawler/resultOut.json");
  }
}
