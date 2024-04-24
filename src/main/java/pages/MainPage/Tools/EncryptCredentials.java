package pages.MainPage.Tools;

import org.apache.commons.crypto.cipher.CryptoCipher;
import org.apache.commons.crypto.utils.Utils;
import org.yaml.snakeyaml.Yaml;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Properties;

public class EncryptCredentials {
    private static final String TRANSFORMATION = "AES/CBC/PKCS5Padding";

    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.setProperty("CipherClassName", "org.apache.commons.crypto.cipher.OpenSslCipher");

        Yaml yaml = new Yaml();
        InputStream inputStream = new FileInputStream("src/main/resources/credentials.yml");
        Map<String, Object> data = yaml.load(inputStream);

        String dataString = yaml.dump(data);

        byte[] key = "1234567890123456".getBytes(StandardCharsets.UTF_8);
        byte[] iv = new byte[16];
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);

        CryptoCipher encipher = Utils.getCipherInstance(TRANSFORMATION, props);
        encipher.init(Cipher.ENCRYPT_MODE, keySpec, ivSpec);

        byte[] input = dataString.getBytes(StandardCharsets.UTF_8);
        byte[] output = new byte[1024];

        int updateBytes = encipher.update(input, 0, input.length, output, 0);
        int finalBytes = encipher.doFinal(input, 0, 0, output, updateBytes);
        byte[] encryptedData = java.util.Arrays.copyOf(output, updateBytes + finalBytes);

        try (FileOutputStream outputStream = new FileOutputStream("encrypted_credentials.dat")) {
            outputStream.write(encryptedData);
        }

        System.out.println("Encryption successful!");
    }
}
