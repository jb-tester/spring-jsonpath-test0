package com.mytests.springboot.springjsonpathtest0;

import com.mytests.springboot.springjsonpathtest0.forMockTest.Person;
import com.mytests.springboot.springjsonpathtest0.forMockTest.PersonService;
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
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }
    @MockBean
    PersonService service;

    @Test
    public void shouldCreatePersonJson() throws Exception {

        when(service.savePerson(any(Person.class))).thenReturn("100");

        mockMvc.perform(post("/createPerson")
                        .contentType(MediaType.APPLICATION_JSON)
                        //.contentType("application/json")
                        .content("{ \"name\": \"vasya\", \"familyName\": \"petrov\", \"age\": 25 }")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(header().string("pid", "/person/100"))
                .andExpect(jsonPath("$.name").value("vasya"))
                .andExpect(jsonPath("$.familyName").value("petrov"))
                .andExpect(jsonPath("$.age").value(25));
    }
    @Test
    public void shouldCreatePersonXML() throws Exception {

        when(service.savePerson(any(Person.class))).thenReturn("100");

        String xml = "<person>\n" +
                "    <name>vasya</name>\n" +
                "    <familyName>petrov</familyName>\n" +
                "    <age>25</age>\n" +
                "</person>";
        mockMvc.perform(post("/createPerson")
                        .contentType(MediaType.APPLICATION_XML)
                        //.contentType("application/xml")
                        //.content(xml.getBytes(StandardCharsets.UTF_8))
                        .content(xml)
                        .accept(MediaType.APPLICATION_XML))
                .andExpect(status().isCreated())
                .andExpect(content().contentType("application/xml;charset=UTF-8"))
                .andExpect(header().string("pid", "/person/100"))
                .andExpect(xpath("/Person/name").string("vasya"))
                .andExpect(content().string("<Person><id/><name>vasya</name><familyName>petrov</familyName><age>25</age></Person>"))
                .andExpect(content().xml("<Person><id/><name>vasya</name><familyName>petrov</familyName><age>25</age></Person>"));

    }


    /*@Test
    public void small() throws Exception{
        mockMvc.perform(post("/createNewCompany")
                .contentType(MediaType.APPLICATION_XML)
                .content("<company>\n" +
                        "    \n" +
                        "</company>")
                .accept(MediaType.APPLICATION_XML))
                .andExpect(status().isCreated());
    }
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
