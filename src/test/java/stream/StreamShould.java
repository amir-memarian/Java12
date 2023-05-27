package stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import player.Player;
import player.PlayerTestHelper;

import java.util.List;
import java.util.stream.Collectors;

public class StreamShould {
    @Test
    void have_many_collectors() {
        PlayerTestHelper scorers = new PlayerTestHelper();

        List<String> result = scorers.getPlayers().stream()
                .collect(Collectors.teeing(
                        Collectors.mapping(Player::getGoal, Collectors.averagingDouble(goal -> goal)),
                        Collectors.mapping(Player::toString, Collectors.toSet()),
                        (average, playerInfo) -> playerInfo.stream()
                                .map(pi -> pi.replace("Player","")
//                                        .replace("{","")
                                        .replace("}","") +
                                        "/" + average+"}").collect(Collectors.toList())
                ));
        System.out.println(result);
        Assertions.assertThat(result.toString())
                .isEqualTo("[{name='Lionel Messi', goal=102/106.2}, {name='Mokhtar Dahari', goal=89/106.2}, {name='Ali Daei', goal=109/106.2}, {name='Cristiano Ronaldo', goal=122/106.2}]");
    }
}
