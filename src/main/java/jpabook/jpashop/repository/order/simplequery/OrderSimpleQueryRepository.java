package jpabook.jpashop.repository.order.simplequery;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderSimpleQueryRepository {

    private final EntityManager em;

    public List<OrderSimpleQueryDto> findOrderDtos() {  //일반 repository가 아닌 페치조인같은 데이터를 뽑아내는용도는 따로 dto를 만든다
        return em.createQuery(
                        "select new jpabook.jpashop.repository.order.simplequery.OrderSimpleQueryDto(o.id, m.name, o.orderDate, o.status, d.address)"+
                                " from Order o" +
                                " join o.member m"+
                                " join o.delivery d", OrderSimpleQueryDto.class)
                .getResultList();
    }

}
