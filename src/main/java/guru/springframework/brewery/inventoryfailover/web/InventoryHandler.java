package guru.springframework.brewery.inventoryfailover.web;

import guru.springframework.brewery.inventoryfailover.web.model.BeerInventoryDto;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author cevher
 */
@Component
public class InventoryHandler {

    public Mono<ServerResponse> listInventory(ServerRequest request) {
        List<BeerInventoryDto> inventory = List.of(BeerInventoryDto.builder().id(UUID.randomUUID())
                .createdDate(OffsetDateTime.now())
                .lastModifiedDate(OffsetDateTime.now())
                .quantityOnHand(999)
                .beerId(new UUID(0, 0))
                .build());
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(inventory), List.class);
    }
}
