package square_game_universe.square_game.player;

import org.mapstruct.*;
import org.springframework.stereotype.Component;


@Mapper(componentModel = "spring")
public interface PlayerMapper {

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePlayerFromDto(PlayerDTO playerDTO, @MappingTarget PlayerJPAEntity playerJPAEntity);
}
