package com.abndev.asan.gkb.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.*;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

public class SSLTool {
    private static final Logger LOG = LoggerFactory.getLogger(SSLTool.class);

    public static void disableCertificateValidation() {
        TrustManager[] trustAllCerts = trustAllCerts();

        // Ignore differences between given hostname and certificate hostname
        HostnameVerifier hv = new HostnameVerifier() {
            public boolean verify(String hostname, SSLSession session) { return true; }
        };

        // Install the all-trusting trust manager
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
            HttpsURLConnection.setDefaultHostnameVerifier(hv);
        }
        catch (Exception e) {
            LOG.error("SSL all valid failed.", e);
        }
    }

    public static TrustManager[] trustAllCerts() {
        // Create a trust manager that does not validate certificate chains
        return new TrustManager[]{
                new X509TrustManager() {
                    public X509Certificate[] getAcceptedIssuers() {
                        return new X509Certificate[0];
                    }

                    public void checkClientTrusted(X509Certificate[] certs, String authType) {}

                    public void checkServerTrusted(X509Certificate[] certs, String authType) {}
                }
        };
    }



}