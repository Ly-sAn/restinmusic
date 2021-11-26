package com.example.restinmusic;

import com.example.restinmusic.controllers.SongController;
import com.example.restinmusic.repositories.ISongRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = SongController.class)
class SongControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ISongRepository songRepository;

    @Test
    public void testGetAll() throws Exception {
        mockMvc.perform(get("/songs"))
                .andExpect(status().isOk());
    }

    @Test
    public void testgetOneById() throws Exception {
        mockMvc.perform(get("/songs/8"))
                .andExpect(status().isOk());
    }



}
