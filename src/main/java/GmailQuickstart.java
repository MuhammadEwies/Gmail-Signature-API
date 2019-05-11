import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;

public class GmailQuickstart {
    private static final String APPLICATION_NAME = "Gmail API Java Quickstart";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList("https://apps-apis.google.com/a/feeds/emailsettings/2.0/");
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    /**
     * Creates an authorized Credential object.
     *
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
//    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT) throws IOException {
//        // Load client secrets.
//        InputStream in = GmailQuickstart.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
//        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
//
//        // Build flow and trigger user authorization request.
//        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
//                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
//                .setDataStoreFactory(new FileDataStoreFactory(new File(TOKENS_DIRECTORY_PATH)))
//                .setAccessType("offline")
//                .build();
//        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
//
//        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
//    }
//
//    public boolean setSignature(String Signature, String username, String Domain) {
//
//        try {
//            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
//            String x = getCredentials(HTTP_TRANSPORT).getAccessToken();
//            String y = getCredentials(HTTP_TRANSPORT).getRefreshToken();
//            URL url = new URL("https://apps-apis.google.com/a/feeds/emailsettings/2.0/" + Domain + "/" + username + "/signature");
//            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//            //con.setRequestMethod("GET");
//            con.setRequestMethod("PUT");
//
//            con.setRequestProperty("Content-Type", "application/atom+xml");
//
//            con.setRequestProperty("Authorization", "Bearer " + x);
//            con.setRequestProperty("refresh_token", y);
//
//            con.setDoOutput(true);
//            OutputStream os = con.getOutputStream();
//            os.write(Signature.getBytes());
//            os.flush();
//            os.close();
//
//            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//            String inputLine;
//            while ((inputLine = in.readLine()) != null) {
//                System.out.println(inputLine);
//            }
//            in.close();
//
//            return true;
//        } catch (Exception E) {
//
//            E.printStackTrace();
//            System.err.println("error happened");
//            return false;
//        }
//    }
//
//    public String getSignature(String username, String Domain) {
//
//        try {
//            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
//            String x = getCredentials(HTTP_TRANSPORT).getAccessToken();
//            String y = getCredentials(HTTP_TRANSPORT).getRefreshToken();
//            URL url = new URL("https://apps-apis.google.com/a/feeds/emailsettings/2.0/" + Domain + "/" + username + "/signature");
//            HttpURLConnection con = (HttpURLConnection) url.openConnection();
//            //con.setRequestMethod("GET");
//            con.setRequestMethod("GET");
//            //
//            con.setRequestProperty("Content-Type", "application/atom+xml");
//
//            con.setRequestProperty("Authorization", "Bearer " + x);
//            con.setRequestProperty("refresh_token", y);
//
//            String Signature = new String(" ");
//            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
//            String inputLine;
//            while ((inputLine = in.readLine()) != null) {
//                System.out.println(inputLine);
//                Signature += inputLine;
//            }
//            in.close();
//
//            return Signature;
//        } catch (Exception E) {
//
//            E.printStackTrace();
//            System.err.println("error happened");
//            return "Error Happened";
//        }
//    }

    public static void main(String... args) throws IOException, GeneralSecurityException {

        SignIn sin = new SignIn();


        Signature mysignarue = new Signature();

        try {
            String direc = System.getProperty("user.dir");
            System.err.println(direc + "\\" + TOKENS_DIRECTORY_PATH + "\\" + "StoredCredential");
            File myf = new File(direc + "\\" + TOKENS_DIRECTORY_PATH + "\\" + "StoredCredential");
            myf.delete();
            System.err.println(myf.exists());
        } catch (Exception e) {

            e.printStackTrace();
        }
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        String x = mysignarue.getCredentials(HTTP_TRANSPORT).getAccessToken();
        String y = mysignarue.getCredentials(HTTP_TRANSPORT).getRefreshToken();

        String s = mysignarue.getSignature("m.ewies","dev.cloud-11.com");

        /*
        String signaturemohamed = "<?xml version=\"1.0\" encoding=\"utf-8\"?>" +
                "<atom:entry xmlns:atom=\"http://www.w3.org/2005/Atom\" xmlns:apps=\"http://schemas.google.com/apps/2006\">" +
                "<apps:property name=\"signature\" value=\"Muhammad Ewies Software developer " +
                " Accounts Management, A&amp;Z LTD.\" />" +
                "</atom:entry> ";

        URL url = new URL("https://apps-apis.google.com/a/feeds/emailsettings/2.0/dev.cloud-11.com/m.ewies/signature");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        //con.setRequestMethod("GET");
        con.setRequestMethod("PUT");
        //
        con.setRequestProperty("Content-Type", "application/atom+xml");

        con.setRequestProperty("Authorization", "Bearer " + x);
        con.setRequestProperty("refresh_token", y);

        con.setDoOutput(true);
        OutputStream os = con.getOutputStream();
        os.write(signaturemohamed.getBytes());
        os.flush();
        os.close();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();
*/
    }
}