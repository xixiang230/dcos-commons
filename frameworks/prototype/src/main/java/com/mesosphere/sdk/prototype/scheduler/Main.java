package com.mesosphere.sdk.prototype.scheduler;

import com.mesosphere.sdk.scheduler.SchedulerFlags;
import com.mesosphere.sdk.specification.DefaultService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * Prototype Framework.
 */
public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            LOGGER.error("Please provide a YAML file containing service specification.");
        }
        final String pathToServiceSpecification = args[0];
        LOGGER.info("Reading service specification from: {}", pathToServiceSpecification);
        final File serviceSpecificationFile = new File(args[0]);
        if (serviceSpecificationFile.exists()) {
            new DefaultService(serviceSpecificationFile, SchedulerFlags.fromEnv()).run();
        } else {
            LOGGER.error("Service specification file doesn't exist at location: {}", pathToServiceSpecification);
            System.exit(1);
        }
    }
}
