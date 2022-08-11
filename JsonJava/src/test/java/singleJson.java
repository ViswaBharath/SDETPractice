import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.apache.commons.text.StringEscapeUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class singleJson {

    static Connection conn = null;

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

        ArrayList<CustomerDetails> arrayList = new ArrayList<CustomerDetails>();
        JSONArray jsonArray = new JSONArray();

        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Business", "root", "root");

        Statement st = conn.createStatement();

        ResultSet rs = st.executeQuery("select * from CustomerInfo where purchasedDate=CURDATE() and Location ='Asia';");

        // !st way to retrieve the details
       /* while (rs.next()) {
            System.out.println(rs.getString(1));
            System.out.println(rs.getString(2));
            System.out.println(rs.getInt(3));
            System.out.println(rs.getString(4));
            System.out.println("******************");
        }*/

        while (rs.next())
        {
            CustomerDetails customerDetails = new CustomerDetails();

            customerDetails.setCourseName(rs.getString(1));
            customerDetails.setPurchasedDate(rs.getString(2));
            customerDetails.setAmount(rs.getInt(3));
            customerDetails.setLocation(rs.getString(4));

            arrayList.add(customerDetails);

            System.out.println("Customer Name is : " + customerDetails.getCourseName());
            System.out.println("Purchased Date is : " + customerDetails.getPurchasedDate());
            System.out.println("Amount is : " + customerDetails.getAmount());
            System.out.println(" Location is : " + customerDetails.getLocation());

            System.out.println("************************************");

        }

        for (int i = 0; i < arrayList.size(); i++)
        {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue
                    (new File("C:\\Users\\002TOJ744\\IdeaProjects\\BestBuyAPIsCucumberBDDFrameWork\\JsonJava\\customerInfo" + i + ".json"),
                            arrayList.get(i));
            //  Create json string from java object
            Gson gson = new Gson();
            String jsonString = gson.toJson(arrayList.get(i));
            jsonArray.add(jsonString);
        }

        //Json Simple
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("data",jsonArray);
        System.out.println(jsonObject.toJSONString());
        String unEscapedString = StringEscapeUtils.unescapeJava(jsonObject.toJSONString());
        System.out.println(unEscapedString);
        String string1 = unEscapedString.replace("\"{", "{");
        String finalString = string1.replace("}\"", "}");
        System.out.println(finalString);

        try (FileWriter file = new FileWriter("C:\\Users\\002TOJ744\\IdeaProjects\\BestBuyAPIsCucumberBDDFrameWork\\JsonJava\\SingleJson.json")){
            file.write(finalString);
        }

        conn.close();
    }
}