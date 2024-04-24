package pages.MainPage.Tools;

import org.apache.commons.crypto.cipher.CryptoCipher;
import org.apache.commons.crypto.utils.Utils;
import org.yaml.snakeyaml.Yaml;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Properties;

public class DecryptCredentials {
    public static String UserName;
    public static String PassWord;

    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";

    public static void main(String[] args) throws Exception {
        // Initialization Vector and Secret Key
        byte[] key = "1234567890123456".getBytes(StandardCharsets.UTF_8); // must match encryption key
        byte[] iv = new byte[16]; // must match encryption IV

        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        // Decrypt the data
        Properties props = new Properties(); // Configuration properties, if needed
        CryptoCipher decipher = Utils.getCipherInstance(TRANSFORMATION, props);
        decipher.init(javax.crypto.Cipher.DECRYPT_MODE, keySpec, ivSpec);

        // Read encrypted data from file
        FileInputStream inputStream = new FileInputStream("encrypted_credentials.dat");
        byte[] encryptedData = new byte[inputStream.available()];
        inputStream.read(encryptedData);
        inputStream.close();

        // Decrypt data
        byte[] decryptedData = new byte[1024]; // Ensure buffer is large enough
        int finalBytes = decipher.doFinal(encryptedData, 0, encryptedData.length, decryptedData, 0);
        String decryptedString = new String(decryptedData, 0, finalBytes, StandardCharsets.UTF_8);

        // Load YAML from decrypted string
        Yaml yaml = new Yaml();
        Map<String, Object> data = yaml.load(decryptedString);

        // Assign to public variables
        UserName = (String) data.get("username");
        PassWord = (String) data.get("password");

        // Optional: Print to verify
        System.out.println("Decrypted Username: " + UserName);
        System.out.println("Decrypted Password: " + PassWord);
    }
}
