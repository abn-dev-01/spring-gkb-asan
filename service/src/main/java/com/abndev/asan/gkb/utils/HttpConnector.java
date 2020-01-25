package com.abndev.asan.gkb.utils;

import com.abndev.asan.gkb.soap.TrustAllHosts;
import org.apache.http.HttpHost;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HttpContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import javax.net.ssl.SSLContext;
import java.net.URI;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class HttpConnector {

    private static final Logger LOG = LoggerFactory.getLogger(HttpConnector.class);
    public static final String CREATING_SSLCONTEXT_FAILED = "Creating SSLContext failed.";

//    public static final String PROXY_HOST = "193.193.240.37"; // 193.193.240.37:45944
    public static final String PROXY_HOST = "91.135.194.22"; // 91.135.194.22:56828
    public static final int PROXY_PORT = 56828;
    public static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.130 Safari/537.36";

    private String userName;
    private String userPassword;
    private boolean proxyEnable;

    public HttpConnector(String userName, String userPassword, boolean proxyEnable) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.proxyEnable = proxyEnable;
    }

    public HttpConnector(String userName, String userPassword) {
        this(userName, userPassword, false);
    }

    public HttpComponentsMessageSender httpComponentsMessageSender() {

        // Trust own CA and all self-signed certs
        SSLContext sslcontext = null;
        try {
//            sslcontext = SSLContexts
//                    .custom()
//                    .loadTrustMaterial(new File("D:/FL/ASAN.SPRING/keys-pkcs.jks"),
//                                       "changeit".toCharArray(),
//                                       new TrustSelfSignedStrategy())
//                    .build();
            sslcontext = SSLContext.getInstance("SSL");
            sslcontext.init(null, SSLTool.trustAllCerts(), new SecureRandom());
        }
        catch (NoSuchAlgorithmException exc) {
            LOG.error(CREATING_SSLCONTEXT_FAILED, exc);
        }
        catch (KeyManagementException exc) {
            LOG.error(CREATING_SSLCONTEXT_FAILED, exc);
        }
//        catch (KeyStoreException exc) {
//            LOG.error(CREATING_SSLCONTEXT_FAILED, exc);
//        }
//        catch (CertificateException exc) {
//            LOG.error(CREATING_SSLCONTEXT_FAILED, exc);
//        }
//        catch (IOException exc) {
//            LOG.error(CREATING_SSLCONTEXT_FAILED, exc);
//        }

        // Allow TLSv1 protocol only
//        getSSLConnectionSocketFactory(sslcontext);

        RequestConfig config = getRequestConfig();

        CloseableHttpClient httpClient = getHttpClient(sslcontext, config);


        HttpComponentsMessageSender httpComponentsMessageSender =
//                new HttpComponentsMessageSender(httpClient);
                new HttpComponentsMessageSender(httpClient) {
                    @Override
                    protected HttpContext createContext(URI uri) {
                        HttpHost target = new HttpHost(uri.getHost(), uri.getPort(), uri.getScheme());

                        // Create AuthCache instance
                        AuthCache authCache = new BasicAuthCache();
                        // Generate BASIC scheme object and add it to the local
                        // auth cache
                        BasicScheme basicAuth = new BasicScheme();
                        authCache.put(target, basicAuth);

                        // Add AuthCache to the execution context
                        HttpClientContext localContext = HttpClientContext.create();
                        localContext.setAuthCache(authCache);

                        return localContext;
                    }
                };

        // set the basic authorization credentials
        httpComponentsMessageSender.setCredentials(usernamePasswordCredentials());
        try {
            httpComponentsMessageSender.afterPropertiesSet();
        }
        catch (Exception exc) {
            LOG.error("HttpComponentsMessageSender failed.", exc);
        }

        return httpComponentsMessageSender;
    }

    public void getSSLConnectionSocketFactory(SSLContext sslcontext) {
        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(
                sslcontext,
                new String[]{"TLSv1"},
                null,
                SSLConnectionSocketFactory.getDefaultHostnameVerifier());
    }

    public CloseableHttpClient getHttpClient(SSLContext sslcontext, RequestConfig config) {
        return HttpClients
                .custom()
                .addInterceptorFirst(new HttpComponentsMessageSender.RemoveSoapHeadersInterceptor())
                .setDefaultRequestConfig(config)
                .setUserAgent(USER_AGENT)
                //                .setSSLSocketFactory(sslsf)
                .setSSLContext(sslcontext)
                .setSSLHostnameVerifier(new TrustAllHosts())
                .build();
    }

    public RequestConfig getRequestConfig() {
        RequestConfig.Builder builder = RequestConfig
                .custom()
                .setConnectTimeout(300000)
                .setAuthenticationEnabled(true);
        if (this.proxyEnable) {
            builder.setProxy(new HttpHost(PROXY_HOST, PROXY_PORT));
        }
        return builder.build();
    }

    public UsernamePasswordCredentials usernamePasswordCredentials() {
        // pass the user name and password to be used
        return new UsernamePasswordCredentials(userName, userPassword);
    }

}
