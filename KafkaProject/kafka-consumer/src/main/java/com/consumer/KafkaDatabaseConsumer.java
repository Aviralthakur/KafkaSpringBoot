package com.consumer;

import com.consumer.entity.WikiMedia;
import com.consumer.repository.WikiMediaDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    @Autowired
    private WikiMediaDao wikiMediaDao;

    private static final Logger logger= LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    @KafkaListener(topics = "wikimedia_recentchange" , groupId = "myGroup")
    public void consume(String eventMessage){
     logger.info("Message recieved-> {}",eventMessage);

        WikiMedia wikiMedia=new WikiMedia();
        wikiMedia.setWikiEventData(eventMessage);

        wikiMediaDao.save(wikiMedia);
    }
}
