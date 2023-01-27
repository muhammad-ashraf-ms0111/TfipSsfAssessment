package com.nusiss.tfip.TfipSsfAssessment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.nusiss.tfip.TfipSsfAssessment.model.DeliveryDetails;
import com.nusiss.tfip.TfipSsfAssessment.model.OrderForm;


@Qualifier("orderService")
@Service
public class OrderService {
    private static final String ORDER_ENTITY = "orderlist";

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    public void save(final OrderForm ord){
        redisTemplate.opsForList()
            .leftPush(ORDER_ENTITY, ord.getId());
        redisTemplate.opsForHash()
            .put( ORDER_ENTITY+ "_Map", ord.getId(), ord);
    }

    public void save(final DeliveryDetails dd){
      redisTemplate.opsForList()
          .leftPush(ORDER_ENTITY, dd.getId());
      redisTemplate.opsForHash()
          .put( ORDER_ENTITY+ "_Map", dd.getId(), dd);
  }
}
