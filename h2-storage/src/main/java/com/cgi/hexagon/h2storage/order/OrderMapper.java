package com.cgi.hexagon.h2storage.order;

import com.cgi.hexagon.businessrules.order.Order;
import com.cgi.hexagon.h2storage.user.H2UserStorage;
import com.cgi.hexagon.h2storage.user.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {

    MapConverter converter = new MapConverter();

    UserMapper userMapper = new UserMapper();

    @Autowired
    H2UserStorage userStorage;

    public AssemblyOrder fromOrder(Order order) {
        return new AssemblyOrder(order.getId())
                .withStatus(order.getStatus())
                .withGoodsId(order.getGoodsId())
                .withAssembler(null == order.getAssembler()?null:order.getAssembler().getId())
                .withQuantity(order.getQuantity())
                .withMetadata(converter.convertToDatabaseColumn(order.getMetadata()))
                .withRealizationDate(order.getRealizationDate());
    }

    public Order fromEntity(AssemblyOrder orderEntity) {
        return new Order()
                .withId(orderEntity.getId())
                .withStatus(orderEntity.getStatus())
                .withGoodsId(orderEntity.getGoodsId())
                .withAssembler(null == orderEntity.getAssembler() || 0 == orderEntity.getAssembler()?null:userStorage.load(orderEntity.getAssembler()))
                .withQuantity(orderEntity.getQuantity())
                .withMetadata(converter.convertToEntityAttribute(orderEntity.getMetadata()))
                .withRealizationDate(orderEntity.getRealizationDate());
    }
}
