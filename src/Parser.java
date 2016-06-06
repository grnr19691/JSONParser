import org.json.JSONObject;
import org.json.JSONException;
import org.json.XML;

import java.io.*;
import java.sql.Statement;


public class Parser
{



    public static void main(String[] args)
    {
        try
        {
            File f1=new File("buildings.xml");
            FileInputStream fstream1 = new FileInputStream(f1);
            BufferedReader b1=new BufferedReader(new InputStreamReader(fstream1));
            String l1 = null;
            int i=0;
            String temp;
            while((temp=b1.readLine())!=null)
            {
                if(i!=0)
                {
                    l1+=temp;
                    l1=l1.replace("    <","<");
                }
                else
                {
                    i++;
                    l1=temp;
                    //l1.replace("\"", "\\\"");
                }

            }
            b1.close();
            fstream1.close();
            JSONObject xmlJSONObj = XML.toJSONObject(l1);
            String jsonbuildingString = xmlJSONObj.toString(4);
            jsonbuildingString=jsonbuildingString.replace("xmlns:xsi", "-xmlns:xsi");
            jsonbuildingString=jsonbuildingString.replace("xsi:noNamespaceSchemaLocation", "-xsi:noNamespaceSchemaLocation");
            System.out.println(jsonbuildingString);
            System.out.println(l1);
            File wfile1=new File("building.json");
            if(!wfile1.exists())
            {
                wfile1.createNewFile();
            }
            BufferedWriter output = new BufferedWriter(new FileWriter(wfile1));
            output.write(jsonbuildingString);
            output.close();
            /////////////////////////////////////////////////////////////////////////////////////////////////////////

        }
        catch (JSONException je)
        {
            System.out.println(je.toString());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        try
        {
            File f1=new File("students.xml");
            FileInputStream fstream1 = new FileInputStream(f1);
            BufferedReader b1=new BufferedReader(new InputStreamReader(fstream1));
            String l1 = null;
            int i1=0;
            String temp;
            while((temp=b1.readLine())!=null)
            {
                if(i1!=0)
                {
                    l1+=temp;
                    l1=l1.replace("    <","<");
                }
                else
                {
                    i1++;
                    l1=temp;
                    //l1.replaceAll("xsi:noNamespaceSchemaLocation", "-xsi:noNamespaceSchemaLocation");
                }

            }
            b1.close();
            fstream1.close();
            JSONObject xmlJSONObj = XML.toJSONObject(l1);
            String jsonstudentString = xmlJSONObj.toString(4);
            jsonstudentString=jsonstudentString.replace("xmlns:xsi", "-xmlns:xsi");
            jsonstudentString=jsonstudentString.replace("xsi:noNamespaceSchemaLocation", "-xsi:noNamespaceSchemaLocation");
            System.out.println(jsonstudentString);
            System.out.println(l1);
            File wfile1=new File("students.json");
            if(!wfile1.exists())
            {
                wfile1.createNewFile();
            }
            BufferedWriter output = new BufferedWriter(new FileWriter(wfile1));
            output.write(jsonstudentString);
            output.close();
            /////////////////////////////////////////////////////////////////////////////////////////////////////////

        }
        catch (JSONException je)
        {
            System.out.println(je.toString());
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

    }
}