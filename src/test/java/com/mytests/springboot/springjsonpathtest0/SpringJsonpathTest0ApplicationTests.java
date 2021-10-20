package com.mytests.springboot.springjsonpathtest0;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.StandardCharsets;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.MOCK, classes={ SpringJsonpathTest0Application.class })
public class SpringJsonpathTest0ApplicationTests {
    
    /*
    @Test
    public void shouldCreateCompanyOnPost() throws Exception {
        mockMvc.perform(post("/createNewCompany")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"name\": \"superCompany\",\n" +
                                "  \"teams\": [\n" +
                                "    {\n" +
                                "      \"team_name\": \"frontend\",\n" +
                                "      \"lead\": {\n" +
                                "        \"name\": \"misha petrov\",\n" +
                                "        \"gender\": \"male\",\n" +
                                "        \"grade\": \"senior\",\n" +
                                "        \"role\": \"dev\",\n" +
                                "        \"lead\": true,\n" +
                                "        \"location\": {\n" +
                                "          \"city\": \"Moscow\",\n" +
                                "          \"country\": \"Russia\"\n" +
                                "        }\n" +
                                "      },\n" +
                                "      \"members\": [\n" +
                                "        {\n" +
                                "          \"name\": \"vasya ivanov\",\n" +
                                "          \"gender\": \"male\",\n" +
                                "          \"grade\": \"senior\",\n" +
                                "          \"role\": \"qa\",\n" +
                                "          \"lead\": false,\n" +
                                "          \"location\": {\n" +
                                "            \"city\": \"Moscow\",\n" +
                                "            \"country\": \"Russia\"\n" +
                                "          }\n" +
                                "        },\n" +
                                "        {\n" +
                                "          \"name\": \"valya petrova\",\n" +
                                "          \"gender\": \"female\",\n" +
                                "          \"grade\": \"junior\",\n" +
                                "          \"role\": \"qa\",\n" +
                                "          \"lead\": false,\n" +
                                "          \"location\": {\n" +
                                "            \"city\": \"Sankt-Petersburg\",\n" +
                                "            \"country\": \"Russia\"\n" +
                                "          }\n" +
                                "        },\n" +
                                "        {\n" +
                                "          \"name\": \"masha ivanova\",\n" +
                                "          \"gender\": \"female\",\n" +
                                "          \"grade\": \"senior\",\n" +
                                "          \"role\": \"qa\",\n" +
                                "          \"lead\": true,\n" +
                                "          \"location\": {\n" +
                                "            \"city\": \"Moscow\",\n" +
                                "            \"country\": \"Russia\"\n" +
                                "          }\n" +
                                "        },\n" +
                                "        {\n" +
                                "          \"name\": \"vera andreeva\",\n" +
                                "          \"gender\": \"female\",\n" +
                                "          \"grade\": \"senior\",\n" +
                                "          \"role\": \"dev\",\n" +
                                "          \"lead\": false,\n" +
                                "          \"location\": {\n" +
                                "            \"city\": \"Manchester\",\n" +
                                "            \"country\": \"UK\"\n" +
                                "          }\n" +
                                "        },\n" +
                                "        {\n" +
                                "          \"name\": \"masha sergeeva\",\n" +
                                "          \"gender\": \"female\",\n" +
                                "          \"grade\": \"junior\",\n" +
                                "          \"role\": \"dev\",\n" +
                                "          \"lead\": false,\n" +
                                "          \"location\": {\n" +
                                "            \"city\": \"Moscow\",\n" +
                                "            \"country\": \"Russia\"\n" +
                                "          }\n" +
                                "        },\n" +
                                "        {\n" +
                                "          \"name\": \"misha petrov\",\n" +
                                "          \"gender\": \"male\",\n" +
                                "          \"grade\": \"senior\",\n" +
                                "          \"role\": \"dev\",\n" +
                                "          \"lead\": true,\n" +
                                "          \"location\": {\n" +
                                "            \"city\": \"Moscow\",\n" +
                                "            \"country\": \"Russia\"\n" +
                                "          }\n" +
                                "        },\n" +
                                "        {\n" +
                                "          \"name\": \"misha sergeev\",\n" +
                                "          \"gender\": \"male\",\n" +
                                "          \"grade\": \"junior\",\n" +
                                "          \"role\": \"dev\",\n" +
                                "          \"lead\": false,\n" +
                                "          \"location\": {\n" +
                                "            \"city\": \"Manchester\",\n" +
                                "            \"country\": \"UK\"\n" +
                                "          }\n" +
                                "        }\n" +
                                "      ],\n" +
                                "      \"size\": 0\n" +
                                "    },\n" +
                                "    {\n" +
                                "      \"team_name\": \"server\",\n" +
                                "      \"lead\": {\n" +
                                "        \"name\": \"max andreev\",\n" +
                                "        \"gender\": \"male\",\n" +
                                "        \"grade\": \"senior\",\n" +
                                "        \"role\": \"dev\",\n" +
                                "        \"lead\": true,\n" +
                                "        \"location\": {\n" +
                                "          \"city\": \"Sankt-Petersburg\",\n" +
                                "          \"country\": \"Russia\"\n" +
                                "        }\n" +
                                "      },\n" +
                                "      \"members\": [\n" +
                                "        {\n" +
                                "          \"name\": \"vasya sidorov\",\n" +
                                "          \"gender\": \"male\",\n" +
                                "          \"grade\": \"junior\",\n" +
                                "          \"role\": \"qa\",\n" +
                                "          \"lead\": false,\n" +
                                "          \"location\": {\n" +
                                "            \"city\": \"Sankt-Petersburg\",\n" +
                                "            \"country\": \"Russia\"\n" +
                                "          }\n" +
                                "        },\n" +
                                "        {\n" +
                                "          \"name\": \"ivan semenov\",\n" +
                                "          \"gender\": \"male\",\n" +
                                "          \"grade\": \"senior\",\n" +
                                "          \"role\": \"qa\",\n" +
                                "          \"lead\": false,\n" +
                                "          \"location\": {\n" +
                                "            \"city\": \"Sankt-Petersburg\",\n" +
                                "            \"country\": \"Russia\"\n" +
                                "          }\n" +
                                "        },\n" +
                                "        {\n" +
                                "          \"name\": \"vika smirnova\",\n" +
                                "          \"gender\": \"female\",\n" +
                                "          \"grade\": \"junior\",\n" +
                                "          \"role\": \"qa\",\n" +
                                "          \"lead\": false,\n" +
                                "          \"location\": {\n" +
                                "            \"city\": \"London\",\n" +
                                "            \"country\": \"UK\"\n" +
                                "          }\n" +
                                "        },\n" +
                                "        {\n" +
                                "          \"name\": \"anya sokolova\",\n" +
                                "          \"gender\": \"female\",\n" +
                                "          \"grade\": \"senior\",\n" +
                                "          \"role\": \"qa\",\n" +
                                "          \"lead\": true,\n" +
                                "          \"location\": {\n" +
                                "            \"city\": \"Sankt-Petersburg\",\n" +
                                "            \"country\": \"Russia\"\n" +
                                "          }\n" +
                                "        },\n" +
                                "        {\n" +
                                "          \"name\": \"sergey krylov\",\n" +
                                "          \"gender\": \"male\",\n" +
                                "          \"grade\": \"senior\",\n" +
                                "          \"role\": \"dev\",\n" +
                                "          \"lead\": false,\n" +
                                "          \"location\": {\n" +
                                "            \"city\": \"Sankt-Petersburg\",\n" +
                                "            \"country\": \"Russia\"\n" +
                                "          }\n" +
                                "        },\n" +
                                "        {\n" +
                                "          \"name\": \"max andreev\",\n" +
                                "          \"gender\": \"male\",\n" +
                                "          \"grade\": \"senior\",\n" +
                                "          \"role\": \"dev\",\n" +
                                "          \"lead\": true,\n" +
                                "          \"location\": {\n" +
                                "            \"city\": \"Sankt-Petersburg\",\n" +
                                "            \"country\": \"Russia\"\n" +
                                "          }\n" +
                                "        },\n" +
                                "        {\n" +
                                "          \"name\": \"max novikov\",\n" +
                                "          \"gender\": \"male\",\n" +
                                "          \"grade\": \"junior\",\n" +
                                "          \"role\": \"dev\",\n" +
                                "          \"lead\": false,\n" +
                                "          \"location\": {\n" +
                                "            \"city\": \"London\",\n" +
                                "            \"country\": \"UK\"\n" +
                                "          }\n" +
                                "        }\n" +
                                "      ],\n" +
                                "      \"size\": 0\n" +
                                "    },\n" +
                                "    {\n" +
                                "      \"team_name\": \"qa\",\n" +
                                "      \"lead\": {\n" +
                                "        \"name\": \"vera dmitrieva\",\n" +
                                "        \"gender\": \"female\",\n" +
                                "        \"grade\": \"senior\",\n" +
                                "        \"role\": \"qa\",\n" +
                                "        \"lead\": true,\n" +
                                "        \"location\": {\n" +
                                "          \"city\": \"Sankt-Petersburg\",\n" +
                                "          \"country\": \"Russia\"\n" +
                                "        }\n" +
                                "      },\n" +
                                "      \"members\": [\n" +
                                "        {\n" +
                                "          \"name\": \"vasya ivanov\",\n" +
                                "          \"gender\": \"male\",\n" +
                                "          \"grade\": \"senior\",\n" +
                                "          \"role\": \"qa\",\n" +
                                "          \"lead\": false,\n" +
                                "          \"location\": {\n" +
                                "            \"city\": \"Moscow\",\n" +
                                "            \"country\": \"Russia\"\n" +
                                "          }\n" +
                                "        },\n" +
                                "        {\n" +
                                "          \"name\": \"valya petrova\",\n" +
                                "          \"gender\": \"female\",\n" +
                                "          \"grade\": \"junior\",\n" +
                                "          \"role\": \"qa\",\n" +
                                "          \"lead\": false,\n" +
                                "          \"location\": {\n" +
                                "            \"city\": \"Sankt-Petersburg\",\n" +
                                "            \"country\": \"Russia\"\n" +
                                "          }\n" +
                                "        },\n" +
                                "        {\n" +
                                "          \"name\": \"masha ivanova\",\n" +
                                "          \"gender\": \"female\",\n" +
                                "          \"grade\": \"senior\",\n" +
                                "          \"role\": \"qa\",\n" +
                                "          \"lead\": true,\n" +
                                "          \"location\": {\n" +
                                "            \"city\": \"Moscow\",\n" +
                                "            \"country\": \"Russia\"\n" +
                                "          }\n" +
                                "        },\n" +
                                "        {\n" +
                                "          \"name\": \"vasya sidorov\",\n" +
                                "          \"gender\": \"male\",\n" +
                                "          \"grade\": \"junior\",\n" +
                                "          \"role\": \"qa\",\n" +
                                "          \"lead\": false,\n" +
                                "          \"location\": {\n" +
                                "            \"city\": \"Sankt-Petersburg\",\n" +
                                "            \"country\": \"Russia\"\n" +
                                "          }\n" +
                                "        },\n" +
                                "        {\n" +
                                "          \"name\": \"ivan semenov\",\n" +
                                "          \"gender\": \"male\",\n" +
                                "          \"grade\": \"senior\",\n" +
                                "          \"role\": \"qa\",\n" +
                                "          \"lead\": false,\n" +
                                "          \"location\": {\n" +
                                "            \"city\": \"Sankt-Petersburg\",\n" +
                                "            \"country\": \"Russia\"\n" +
                                "          }\n" +
                                "        },\n" +
                                "        {\n" +
                                "          \"name\": \"vika smirnova\",\n" +
                                "          \"gender\": \"female\",\n" +
                                "          \"grade\": \"junior\",\n" +
                                "          \"role\": \"qa\",\n" +
                                "          \"lead\": false,\n" +
                                "          \"location\": {\n" +
                                "            \"city\": \"London\",\n" +
                                "            \"country\": \"UK\"\n" +
                                "          }\n" +
                                "        },\n" +
                                "        {\n" +
                                "          \"name\": \"anya sokolova\",\n" +
                                "          \"gender\": \"female\",\n" +
                                "          \"grade\": \"senior\",\n" +
                                "          \"role\": \"qa\",\n" +
                                "          \"lead\": true,\n" +
                                "          \"location\": {\n" +
                                "            \"city\": \"Sankt-Petersburg\",\n" +
                                "            \"country\": \"Russia\"\n" +
                                "          }\n" +
                                "        },\n" +
                                "        {\n" +
                                "          \"name\": \"vera dmitrieva\",\n" +
                                "          \"gender\": \"female\",\n" +
                                "          \"grade\": \"senior\",\n" +
                                "          \"role\": \"qa\",\n" +
                                "          \"lead\": true,\n" +
                                "          \"location\": {\n" +
                                "            \"city\": \"Sankt-Petersburg\",\n" +
                                "            \"country\": \"Russia\"\n" +
                                "          }\n" +
                                "        }\n" +
                                "      ],\n" +
                                "      \"size\": 0\n" +
                                "    },\n" +
                                "    {\n" +
                                "      \"team_name\": \"marketing\",\n" +
                                "      \"lead\": null,\n" +
                                "      \"members\": [],\n" +
                                "      \"size\": 0\n" +
                                "    }\n" +
                                "  ]\n" +
                                "}")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.teams[0].members.length()").value("7"))
                .andExpect(jsonPath("$.teams[1].members[1].name").value("ivan semenov"));
    }*/
}
