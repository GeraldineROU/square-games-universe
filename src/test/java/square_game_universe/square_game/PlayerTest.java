package square_game_universe.square_game;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import square_game_universe.square_game.player.PlayerDTORecord;
import square_game_universe.square_game.player.PlayerJPAEntity;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith({SpringExtension.class})
@SpringBootTest
@AutoConfigureMockMvc
public class PlayerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetReviewByIdFound() throws Exception {
        mockMvc.perform(get("/players"))

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                // Validate the returned fields
                .andExpect(jsonPath("$.length()", is(0)));
    }

//    @Test
//    void testCreateReview() throws Exception {
//        PlayerJPAEntity player = new PlayerJPAEntity("Baldr test");
//
//        mockMvc.perform(post("/players")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content("{\n" +
//                                "  \"name\": \"Baldr de test\"\n" +
//                                "}"))
//
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//
//                .andExpect(jsonPath("$.id", any(Integer.class)))
//                .andExpect(jsonPath("$.name", Matchers.is("Baldr de test")));
//    }
}
