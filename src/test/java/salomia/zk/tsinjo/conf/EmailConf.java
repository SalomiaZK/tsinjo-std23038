package salomia.zk.tsinjo.conf;

import org.springframework.test.context.DynamicPropertyRegistry;
import salomia.zk.tsinjo.PojaGenerated;

@PojaGenerated
public class EmailConf {

  void configureProperties(DynamicPropertyRegistry registry) {
    registry.add("aws.ses.source", () -> "dummy-ses-source");
  }
}
