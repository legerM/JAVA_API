package com.campus.demo.testThymeleaf;



import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class ApplicationTests {

    @Test
    void contextLoads() {
    }
    @Autowired
    private TestRestTemplate testRestTemplate;

    
    
    
    @Test
    public void TestAll(){
        
        //getALLCARS
        String res = this.testRestTemplate.getForObject("/Cars", String.class);
        assertEquals("{\"1\":{\"modele\":\"mustang\",\"couleur\":\"noire\",\"marque\":\"Ford\",\"id\":1},"
                + "\"2\":{\"modele\":\"clio\",\"couleur\":\"grise\",\"marque\":\"Renault\",\"id\":2},"
                + "\"3\":{\"modele\":\"Twingo\",\"couleur\":\"verte\",\"marque\":\"Renault\",\"id\":3}}", res);
        
        //get CARBY ID
        String resID = this.testRestTemplate.getForObject("/Cars/2", String.class);
        assertEquals("{\"modele\":\"clio\",\"couleur\":\"grise\",\"marque\":\"Renault\",\"id\":2}", resID);
        
        
        //ADDCAR
          Car lambo = new Car(4,"aventador","jaune","Lamborgini");
        this.testRestTemplate.postForObject("/Cars",lambo, String.class);
        String resAdd = this.testRestTemplate.getForObject("/Cars", String.class);
        assertEquals("{\"1\":{\"modele\":\"mustang\",\"couleur\":\"noire\",\"marque\":\"Ford\",\"id\":1},"
                + "\"2\":{\"modele\":\"clio\",\"couleur\":\"grise\",\"marque\":\"Renault\",\"id\":2},"
                + "\"3\":{\"modele\":\"Twingo\",\"couleur\":\"verte\",\"marque\":\"Renault\",\"id\":3},"
                + "\"4\":{\"modele\":\"aventador\",\"couleur\":\"jaune\",\"marque\":\"Lamborgini\",\"id\":4}}", resAdd);
//        testRestTemplate.delete("/Cars/{4}", 4);
        
        
        //DeleteCAR
          testRestTemplate.delete("/Cars/{4}", 4);
        String resDel = this.testRestTemplate.getForObject("/Cars", String.class);
        assertEquals("{\"1\":{\"modele\":\"mustang\",\"couleur\":\"noire\",\"marque\":\"Ford\",\"id\":1},"+
                "\"2\":{\"modele\":\"clio\",\"couleur\":\"grise\",\"marque\":\"Renault\",\"id\":2},"
                + "\"3\":{\"modele\":\"Twingo\",\"couleur\":\"verte\",\"marque\":\"Renault\",\"id\":3}}", resDel);
        
        //UpdateCar
         Car BX = new Car(1,"BX","Bleu","Citroen");
        Car mustang = new Car(1,"mustang","noire","Ford");
        this.testRestTemplate.put("/Cars/1",BX, String.class);
        String resUPT = this.testRestTemplate.getForObject("/Cars/1", String.class);
        assertEquals("{\"modele\":\"BX\",\"couleur\":\"Bleu\",\"marque\":\"Citroen\",\"id\":1}", resUPT);
//        this.testRestTemplate.put("/Cars/1",mustang, String.class);

        //DeleteBYID
                testRestTemplate.delete("/Cars/{1}", 1);
        String resDelID = this.testRestTemplate.getForObject("/Cars", String.class);
        assertEquals("{\"2\":{\"modele\":\"clio\",\"couleur\":\"grise\",\"marque\":\"Renault\",\"id\":2},"
                + "\"3\":{\"modele\":\"Twingo\",\"couleur\":\"verte\",\"marque\":\"Renault\",\"id\":3}}", resDelID);
        this.testRestTemplate.postForObject("/Cars",mustang, String.class);
        
        
    }

}
