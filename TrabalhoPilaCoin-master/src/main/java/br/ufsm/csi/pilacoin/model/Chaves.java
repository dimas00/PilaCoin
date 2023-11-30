package br.ufsm.csi.pilacoin.model;

import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

public class Chaves {

    private static final String PRIVATE_KEY_FILE = "private_key.pem";
    private static final String PUBLIC_KEY_FILE = "public_key.pem";

    private PrivateKey privateKey;
    private PublicKey publicKey;

    @SneakyThrows
    public PrivateKey getPrivateKey() {
        if (privateKey == null) {
            // Verifica se o arquivo de chave privada já existe
            if (Files.exists(Paths.get(PRIVATE_KEY_FILE))) {
                byte[] keyBytes = Files.readAllBytes(Paths.get(PRIVATE_KEY_FILE));
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
                this.privateKey = keyFactory.generatePrivate(keySpec);
            } else {
                // Se não existir, gera uma nova chave privada
                KeyPair keyPair = generateKeyPair();
                this.privateKey = keyPair.getPrivate();

                // Salva a nova chave privada no arquivo
                Files.write(Paths.get(PRIVATE_KEY_FILE), this.privateKey.getEncoded());
            }
        }
        return privateKey;
    }

    @SneakyThrows
    public PublicKey getPublicKey() {
        if (publicKey == null) {
            // Verifica se o arquivo de chave pública já existe
            if (Files.exists(Paths.get(PUBLIC_KEY_FILE))) {
                byte[] keyBytes = Files.readAllBytes(Paths.get(PUBLIC_KEY_FILE));
                KeyFactory keyFactory = KeyFactory.getInstance("RSA");
                X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
                this.publicKey = keyFactory.generatePublic(keySpec);
            } else {
                // Se não existir, gera uma nova chave pública
                KeyPair keyPair = generateKeyPair();
                this.publicKey = keyPair.getPublic();

                // Salva a nova chave pública no arquivo
                Files.write(Paths.get(PUBLIC_KEY_FILE), this.publicKey.getEncoded());
            }
        }
        return publicKey;
    }

    @SneakyThrows
    private KeyPair generateKeyPair() {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // Tamanho da chave (pode ser ajustado conforme necessário)
        return keyPairGenerator.generateKeyPair();
    }
}
