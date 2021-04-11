package org.learn.springbootlearn.schedulingtasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {
	private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	private static final SimpleDateFormat dataFormat = new SimpleDateFormat("HH:mm:ss");

	@Schedules({@Scheduled(fixedRate = 600000), @Scheduled(fixedRate = 3600000)})
	private void reportCurrentTime() {
		log.info("Time is now {}", dataFormat.format(new Date()));
	}
}
