import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class extractJson {

    public static void main(String[] args) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        CustomerDetails customerDetails = objectMapper.readValue
                (new File("C:\\Users\\002TOJ744\\IdeaProjects\\BestBuyAPIsCucumberBDDFrameWork\\JsonJava\\customerInfo0.json"),
                        CustomerDetails.class);
        System.out.println("Course Name is : "+customerDetails.getCourseName());

    }
}